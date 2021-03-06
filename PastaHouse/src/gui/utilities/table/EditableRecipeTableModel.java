/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.utilities.table;

import database.extra.Component;
import database.extra.Ingredient;
import gui.ingredients.dialogs.EditableRecipeTableModelDelegate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Robin jr
 */
public class EditableRecipeTableModel extends AbstractTableModel implements Reorderable {

    private Map<Integer, Component> data;
    private final EditableRecipeTableModelDelegate del;
    
    public EditableRecipeTableModel(Map<Integer, Component> data, EditableRecipeTableModelDelegate del){
	this.data = data;
	this.del = del;
    }
    
    public Map<Integer, Component> getData(){
	return data;
    }
    
    @Override
    public int getRowCount() {
	return data.size();
    }

    @Override
    public int getColumnCount() {
	return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
	switch(columnIndex){
	    case 0:
		return ((Component)data.values().toArray()[rowIndex]).getRank();
	    case 1:
		return ((Component)data.values().toArray()[rowIndex]).getIngredient();
	    case 2:
		return ((Component)data.values().toArray()[rowIndex]).getPieces();
	    case 3:
		return ((Component)data.values().toArray()[rowIndex]).getQuantity();
	    default:
		return "<ERROR>";
	}
    }
    
    @Override
    public String getColumnName(int column) {
	switch(column){
	    case 0:
		return "Nr";
	    case 1:
		return "Ingredient";
	    case 2:
		return "Stuks";
	    case 3:
		return "Kg";
	    default:
		return "<ERROR>";
	}
    }

    // add a custom cell renderer for Double.class type to use proper formatting
    // add a custom cell renderer for Ingredient type (with hyperlink)
    @Override
    public Class<?> getColumnClass(int columnIndex) {
	switch(columnIndex){
	    case 0:
		return Integer.class;
	    case 1:
		return Ingredient.class;
	    case 2:
		return Component.class;
	    case 3:
		return Double.class;
	    default:
		return Object.class;
	}
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
	return col==2 || col==3;
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
//	System.out.println("Called 'set value' at "+row+", "+col+": "+value);
	try{
	    if (col == 2) {
		double v = Double.parseDouble((String)value);
		if (v>=0) {
		    Component c = (Component)data.values().toArray()[row];
		    c.setQuantity(v*c.getIngredient().getWeightPerUnit());
		    fireTableCellUpdated(row, col);
		    fireTableCellUpdated(row, 3);
		    del.dataChanged();
		}
	    } else if (col == 3) {
		double v = Double.parseDouble((String)value);
		if (v>=0) {
		    ((Component)data.values().toArray()[row]).setQuantity(v);
		    fireTableCellUpdated(row, col);
		    fireTableCellUpdated(row, 2);
		    del.dataChanged();
		}
	    }
	} catch (Exception e){
	    System.err.println("Something went wrong setting the value at "+row+", "+col+":\n"+e.getMessage());
	}
    }
    
    public void removeRow(int row){
	data.remove((Integer)data.keySet().toArray()[row]);
	
	Map<Integer, Component> temp = new TreeMap<Integer, Component>();
	int expected = 1;
	for (Component component : data.values()) {
	    if(component.getRank()>expected){
		component.setRank(expected);
	    }
	    temp.put(expected, component);
	    expected++;
	}
	
	data = temp;
	
	fireTableRowsDeleted(row, row);
    }
    
    @Deprecated
    public void addRow(){
	Component c = new Component();
	c.setQuantity(0.0);
	int key = 1;
	if(data.size()>0) {
	    key = Collections.max(data.keySet())+1;
	}
	
	c.setRank(key);
//	c.setIngredient((Ingredient)Database.driver().getIngredients().values().toArray()[0]);
	c.setIngredient(null);
	data.put(key, c);
	
	fireTableRowsInserted(0, data.size());
    }
    
    public void addComponent(Ingredient ingredient, double quantity){
	int key = 1;
	if(data.size()>0) {
	    key = Collections.max(data.keySet())+1;
	}
	data.put(key, new Component(ingredient, key, quantity));
	
	fireTableRowsInserted(0, data.size());
    }

    @Override
    public void reorder(int fromIndex, int toIndex) {
	ArrayList<Component> list = new ArrayList(data.values());
	Component from = list.remove(fromIndex);
	if (toIndex>fromIndex) {
	    toIndex--;
	}
	list.add(toIndex, from);
	
	int rank = 1;
	Map<Integer, Component> temp = new TreeMap<Integer, Component>(data);
	for (Component component : list) {
	    component.setRank(rank);
	    temp.put(rank, component);
	    rank++;
	}
	
	data = temp;
	fireTableDataChanged();
    }
}
