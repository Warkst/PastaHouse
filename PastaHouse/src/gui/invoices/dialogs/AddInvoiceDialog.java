/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.invoices.dialogs;

import database.Database;
import database.extra.InvoiceItem;
import database.tables.Contact;
import gui.contacts.delegates.AddContactDelegate;
import gui.contacts.dialogs.AddContactDialog;
import gui.invoices.delegates.AddInvoiceDelegate;
import gui.utilities.combobox.AutocompleteCombobox;
import gui.utilities.table.invoicetable.InvoiceItemTableModel;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.JXTableHeader;

/**
 *
 * @author Hannes
 */
public class AddInvoiceDialog extends javax.swing.JDialog implements AddContactDelegate{

    private AutocompleteCombobox clientBox;
    private JXDatePicker datepicker = new JXDatePicker();
    private JXTable table;
    private Map<Integer, InvoiceItem> data = new TreeMap<Integer, InvoiceItem>();

    public AddInvoiceDialog(java.awt.Frame parent, boolean modal, AddInvoiceDelegate delegate) {
        super(parent, modal);
        initComponents();
        comboPriceClass.addItem("A");
        comboPriceClass.addItem("B");
        DateOutlet.add(datepicker);
        datepicker.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
        datepicker.setDate(new Date());
        txtNumber.setText(""+Database.driver().getInvoiceNumber());
        table = createXTable();
        InvoiceItemTableModel tablemodel = new InvoiceItemTableModel(data);
        table.setModel(tablemodel);
        JScrollPane scrollpane = new JScrollPane(table);
        table.setName("invoiceTable");
        artikelspanel.add(scrollpane, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        detail = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        DateOutlet = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ClientOutlet = new javax.swing.JPanel();
        addSupplier = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comboPriceClass = new javax.swing.JComboBox();
        artikelspanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnReduction = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        detail.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(0, 2));

        jLabel6.setText("Nummer");
        jPanel2.add(jLabel6);
        jPanel2.add(txtNumber);

        jLabel4.setText("Datum");
        jPanel2.add(jLabel4);

        DateOutlet.setLayout(new java.awt.BorderLayout());
        jPanel2.add(DateOutlet);

        jLabel2.setText("Klant");
        jPanel2.add(jLabel2);

        ClientOutlet.setLayout(new java.awt.BorderLayout());

        addSupplier.setText("+");
        addSupplier.setToolTipText("Klik hier om een nieuwe leverancier toe te voegen.");
        addSupplier.setFocusable(false);
        addSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSupplierActionPerformed(evt);
            }
        });
        ClientOutlet.add(addSupplier, java.awt.BorderLayout.EAST);

        jPanel2.add(ClientOutlet);

        jLabel3.setText("Prijsklasse");
        jPanel2.add(jLabel3);
        jPanel2.add(comboPriceClass);

        detail.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        artikelspanel.setLayout(new java.awt.BorderLayout());
        artikelspanel.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        detail.add(artikelspanel, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(0, 2));

        jLabel5.setText("Korting");
        jPanel1.add(jLabel5);
        jPanel1.add(btnReduction);

        jLabel1.setText("Prijs");
        jPanel1.add(jLabel1);
        jPanel1.add(lblPrice);

        detail.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(detail, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        btnSave.setText("Opslaan");
        jPanel4.add(btnSave);

        btnBack.setText("Terug");
        jPanel4.add(btnBack);

        jPanel3.add(jPanel4, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSupplierActionPerformed
        AddContactDialog.createSupplierDialog(this).setVisible(true);
    }//GEN-LAST:event_addSupplierActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ClientOutlet;
    private javax.swing.JPanel DateOutlet;
    private javax.swing.JButton addSupplier;
    private javax.swing.JPanel artikelspanel;
    private javax.swing.JButton btnBack;
    private javax.swing.JTextField btnReduction;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox comboPriceClass;
    private javax.swing.JPanel detail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JTextField txtNumber;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addContact(Contact c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
        private JXTable createXTable() {
        JXTable table = new JXTable() {
            @Override
            protected JTableHeader createDefaultTableHeader() {
                return new JXTableHeader(columnModel) {
                    @Override
                    public void updateUI() {
                        super.updateUI();
                        // need toPicker do in updateUI toPicker survive toggling of LAF 
                        if (getDefaultRenderer() instanceof JLabel) {
                            ((JLabel) getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

                        }
                    }
                    //                    </snip> 
                };
            }
        };
        return table;
    }
}
