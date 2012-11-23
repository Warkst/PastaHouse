/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ingredients.controllers;

import database.Database;
import database.Supplier;
import gui.ingredients.dialogs.AddSupplierDialog;
import gui.ingredients.dialogs.EditSupplierDialog;
import gui.utilities.list.EditableListModel;
import gui.utilities.list.ListModelFactory;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import utilities.StringTools;

/**
 *
 * @author Warkst
 */
public class SupplierViewController extends javax.swing.JPanel implements MasterDetailViewController {

    /**
     * Creates new form SupplierViewController
     */
    public SupplierViewController() {
        initComponents();
        
        listOutlet.setModel(ListModelFactory.createSupplierListModel(Database.driver().getSuppliers()));
        listOutlet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listOutlet.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    updateDetail(listOutlet.getSelectedValue());
                }
            }
        });
        
        listOutlet.setSelectedIndex(0);
    }
    
    @Override
    public void updateDetail(Object value) {
        Supplier s = (Supplier) value;
        firmOutlet.setText(StringTools.capitalize(s.getFirm()));
        contactOutlet.setText(StringTools.capitalizeEach(s.getContact()));
        addressOutlet.setText(StringTools.capitalizeEach(s.getAddress()));
        municipalityOutlet.setText(StringTools.capitalize(s.getMunicipality()));
        telephoneOutlet.setText(s.getTelephone());
        cellphoneOutlet.setText(s.getCellphone());
        faxOutlet.setText(s.getFax());
        emailOutlet.setText(s.getEmail());
        telephone2Outlet.setText(s.getTelephone2());
        notesOutlet.setText(s.getNotes());
        zipcodeOutlet.setText("" + s.getZipcode());
    }
    
    public void selectSupplier(Supplier supplier) {
//	System.out.println("SVC::select index stub called with index "+);
        listOutlet.setSelectedValue(supplier, true);
    }
    
    public void addSupplier(Supplier supplier) {
        EditableListModel<Supplier> dlm = (EditableListModel) listOutlet.getModel();
        dlm.add(supplier);
//        updateDetail(supplier);
        listOutlet.setSelectedValue(supplier, true);
        listOutlet.requestFocus();
    }
    
    public void updateList() {
        EditableListModel<Supplier> dlm = (EditableListModel) listOutlet.getModel();
        dlm.update();
        updateDetail(dlm.getElementAt(listOutlet.getSelectedIndex()));
    }
    
    @Override
    public JPanel view() {
        return this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSplitPane1 = new javax.swing.JSplitPane();
        detail = new javax.swing.JPanel();
        fixedFields = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        firmOutlet = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        contactOutlet = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        addressOutlet = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        zipcodeOutlet = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        municipalityOutlet = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        telephoneOutlet = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        telephone2Outlet = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cellphoneOutlet = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        faxOutlet = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        emailOutlet = new javax.swing.JLabel();
        stretchableFields = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        notesOutlet = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        edit = new javax.swing.JButton();
        master = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listOutlet = new javax.swing.JList();
        add = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable1);

        setFocusable(false);
        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setFocusable(false);

        detail.setFocusable(false);
        detail.setLayout(new java.awt.BorderLayout());

        fixedFields.setFocusable(false);
        fixedFields.setLayout(new java.awt.GridLayout(10, 2, 0, 5));

        jLabel1.setText("Firma");
        jLabel1.setFocusable(false);
        fixedFields.add(jLabel1);

        firmOutlet.setText("<firmOutlet>");
        firmOutlet.setFocusable(false);
        fixedFields.add(firmOutlet);

        jLabel4.setText("Contactpersoon");
        jLabel4.setFocusable(false);
        fixedFields.add(jLabel4);

        contactOutlet.setText("<contactOutlet>");
        contactOutlet.setFocusable(false);
        fixedFields.add(contactOutlet);

        jLabel2.setText("Adres");
        jLabel2.setFocusable(false);
        fixedFields.add(jLabel2);

        addressOutlet.setText("<addressOutlet>");
        addressOutlet.setFocusable(false);
        fixedFields.add(addressOutlet);

        jLabel10.setText("Postcode");
        fixedFields.add(jLabel10);

        zipcodeOutlet.setText("<zipcodeOutlet>");
        fixedFields.add(zipcodeOutlet);

        jLabel3.setText("Gemeente");
        jLabel3.setFocusable(false);
        fixedFields.add(jLabel3);

        municipalityOutlet.setText("<municipalityOutlet>");
        municipalityOutlet.setFocusable(false);
        fixedFields.add(municipalityOutlet);

        jLabel5.setText("Telefoon");
        jLabel5.setFocusable(false);
        fixedFields.add(jLabel5);

        telephoneOutlet.setText("<telephoneOutlet>");
        telephoneOutlet.setFocusable(false);
        fixedFields.add(telephoneOutlet);

        jLabel9.setText("Telefoon 2");
        fixedFields.add(jLabel9);

        telephone2Outlet.setText("<telephone2Outlet>");
        fixedFields.add(telephone2Outlet);

        jLabel6.setText("GSM");
        jLabel6.setFocusable(false);
        fixedFields.add(jLabel6);

        cellphoneOutlet.setText("<cellphoneOutlet>");
        cellphoneOutlet.setFocusable(false);
        fixedFields.add(cellphoneOutlet);

        jLabel7.setText("Fax");
        jLabel7.setFocusable(false);
        fixedFields.add(jLabel7);

        faxOutlet.setText("<faxOutlet>");
        faxOutlet.setFocusable(false);
        fixedFields.add(faxOutlet);

        jLabel8.setText("Email");
        jLabel8.setFocusable(false);
        fixedFields.add(jLabel8);

        emailOutlet.setText("<emailOutlet>");
        emailOutlet.setFocusable(false);
        fixedFields.add(emailOutlet);

        detail.add(fixedFields, java.awt.BorderLayout.NORTH);

        stretchableFields.setFocusable(false);
        stretchableFields.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opmerking:"));
        jScrollPane2.setFocusable(false);

        notesOutlet.setColumns(20);
        notesOutlet.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        notesOutlet.setLineWrap(true);
        notesOutlet.setRows(5);
        notesOutlet.setWrapStyleWord(true);
        notesOutlet.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        notesOutlet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                notesOutletKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                notesOutletKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                notesOutletKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(notesOutlet);

        stretchableFields.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        detail.add(stretchableFields, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout());

        edit.setText("Wijzigen...");
        edit.setFocusable(false);
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel1.add(edit, java.awt.BorderLayout.EAST);

        detail.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jSplitPane1.setRightComponent(detail);

        master.setFocusable(false);
        master.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setFocusable(false);

        listOutlet.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listOutlet);

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

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        AddSupplierDialog dia = new AddSupplierDialog((JFrame) SwingUtilities.getWindowAncestor(this).getParent(), true, this);
        dia.setVisible(true);
    }//GEN-LAST:event_addActionPerformed
    
    private void notesOutletKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notesOutletKeyPressed
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
    }//GEN-LAST:event_notesOutletKeyPressed
    
    private void notesOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notesOutletKeyReleased
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
    }//GEN-LAST:event_notesOutletKeyReleased
    
    private void notesOutletKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notesOutletKeyTyped
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
    }//GEN-LAST:event_notesOutletKeyTyped
    
    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        new EditSupplierDialog(null, true, this, (Supplier) listOutlet.getSelectedValue()).setVisible(true);
    }//GEN-LAST:event_editActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JLabel addressOutlet;
    private javax.swing.JLabel cellphoneOutlet;
    private javax.swing.JLabel contactOutlet;
    private javax.swing.JPanel detail;
    private javax.swing.JButton edit;
    private javax.swing.JLabel emailOutlet;
    private javax.swing.JLabel faxOutlet;
    private javax.swing.JLabel firmOutlet;
    private javax.swing.JPanel fixedFields;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JList listOutlet;
    private javax.swing.JPanel master;
    private javax.swing.JLabel municipalityOutlet;
    private javax.swing.JTextArea notesOutlet;
    private javax.swing.JPanel stretchableFields;
    private javax.swing.JLabel telephone2Outlet;
    private javax.swing.JLabel telephoneOutlet;
    private javax.swing.JLabel zipcodeOutlet;
    // End of variables declaration//GEN-END:variables

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
}