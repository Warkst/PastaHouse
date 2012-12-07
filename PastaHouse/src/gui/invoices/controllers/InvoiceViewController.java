/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.invoices.controllers;

import database.tables.Invoice;
import gui.MasterDetailViewController;
import gui.utilities.table.InvoiceTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import tools.Utilities;

/**
 *
 * @author Warkst
 */
public class InvoiceViewController extends javax.swing.JPanel implements MasterDetailViewController<Invoice> {

    private Map<String, RowFilter<Object, Object>> filters;
    
    private TableRowSorter<InvoiceTableModel> sorter;
    
    /**
     * Creates new form InvoiceViewController
     */
    public InvoiceViewController() {
	initComponents();
	
	InvoiceTableModel model = new InvoiceTableModel();
	
	invoiceTableOutlet.setModel(model);
	
	filters = new HashMap<String, RowFilter<Object, Object>>();
	sorter = new TableRowSorter<InvoiceTableModel>(model);
	
	invoiceTableOutlet.setRowSorter(sorter);
	invoiceTableOutlet.setRowHeight(invoiceTableOutlet.getRowHeight()+Utilities.fontSize()-10);
	
	/*
	 * TODO: add column filters dynamically based on the model Invoice
	 */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        noResultOutlet = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        filterPanel = new javax.swing.JPanel();
        dateFilterOutlet = new javax.swing.JTextField();
        clientFilterOutlet = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTableOutlet = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        articleTableOutlet = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        noResultOutlet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noResultOutlet.setText("Geen resultaten");

        setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        filterPanel.setLayout(new java.awt.GridLayout(1, 2));

        dateFilterOutlet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dateFilterOutletKeyReleased(evt);
            }
        });
        filterPanel.add(dateFilterOutlet);

        clientFilterOutlet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clientFilterOutletKeyReleased(evt);
            }
        });
        filterPanel.add(clientFilterOutlet);

        jPanel1.add(filterPanel, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel3.setPreferredSize(new java.awt.Dimension(400, 150));
        jPanel3.setLayout(new java.awt.BorderLayout());

        invoiceTableOutlet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(invoiceTableOutlet);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel3, java.awt.BorderLayout.CENTER);

        add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.BorderLayout());

        articleTableOutlet.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(articleTableOutlet);

        jPanel6.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Details");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 10, 5, 0));
        jPanel7.add(jLabel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.GridLayout(3, 2));

        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2);

        jLabel3.setText("jLabel3");
        jPanel2.add(jLabel3);

        jLabel4.setText("jLabel4");
        jPanel2.add(jLabel4);

        jLabel5.setText("jLabel5");
        jPanel2.add(jLabel5);

        jLabel6.setText("jLabel6");
        jPanel2.add(jLabel6);

        jLabel7.setText("jLabel7");
        jPanel2.add(jLabel7);

        jPanel7.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel7, java.awt.BorderLayout.NORTH);

        add(jPanel5, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void updateFilter(){
	List<RowFilter<Object, Object>> filters_ = new ArrayList<RowFilter<Object, Object>>();
	
	for (RowFilter<Object, Object> rowFilter : filters.values()) {
	    if (rowFilter!=null) {
		filters_.add(rowFilter);
	    }
	}
	
	sorter.setRowFilter(RowFilter.andFilter(filters_));
	
//	System.out.println("showing "+tableOutlet.getRowCount()+ " rows");	
	if (invoiceTableOutlet.getRowCount() == 0) {
	    System.out.println("wub wub");
//	    jPanel3.add(noResultOutlet, BorderLayout.SOUTH);
//	    jPanel3.validate();
//	    jPanel3.repaint();
	}
    }
    
    private void dateFilterOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateFilterOutletKeyReleased
        if (!dateFilterOutlet.getText().isEmpty()) {
	    filters.put("date", RowFilter.regexFilter(dateFilterOutlet.getText(), 0));
	} else {
	    filters.put("date", null);
	}
	
	updateFilter();
	
    }//GEN-LAST:event_dateFilterOutletKeyReleased

    private void clientFilterOutletKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clientFilterOutletKeyReleased
        if (!clientFilterOutlet.getText().isEmpty()) {
	    filters.put("client", RowFilter.regexFilter(clientFilterOutlet.getText(), 1));
	} else {
	    filters.put("client", null);
	}
	
	updateFilter();
    }//GEN-LAST:event_clientFilterOutletKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable articleTableOutlet;
    private javax.swing.JTextField clientFilterOutlet;
    private javax.swing.JTextField dateFilterOutlet;
    private javax.swing.JPanel filterPanel;
    private javax.swing.JTable invoiceTableOutlet;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel noResultOutlet;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateDetail(Invoice value) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addAndSelect(Invoice newObj) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void editAndSelect(Invoice newObj, Invoice oldObj) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addProxy() {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void editProxy() {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void electFirstResponder() {
	invoiceTableOutlet.requestFocus();
    }

    @Override
    public JPanel view() {
	return this;
    }
}
