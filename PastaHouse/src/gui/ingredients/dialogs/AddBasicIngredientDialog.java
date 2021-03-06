/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ingredients.dialogs;

import database.Database;
import database.FunctionResult;
import database.extra.Ingredient;
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
import gui.utilities.validation.AbstractValidator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import org.jdesktop.swingx.JXTitledPanel;
import tools.Utilities;

/**
 *
 * @author Robin jr
 */
public class AddBasicIngredientDialog extends javax.swing.JDialog implements AddContactDelegate {

	private final AddBasicIngredientDelegate delegate;
	private final BasicIngredientModel model;
	private final AutocompleteCombobox supplierBox;
//    private final ButtonGroup buttons;

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

		notesOutlet.setFont(new Font(notesOutlet.getFont().getName(), Font.PLAIN, Utilities.fontSize()));

		taxesOutlet.setText("" + 6.0);
		taxesFormattedOutlet.setText(new DecimalFormat("0.00").format(new Double(6.0)) + " %");
		lossOutlet.setText("" + 0.0);
		lossFormattedOutlet.setText(new DecimalFormat("0.00").format(new Double(0.0)) + " %");

		TextFieldAutoHighlighter.installHighlighter(taxesOutlet);
		TextFieldAutoHighlighter.installHighlighter(lossOutlet);
		TextFieldAutoHighlighter.installHighlighter(pricePerWeightOutlet);
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

		packagingOutlet.setInputVerifier(new AbstractValidator(this, packagingOutlet, "Dit veld mag niet leeg zijn!") {

			@Override
			protected boolean validationCriteria(JComponent c) {
				return !packagingOutlet.getText().isEmpty();
			}
		});

//	weightPerUnitOutlet.setInputVerifier(new AbstractValidator(this, weightPerUnitOutlet, "Vul een geldig gewicht per eenheid in.") {
//
//	    @Override
//	    protected boolean validationCriteria(JComponent c) {
//		try{
//		    Double.parseDouble(weightPerUnitOutlet.getText());
//		    return true;
//		} catch (Exception e){
//		    return false;
//		}
//	    }
//	});
//	
//	pricePerUnitOutlet.setInputVerifier(new AbstractValidator(this, pricePerUnitOutlet, "Vul een geldige eenheidsprijs in.") {
//
//	    @Override
//	    protected boolean validationCriteria(JComponent c) {
//		try{
//		    Double.parseDouble(pricePerUnitOutlet.getText());
//		    return true;
//		} catch (Exception e){
//		    return false;
//		}
//	    }
//	});
//	
//	pricePerWeightOutlet.setInputVerifier(new AbstractValidator(this, pricePerWeightOutlet, "Vul een geldige prijs per kg in.") {
//
//	    @Override
//	    protected boolean validationCriteria(JComponent c) {
//		try{
//		    Double.parseDouble(pricePerWeightOutlet.getText());
//		    return true;
//		} catch (Exception e){
//		    return false;
//		}
//	    }
//	});
		nameOutlet.setInputVerifier(new AbstractValidator(this, nameOutlet, "De naam moet uniek en niet leeg zijn!") {

			@Override
			protected boolean validationCriteria(JComponent c) {
				try {
					if (nameOutlet.getText().isEmpty()) {
						return false;
					}
					List<Ingredient> ingrs = database.Database.driver().getIngredients();
					for (Ingredient ingredient : ingrs) {
						if (ingredient.getName().equalsIgnoreCase(nameOutlet.getText())) {
							return false;
						}
					}
					return true;
				} catch (Exception e) {
					return false;
				}
			}
		});
		lossOutlet.setInputVerifier(new AbstractValidator(this, lossOutlet, "Gelieve een geldige waarde tussen 0.0 inclusief en 100.0 exclusief (%) in te voeren.") {

			@Override
			protected boolean validationCriteria(JComponent c) {
				try {
					double d = Double.parseDouble(lossOutlet.getText());
					return d >= 0 && d < 100;
				} catch (Exception e) {
					return false;
				}
			}
		});
		taxesOutlet.setInputVerifier(new AbstractValidator(this, taxesOutlet, "Gelieve een geldige, positieve waarde in te geven (%).") {

			@Override
			protected boolean validationCriteria(JComponent c) {
				try {
					double d = Double.parseDouble(taxesOutlet.getText());
					return d >= 0;
				} catch (Exception e) {
					return false;
				}
			}
		});

		add(new JXTitledPanel("Details", fixedFields), BorderLayout.NORTH);
		add(new JXTitledPanel("Opmerkingen", stretchableFields), BorderLayout.CENTER);

		updatePricePanel();

		nameOutlet.requestFocus();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        fixedFields = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameOutlet = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        brandOutlet = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        supplierParent = new javax.swing.JPanel();
        supplierOutlet = new javax.swing.JComboBox();
        addSupplier = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        packaging = new javax.swing.JLabel();
        packagingOutlet = new javax.swing.JTextField();
        weightPerUnit = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        weightPerUnitOutlet = new javax.swing.JTextField();
        weightPerUnitFormattedOutlet = new javax.swing.JLabel();
        pricePerUnit = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pricePerUnitOutlet = new javax.swing.JTextField();
        pricePerUnitFormattedOutlet = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        pricePerWeightOutlet = new javax.swing.JTextField();
        pricePerWeightFormattedOutlet = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
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
        bulkOutlet = new javax.swing.JRadioButton();
        perUnitOutlet = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jPanel4 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        fixedFields.setLayout(new java.awt.GridBagLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        jPanel9.setLayout(new java.awt.GridLayout(3, 2));

        jLabel1.setText("Ingrediënt");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jLabel1.setFocusable(false);
        jPanel9.add(jLabel1);
        jPanel9.add(nameOutlet);

        jLabel2.setText("Merk");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jLabel2.setFocusable(false);
        jPanel9.add(jLabel2);
        jPanel9.add(brandOutlet);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Leverancier");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jLabel4.setFocusable(false);
        jPanel7.add(jLabel4, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel7);

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

        jPanel9.add(supplierParent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        fixedFields.add(jPanel9, gridBagConstraints);

        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        jPanel10.setLayout(new java.awt.GridLayout(4, 2));

        packaging.setText("Verpakking");
        packaging.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        packaging.setFocusable(false);
        jPanel10.add(packaging);

        packagingOutlet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                packagingOutletKeyReleased(evt);
            }
        });
        jPanel10.add(packagingOutlet);

        weightPerUnit.setText("Gewicht per verpakking");
        weightPerUnit.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        weightPerUnit.setFocusable(false);
        jPanel10.add(weightPerUnit);

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

        jPanel10.add(jPanel2);

        pricePerUnit.setText("Prijs per verpakking (BTW excl) *");
        pricePerUnit.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pricePerUnit.setFocusable(false);
        jPanel10.add(pricePerUnit);

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

        jPanel10.add(jPanel1);

        jLabel8.setText("Prijs per kg (BTW excl)");
        jLabel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jLabel8.setFocusable(false);
        jPanel10.add(jLabel8);

        jPanel8.setFocusable(false);
        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        pricePerWeightOutlet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pricePerWeightOutletKeyReleased(evt);
            }
        });
        jPanel8.add(pricePerWeightOutlet);

        pricePerWeightFormattedOutlet.setText("<pricePerWeightFormattedOutlet>");
        pricePerWeightFormattedOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pricePerWeightFormattedOutlet.setFocusable(false);
        jPanel8.add(pricePerWeightFormattedOutlet);

        jPanel10.add(jPanel8);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        fixedFields.add(jPanel10, gridBagConstraints);

        jPanel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 0, 0));
        jPanel11.setLayout(new java.awt.GridLayout(2, 2));

        jLabel7.setText("Verliespercentage");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jLabel7.setFocusable(false);
        jPanel11.add(jLabel7);

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

        jPanel11.add(jPanel5);

        jLabel11.setText("BTW");
        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jLabel11.setFocusable(false);
        jPanel11.add(jLabel11);

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

        jPanel11.add(jPanel6);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        fixedFields.add(jPanel11, gridBagConstraints);

        stretchableFields.setFocusable(false);
        stretchableFields.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setFocusable(false);

        notesOutlet.setColumns(20);
        notesOutlet.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        notesOutlet.setLineWrap(true);
        notesOutlet.setRows(1);
        notesOutlet.setWrapStyleWord(true);
        jScrollPane1.setViewportView(notesOutlet);

        stretchableFields.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        bulkOutlet.setText("Bulk");

        perUnitOutlet.setText("Verpakking");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(430, 380));
        setPreferredSize(new java.awt.Dimension(600, 800));

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

	private void updatePricePanel() {
		pricePerWeightOutlet.setText("");
//	pricePerWeightOutlet.setText("" + 0.0);
//	pricePerWeightFormattedOutlet.setText(new DecimalFormat("0.000").format(0.0) + " euro/kg");
		pricePerWeightFormattedOutlet.setText("");
//	if (bulkOutlet.isSelected()) {
//	    packagingOutlet.setEnabled(false);
//	    weightPerUnitOutlet.setEnabled(false);
//	    weightPerUnitOutlet.setText(null);
//	    pricePerUnitOutlet.setEnabled(false);
//	    pricePerUnitOutlet.setText(null);
//	    packagingOutlet.setText(null);
//
//	    packaging.setEnabled(false);
//	    weightPerUnit.setEnabled(false);
//	    pricePerUnit.setEnabled(false);
//
//	    weightPerUnitFormattedOutlet.setText("In bulk");
//	    pricePerUnitFormattedOutlet.setText("In bulk");
//
//	    pricePerWeightOutlet.setEnabled(true);
//
//	    pricePerWeightOutlet.requestFocus();
//	} else {
//	    pricePerWeightOutlet.setEnabled(false);
//
//	    packaging.setEnabled(true);
//	    weightPerUnit.setEnabled(true);
//	    pricePerUnit.setEnabled(true);
//
//	    packagingOutlet.setEnabled(true);
//	    weightPerUnitOutlet.setEnabled(true);
//	    pricePerUnitOutlet.setEnabled(true);
		packagingOutlet.setText("");
//	    weightPerUnitOutlet.setText("" + 0.0);
//	    weightPerUnitFormattedOutlet.setText(new DecimalFormat("0.000").format(0.0) + " kg/" + packagingOutlet.getText());
		weightPerUnitFormattedOutlet.setText("");
//	    pricePerUnitOutlet.setText("" + 0.0);
//	    pricePerUnitFormattedOutlet.setText(new DecimalFormat("0.000").format(0.0) + " euro/" + packagingOutlet.getText());
		pricePerUnitFormattedOutlet.setText("");
//
//	    packagingOutlet.requestFocus();
//	}
	}

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
		disposeLater();
    }//GEN-LAST:event_cancelActionPerformed

    private void taxesOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taxesOutletKeyReleased
		try {
			taxesFormattedOutlet.setText(new DecimalFormat("0.00").format(Double.parseDouble(taxesOutlet.getText())) + " %");
			taxesFormattedOutlet.setForeground(Color.black);
			taxesOutlet.setForeground(Color.black);
		} catch (Exception e) {
			taxesFormattedOutlet.setForeground(Color.red);
			taxesOutlet.setForeground(Color.red);
			taxesFormattedOutlet.setText("??? %");
			System.err.println("Exception: " + e.getMessage());
		}
    }//GEN-LAST:event_taxesOutletKeyReleased

    private void packagingOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_packagingOutletKeyReleased
		String ppu = pricePerUnitFormattedOutlet.getText();
		pricePerUnitFormattedOutlet.setText(ppu.substring(0, ppu.lastIndexOf("/") + 1) + packagingOutlet.getText().toLowerCase());
		String wpu = weightPerUnitFormattedOutlet.getText();
		weightPerUnitFormattedOutlet.setText(wpu.substring(0, wpu.lastIndexOf("/") + 1) + packagingOutlet.getText().toLowerCase());
    }//GEN-LAST:event_packagingOutletKeyReleased

    private void lossOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lossOutletKeyReleased
		try {
			lossFormattedOutlet.setText(new DecimalFormat("0.00").format(Double.parseDouble(lossOutlet.getText())) + " %");
			lossOutlet.setForeground(Color.black);
			lossFormattedOutlet.setForeground(Color.black);
		} catch (Exception e) {
			lossFormattedOutlet.setForeground(Color.red);
			lossOutlet.setForeground(Color.red);
			lossFormattedOutlet.setText("??? %");
			System.err.println("Exception: " + e.getMessage());
		}
    }//GEN-LAST:event_lossOutletKeyReleased

    private void weightPerUnitOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_weightPerUnitOutletKeyReleased
		try {
			weightPerUnitFormattedOutlet.setText(new DecimalFormat("0.000").format(Double.parseDouble(weightPerUnitOutlet.getText())) + " kg/" + packagingOutlet.getText());
			weightPerUnitFormattedOutlet.setForeground(Color.black);
			weightPerUnitOutlet.setForeground(Color.black);
		} catch (Exception e) {
			weightPerUnitFormattedOutlet.setText("??? kg/" + packagingOutlet.getText().toLowerCase());
			weightPerUnitFormattedOutlet.setForeground(Color.red);
			weightPerUnitOutlet.setForeground(Color.red);
			System.err.println("Exception: " + e.getMessage());
		}
//	updatePricePerWeight();
		pricePerUnitOutlet.setText("");
		pricePerUnitFormattedOutlet.setText("");
		pricePerWeightOutlet.setText("");
		pricePerWeightFormattedOutlet.setText("");
    }//GEN-LAST:event_weightPerUnitOutletKeyReleased

    private void pricePerUnitOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pricePerUnitOutletKeyReleased
		try {
			pricePerUnitFormattedOutlet.setText(new DecimalFormat("0.000").format(Double.parseDouble(pricePerUnitOutlet.getText())) + " euro/" + packagingOutlet.getText());
			pricePerUnitFormattedOutlet.setForeground(Color.black);
			pricePerUnitOutlet.setForeground(Color.black);
		} catch (Exception e) {
			pricePerUnitFormattedOutlet.setForeground(Color.red);
			pricePerUnitOutlet.setForeground(Color.red);
			pricePerUnitFormattedOutlet.setText("??? euro/" + packagingOutlet.getText().toLowerCase());
			System.err.println("Exception: " + e.getMessage());
		}
		try {
			Double.parseDouble(weightPerUnitOutlet.getText());
			updatePricePerWeight();
		} catch (Exception ex) {
		}
    }//GEN-LAST:event_pricePerUnitOutletKeyReleased

	private void updatePricePerUnit() {
		boolean failed = false;

		double wpu;
		try {
			wpu = Double.parseDouble(weightPerUnitOutlet.getText());
		} catch (Exception e) {
			pricePerWeightOutlet.setText("");
			pricePerWeightOutlet.setForeground(Color.red);
			pricePerWeightFormattedOutlet.setText("??? euro/kg");
			pricePerWeightFormattedOutlet.setForeground(Color.red);

			failed = true;
			wpu = 1.0;
		}

		double ppw;
		try {
			ppw = Double.parseDouble(pricePerWeightOutlet.getText());
		} catch (Exception e) {
			pricePerUnitOutlet.setText("");
			pricePerUnitOutlet.setForeground(Color.red);
			pricePerUnitFormattedOutlet.setText("??? euro/kg");
			pricePerUnitFormattedOutlet.setForeground(Color.red);

			failed = true;
			ppw = 0.0;
		}

		if (failed) {
			return;
		}
		double ppu = ppw * wpu;
		pricePerUnitOutlet.setText("" + ppu);
		pricePerUnitOutlet.setForeground(Color.black);
		pricePerUnitFormattedOutlet.setText(new DecimalFormat("0.000").format(ppu) + " euro/" + packagingOutlet.getText().toLowerCase());
		pricePerUnitFormattedOutlet.setForeground(Color.black);
	}

	private void updatePricePerWeight() {
		boolean failed = false;

		double wpu;
		try {
			wpu = Double.parseDouble(weightPerUnitOutlet.getText());
		} catch (Exception e) {
			pricePerWeightOutlet.setText("");
			pricePerWeightOutlet.setForeground(Color.red);
			pricePerWeightFormattedOutlet.setText("??? euro/kg");
			pricePerWeightFormattedOutlet.setForeground(Color.red);

			failed = true;
			wpu = 1.0;
		}

		double ppu;
		try {
			ppu = Double.parseDouble(pricePerUnitOutlet.getText());
		} catch (Exception e) {
			pricePerWeightOutlet.setText("");
			pricePerWeightOutlet.setForeground(Color.red);
			pricePerWeightFormattedOutlet.setText("??? euro/kg");
			pricePerWeightFormattedOutlet.setForeground(Color.red);

			failed = true;
			ppu = 0.0;
		}

		if (failed) {
			return;
		}
		double ppw = ppu / wpu;
		pricePerWeightOutlet.setText("" + ppw);
		pricePerWeightOutlet.setForeground(Color.black);
		pricePerWeightFormattedOutlet.setText(new DecimalFormat("0.000").format(ppw) + " euro/kg");
		pricePerWeightFormattedOutlet.setForeground(Color.black);
	}

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
		try {
			/*
			 * Validity check
			 */
			if (!valid()) {
				return;
			}

			/*
			 * Warnings
			 */
			double ppw = Double.parseDouble(pricePerWeightOutlet.getText());
			if (ppw == 0) {
				int result = JOptionPane.showOptionDialog(null, "Bent u zeker dat de prijs 0 is?", "Opgelet!", 0, JOptionPane.WARNING_MESSAGE, null, new String[]{"Ja", "Aanpassen"}, "Ja");
				if (result != 0) {
					if (bulkOutlet.isSelected()) {
						pricePerWeightOutlet.requestFocus();
					} else {
						pricePerUnitOutlet.requestFocus();
					}
					return;
				}
			}

			/*
			 * Set values on the model
			 */
			model.setName(nameOutlet.getText());
			model.setDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			model.setBrand(brandOutlet.getText());
//	    if (bulkOutlet.isSelected()) {
//		model.setPackaging("Bulk");
//		model.setWeightPerUnit(-1);
//		model.setPricePerUnit(-1);
//	    } else {
			model.setPackaging(packagingOutlet.getText());
			model.setWeightPerUnit(weightPerUnitOutlet.getText().isEmpty() ? 0.0 : Double.parseDouble(weightPerUnitOutlet.getText()));
			model.setPricePerUnit(weightPerUnitOutlet.getText().isEmpty() ? 0.0 : Double.parseDouble(pricePerUnitOutlet.getText()));
//	    }
			model.setPricePerWeight(Double.parseDouble(pricePerWeightOutlet.getText()));
			model.setLossPercent(Double.parseDouble(lossOutlet.getText()));
			model.setTaxes(Double.parseDouble(taxesOutlet.getText()));
			model.setNotes(notesOutlet.getText());

			Contact s = null;
			if (supplierBox.getSelectedItem() instanceof Contact) {
				s = (Contact) supplierBox.getSelectedItem();
			} else if (supplierBox.getSelectedItem() instanceof String) {
				s = Database.driver().getSuppliersAlphabetically().get(((String) supplierBox.getSelectedItem()).toLowerCase());
			}
			if (s == null) {
				throw new Exception("Supplier " + (String) supplierBox.getSelectedItem() + " was not found in the database.");
			}
			model.setSupplier(s);

			FunctionResult<BasicIngredient> res = model.create();
			if (res.getCode() == 0 && res.getObj() != null) {
				delegate.addBasicIngredient(res.getObj());
				disposeLater();
			} else {
				// switch case error code
				String msg;
				switch (res.getCode()) {
					case 1:
						msg = "Controleer of alle velden uniek zijn. Informatie van de databank:\n" + res.getMessage();
						break;
					case 4:
						msg = res.getMessage();
						break;
					default:
						msg = "Het toevoegen van het basisingrediënt is foutgelopen (code " + res.getCode() + "). Contacteer de ontwikkelaars met deze informatie.";
				}
				JOptionPane.showMessageDialog(null, msg, "Fout!", JOptionPane.ERROR_MESSAGE);
//		disposeLater();
			}
		} catch (Exception e) {
			System.err.println("Error: \n" + e.getMessage());
			JOptionPane.showMessageDialog(null, tools.Utilities.incorrectFormMessage, "Fout!", JOptionPane.WARNING_MESSAGE);
		}
    }//GEN-LAST:event_addActionPerformed

    private void addSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSupplierActionPerformed
		AddContactDialog.createSupplierDialog(this).setVisible(true);
    }//GEN-LAST:event_addSupplierActionPerformed

    private void pricePerWeightOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pricePerWeightOutletKeyReleased
		try {
			pricePerWeightFormattedOutlet.setText(new DecimalFormat("0.000").format(Double.parseDouble(pricePerWeightOutlet.getText())) + " euro/kg");
			pricePerWeightFormattedOutlet.setForeground(Color.black);
			pricePerWeightOutlet.setForeground(Color.black);
		} catch (Exception e) {
			pricePerWeightFormattedOutlet.setForeground(Color.red);
			pricePerWeightOutlet.setForeground(Color.red);
			pricePerWeightFormattedOutlet.setText("??? euro/kg");
			System.err.println("Exception: " + e.getMessage());
		}

		try {
			Double.parseDouble(weightPerUnitOutlet.getText());
			updatePricePerUnit();
		} catch (Exception ex) {
		}
    }//GEN-LAST:event_pricePerWeightOutletKeyReleased

	private void disposeLater() {
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
    private javax.swing.JRadioButton bulkOutlet;
    private javax.swing.JButton cancel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel fixedFields;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lossFormattedOutlet;
    private javax.swing.JTextField lossOutlet;
    private javax.swing.JTextField nameOutlet;
    private javax.swing.JTextArea notesOutlet;
    private javax.swing.JLabel packaging;
    private javax.swing.JTextField packagingOutlet;
    private javax.swing.JRadioButton perUnitOutlet;
    private javax.swing.JLabel pricePerUnit;
    private javax.swing.JLabel pricePerUnitFormattedOutlet;
    private javax.swing.JTextField pricePerUnitOutlet;
    private javax.swing.JLabel pricePerWeightFormattedOutlet;
    private javax.swing.JTextField pricePerWeightOutlet;
    private javax.swing.JPanel stretchableFields;
    private javax.swing.JComboBox supplierOutlet;
    private javax.swing.JPanel supplierParent;
    private javax.swing.JLabel taxesFormattedOutlet;
    private javax.swing.JTextField taxesOutlet;
    private javax.swing.JLabel weightPerUnit;
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

	private boolean valid() {
		if (!nameOutlet.getInputVerifier().verify(nameOutlet)) {
			JOptionPane.showMessageDialog(null, "Gelieve een geldige naam in te voeren!", "Fout!", JOptionPane.ERROR_MESSAGE);
			nameOutlet.requestFocus();
			return false;
		}

		if (supplierBox.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Gelieve een geldige leverancier te kiezen!", "Fout!", JOptionPane.ERROR_MESSAGE);
			supplierBox.requestFocus();
			return false;
		}

//	if (!bulkOutlet.isSelected()) {
//	    /*
//	     * Test packaging
//	     */
		if (packagingOutlet.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Gelieve een geldige verpakking in te geven!", "Fout!", JOptionPane.ERROR_MESSAGE);
			packagingOutlet.requestFocus();
			return false;
		}
//	    /*
//	     * Test WPU
//	     */
		try {
			double wpu = Double.parseDouble(weightPerUnitOutlet.getText());
			if (wpu <= 0) {
				throw new Exception("Gewicht per eenheid moet een positief getal zijn!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Gelieve een geldige, strikt positief gewicht per eenheid in te geven!\n(Gewicht mag niet 0.0 zijn)", "Fout!", JOptionPane.ERROR_MESSAGE);
			weightPerUnitOutlet.requestFocus();
			return false;
		}
//	    /*
//	     * Test PPU
//	     */
		try {
			double ppu = Double.parseDouble(pricePerUnitOutlet.getText());
			if (ppu < 0) {
				throw new Exception("Prijs per eenheid moet een positief getal zijn!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Gelieve een geldige, positieve prijs per eenheid in te geven!", "Fout!", JOptionPane.ERROR_MESSAGE);
			pricePerUnitOutlet.requestFocus();
			return false;
		}
//	} else {
		/*
		 * Test PPW
		 */
		try {
			double d = Double.parseDouble(pricePerWeightOutlet.getText());
			if (d < 0.0) {
				throw new Exception("Prijs per gewicht moet een positief getal zijn!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Gelieve een geldige, positieve prijs per kg in te geven!", "Fout!", JOptionPane.ERROR_MESSAGE);
			pricePerWeightOutlet.requestFocus();
			return false;
		}
//	}

		if (!lossOutlet.getInputVerifier().verify(lossOutlet)) {
			JOptionPane.showMessageDialog(null, "Kijk het verliespercentage na!", "Fout!", JOptionPane.ERROR_MESSAGE);
			lossOutlet.requestFocus();
			return false;
		}

		if (!taxesOutlet.getInputVerifier().verify(taxesOutlet)) {
			JOptionPane.showMessageDialog(null, "Kijk het BTWpercentage na!", "Fout!", JOptionPane.ERROR_MESSAGE);
			nameOutlet.requestFocus();
			return false;
		}
		return true;
	}
}
