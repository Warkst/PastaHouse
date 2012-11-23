/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ingredients.controllers;

import database.Component;
import database.Database;
import database.Ingredient;
import database.Recipe;
import gui.ingredients.dialogs.AddRecipeDialog;
import gui.ingredients.dialogs.EditRecipeDialog;
import gui.ingredients.dialogs.PrintDialog;
import gui.utilities.cell.CellRendererFactory;
import gui.utilities.list.EditableListModel;
import gui.utilities.list.ListModelFactory;
import gui.utilities.table.StaticTableModel;
import java.awt.print.Printable;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import printer.PrintableRecipe;
import printer.Printer;
import utilities.StringTools;
import utilities.Utilities;

/**
 *
 * @author Warkst
 */
public class RecipeViewController extends javax.swing.JPanel implements MasterDetailViewController, PrintDialogDelegate{

    /**
     * Creates new form RecipeViewController
     */
    public RecipeViewController() {
	initComponents();
	
	recipeListOutlet.setModel(ListModelFactory.createRecipeListModel(Database.driver().getRecipes()));
	recipeListOutlet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	recipeListOutlet.addListSelectionListener(new ListSelectionListener() {

	    @Override
	    public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
		    updateDetail(recipeListOutlet.getSelectedValue());
		}
	    }
	});
	
	recipeListOutlet.setSelectedIndex(0);
	
	ingredientsOutlet.setRowHeight(ingredientsOutlet.getRowHeight()+Utilities.fontSize()-10);
    }
    
    @Override
    public JPanel view(){
	return this;
    }
    
    @Override
    public void updateDetail(Object value){
	Recipe r = (Recipe)value;
	
	nameOutlet.setText(StringTools.capitalize(r.getName()));
	dateOutlet.setText(r.getDate());
	
	DecimalFormat threeFormatter = new DecimalFormat("0.000");
	grossWeightOutlet.setText(threeFormatter.format(r.getGrossWeight())+" kg");
	netWeightOutlet.setText(threeFormatter.format(r.getNetWeight())+" kg");
	pricePerWeightOutlet.setText(threeFormatter.format(r.getPricePerWeight())+" euro / kg");
	
	preparationOutlet.setText(r.getPreparation());
	
	ingredientsOutlet.setDefaultRenderer(String.class, CellRendererFactory.createCapitalizedStringCellRenderer());
	ingredientsOutlet.setDefaultRenderer(Double.class, CellRendererFactory.createTwoDecimalDoubleCellRenderer());
	ingredientsOutlet.setDefaultRenderer(Ingredient.class, CellRendererFactory.createIngredientCellRenderer());
	ingredientsOutlet.setDefaultRenderer(Component.class, CellRendererFactory.createThreeDecimalDoubleCellRenderer());
	
	ingredientsOutlet.setModel(new StaticTableModel(r.getIngredients()));
	
//	ingredientListOutlet.setModel(ListModelFactory.createComponentListModel(r.getIngredients()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        master = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recipeListOutlet = new javax.swing.JList();
        add = new javax.swing.JButton();
        detail = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        nameOutlet = new javax.swing.JLabel();
        dateOutlet = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        preparationOutlet = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        grossWeightOutlet = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        netWeightOutlet = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pricePerWeightOutlet = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jPanel2 = new javax.swing.JPanel();
        print = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        ingredientsOutlet = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(200);

        master.setLayout(new java.awt.BorderLayout());

        recipeListOutlet.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(recipeListOutlet);

        master.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add.setText("Toevoegen...");
        add.setFocusable(false);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        master.add(add, java.awt.BorderLayout.SOUTH);

        jSplitPane1.setLeftComponent(master);

        detail.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        nameOutlet.setText("<nameOutlet>");
        jPanel5.add(nameOutlet);

        dateOutlet.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dateOutlet.setText("<dateOutlet>");
        jPanel5.add(dateOutlet);

        detail.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel7.setPreferredSize(new java.awt.Dimension(176, 250));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Bereiding:"));

        preparationOutlet.setColumns(20);
        preparationOutlet.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        preparationOutlet.setRows(5);
        jScrollPane3.setViewportView(preparationOutlet);

        jPanel7.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel6.setLayout(new java.awt.GridLayout(3, 2));

        jLabel2.setText("Totaalgewicht ingrediënten");
        jPanel6.add(jLabel2);

        grossWeightOutlet.setText("<grossWeightOutlet>");
        jPanel6.add(grossWeightOutlet);

        jLabel4.setText("Gewicht na bereiding");
        jPanel6.add(jLabel4);

        netWeightOutlet.setText("<netWeightOutlet>");
        jPanel6.add(netWeightOutlet);

        jLabel7.setText("Kostprijs per kg (BTW excl)");
        jPanel6.add(jLabel7);

        pricePerWeightOutlet.setText("<pricePerWeightOutlet>");
        jPanel6.add(pricePerWeightOutlet);

        jPanel7.add(jPanel6, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(filler1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        print.setText("Afdrukken...");
        print.setFocusable(false);
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel2.add(print);

        edit.setText("Wijzigen...");
        edit.setFocusable(false);
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel2.add(edit);

        jPanel1.add(jPanel2, java.awt.BorderLayout.EAST);

        jPanel7.add(jPanel1, java.awt.BorderLayout.SOUTH);

        detail.add(jPanel7, java.awt.BorderLayout.SOUTH);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingrediënten:"));

        ingredientsOutlet.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        ingredientsOutlet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ingredientsOutlet.setRowSelectionAllowed(false);
        ingredientsOutlet.setSurrendersFocusOnKeystroke(true);
        jScrollPane4.setViewportView(ingredientsOutlet);

        detail.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(detail);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
	new AddRecipeDialog(null, true, this).setVisible(true);
    }//GEN-LAST:event_addActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        new EditRecipeDialog(null, true, (Recipe)recipeListOutlet.getSelectedValue(), this).setVisible(true);
    }//GEN-LAST:event_editActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
	new PrintDialog(null, true, this).setVisible(true);
    }//GEN-LAST:event_printActionPerformed

    public void printProxy(){
	printActionPerformed(null);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JLabel dateOutlet;
    private javax.swing.JPanel detail;
    private javax.swing.JButton edit;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel grossWeightOutlet;
    private javax.swing.JTable ingredientsOutlet;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel master;
    private javax.swing.JLabel nameOutlet;
    private javax.swing.JLabel netWeightOutlet;
    private javax.swing.JTextArea preparationOutlet;
    private javax.swing.JLabel pricePerWeightOutlet;
    private javax.swing.JButton print;
    private javax.swing.JList recipeListOutlet;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateList() {
	EditableListModel<Recipe> dlm = (EditableListModel)recipeListOutlet.getModel();
	dlm.update();
	updateDetail(dlm.getElementAt(recipeListOutlet.getSelectedIndex()));
    }

    @Override
    public void updateListAndSelect(Object select) {
	System.err.println("Not implemented");
    }

    @Override
    public void add() {
	addActionPerformed(null);
    }

    @Override
    public void edit() {
	editActionPerformed(null);
    }

    @Override
    public void printQuantity(double q) {
	print(new PrintableRecipe((Recipe)recipeListOutlet.getSelectedValue(), q));
    }

    @Override
    public void printAmount(double a) {
	Recipe r = (Recipe)recipeListOutlet.getSelectedValue();
	// herreken het aantal stuks naar een gewicht
	
	print(new PrintableRecipe(r, a*r.getNetWeight(), a));
    }
    
    private void print(Printable pr){
//        Printable pr = new PrintableTest();
	Printer.driver().setPrintJob(pr);
	Printer.driver().tryPrint();
//	try {
//	    ingredientsOutlet.print();
//	} catch (PrinterException ex) {
//	    Logger.getLogger(RecipeViewController.class.getName()).log(Level.SEVERE, null, ex);
//	}
    }
}
