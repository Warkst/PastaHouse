/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.tables;

import database.Database;
import database.FunctionResult;
import database.extra.Component;
import database.extra.Ingredient;
import database.models.RecipeModel;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.Configuration;
import tools.StringTools;

/**
 *
 * @author Warkst
 */
public class Recipe extends Ingredient {
//    private final String table_id = Configuration.center().getDB_TABLE_REC();
    
    // database variables
    private double netWeight;
    private String preparation;
    private Map<Integer, Component> components;
    
    // derived variables
    
    private Recipe(int id, RecipeModel r){
	super(r.getName(), r.getDate(), id, Configuration.center().getDB_TABLE_REC());
	netWeight = r.getNetWeight();
	preparation = r.getPreparation();
	components = new TreeMap<Integer, Component>();
	// deep copy components map
	for (Map.Entry<Integer, Component> entry : r.getComponents().entrySet()) {
	    components.put(entry.getKey(), new Component(entry.getValue().getIngredient(), entry.getValue().getRank(), entry.getValue().getQuantity()));
	}
    }
    
    /**
     * Copy constructor.
     * 
     * @param r 
     */
    public Recipe(Recipe r){
	super(r.getName(), r.getDate(), r.getPrimaryKeyValue(), r.getTableName());
	netWeight = r.netWeight;
	preparation = r.preparation;
	components = new TreeMap<Integer, Component>();
	/*
	 * Deep copy
	 */
	for (Map.Entry<Integer, Component> entry : r.getComponents().entrySet()) {
	    components.put(entry.getKey(), new Component(entry.getValue().getIngredient(), entry.getValue().getRank(), entry.getValue().getQuantity()));
	}
    }
    
    public Recipe(int id, String name, String date){
	this(id, name, date, "", 0.0);
    }
    
    private Recipe(int id, String name, String date, String preparation, double netWeight){
	super(name, date, id, Configuration.center().getDB_TABLE_REC());
	this.preparation = preparation;
	this.netWeight = netWeight;
	
	components = new TreeMap<Integer, Component>();
    }
    
    public static Recipe createStub(int id, String name, String date, String preparation, double netWeight){
	return new Recipe(id, name, date, preparation, netWeight);
    }
    
    public static Recipe createFromModel(int id, RecipeModel model){
	return new Recipe(id, model);
    }
    
    public void copy(Recipe r){
	setName(r.getName());
	setDate(r.getDate());
	netWeight = r.netWeight;
	preparation = r.preparation;
	components = new TreeMap<Integer, Component>();
	components.putAll(r.components);
    }
    
    public void addIngredient(Ingredient i, int rank, double quantity){
	components.put(rank, new Component(i, rank, quantity));
    }

    public void setNetWeight(double netWeight) {
	this.netWeight = netWeight;
    }

    public void setPreparation(String preparation) {
	this.preparation = preparation;
    }
    
    public double getNetWeight() {
	return netWeight;
    }

    public String getPreparation() {
	return preparation;
    }

    public void setComponents(Map<Integer, Component> components) {
	this.components = components;
    }
    
    /**
     * Lazily calculate and return the gross weight of the recipe as the sum of the quantities (= net weights) of all the ingredients.
     * 
     * @return 
     */
    public double getGrossWeight(){
	double returnMe = 0.0;
	
	for (Map.Entry<Integer, Component> entry : components.entrySet()) {
	    returnMe += entry.getValue().getQuantity();
	}
	
	return returnMe;
    }
    
    public Map<Integer, Component> getComponents(){
	return components;
    }
    
    @Override
    public double getPricePerWeight(){
	double returnMe = 0.0;
	
	for (Map.Entry<Integer, Component> entry : components.entrySet()) {
	    if (entry.getValue().getIngredient() != null) {
//		returnMe += entry.getValue().getIngredient().getPricePerWeight()*entry.getValue().getGrossQuantity();
//		returnMe += entry.getValue().getIngredient().getPricePerWeight();
		returnMe += entry.getValue().getIngredient().getPricePerWeight()*entry.getValue().getQuantity();
	    }
	}
	
//	return Math.abs(netWeight-0.0)>0.0001 ? returnMe/netWeight : 0.0;
	return getNetWeight()==0 ? 0 : returnMe/getNetWeight();
    }
    
    @Override
    public FunctionResult<Recipe> update(){
        try {
            return Database.driver().updateRecipe(this);
        } catch (SQLException ex) {
            Logger.getLogger(Recipe.class.getName()).log(Level.SEVERE, null, ex);
            return new FunctionResult<Recipe>(2, null, ex.getMessage());
        }
    }
    
    @Override
    public boolean delete(){
	return false;
    }
    
    @Override
    public String toString(){
	return StringTools.capitalize(getName());
    }
    
    @Override
    public double getWeightPerUnit(){
	return netWeight;
    }

    @Override
    public String getPackaging() {
	return "Recept"; // geen packaging
    }

    @Override
    public double getLossPercent() {
	return netWeight/getGrossWeight();
    }
    
    @Override
    public boolean isBasicIngredient(){
	return false;
    }
    
    @Override
    public boolean isInBulk(){
	return false;
    }

    public boolean containsRecipe(Recipe r) {
	if (this == r) {
	    return true;
	} else {
//	    boolean result = false;
	    for (Component component : components.values()) {
		if (!component.getIngredient().isBasicIngredient()) {
//		    result |= ((Recipe)component.getIngredient()).containsRecipe(r);
//		    if (result) {
//			return true;
//		    }
		    if (((Recipe)component.getIngredient()).containsRecipe(r)) {
			return true;
		    }
		}
	    }
	    return false;
//	    return result;
	}
    }

    @Override
    public String filterable() {
	String result = getName()+";"+getDate()+";"+preparation+";"+getNetWeight();
	for (Component component : components.values()) {
	    result+=";"+component.getIngredient().getName();
	}
	return result;
    }
}
