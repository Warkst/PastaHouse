/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ingredients.controllers;

import database.Database;
import database.tables.Contact;
import gui.EmptyPanelManager;
import gui.MasterDetailViewController;
import gui.contacts.delegates.AddContactDelegate;
import gui.contacts.delegates.EditContactDelegate;
import gui.contacts.dialogs.AddContactDialog;
import gui.contacts.dialogs.EditContactDialog;
import gui.utilities.list.SupplierListModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.swingx.JXTitledPanel;
import tools.StringTools;
import tools.Utilities;

/**
 *
 * @author Warkst
 */
public class SupplierViewController extends javax.swing.JPanel implements MasterDetailViewController<Contact>, AddContactDelegate, EditContactDelegate {

    private SupplierListModel listModel;
    
    /**
     * Creates new form SupplierViewController
     */
    public SupplierViewController() {
        initComponents();
        notesOutlet.setBackground(new Color(213,216,222));
        notesOutlet.setCaretPosition(0);
	listModel = new SupplierListModel(Database.driver().getContactsAlphabetically());
	
        listOutlet.setModel(listModel);
        listOutlet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listOutlet.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    updateDetail((Contact)listOutlet.getSelectedValue());
                }
            }
        });
	listOutlet.setSelectedIndex(0);
        
	notesOutlet.setFont(new Font(notesOutlet.getFont().getName(), Font.PLAIN, Utilities.fontSize()));
	
	if (listModel.getSize() == 0) {
	    detail.remove(container);
	    detail.add(EmptyPanelManager.instance(), BorderLayout.CENTER);
	}
	
	container.add(new JXTitledPanel("Details", fixedFields), BorderLayout.NORTH);
	container.add(new JXTitledPanel("Opmerkingen", stretchableFields), BorderLayout.CENTER);
    }
    
    @Override
    public void updateDetail(Contact s) {
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
	taxnrOutlet.setText(s.getTaxnumber());
	String code = s.getPricecode();
	if (code != null) {
	    code = code.toUpperCase(); 
	}
	pricecodeOutlet.setText(code);
        notesOutlet.setCaretPosition(0);
    }
    
    public void selectSupplier(Contact supplier) {
        listOutlet.setSelectedValue(supplier, true);
	updateDetail(supplier);
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
        editMenu = new javax.swing.JMenu();
        addMenuItem = new javax.swing.JMenuItem();
        editMenuItem = new javax.swing.JMenuItem();
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
        jLabel11 = new javax.swing.JLabel();
        taxnrOutlet = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pricecodeOutlet = new javax.swing.JLabel();
        stretchableFields = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        notesOutlet = new javax.swing.JTextArea();
        jSplitPane1 = new javax.swing.JSplitPane();
        detail = new javax.swing.JPanel();
        container = new javax.swing.JPanel();
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

        fixedFields.setFocusable(false);
        fixedFields.setLayout(new java.awt.GridLayout(12, 2));

        jLabel1.setText("Firma");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel1.setFocusable(false);
        fixedFields.add(jLabel1);

        firmOutlet.setText("<firmOutlet>");
        firmOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        firmOutlet.setFocusable(false);
        fixedFields.add(firmOutlet);

        jLabel4.setBackground(new java.awt.Color(239, 239, 239));
        jLabel4.setText("Contactpersoon");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel4.setFocusable(false);
        jLabel4.setOpaque(true);
        fixedFields.add(jLabel4);

        contactOutlet.setBackground(new java.awt.Color(239, 239, 239));
        contactOutlet.setText("<contactOutlet>");
        contactOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        contactOutlet.setFocusable(false);
        contactOutlet.setOpaque(true);
        fixedFields.add(contactOutlet);

        jLabel2.setText("Adres");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel2.setFocusable(false);
        fixedFields.add(jLabel2);

        addressOutlet.setText("<addressOutlet>");
        addressOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        addressOutlet.setFocusable(false);
        fixedFields.add(addressOutlet);

        jLabel10.setBackground(new java.awt.Color(239, 239, 239));
        jLabel10.setText("Postcode");
        jLabel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel10.setOpaque(true);
        fixedFields.add(jLabel10);

        zipcodeOutlet.setBackground(new java.awt.Color(239, 239, 239));
        zipcodeOutlet.setText("<zipcodeOutlet>");
        zipcodeOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        zipcodeOutlet.setOpaque(true);
        fixedFields.add(zipcodeOutlet);

        jLabel3.setText("Gemeente");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel3.setFocusable(false);
        fixedFields.add(jLabel3);

        municipalityOutlet.setText("<municipalityOutlet>");
        municipalityOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        municipalityOutlet.setFocusable(false);
        fixedFields.add(municipalityOutlet);

        jLabel5.setBackground(new java.awt.Color(239, 239, 239));
        jLabel5.setText("Telefoon");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel5.setFocusable(false);
        jLabel5.setOpaque(true);
        fixedFields.add(jLabel5);

        telephoneOutlet.setBackground(new java.awt.Color(239, 239, 239));
        telephoneOutlet.setText("<telephoneOutlet>");
        telephoneOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        telephoneOutlet.setFocusable(false);
        telephoneOutlet.setOpaque(true);
        fixedFields.add(telephoneOutlet);

        jLabel9.setText("Telefoon 2");
        jLabel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        fixedFields.add(jLabel9);

        telephone2Outlet.setText("<telephone2Outlet>");
        telephone2Outlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        fixedFields.add(telephone2Outlet);

        jLabel6.setBackground(new java.awt.Color(239, 239, 239));
        jLabel6.setText("GSM");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel6.setFocusable(false);
        jLabel6.setOpaque(true);
        fixedFields.add(jLabel6);

        cellphoneOutlet.setBackground(new java.awt.Color(239, 239, 239));
        cellphoneOutlet.setText("<cellphoneOutlet>");
        cellphoneOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        cellphoneOutlet.setFocusable(false);
        cellphoneOutlet.setOpaque(true);
        fixedFields.add(cellphoneOutlet);

        jLabel7.setText("Fax");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel7.setFocusable(false);
        fixedFields.add(jLabel7);

        faxOutlet.setText("<faxOutlet>");
        faxOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        faxOutlet.setFocusable(false);
        fixedFields.add(faxOutlet);

        jLabel8.setBackground(new java.awt.Color(239, 239, 239));
        jLabel8.setText("Email");
        jLabel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel8.setFocusable(false);
        jLabel8.setOpaque(true);
        fixedFields.add(jLabel8);

        emailOutlet.setBackground(new java.awt.Color(239, 239, 239));
        emailOutlet.setText("<emailOutlet>");
        emailOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        emailOutlet.setFocusable(false);
        emailOutlet.setOpaque(true);
        fixedFields.add(emailOutlet);

        jLabel11.setText("BTWNummer");
        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel11.setFocusable(false);
        fixedFields.add(jLabel11);

        taxnrOutlet.setText("<taxnrOutlet>");
        taxnrOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        taxnrOutlet.setFocusable(false);
        fixedFields.add(taxnrOutlet);

        jLabel12.setBackground(new java.awt.Color(239, 239, 239));
        jLabel12.setText("Prijscode");
        jLabel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel12.setFocusable(false);
        jLabel12.setOpaque(true);
        fixedFields.add(jLabel12);

        pricecodeOutlet.setBackground(new java.awt.Color(239, 239, 239));
        pricecodeOutlet.setText("<pricecodeOutlet>");
        pricecodeOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        pricecodeOutlet.setFocusable(false);
        pricecodeOutlet.setOpaque(true);
        fixedFields.add(pricecodeOutlet);

        stretchableFields.setFocusable(false);
        stretchableFields.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(null);
        jScrollPane2.setFocusable(false);

        notesOutlet.setBackground(new java.awt.Color(240, 240, 240));
        notesOutlet.setColumns(20);
        notesOutlet.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        notesOutlet.setLineWrap(true);
        notesOutlet.setRows(1);
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

        setFocusable(false);
        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setFocusable(false);

        detail.setFocusable(false);
        detail.setLayout(new java.awt.BorderLayout());

        container.setLayout(new java.awt.BorderLayout());

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
//        new AddContactDialog((JFrame) SwingUtilities.getWindowAncestor(this).getParent(), true, this).setVisible(true);
	final SupplierViewController me = this;
        SwingUtilities.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		AddContactDialog.createSupplierDialog(me).setVisible(true);
	    }
	});
    }//GEN-LAST:event_addActionPerformed
    
    private void notesKeyEvent(KeyEvent evt){
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
    
    private void notesOutletKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notesOutletKeyPressed
        notesKeyEvent(evt);
    }//GEN-LAST:event_notesOutletKeyPressed
    
    private void notesOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notesOutletKeyReleased
        notesKeyEvent(evt);
    }//GEN-LAST:event_notesOutletKeyReleased
    
    private void notesOutletKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notesOutletKeyTyped
        notesKeyEvent(evt);
    }//GEN-LAST:event_notesOutletKeyTyped
    
    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        EditContactDialog.createSupplierDialog(this, (Contact) listOutlet.getSelectedValue()).setVisible(true);
    }//GEN-LAST:event_editActionPerformed

    private void addMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenuItemActionPerformed
        addActionPerformed(null);
    }//GEN-LAST:event_addMenuItemActionPerformed

    private void editMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuItemActionPerformed
        editActionPerformed(null);
    }//GEN-LAST:event_editMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JMenuItem addMenuItem;
    private javax.swing.JLabel addressOutlet;
    private javax.swing.JLabel cellphoneOutlet;
    private javax.swing.JLabel contactOutlet;
    private javax.swing.JPanel container;
    private javax.swing.JPanel detail;
    private javax.swing.JButton edit;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem editMenuItem;
    private javax.swing.JLabel emailOutlet;
    private javax.swing.JLabel faxOutlet;
    private javax.swing.JLabel firmOutlet;
    private javax.swing.JPanel fixedFields;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel pricecodeOutlet;
    private javax.swing.JPanel stretchableFields;
    private javax.swing.JLabel taxnrOutlet;
    private javax.swing.JLabel telephone2Outlet;
    private javax.swing.JLabel telephoneOutlet;
    private javax.swing.JLabel zipcodeOutlet;
    // End of variables declaration//GEN-END:variables

    @Override
    public void editContact(Contact oldObj, Contact newObj){
//	EditableListModel<Contact> dlm = (EditableListModel)listOutlet.getModel();
	listModel.edit(newObj, oldObj);
	listOutlet.setSelectedValue(newObj, true);
	updateDetail(newObj);
    }
    
    @Override
    public void electFirstResponder() {
//	((EditableListModel)listOutlet.getModel()).update();
	listModel.update();
	listOutlet.setSelectedIndex(0);
	listOutlet.requestFocus();
	if(listOutlet.getSelectedValue()!=null) updateDetail((Contact)listOutlet.getSelectedValue());
    }

    @Override
    public JMenu menu() {
	return editMenu;
    }

    @Override
    public void addContact(Contact s) {
//	EditableListModel<Contact> dlm = (EditableListModel)listOutlet.getModel();
//	dlm.update();
	listModel.update();
	if (listModel.getSize() == 1) {
	    detail.removeAll();
	    detail.add(container);
	}
	listOutlet.setSelectedValue(s, true);
	updateDetail(s);
    }
}
