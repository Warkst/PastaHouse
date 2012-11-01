
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Warkst
 */
public class Database {
    private static Database driver;
    private Connection connection;
    private Statement statement;
    
    private Map<String, Supplier> suppliers;
    private Map<String, BasicIngredient> basicIngredients;
    private Map<String, Recipe> recipes;
    
    private Database() {
	try {
	    suppliers = new TreeMap<String, Supplier>();
	    basicIngredients = new TreeMap<String, BasicIngredient>();
	    recipes = new TreeMap<String, Recipe>();
	    
	    // connect to db
	    Class.forName("org.sqlite.JDBC");
	    connection = DriverManager.getConnection(Configuration.center().getDB_URL());
	    statement = connection.createStatement();
	     
	    // load data
	    loadSuppliers();
	    loadBasicIngredients();
	    loadRecipes();
	    
	} catch (Exception ex) {
	    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    public static Database driver(){
	if(driver==null) {
	    driver = new Database();
	}
	return driver;
    }
    
    private void loadSuppliers() throws SQLException{
	ResultSet rs = statement.executeQuery("SELECT * FROM "+Configuration.center().getDB_TABLE_SUP());
	while (rs.next()) {	    
	    suppliers.put(rs.getString("firma"),
		    Supplier.loadWithValues(rs.getString("firma"), 
		    rs.getString("adres"), 
		    rs.getString("gemeente"), 
		    rs.getString("tel"), 
		    rs.getString("gsm"), 
		    rs.getString("fax"), 
		    rs.getString("email"), 
		    rs.getString("opmerking"), 
		    rs.getString("contactpersoon"), 
		    rs.getBoolean("verwijderd")));
	}
	
	System.out.println("Database driver:: loaded "+suppliers.size()+" suppliers!");
    }
    
    private void loadBasicIngredients() throws SQLException{
	ResultSet rs = statement.executeQuery("SELECT * FROM "+Configuration.center().getDB_TABLE_INGR());
	while (rs.next()) {	    
	    basicIngredients.put(rs.getString("naam"), 
		    BasicIngredient.loadWithValues(
		    suppliers.get(rs.getString("firma")), 
		    rs.getString("merk"), 
		    rs.getString("verpakking"), 
		    rs.getDouble("prijsPerVerpakking"), 
		    rs.getDouble("gewichtPerVerpakking"), 
		    rs.getDouble("verliespercentage"), 
		    rs.getDouble("BTW"), 
		    rs.getString("naam"), 
		    rs.getString("datum")));
	}
	
	System.out.println("Database driver:: loaded "+basicIngredients.size()+" basic ingredients!");
    }
    
    private void loadRecipes() throws SQLException{
	ResultSet rs = statement.executeQuery("SELECT * FROM "+Configuration.center().getDB_TABLE_REC());
	while (rs.next()) {	    
	    recipes.put(rs.getString("naam"), 
		    Recipe.createStub(
		    rs.getString("naam"), 
		    rs.getString("datum"), 
		    rs.getString("bereiding"), 
		    rs.getDouble("nettogewicht")));
	}
	// also load all linked ingredients and recipes
	rs = statement.executeQuery("SELECT * FROM "+Configuration.center().getDB_TABLE_REC_INGR());
	int ingrLinks = 0;
	while(rs.next()){
	    String recipeName = rs.getString("receptnaam");
	    String ingredientName = rs.getString("ingredientnaam");
	    int rank = rs.getInt("rang");
	    double quantity = rs.getDouble("quantiteit");
	    recipes.get(recipeName).addIngredient(basicIngredients.get(ingredientName), rank, quantity);
	    ingrLinks++;
	}
	rs = statement.executeQuery("SELECT * FROM "+Configuration.center().getDB_TABLE_REC_REC());
	int recLinks = 0;
	while(rs.next()){
	    String recipeName = rs.getString("receptnaam");
	    String subrecipeName = rs.getString("deelreceptnaam");
	    int rank = rs.getInt("rang");
	    double quantity = rs.getDouble("quantiteit");
	    recipes.get(recipeName).addIngredient(recipes.get(subrecipeName), rank, quantity);
	    recLinks++;
	}
	
	System.out.println("Database driver:: loaded "+recipes.size()+" recipes (linked "+ingrLinks+" ingredients and "+recLinks+" recipes)!");
    }

    public Map<String, Supplier> getSuppliers() {
	return suppliers;
    }

    public Map<String, BasicIngredient> getBasicIngredients() {
	return basicIngredients;
    }

    public Map<String, Recipe> getRecipes() {
	return recipes;
    }
    
    public void executeStatement(String s){
	
    }
    
    /**
     * 
     * @param table
     * @param values
     * @throws SQLException 
     */
    public void executeInsert(String table, String values) throws SQLException{
	statement.executeUpdate("INSERT INTO "+table+" VALUES (null, "+values+")");
	System.out.println("DatabaseDriver::Executed insert of ("+values+") into "+table);
    }
    
    /**
     * Tries to send an update command to the database to update the record
     * with the specified id of the specified table to set the new values.
     * Values is expected to be of the format: "column_name = value, ...".
     * 
     * @param table The table of the record to be updated.
     * @param id The primary key of the record to be updated.
     * @param values The new set of values for the record.
     * @throws SQLException when the update statement fails to complete.
     */
    public void executeUpdate(String table, String primaryKey, String values) throws SQLException{
	statement.executeUpdate("UPDATE "+table+" SET "+values+" WHERE id = "+primaryKey);
	System.out.println("DatabaseDriver::Executed update of ("+values+") into "+table+" for PK "+primaryKey);
    }
    
    public void executeDelete(String table, int id){
	
    }
    
    /**
     * Tries to close the active database connection.
     * 
     * @throws SQLException when the connection can't be closed.
     */
    public void shutdown() throws SQLException{
	connection.close();
    }
}
