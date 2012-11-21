/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ingredients.dialogs;

import com.michaelbaranov.microba.calendar.DatePicker;
import database.BasicIngredient;
import database.Database;
import database.Supplier;
import gui.ingredients.controllers.MasterDetailViewController;
import gui.utilities.combobox.AutocompleteCombobox;
import gui.utilities.combobox.ComboBoxModelFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.text.DateFormatter;
import utilities.Utilities;

/**
 *
 * @author Robin jr
 */
public class EditIngredientDialog extends javax.swing.JDialog{

    private final BasicIngredient model;
    private final BasicIngredient defaultModel;
    private final MasterDetailViewController delegate;
    
    private final DatePicker dp;
    private final AutocompleteCombobox supplierBox;
    
    /**
     * Creates new form EditIngredientDialog
     */
    public EditIngredientDialog(java.awt.Frame parent, boolean modal, MasterDetailViewController delegate, BasicIngredient model) {
	super(parent, modal);
	initComponents();
	
	this.delegate = delegate;
	this.model = model;
	this.defaultModel = new BasicIngredient(model);
	
	supplierParent.removeAll();
	List suppliers = new ArrayList();
	suppliers.add("");
	suppliers.addAll(Database.driver().getSuppliers().values());
	supplierBox = new AutocompleteCombobox(suppliers);
	supplierParent.add(supplierBox, BorderLayout.CENTER);
	
	setLocationRelativeTo(null);
	setTitle("Ingrediënt wijzigen");
	
	supplierOutlet.setModel(ComboBoxModelFactory.createSupplierComboBoxModel(Database.driver().getSuppliers().values().toArray()));
	
	dp = new DatePicker(new Date(), new SimpleDateFormat("dd/MM/yyyy"));
//	fixedFields.add(dp);
	
	loadModel();
    }
    
    private void loadModel(){
	nameOutlet.setText(model.getName());
	brandOutlet.setText(model.getBrand());
	packagingOutlet.setText(model.getPackaging());
//	supplierOutlet.setSelectedItem(model.getSupplier());
	if(model.getSupplier()!=null){
	    supplierBox.setSelectedItem(model.getSupplier());
	}
	
	// compound fields
	DecimalFormat threeFormatter = new DecimalFormat("0.000");
	DecimalFormat twoFormatter = new DecimalFormat("0.00");
	pricePerUnitOutlet.setText(""+model.getPricePerUnit());
	pricePerUnitFormattedOutlet.setText(threeFormatter.format(model.getPricePerUnit())+" euro/"+model.getPackaging());
	weightPerUnitOutlet.setText(""+model.getWeightPerUnit());
	weightPerUnitFormattedOutlet.setText(threeFormatter.format(model.getWeightPerUnit())+" kg/"+model.getPackaging());
	pricePerWeightOutlet.setText(""+model.getPricePerWeight());
	pricePerWeightFormattedOutlet.setText(threeFormatter.format(model.getPricePerWeight())+" euro/kg");
	lossOutlet.setText(""+model.getLossPercent());
	lossFormattedOutlet.setText(twoFormatter.format(model.getLossPercent())+" %");
	grossPriceOutlet.setText(""+model.getGrossPrice());
	grossPriceFormattedOutlet.setText(threeFormatter.format(model.getGrossPrice())+" euro");
	taxesOutlet.setText(""+model.getTaxes());
	taxesFormattedOutlet.setText(twoFormatter.format(model.getTaxes())+" %");
	netPriceOutlet.setText(""+model.getNetPrice());
	netPriceFormattedOutlet.setText(twoFormatter.format(model.getNetPrice())+" euro");
	notesOutlet.setText(model.getNotes());
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        detail = new javax.swing.JPanel();
        fixedFields = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameOutlet = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        brandOutlet = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        packagingOutlet = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        supplierParent = new javax.swing.JPanel();
        supplierOutlet = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pricePerUnitOutlet = new javax.swing.JTextField();
        pricePerUnitFormattedOutlet = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        weightPerUnitOutlet = new javax.swing.JTextField();
        weightPerUnitFormattedOutlet = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        pricePerWeightOutlet = new javax.swing.JLabel();
        pricePerWeightFormattedOutlet = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lossOutlet = new javax.swing.JTextField();
        lossFormattedOutlet = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        grossPriceOutlet = new javax.swing.JLabel();
        grossPriceFormattedOutlet = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        taxesOutlet = new javax.swing.JTextField();
        taxesFormattedOutlet = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        netPriceOutlet = new javax.swing.JLabel();
        netPriceFormattedOutlet = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        stretchableFields = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        notesOutlet = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        detail.setLayout(new java.awt.BorderLayout());

        fixedFields.setFocusable(false);
        fixedFields.setLayout(new java.awt.GridLayout(12, 3));

        jLabel1.setText("Naam");
        jLabel1.setFocusable(false);
        fixedFields.add(jLabel1);

        nameOutlet.setText("<nameOutlet>");
        fixedFields.add(nameOutlet);

        jLabel2.setText("Merk");
        jLabel2.setFocusable(false);
        fixedFields.add(jLabel2);

        brandOutlet.setText("<brandOutlet>");
        fixedFields.add(brandOutlet);

        jLabel6.setText("Verpakking");
        jLabel6.setFocusable(false);
        fixedFields.add(jLabel6);

        packagingOutlet.setText("<packagingOutlet>");
        packagingOutlet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                packagingOutletKeyReleased(evt);
            }
        });
        fixedFields.add(packagingOutlet);

        jLabel3.setText("Leverancier");
        jLabel3.setFocusable(false);
        fixedFields.add(jLabel3);

        supplierParent.setLayout(new java.awt.BorderLayout());

        supplierOutlet.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        supplierParent.add(supplierOutlet, java.awt.BorderLayout.CENTER);

        fixedFields.add(supplierParent);

        jLabel10.setText("Prijs per verpakking (BTW excl)");
        jLabel10.setFocusable(false);
        fixedFields.add(jLabel10);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        pricePerUnitOutlet.setText("<pricePerUnitOutlet>");
        pricePerUnitOutlet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pricePerUnitOutletKeyReleased(evt);
            }
        });
        jPanel1.add(pricePerUnitOutlet);

        pricePerUnitFormattedOutlet.setText("<pricePerUnitFormattedOutlet>");
        jPanel1.add(pricePerUnitFormattedOutlet);

        fixedFields.add(jPanel1);

        jLabel8.setText("Gewicht per verpakking");
        jLabel8.setFocusable(false);
        fixedFields.add(jLabel8);

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        weightPerUnitOutlet.setText("<weightPerUnitOutlet>");
        weightPerUnitOutlet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                weightPerUnitOutletKeyReleased(evt);
            }
        });
        jPanel2.add(weightPerUnitOutlet);

        weightPerUnitFormattedOutlet.setText("<weightPerUnitFormattedOutlet>");
        jPanel2.add(weightPerUnitFormattedOutlet);

        fixedFields.add(jPanel2);

        jLabel12.setText("Prijs per kg (BTW excl)");
        jLabel12.setFocusable(false);
        fixedFields.add(jLabel12);

        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        pricePerWeightOutlet.setText("<pricePerWeightOutlet>");
        jPanel5.add(pricePerWeightOutlet);

        pricePerWeightFormattedOutlet.setText("<pricePerWeightFormattedOutlet>");
        jPanel5.add(pricePerWeightFormattedOutlet);

        fixedFields.add(jPanel5);

        jLabel14.setText("Verliespercentage");
        jLabel14.setFocusable(false);
        fixedFields.add(jLabel14);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        lossOutlet.setText("<lossOutlet>");
        lossOutlet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lossOutletKeyReleased(evt);
            }
        });
        jPanel6.add(lossOutlet);

        lossFormattedOutlet.setText("<lossFormattedOutlet>");
        jPanel6.add(lossFormattedOutlet);

        fixedFields.add(jPanel6);

        jLabel16.setText("Totaalprijs (BTW excl)");
        jLabel16.setFocusable(false);
        fixedFields.add(jLabel16);

        jPanel7.setLayout(new java.awt.GridLayout(1, 2));

        grossPriceOutlet.setText("<grossPriceOutlet>");
        jPanel7.add(grossPriceOutlet);

        grossPriceFormattedOutlet.setText("<grossPriceFormattedOutlet>");
        jPanel7.add(grossPriceFormattedOutlet);

        fixedFields.add(jPanel7);

        jLabel18.setText("BTW");
        jLabel18.setFocusable(false);
        fixedFields.add(jLabel18);

        jPanel8.setLayout(new java.awt.GridLayout(1, 2));

        taxesOutlet.setText("<taxesOutlet>");
        taxesOutlet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                taxesOutletKeyReleased(evt);
            }
        });
        jPanel8.add(taxesOutlet);

        taxesFormattedOutlet.setText("<taxesFormattedOutlet>");
        jPanel8.add(taxesFormattedOutlet);

        fixedFields.add(jPanel8);

        jLabel20.setText("Totaalprijs");
        jLabel20.setFocusable(false);
        fixedFields.add(jLabel20);

        jPanel9.setLayout(new java.awt.GridLayout(1, 2));

        netPriceOutlet.setText("<netPriceOutlet>");
        jPanel9.add(netPriceOutlet);

        netPriceFormattedOutlet.setText("<netPriceFormattedOutlet>");
        jPanel9.add(netPriceFormattedOutlet);

        fixedFields.add(jPanel9);

        jLabel22.setText("Datum");
        jLabel22.setFocusable(false);
        fixedFields.add(jLabel22);

        detail.add(fixedFields, java.awt.BorderLayout.NORTH);

        stretchableFields.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opmerking:"));

        notesOutlet.setColumns(20);
        notesOutlet.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        notesOutlet.setRows(5);
        jScrollPane2.setViewportView(notesOutlet);

        stretchableFields.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        detail.add(stretchableFields, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        save.setText("Opslaan");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel4.add(save);

        cancel.setText("Terug");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel4.add(cancel);

        jPanel3.add(jPanel4, java.awt.BorderLayout.EAST);
        jPanel3.add(filler1, java.awt.BorderLayout.CENTER);

        detail.add(jPanel3, java.awt.BorderLayout.SOUTH);

        getContentPane().add(detail, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void weightPerUnitOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_weightPerUnitOutletKeyReleased
	updatePricePerWeightOutlet();
    }//GEN-LAST:event_weightPerUnitOutletKeyReleased

    private void pricePerUnitOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pricePerUnitOutletKeyReleased
	updatePricePerWeightOutlet();
    }//GEN-LAST:event_pricePerUnitOutletKeyReleased

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        model.copy(defaultModel);
	this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void updatePricePerWeightOutlet(){
	boolean failed = false;
	
	double ppu;
	try{
	    ppu = Double.parseDouble(pricePerUnitOutlet.getText());
	    pricePerUnitOutlet.setForeground(Color.black);
	    pricePerUnitFormattedOutlet.setForeground(Color.black);
	    pricePerUnitFormattedOutlet.setText(new DecimalFormat("0.000").format(ppu) +" euro/"+packagingOutlet.getText());
	} catch(Exception e){
	    pricePerUnitOutlet.setForeground(Color.red);
	    pricePerUnitFormattedOutlet.setForeground(Color.red);
	    pricePerUnitFormattedOutlet.setText("??? euro/"+packagingOutlet.getText());
	    pricePerWeightOutlet.setForeground(Color.red);
	    pricePerWeightOutlet.setText("???");
	    pricePerWeightFormattedOutlet.setForeground(Color.red);
	    pricePerWeightFormattedOutlet.setText("??? euro");
	    updateGrossPriceOutlet();
	    failed = true;
	    ppu = 0.0;
	}
	
	double wpu;
	try{
	    wpu = Double.parseDouble(weightPerUnitOutlet.getText());
	    weightPerUnitOutlet.setForeground(Color.black);
	    weightPerUnitFormattedOutlet.setForeground(Color.black);
	    weightPerUnitFormattedOutlet.setText(new DecimalFormat("0.000").format(wpu) +" kg/"+packagingOutlet.getText());
	} catch(Exception e){
	    weightPerUnitOutlet.setForeground(Color.red);
	    weightPerUnitFormattedOutlet.setForeground(Color.red);
	    weightPerUnitFormattedOutlet.setText("??? kg/"+packagingOutlet.getText());
	    pricePerWeightOutlet.setForeground(Color.red);
	    pricePerWeightOutlet.setText("???");
	    pricePerWeightFormattedOutlet.setForeground(Color.red);
	    pricePerWeightFormattedOutlet.setText("??? euro");
	    updateGrossPriceOutlet();
	    failed = true;
	    wpu = 0.0;
	}
	
	if (failed) {
	    return;
	}
	
	pricePerWeightOutlet.setText(""+(ppu/wpu));
	pricePerWeightOutlet.setForeground(Color.BLACK);
	pricePerWeightFormattedOutlet.setText(new DecimalFormat("0.000").format(ppu/wpu)+" euro/kg");
	pricePerWeightFormattedOutlet.setForeground(Color.BLACK);
	
	updateGrossPriceOutlet();
    }
    
    private void updateGrossPriceOutlet(){
	boolean failed = false;
	
	double loss;
	try{
	    loss = Double.parseDouble(lossOutlet.getText());
	    lossOutlet.setForeground(Color.black);
	    lossFormattedOutlet.setForeground(Color.black);
	    lossFormattedOutlet.setText(new DecimalFormat("0.00").format(loss)+" %");
	} catch(Exception e){
	    lossOutlet.setForeground(Color.red);
	    lossFormattedOutlet.setForeground(Color.red);
	    lossFormattedOutlet.setText("??? %");
	    grossPriceOutlet.setForeground(Color.red);
	    grossPriceOutlet.setText("???");
	    grossPriceFormattedOutlet.setForeground(Color.red);
	    grossPriceFormattedOutlet.setText("??? euro");
	    updateNetPriceOutlet();
	    failed = true;
	    loss = 0.0;
	}
	
	double ppw;
	try{
	    ppw = Double.parseDouble(pricePerWeightOutlet.getText());
	    pricePerWeightOutlet.setForeground(Color.black);
	    pricePerWeightFormattedOutlet.setForeground(Color.black);
	    pricePerWeightFormattedOutlet.setText(new DecimalFormat("0.000").format(ppw)+" euro/kg");
	} catch(Exception e){
	    pricePerWeightOutlet.setForeground(Color.red);
	    pricePerWeightFormattedOutlet.setForeground(Color.red);
	    pricePerWeightFormattedOutlet.setText("??? euro/kg");
	    grossPriceOutlet.setForeground(Color.red);
	    grossPriceOutlet.setText("???");
	    grossPriceFormattedOutlet.setForeground(Color.red);
	    grossPriceFormattedOutlet.setText("??? euro");
	    updateNetPriceOutlet();
	    failed = true;
	    ppw = 0.0;
	}
	
	if (failed) {
	    return;
	}
	
	grossPriceOutlet.setText(""+(ppw/(1.0-(0.01*loss))));
	grossPriceOutlet.setForeground(Color.BLACK);
	grossPriceFormattedOutlet.setForeground(Color.BLACK);
	grossPriceFormattedOutlet.setText(new DecimalFormat("0.000").format(ppw/(1.0-(0.01*loss)))+" euro");
	
	updateNetPriceOutlet();
    }
    
    private void updateNetPriceOutlet(){
	boolean failed = false;
	
	double taxes;
	try{
	    taxes = Double.parseDouble(taxesOutlet.getText());
	    taxesOutlet.setForeground(Color.black);
	    taxesFormattedOutlet.setForeground(Color.black);
	    taxesFormattedOutlet.setText(new DecimalFormat("0.00").format(taxes)+" %");
	} catch(Exception e){
	    taxesOutlet.setForeground(Color.red);
	    taxesFormattedOutlet.setForeground(Color.red);
	    taxesFormattedOutlet.setText("??? %");
	    netPriceOutlet.setForeground(Color.red);
	    netPriceOutlet.setText("???");
	    netPriceFormattedOutlet.setForeground(Color.red);
	    netPriceFormattedOutlet.setText("??? euro");
	    failed = true;
	    taxes = 0.0;
	}
	
	double grossPrice;
	try{
	    grossPrice = Double.parseDouble(grossPriceOutlet.getText());
	    grossPriceOutlet.setForeground(Color.black);
	    grossPriceFormattedOutlet.setForeground(Color.black);
	    grossPriceFormattedOutlet.setText(new DecimalFormat("0.000").format(grossPrice)+" euro");
	} catch(Exception e){
	    grossPriceOutlet.setForeground(Color.red);
	    grossPriceFormattedOutlet.setForeground(Color.red);
	    grossPriceFormattedOutlet.setText("??? euro");
	    netPriceOutlet.setForeground(Color.red);
	    netPriceOutlet.setText("???");
	    netPriceFormattedOutlet.setForeground(Color.red);
	    netPriceFormattedOutlet.setText("??? euro");
	    failed = true;
	    grossPrice = 0.0;
	}
	
	if (failed) {
	    return;
	}
	
	netPriceOutlet.setText(""+grossPrice * (1.0 + 0.01*taxes));
	netPriceOutlet.setForeground(Color.BLACK);
	netPriceFormattedOutlet.setText(new DecimalFormat("0.00").format(grossPrice * (1.0 + 0.01*taxes))+" euro");
	netPriceFormattedOutlet.setForeground(Color.black);
    }
    
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try{
	    model.setName(nameOutlet.getText());
	    model.setDate(new DateFormatter(dp.getDateFormat()).valueToString(dp.getDate()));
	    model.setNotes(notesOutlet.getText());
	    Supplier supp;
	    if (supplierBox.getSelectedItem() instanceof Supplier) {
		supp = (Supplier)supplierBox.getSelectedItem();
	    } else if (supplierBox.getSelectedItem() instanceof String) {
		String s = (String)supplierBox.getSelectedItem();
		supp = Database.driver().getSuppliers().get(s.toLowerCase());
	    } else {
		supp = null;
	    }
	    model.setSupplier(supp);
	    model.setBrand(brandOutlet.getText());
	    model.setPackaging(packagingOutlet.getText());
	    model.setLossPercent(Double.parseDouble(lossOutlet.getText()));
	    model.setPricePerUnit(Double.parseDouble(pricePerUnitOutlet.getText()));
	    model.setTaxes(Double.parseDouble(taxesOutlet.getText()));
	    model.setWeightPerUnit(Double.parseDouble(weightPerUnitOutlet.getText()));

	    if(model.update()){
		delegate.updateList();
		this.dispose();
	    } else {
		JOptionPane.showMessageDialog(null, "Er is een fout opgetreden bij het opslaan van deze leverancier in de databank.", "Fout!", JOptionPane.ERROR_MESSAGE);
	    }
	} catch (Exception ex) {
	    System.err.println(ex.getMessage());
	    JOptionPane.showMessageDialog(null, Utilities.incorrectFormMessage, "Fout!", JOptionPane.ERROR_MESSAGE);
	}
    }//GEN-LAST:event_saveActionPerformed

    private void lossOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lossOutletKeyReleased
	updateGrossPriceOutlet();
    }//GEN-LAST:event_lossOutletKeyReleased

    private void taxesOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taxesOutletKeyReleased
        updateNetPriceOutlet();
    }//GEN-LAST:event_taxesOutletKeyReleased

    private void packagingOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_packagingOutletKeyReleased
        //update all the formatted labels that use packaging
	String cppu = pricePerUnitFormattedOutlet.getText();
	pricePerUnitFormattedOutlet.setText(cppu.substring(0, cppu.lastIndexOf("/")+1)+packagingOutlet.getText());
	String cwpu = weightPerUnitFormattedOutlet.getText();
	weightPerUnitFormattedOutlet.setText(cwpu.substring(0, cwpu.lastIndexOf("/")+1)+packagingOutlet.getText());
    }//GEN-LAST:event_packagingOutletKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField brandOutlet;
    private javax.swing.JButton cancel;
    private javax.swing.JPanel detail;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel fixedFields;
    private javax.swing.JLabel grossPriceFormattedOutlet;
    private javax.swing.JLabel grossPriceOutlet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lossFormattedOutlet;
    private javax.swing.JTextField lossOutlet;
    private javax.swing.JTextField nameOutlet;
    private javax.swing.JLabel netPriceFormattedOutlet;
    private javax.swing.JLabel netPriceOutlet;
    private javax.swing.JTextArea notesOutlet;
    private javax.swing.JTextField packagingOutlet;
    private javax.swing.JLabel pricePerUnitFormattedOutlet;
    private javax.swing.JTextField pricePerUnitOutlet;
    private javax.swing.JLabel pricePerWeightFormattedOutlet;
    private javax.swing.JLabel pricePerWeightOutlet;
    private javax.swing.JButton save;
    private javax.swing.JPanel stretchableFields;
    private javax.swing.JComboBox supplierOutlet;
    private javax.swing.JPanel supplierParent;
    private javax.swing.JLabel taxesFormattedOutlet;
    private javax.swing.JTextField taxesOutlet;
    private javax.swing.JLabel weightPerUnitFormattedOutlet;
    private javax.swing.JTextField weightPerUnitOutlet;
    // End of variables declaration//GEN-END:variables

}
