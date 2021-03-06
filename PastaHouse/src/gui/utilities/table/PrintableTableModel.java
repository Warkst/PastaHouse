/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.utilities.table;

import database.extra.Component;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Warkst
 */
public class PrintableTableModel extends AbstractTableModel{

    private final Map<Integer, Component> data;
    
    public PrintableTableModel(Map<Integer, Component> data){
	this.data = data;
    }
    
    public void update(){
	fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int arg0, int arg1) {
	return false;
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
		return ((Component)data.values().toArray()[rowIndex]).getIngredient().getName();
	    case 1:
		return ((Component)data.values().toArray()[rowIndex]).getIngredient().getPackaging();
	    case 2:
		return ((Component)data.values().toArray()[rowIndex]).getUnits();
	    case 3:
		return ((Component)data.values().toArray()[rowIndex]).getQuantity();
	    default:
		return "<empty>";
	}
    }

    @Override
    public String getColumnName(int column) {
	switch(column){
	    case 0:
		return "Naam";
	    case 1:
		return "Verpakking";
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
		return String.class;
	    case 1:
		return String.class;
	    case 2:
		return Double.class;
	    case 3:
		return Component.class;
	    default:
		return Object.class;
	}
    }
}
