/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.invoices.controllers;

import database.Database;
import database.tables.Invoice;
import gui.MasterDetailViewController;
import gui.invoices.delegates.AddInvoiceDelegate;
import gui.invoices.delegates.EditInvoiceDelegate;
import gui.invoices.dialogs.AddInvoiceDialog;
import gui.invoices.dialogs.InvoiceDetailsDialog;
import gui.utilities.table.invoicetable.CustomColumnFactory;
import gui.utilities.table.invoicetable.InvoiceFiltering;
import gui.utilities.table.invoicetable.InvoiceRendering;
import gui.utilities.table.invoicetable.InvoiceTableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.text.SimpleDateFormat;
import java.util.Map;
import javax.crypto.spec.IvParameterSpec;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.RowFilter;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.JXTableHeader;
import org.jdesktop.swingx.decorator.HighlighterFactory;
import printer.printables.PrintableInvoiceNew;

/**
 *
 * @author Warkst
 */
public class InvoiceViewController extends javax.swing.JPanel implements MasterDetailViewController<Invoice>, AddInvoiceDelegate, EditInvoiceDelegate {

    private Map<String, RowFilter<Object, Object>> filters;
    private TableRowSorter<InvoiceTableModel> sorter;
    private InvoiceTableModel tableModel;
    private JXTable table;
    private Map<Integer, Invoice> invoicesByID;
    private JXDatePicker fromPicker;
    private JXDatePicker toPicker;
    private InvoiceFiltering filterController;

    /**
     * Creates new form InvoiceViewController
     */
    public InvoiceViewController() {

        initComponents();
        invoicesByID = Database.driver().getInvoicesById();
        tablePanel.add(controlPanel, BorderLayout.NORTH);
        table = createXTable();
        JScrollPane scrollpane = new JScrollPane(table);
        table.setName("invoiceTable");
        tablePanel.add(scrollpane, BorderLayout.CENTER);
        configureDisplayProperties();
        fromPicker = new JXDatePicker();
        fromPicker.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
        toPicker = new JXDatePicker();
        toPicker.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
        fromOutlet.add(fromPicker);
        toOutlet.add(toPicker);
        bind();

    }

    /**
     * This method is called fromPicker within the constructor toPicker
     * initialize the form. WARNING: Do NOT modify this code. The content of
     * this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        noResultOutlet = new javax.swing.JLabel();
        controlPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        numberField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        clientField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        fromOutlet = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        toOutlet = new javax.swing.JPanel();
        tablePanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        invoices = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        afdrukken = new javax.swing.JButton();
        edit = new javax.swing.JButton();

        noResultOutlet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noResultOutlet.setText("Geen resultaten");

        setLayout(new java.awt.BorderLayout());

        controlPanel.setLayout(new java.awt.GridLayout(1, 3));

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 15, 5));
        jPanel4.setLayout(new java.awt.GridLayout(2, 1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nummer");
        jPanel4.add(jLabel1);

        numberField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numberFieldKeyReleased(evt);
            }
        });
        jPanel4.add(numberField);

        controlPanel.add(jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 15, 5));
        jPanel5.setLayout(new java.awt.GridLayout(2, 1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Klant");
        jPanel5.add(jLabel2);
        jPanel5.add(clientField);

        controlPanel.add(jPanel5);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 15, 5));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Van");
        jLabel3.setVerifyInputWhenFocusTarget(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(jLabel3, gridBagConstraints);

        fromOutlet.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 5.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(fromOutlet, gridBagConstraints);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tot");
        jLabel4.setVerifyInputWhenFocusTarget(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(jLabel4, gridBagConstraints);

        toOutlet.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 5.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(toOutlet, gridBagConstraints);

        controlPanel.add(jPanel3);

        add(controlPanel, java.awt.BorderLayout.NORTH);
        controlPanel.getAccessibleContext().setAccessibleName("");

        tablePanel.setLayout(new java.awt.BorderLayout());
        add(tablePanel, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout());

        invoices.setText("Toevoegen...");
        invoices.setFocusable(false);
        invoices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoicesActionPerformed(evt);
            }
        });
        jPanel1.add(invoices, java.awt.BorderLayout.WEST);

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        afdrukken.setText("Afdrukken...");
        afdrukken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afdrukkenActionPerformed(evt);
            }
        });
        jPanel2.add(afdrukken);

        edit.setText("Details...");
        edit.setFocusable(false);
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel2.add(edit);

        jPanel1.add(jPanel2, java.awt.BorderLayout.EAST);

        add(jPanel1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void invoicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoicesActionPerformed
        new AddInvoiceDialog(null, true, this).setVisible(true);
    }//GEN-LAST:event_invoicesActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        int row = table.getSelectedRow();
        int index = table.convertRowIndexToModel(row);
        Invoice inv = (Invoice) (invoicesByID.values().toArray())[index];
        new InvoiceDetailsDialog(null, true, inv).setVisible(true);
    }//GEN-LAST:event_editActionPerformed

    private void numberFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numberFieldKeyReleased
    }//GEN-LAST:event_numberFieldKeyReleased

    private void afdrukkenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afdrukkenActionPerformed
	int[] rijen = table.getSelectedRows();
        Book b = new Book();
        PageFormat pf = new PageFormat();
        pf.setPaper(new A4());

	for (int i : rijen) {
//            b.append(new PrintableInvoice(tableModel.getInvoiceAtRow(i)), pf);
            b.append(new PrintableInvoiceNew(tableModel.getInvoiceAtRow(i)), pf);
        }

        printer.Printer.driver().setPrintableBook(b);
        printer.Printer.driver().tryPrint();
    }//GEN-LAST:event_afdrukkenActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton afdrukken;
    private javax.swing.JTextField clientField;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JButton edit;
    private javax.swing.JPanel fromOutlet;
    private javax.swing.JButton invoices;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel noResultOutlet;
    private javax.swing.JTextField numberField;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JPanel toOutlet;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateDetail(Invoice value) {
//	clientOutlet.setText(value.getClient().getSortKey());
//	dateOutlet.setText(value.getDate());
//	priceOutlet.setText(value.getPriceCode());
//	
//	articleTableOutlet.setModel(new InvoiceItemTableModel(value.items()));
    }

    @Override
    public JPanel view() {
        return this;
    }

    @Override
    public JMenu menu() {
        return null;
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

    private void bind() {
        tableModel = new InvoiceTableModel(invoicesByID);
        table.setModel(tableModel);
        filterController = new InvoiceFiltering(table);
//        BindingGroup filterGroup = new BindingGroup();
//        filterGroup.addBinding(Bindings.createAutoBinding(READ,
//                clientField, BeanProperty.create("text"),
//                filterController, BeanProperty.create("clientString")));
//        System.out.println("binded!");
//        filterGroup.addBinding(Bindings.createAutoBinding(READ,  
//                 filterController, BeanProperty.create("clientString"), 
//                 this, BeanProperty.create("statusContent"))); 
//        filterGroup.bind();
        clientField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    filterController.setClientString(clientField.getText());
                } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && clientField.getText().equals("")) {
                    filterController.setClientString(clientField.getText());
                }
            }
        });

        numberField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    filterController.setNumberString(numberField.getText());
                } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && numberField.getText().equals("")) {
                    filterController.setNumberString(numberField.getText());
                }
            }
        });

        fromPicker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterController.setFromDate(fromPicker.getDate());
            }
        });

        toPicker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterController.setToDate(toPicker.getDate());
            }
        });



    }

    @Override
    public void electFirstResponder() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void configureDisplayProperties() {
        table.setColumnControlVisible(true);
        table.setShowGrid(false, false);
        table.addHighlighter(HighlighterFactory.createAlternateStriping());
        table.setVisibleRowCount(10);
        CustomColumnFactory factory = new CustomColumnFactory();
        InvoiceRendering.configureColumnFactory(factory, getClass());
        table.setColumnFactory(factory);
    }

    @Override
    public void addInvoice(Invoice e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void editInvoice(Invoice oldInvoice, Invoice newInvoice) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private class A4 extends Paper {

        public A4() {
            super();
            setSize(594.992125984252, 841.8897637795276);
            setImageableArea(36.0, 36.0, 522.99212598425197, 769.8897637795276);
        }
    }
}
