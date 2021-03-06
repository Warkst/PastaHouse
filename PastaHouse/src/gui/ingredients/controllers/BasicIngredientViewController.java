/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BasicIngredientViewController.java
 *
 * Created on Oct 24, 2012, 3:50:31 PM
 */
package gui.ingredients.controllers;

import database.*;
import database.tables.BasicIngredient;
import gui.EmptyPanelManager;
import gui.MasterDetailViewController;
import gui.NoResultsPanel;
import gui.ingredients.RecipeTabbedViewController;
import gui.ingredients.delegates.AddBasicIngredientDelegate;
import gui.ingredients.delegates.EditBasicIngredientDelegate;
import gui.ingredients.dialogs.AddBasicIngredientDialog;
import gui.ingredients.dialogs.EditBasicIngredientDialog;
import gui.utilities.list.FilterableListModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.swingx.JXTextField;
import org.jdesktop.swingx.JXTitledPanel;
import tools.StringTools;
import tools.Utilities;

/**
 *
 * @author Warkst
 */
public class BasicIngredientViewController extends javax.swing.JPanel implements MasterDetailViewController<BasicIngredient>, AddBasicIngredientDelegate, EditBasicIngredientDelegate {
    
    private RecipeTabbedViewController delegate;
//    private final BasicIngredientListModel listModel;
    private final FilterableListModel<BasicIngredient> listModel;
    private final JXTextField xfilter = new JXTextField("Zoeken");

    /**
     * Creates new form BasicIngredientViewController
     */
    public BasicIngredientViewController(RecipeTabbedViewController application) {
        this.delegate = application;
        
        initComponents();
        notesOutlet.setBackground(new Color(213, 216, 222));
        notesOutlet.setCaretPosition(0);
        listOutlet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listOutlet.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    updateDetail((BasicIngredient) listOutlet.getSelectedValue());
                }
            }
        });

        // copy from the db
//        listOutlet.setModel(ListModelFactory.createBasicIngredientModel(Database.driver().getBasicIngredientsAlphabetically()));
//	listModel = new BasicIngredientListModel(Database.driver().getBasicIngredientsAlphabetically());
	listModel = new FilterableListModel<BasicIngredient>(Database.driver().getBasicIngredientsAlphabetically());
	listOutlet.setModel(listModel);
        listOutlet.setSelectedIndex(0);

	notesOutlet.setFont(new Font(notesOutlet.getFont().getName(), Font.PLAIN, Utilities.fontSize()));
	
        /*
         * If there are no ingredients, hide the ugly right detail view
         */
        if (Database.driver().getBasicIngredients().isEmpty()) {
            detail.remove(container);
            detail.add(EmptyPanelManager.instance(), BorderLayout.CENTER);
        }
	
	container.add(new JXTitledPanel("Details", fixedFields), BorderLayout.NORTH);
	container.add(new JXTitledPanel("Opmerkingen", stretchableFields), BorderLayout.CENTER);
	
	master.add(xfilter, BorderLayout.NORTH);
	
	xfilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterKeyReleased(evt);
            }
        });
    }
    
    @Override
    public void updateDetail(BasicIngredient bi) {
        if (bi == null) {
            return;
        }
        
        DecimalFormat threeFormatter = new DecimalFormat("0.000");
        DecimalFormat twoFormatter = new DecimalFormat("0.00");
        
	ingredientOutlet.setText(bi.getName());
	
        supplierOutlet.setText(bi.getSupplier() != null ? bi.getSupplier().toString() : "<geen>");
        supplierOutlet.setForeground(Color.BLUE);
        supplierOutlet.setCursor(new Cursor(Cursor.HAND_CURSOR));

	packagingOutlet.setText(StringTools.capitalize(bi.getPackaging()));
//	if (bi.isInBulk()) {
//	    pricePerUnitOutlet.setText("");
//	    weightPerUnitOutlet.setText("");
//	} else {
	    pricePerUnitOutlet.setText(threeFormatter.format(bi.getPricePerUnit()) + " euro / " + bi.getPackaging());
	    weightPerUnitOutlet.setText(threeFormatter.format(bi.getWeightPerUnit()) + " kg / " + bi.getPackaging());
//	}
	
        //€-sign?
        brandOutlet.setText(StringTools.capitalize(bi.getBrand()));
        pricePerWeightOutlet.setText("" + threeFormatter.format(bi.getPricePerWeight()) + " euro / kg");
        lossPercentOutlet.setText("" + twoFormatter.format(bi.getLossPercent()) + " %");
        grossPriceOutlet.setText("" + threeFormatter.format(bi.getGrossPrice()) + " euro / kg");
        taxesOutlet.setText("" + twoFormatter.format(bi.getTaxes()) + " %");
        netPriceOutlet.setText("" + twoFormatter.format(bi.getNetPrice()) + " euro / kg");
        dateOutlet.setText(bi.getDate());
        notesOutlet.setText(bi.getNotes());
        
        notesOutlet.setCaretPosition(0);
    }
    
    @Override
    public JPanel view() {
        return this;
    }
    
    @Override
    public void addBasicIngredient(BasicIngredient select) {
        listModel.update();
        if (listModel.getSize() == 1) {
            detail.removeAll();
            detail.add(container);
        }
        listOutlet.setSelectedValue(select, true);
        updateDetail(select);
    }
    
    @Override
    public void editBasicIngredient(BasicIngredient n, BasicIngredient o) {
        listModel.update();
	listModel.edit(n, o);
        listOutlet.setSelectedValue(n, true);
        updateDetail(n);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editMenu = new javax.swing.JMenu();
        addMenuItem = new javax.swing.JMenuItem();
        editMenuItem = new javax.swing.JMenuItem();
        searchMenuItem = new javax.swing.JMenuItem();
        fixedFields = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ingredientOutlet = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        brandOutlet = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        supplierOutlet = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        packagingOutlet = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        weightPerUnitOutlet = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pricePerUnitOutlet = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pricePerWeightOutlet = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lossPercentOutlet = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        grossPriceOutlet = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        taxesOutlet = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        netPriceOutlet = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateOutlet = new javax.swing.JLabel();
        stretchableFields = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        notesOutlet = new javax.swing.JTextArea();
        filter = new javax.swing.JTextField();
        jSplitPane1 = new javax.swing.JSplitPane();
        master = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listOutlet = new javax.swing.JList();
        detail = new javax.swing.JPanel();
        container = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        edit = new javax.swing.JButton();

        editMenu.setText("Acties");

        addMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        addMenuItem.setText("Toevoegen...");
        addMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(addMenuItem);

        editMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        editMenuItem.setText("Wijzigen...");
        editMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(editMenuItem);

        searchMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        searchMenuItem.setText("Zoeken");
        searchMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(searchMenuItem);

        fixedFields.setFocusable(false);
        fixedFields.setLayout(new java.awt.GridLayout(12, 2));

        jLabel1.setText("Ingrediënt");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 3, 5));
        fixedFields.add(jLabel1);

        ingredientOutlet.setText("<ingredientOutlet>");
        ingredientOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 3, 5));
        fixedFields.add(ingredientOutlet);

        jLabel2.setBackground(new java.awt.Color(239, 239, 239));
        jLabel2.setText("Merk");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel2.setFocusable(false);
        jLabel2.setOpaque(true);
        fixedFields.add(jLabel2);

        brandOutlet.setBackground(new java.awt.Color(239, 239, 239));
        brandOutlet.setText("<brandOutlet>");
        brandOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        brandOutlet.setFocusable(false);
        brandOutlet.setOpaque(true);
        fixedFields.add(brandOutlet);

        jLabel3.setBackground(new java.awt.Color(239, 239, 239));
        jLabel3.setText("Leverancier");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel3.setFocusable(false);
        fixedFields.add(jLabel3);

        supplierOutlet.setBackground(new java.awt.Color(239, 239, 239));
        supplierOutlet.setText("<supplierOutlet>");
        supplierOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        supplierOutlet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        supplierOutlet.setFocusable(false);
        supplierOutlet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                supplierOutletMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                supplierOutletMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                supplierOutletMouseEntered(evt);
            }
        });
        fixedFields.add(supplierOutlet);

        jLabel6.setBackground(new java.awt.Color(239, 239, 239));
        jLabel6.setText("Verpakking");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel6.setFocusable(false);
        jLabel6.setOpaque(true);
        fixedFields.add(jLabel6);

        packagingOutlet.setBackground(new java.awt.Color(239, 239, 239));
        packagingOutlet.setText("<packagingOutlet>");
        packagingOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        packagingOutlet.setFocusable(false);
        packagingOutlet.setOpaque(true);
        fixedFields.add(packagingOutlet);

        jLabel8.setBackground(new java.awt.Color(239, 239, 239));
        jLabel8.setText("Gewicht per verpakking");
        jLabel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel8.setFocusable(false);
        fixedFields.add(jLabel8);

        weightPerUnitOutlet.setBackground(new java.awt.Color(239, 239, 239));
        weightPerUnitOutlet.setText("<weightPerUnitOutlet>");
        weightPerUnitOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        weightPerUnitOutlet.setFocusable(false);
        fixedFields.add(weightPerUnitOutlet);

        jLabel10.setBackground(new java.awt.Color(239, 239, 239));
        jLabel10.setText("Prijs per verpakking (BTW excl)");
        jLabel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel10.setFocusable(false);
        jLabel10.setOpaque(true);
        fixedFields.add(jLabel10);

        pricePerUnitOutlet.setBackground(new java.awt.Color(239, 239, 239));
        pricePerUnitOutlet.setText("<pricePerUnitOutlet>");
        pricePerUnitOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        pricePerUnitOutlet.setFocusable(false);
        pricePerUnitOutlet.setOpaque(true);
        fixedFields.add(pricePerUnitOutlet);

        jLabel12.setText("Prijs per kg (BTW excl)");
        jLabel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel12.setFocusable(false);
        fixedFields.add(jLabel12);

        pricePerWeightOutlet.setText("<pricePerWeightOutlet>");
        pricePerWeightOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        pricePerWeightOutlet.setFocusable(false);
        fixedFields.add(pricePerWeightOutlet);

        jLabel14.setBackground(new java.awt.Color(239, 239, 239));
        jLabel14.setText("Verliespercentage");
        jLabel14.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel14.setFocusable(false);
        jLabel14.setOpaque(true);
        fixedFields.add(jLabel14);

        lossPercentOutlet.setBackground(new java.awt.Color(239, 239, 239));
        lossPercentOutlet.setText("<lossPercentOutlet>");
        lossPercentOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        lossPercentOutlet.setFocusable(false);
        lossPercentOutlet.setOpaque(true);
        fixedFields.add(lossPercentOutlet);

        jLabel16.setText("Totaalprijs (BTW excl)");
        jLabel16.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel16.setFocusable(false);
        fixedFields.add(jLabel16);

        grossPriceOutlet.setText("<grossPriceOutlet>");
        grossPriceOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        grossPriceOutlet.setFocusable(false);
        fixedFields.add(grossPriceOutlet);

        jLabel18.setBackground(new java.awt.Color(239, 239, 239));
        jLabel18.setText("BTW");
        jLabel18.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel18.setFocusable(false);
        jLabel18.setOpaque(true);
        fixedFields.add(jLabel18);

        taxesOutlet.setBackground(new java.awt.Color(239, 239, 239));
        taxesOutlet.setText("<taxesOutlet>");
        taxesOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        taxesOutlet.setFocusable(false);
        taxesOutlet.setOpaque(true);
        fixedFields.add(taxesOutlet);

        jLabel20.setText("Totaalprijs");
        jLabel20.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel20.setFocusable(false);
        fixedFields.add(jLabel20);

        netPriceOutlet.setText("<netPriceOutlet>");
        netPriceOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        netPriceOutlet.setFocusable(false);
        fixedFields.add(netPriceOutlet);

        jLabel4.setBackground(new java.awt.Color(239, 239, 239));
        jLabel4.setText("Laatste update");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel4.setOpaque(true);
        fixedFields.add(jLabel4);

        dateOutlet.setBackground(new java.awt.Color(239, 239, 239));
        dateOutlet.setText("<dateOutlet>");
        dateOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        dateOutlet.setFocusable(false);
        dateOutlet.setOpaque(true);
        fixedFields.add(dateOutlet);

        stretchableFields.setFocusable(false);
        stretchableFields.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(null);
        jScrollPane2.setFocusable(false);

        notesOutlet.setBackground(new java.awt.Color(191, 205, 219));
        notesOutlet.setColumns(20);
        notesOutlet.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        notesOutlet.setLineWrap(true);
        notesOutlet.setRows(1);
        notesOutlet.setWrapStyleWord(true);
        notesOutlet.setFocusable(false);
        notesOutlet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                notesOutletKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                notesOutletKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                notesOutletKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(notesOutlet);

        stretchableFields.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        filter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterKeyReleased(evt);
            }
        });

        setFocusable(false);
        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(300);
        jSplitPane1.setFocusable(false);

        master.setFocusable(false);
        master.setLayout(new java.awt.BorderLayout());

        add.setText("Toevoegen...");
        add.setFocusable(false);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        master.add(add, java.awt.BorderLayout.SOUTH);

        jScrollPane1.setFocusable(false);

        listOutlet.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listOutlet);

        master.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jSplitPane1.setLeftComponent(master);

        detail.setFocusable(false);
        detail.setLayout(new java.awt.BorderLayout());

        container.setLayout(new java.awt.BorderLayout());

        jPanel1.setFocusable(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        edit.setText("Wijzigen...");
        edit.setFocusable(false);
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel1.add(edit, java.awt.BorderLayout.EAST);

        container.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        detail.add(container, java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(detail);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        new EditBasicIngredientDialog(null, true, this, (BasicIngredient) listOutlet.getSelectedValue()).setVisible(true);
	listModel.setFilter(null);
	xfilter.setText("");
    }//GEN-LAST:event_editActionPerformed
    
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        listModel.setFilter(null);
//	filter.setText("");
	xfilter.setText("");
	
	new AddBasicIngredientDialog(null, true, this).setVisible(true);
    }//GEN-LAST:event_addActionPerformed
    
    private void notesOutletKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notesOutletKeyPressed
        notesKeyEvent(evt);
    }//GEN-LAST:event_notesOutletKeyPressed
    
    private void notesOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notesOutletKeyReleased
        notesKeyEvent(evt);
    }//GEN-LAST:event_notesOutletKeyReleased
    
    private void notesOutletKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notesOutletKeyTyped
        notesKeyEvent(evt);
    }//GEN-LAST:event_notesOutletKeyTyped
    
    private void addMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenuItemActionPerformed
        addActionPerformed(null);
    }//GEN-LAST:event_addMenuItemActionPerformed
    
    private void editMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuItemActionPerformed
        editActionPerformed(null);
    }//GEN-LAST:event_editMenuItemActionPerformed

    private void supplierOutletMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierOutletMouseEntered
//	BasicIngredient bi = (BasicIngredient) listOutlet.getSelectedValue();
//        if (bi.getSupplier() != null) {
//	    supplierOutlet.setText("<html><u>" + supplierOutlet.getText() + "</u></html>");
//	}
    }//GEN-LAST:event_supplierOutletMouseEntered

    private void supplierOutletMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierOutletMouseExited
//        BasicIngredient bi = (BasicIngredient) listOutlet.getSelectedValue();
//        if (bi.getSupplier() != null) {
//	    supplierOutlet.setText(bi.getSupplier().getSortKey());
//        }
    }//GEN-LAST:event_supplierOutletMouseExited

    private void supplierOutletMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierOutletMouseReleased
//        BasicIngredient selectedIngredient = (BasicIngredient) listOutlet.getSelectedValue();
//        if (selectedIngredient.getSupplier()!=null) {
//	    delegate.selectAndSwitchToSupplier(selectedIngredient.getSupplier());
//	}
    }//GEN-LAST:event_supplierOutletMouseReleased

    private void filterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterKeyReleased
//        if (filter.getText().isEmpty()) {
        if (xfilter.getText().isEmpty()) {
	    listModel.setFilter(null);
	} else {
//	    listModel.setFilter(filter.getText());
	    listModel.setFilter(xfilter.getText());
	}
	if (listModel.getSize()==0) {
	    System.out.println("No results");
	    detail.removeAll();
	    detail.add(new NoResultsPanel(), BorderLayout.CENTER);
	    validate();
	    repaint();
	    return;
	}
	detail.removeAll();
	detail.add(container);
	listOutlet.setSelectedIndex(0);
	if (listOutlet.getSelectedValue()!=null) {
	    updateDetail((BasicIngredient)listOutlet.getSelectedValue());
	}
	validate();
	repaint();
    }//GEN-LAST:event_filterKeyReleased

    private void searchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMenuItemActionPerformed
//        filter.requestFocus();
        xfilter.requestFocus();
    }//GEN-LAST:event_searchMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JMenuItem addMenuItem;
    private javax.swing.JLabel brandOutlet;
    private javax.swing.JPanel container;
    private javax.swing.JLabel dateOutlet;
    private javax.swing.JPanel detail;
    private javax.swing.JButton edit;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem editMenuItem;
    private javax.swing.JTextField filter;
    private javax.swing.JPanel fixedFields;
    private javax.swing.JLabel grossPriceOutlet;
    private javax.swing.JLabel ingredientOutlet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JList listOutlet;
    private javax.swing.JLabel lossPercentOutlet;
    private javax.swing.JPanel master;
    private javax.swing.JLabel netPriceOutlet;
    private javax.swing.JTextArea notesOutlet;
    private javax.swing.JLabel packagingOutlet;
    private javax.swing.JLabel pricePerUnitOutlet;
    private javax.swing.JLabel pricePerWeightOutlet;
    private javax.swing.JMenuItem searchMenuItem;
    private javax.swing.JPanel stretchableFields;
    private javax.swing.JLabel supplierOutlet;
    private javax.swing.JLabel taxesOutlet;
    private javax.swing.JLabel weightPerUnitOutlet;
    // End of variables declaration//GEN-END:variables

    @Override
    public void electFirstResponder() {
	/*
	 * Update the list model to reflect any changes in the underlying data structure (contacts list)
	 */
	listModel.update();
	
//        if (listOutlet.getSelectedValue() != null) {
//            updateDetail((BasicIngredient) listOutlet.getSelectedValue());
//        }
	if (listModel.getSize()>0) {
	    if (listModel.getSize() == 1) {
		detail.removeAll();
		detail.add(container);
	    }
	    listOutlet.setSelectedIndex(0);
	    if(listOutlet.getSelectedValue()!=null)updateDetail((BasicIngredient)listOutlet.getSelectedValue());
	} else {
	    System.out.println("No results");
	    detail.removeAll();
	    detail.add(new NoResultsPanel(), BorderLayout.CENTER);
	    validate();
	    repaint();
	    return;
	}
	
	/*
	 * Elect first responder
	 */
	listOutlet.requestFocus();
    }
    
    private void notesKeyEvent(KeyEvent evt) {
        if (!(evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_C)
                && !(evt.getKeyCode() == KeyEvent.VK_F1)
                && !(evt.getKeyCode() == KeyEvent.VK_F2)
                && !(evt.getKeyCode() == KeyEvent.VK_F3)) {
            evt.consume();
        }
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();
            listOutlet.requestFocus();
        }
    }
    
    @Override
    public JMenu menu() {
        return editMenu;
    }
}
