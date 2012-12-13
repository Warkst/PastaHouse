/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ingredients.dialogs;

import database.Database;
import database.FunctionResult;
import database.models.BasicIngredientModel;
import database.tables.BasicIngredient;
import database.tables.Contact;
import gui.contacts.delegates.AddContactDelegate;
import gui.contacts.dialogs.AddContactDialog;
import gui.ingredients.delegates.AddBasicIngredientDelegate;
import gui.utilities.AcceleratorAdder;
import gui.utilities.KeyAction;
import gui.utilities.TextFieldAutoHighlighter;
import gui.utilities.combobox.AutocompleteCombobox;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

/**
 *
 * @author Robin jr
 */
public class AddBasicIngredientDialog extends javax.swing.JDialog implements AddContactDelegate{

    private final AddBasicIngredientDelegate delegate;
    private final BasicIngredientModel model;
    private final AutocompleteCombobox supplierBox;
    
    /**
     * Creates new form AddBasicIngredientDialog
     */
    public AddBasicIngredientDialog(java.awt.Frame parent, boolean modal, AddBasicIngredientDelegate delegate) {
	super(parent, modal);
	initComponents();
	
	this.delegate = delegate;
	this.model = new BasicIngredientModel();
	
	setLocationRelativeTo(null);
	setTitle("Ingrediënt toevoegen");
	
//	supplierOutlet.setModel(ComboBoxModelFactory.createSupplierComboBoxModel(Database.driver().getSuppliers().values().toArray()));
	
	supplierParent.removeAll();
	List suppliers = new ArrayList();
	suppliers.add("");
	suppliers.addAll(Database.driver().getSuppliersAlphabetically().values());
	supplierBox = new AutocompleteCombobox(suppliers);
	supplierParent.add(supplierBox, BorderLayout.CENTER);
	supplierParent.add(addSupplier, BorderLayout.EAST);
	
	taxesOutlet.setText(""+21.0);
	taxesFormattedOutlet.setText(new DecimalFormat("0.00").format(new Double(21.0))+" %");
	lossOutlet.setText(""+0.0);
	lossFormattedOutlet.setText(new DecimalFormat("0.00").format(new Double(0.0))+" %");
	pricePerUnitOutlet.setText(""+0.0);
	pricePerUnitFormattedOutlet.setText(new DecimalFormat("0.000").format(new Double(0.0))+" euro/");
	weightPerUnitOutlet.setText(""+0.0);
	weightPerUnitFormattedOutlet.setText(new DecimalFormat("0.000").format(new Double(0.0))+" kg/");
	
	TextFieldAutoHighlighter.installHighlighter(taxesOutlet);
	TextFieldAutoHighlighter.installHighlighter(lossOutlet);
	TextFieldAutoHighlighter.installHighlighter(pricePerUnitOutlet);
	TextFieldAutoHighlighter.installHighlighter(weightPerUnitOutlet);
	
	AcceleratorAdder.addAccelerator(add, KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), new KeyAction() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		addActionPerformed(e);
	    }
	});
	
	AcceleratorAdder.addAccelerator(cancel, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), new KeyAction() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		cancelActionPerformed(e);
	    }
	});
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fixedFields = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameOutlet = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        brandOutlet = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        packagingOutlet = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        supplierParent = new javax.swing.JPanel();
        supplierOutlet = new javax.swing.JComboBox();
        addSupplier = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pricePerUnitOutlet = new javax.swing.JTextField();
        pricePerUnitFormattedOutlet = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        weightPerUnitOutlet = new javax.swing.JTextField();
        weightPerUnitFormattedOutlet = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lossOutlet = new javax.swing.JTextField();
        lossFormattedOutlet = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        taxesOutlet = new javax.swing.JTextField();
        taxesFormattedOutlet = new javax.swing.JLabel();
        stretchableFields = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notesOutlet = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jPanel4 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(430, 380));
        setPreferredSize(new java.awt.Dimension(500, 500));

        fixedFields.setLayout(new java.awt.GridLayout(8, 2, -1, 0));

        jLabel1.setText("Naam *");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jLabel1.setFocusable(false);
        fixedFields.add(jLabel1);
        fixedFields.add(nameOutlet);

        jLabel2.setText("Merk");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jLabel2.setFocusable(false);
        fixedFields.add(jLabel2);
        fixedFields.add(brandOutlet);

        jLabel3.setText("Verpakking");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jLabel3.setFocusable(false);
        fixedFields.add(jLabel3);

        packagingOutlet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                packagingOutletKeyReleased(evt);
            }
        });
        fixedFields.add(packagingOutlet);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Leverancier");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jLabel4.setFocusable(false);
        jPanel7.add(jLabel4, java.awt.BorderLayout.CENTER);

        fixedFields.add(jPanel7);

        supplierParent.setFocusable(false);
        supplierParent.setLayout(new java.awt.BorderLayout());

        supplierOutlet.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        supplierParent.add(supplierOutlet, java.awt.BorderLayout.CENTER);

        addSupplier.setText("+");
        addSupplier.setToolTipText("Klik hier om een nieuwe leverancier toe te voegen.");
        addSupplier.setFocusable(false);
        addSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSupplierActionPerformed(evt);
            }
        });
        supplierParent.add(addSupplier, java.awt.BorderLayout.EAST);

        fixedFields.add(supplierParent);

        jLabel5.setText("Prijs per verpakking (BTW excl) *");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jLabel5.setFocusable(false);
        fixedFields.add(jLabel5);

        jPanel1.setFocusable(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        pricePerUnitOutlet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pricePerUnitOutletKeyReleased(evt);
            }
        });
        jPanel1.add(pricePerUnitOutlet);

        pricePerUnitFormattedOutlet.setText("<pricePerUnitFormattedOutlet>");
        pricePerUnitFormattedOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pricePerUnitFormattedOutlet.setFocusable(false);
        jPanel1.add(pricePerUnitFormattedOutlet);

        fixedFields.add(jPanel1);

        jLabel6.setText("Gewicht per verpakking *");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jLabel6.setFocusable(false);
        fixedFields.add(jLabel6);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        weightPerUnitOutlet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                weightPerUnitOutletKeyReleased(evt);
            }
        });
        jPanel2.add(weightPerUnitOutlet);

        weightPerUnitFormattedOutlet.setText("<weightPerUnitFormattedOutlet>");
        weightPerUnitFormattedOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        weightPerUnitFormattedOutlet.setFocusable(false);
        jPanel2.add(weightPerUnitFormattedOutlet);

        fixedFields.add(jPanel2);

        jLabel7.setText("Verliespercentage *");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jLabel7.setFocusable(false);
        fixedFields.add(jLabel7);

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        lossOutlet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lossOutletKeyReleased(evt);
            }
        });
        jPanel5.add(lossOutlet);

        lossFormattedOutlet.setText("<lossFormattedOutlet>");
        lossFormattedOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        lossFormattedOutlet.setFocusable(false);
        jPanel5.add(lossFormattedOutlet);

        fixedFields.add(jPanel5);

        jLabel11.setText("BTW *");
        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jLabel11.setFocusable(false);
        fixedFields.add(jLabel11);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        taxesOutlet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                taxesOutletKeyReleased(evt);
            }
        });
        jPanel6.add(taxesOutlet);

        taxesFormattedOutlet.setText("<taxesFormattedOutlet>");
        taxesFormattedOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        taxesFormattedOutlet.setFocusable(false);
        jPanel6.add(taxesFormattedOutlet);

        fixedFields.add(jPanel6);

        getContentPane().add(fixedFields, java.awt.BorderLayout.NORTH);

        stretchableFields.setFocusable(false);
        stretchableFields.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opmerkingen:"));
        jScrollPane1.setFocusable(false);

        notesOutlet.setColumns(20);
        notesOutlet.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        notesOutlet.setRows(5);
        jScrollPane1.setViewportView(notesOutlet);

        stretchableFields.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(stretchableFields, java.awt.BorderLayout.CENTER);

        jPanel3.setFocusable(false);
        jPanel3.setLayout(new java.awt.BorderLayout());

        filler1.setFocusable(false);
        jPanel3.add(filler1, java.awt.BorderLayout.CENTER);

        jPanel4.setFocusable(false);
        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        add.setText("Aanmaken");
        add.setFocusable(false);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel4.add(add);

        cancel.setText("Terug");
        cancel.setFocusable(false);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel4.add(cancel);

        jPanel3.add(jPanel4, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        disposeLater();
    }//GEN-LAST:event_cancelActionPerformed

    private void taxesOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taxesOutletKeyReleased
       try{
	   taxesFormattedOutlet.setText(new DecimalFormat("0.00").format(Double.parseDouble(taxesOutlet.getText())) +" %");
	   taxesFormattedOutlet.setForeground(Color.black);
	   taxesOutlet.setForeground(Color.black);
       } catch(Exception e){
	   taxesFormattedOutlet.setForeground(Color.red);
	   taxesOutlet.setForeground(Color.red);
	   taxesFormattedOutlet.setText("??? %");
	   System.err.println("Exception: "+e.getMessage());
       }
    }//GEN-LAST:event_taxesOutletKeyReleased

    private void packagingOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_packagingOutletKeyReleased
        String ppu = pricePerUnitFormattedOutlet.getText();
	pricePerUnitFormattedOutlet.setText(ppu.substring(0, ppu.lastIndexOf("/")+1)+packagingOutlet.getText().toLowerCase());
	String wpu = weightPerUnitFormattedOutlet.getText();
	weightPerUnitFormattedOutlet.setText(wpu.substring(0, wpu.lastIndexOf("/")+1)+packagingOutlet.getText().toLowerCase());
    }//GEN-LAST:event_packagingOutletKeyReleased

    private void lossOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lossOutletKeyReleased
        try{
	   lossFormattedOutlet.setText(new DecimalFormat("0.00").format(Double.parseDouble(lossOutlet.getText())) +" %");
	   lossOutlet.setForeground(Color.black);
	   lossFormattedOutlet.setForeground(Color.black);
       } catch(Exception e){
	   lossFormattedOutlet.setForeground(Color.red);
	   lossOutlet.setForeground(Color.red);
	   lossFormattedOutlet.setText("??? %");
	   System.err.println("Exception: "+e.getMessage());
       }
    }//GEN-LAST:event_lossOutletKeyReleased

    private void weightPerUnitOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_weightPerUnitOutletKeyReleased
        try{
	   weightPerUnitFormattedOutlet.setText(new DecimalFormat("0.000").format(Double.parseDouble(weightPerUnitOutlet.getText())) +" kg/"+packagingOutlet.getText());
	   weightPerUnitFormattedOutlet.setForeground(Color.black);
	   weightPerUnitOutlet.setForeground(Color.black);
       } catch(Exception e){
	   weightPerUnitFormattedOutlet.setText("??? kg/"+packagingOutlet.getText());
	   weightPerUnitFormattedOutlet.setForeground(Color.red);
	   weightPerUnitOutlet.setForeground(Color.red);
	   System.err.println("Exception: "+e.getMessage());
       }
    }//GEN-LAST:event_weightPerUnitOutletKeyReleased

    private void pricePerUnitOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pricePerUnitOutletKeyReleased
        try{
	   pricePerUnitFormattedOutlet.setText(new DecimalFormat("0.000").format(Double.parseDouble(pricePerUnitOutlet.getText())) +" euro/"+packagingOutlet.getText());
	   pricePerUnitFormattedOutlet.setForeground(Color.black);
	   pricePerUnitOutlet.setForeground(Color.black);
       } catch(Exception e){
	   pricePerUnitFormattedOutlet.setForeground(Color.red);
	   pricePerUnitOutlet.setForeground(Color.red);
	   pricePerUnitFormattedOutlet.setText("??? euro/"+packagingOutlet.getText());
	   System.err.println("Exception: "+e.getMessage());
       }
    }//GEN-LAST:event_pricePerUnitOutletKeyReleased

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
	try{
	    if (nameOutlet.getText().isEmpty()
		    || weightPerUnitOutlet.getText().isEmpty()
		    || pricePerUnitOutlet.getText().isEmpty()
		    || taxesOutlet.getText().isEmpty()
		    || lossOutlet.getText().isEmpty()) {
		JOptionPane.showMessageDialog(null, tools.Utilities.incompleteFormMessage, "Fout!", JOptionPane.WARNING_MESSAGE);
		return;
	    }
	    
	    /*
	     * Set values on the model
	     */
	    model.setName(nameOutlet.getText());
	    model.setDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
	    model.setBrand(brandOutlet.getText());
	    model.setPackaging(packagingOutlet.getText());
	    model.setWeightPerUnit(Double.parseDouble(weightPerUnitOutlet.getText()));
	    model.setPricePerUnit(Double.parseDouble(pricePerUnitOutlet.getText()));
	    model.setLossPercent(Double.parseDouble(lossOutlet.getText()));
	    model.setTaxes(Double.parseDouble(taxesOutlet.getText()));
	    model.setNotes(notesOutlet.getText());
	    
	    Contact s = null;
	    if (supplierBox.getSelectedItem() instanceof Contact) {
		s = (Contact)supplierBox.getSelectedItem();
	    } else if(supplierBox.getSelectedItem() instanceof String){
		s = Database.driver().getSuppliersAlphabetically().get(((String)supplierBox.getSelectedItem()).toLowerCase());
	    }
	    if (s==null) {
		throw new Exception("Supplier "+(String)supplierBox.getSelectedItem()+" was not found in the database.");
	    }
	    model.setSupplier(s);
	    
	    FunctionResult<BasicIngredient> res = model.create();
	    if (res.getCode() == 0 && res.getObj() != null) {
		delegate.addBasicIngredient(res.getObj());
		disposeLater();
	    } else {
		// switch case error code
		JOptionPane.showMessageDialog(null, "Het toevoegen van het basisingrediënt heeft foutcode "+res.getCode()+" opgeleverd. Contacteer de ontwikkelaars met deze informatie.", "Fout!", JOptionPane.ERROR_MESSAGE);
		disposeLater();
	    }
	} catch (Exception e){
	    System.err.println("Error: \n"+e.getMessage());
	    JOptionPane.showMessageDialog(null, tools.Utilities.incorrectFormMessage, "Fout!", JOptionPane.WARNING_MESSAGE);
	}
    }//GEN-LAST:event_addActionPerformed

    private void addSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSupplierActionPerformed
        AddContactDialog.createSupplierDialog(this).setVisible(true);
    }//GEN-LAST:event_addSupplierActionPerformed
    
    private void disposeLater(){
	SwingUtilities.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		dispose();
	    }
	});
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton addSupplier;
    private javax.swing.JTextField brandOutlet;
    private javax.swing.JButton cancel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel fixedFields;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lossFormattedOutlet;
    private javax.swing.JTextField lossOutlet;
    private javax.swing.JTextField nameOutlet;
    private javax.swing.JTextArea notesOutlet;
    private javax.swing.JTextField packagingOutlet;
    private javax.swing.JLabel pricePerUnitFormattedOutlet;
    private javax.swing.JTextField pricePerUnitOutlet;
    private javax.swing.JPanel stretchableFields;
    private javax.swing.JComboBox supplierOutlet;
    private javax.swing.JPanel supplierParent;
    private javax.swing.JLabel taxesFormattedOutlet;
    private javax.swing.JTextField taxesOutlet;
    private javax.swing.JLabel weightPerUnitFormattedOutlet;
    private javax.swing.JTextField weightPerUnitOutlet;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addContact(Contact s) {
	supplierParent.removeAll();
	List suppliers = new ArrayList();
	suppliers.add("");
	suppliers.addAll(Database.driver().getSuppliersAlphabetically().values());
	supplierBox.setDataList(suppliers);
	supplierParent.add(supplierBox, BorderLayout.CENTER);
	/*
	 * Select the newly created supplier
	 */
	supplierBox.setSelectedItem(s);
	
	pricePerUnitOutlet.requestFocus();
    }

}
