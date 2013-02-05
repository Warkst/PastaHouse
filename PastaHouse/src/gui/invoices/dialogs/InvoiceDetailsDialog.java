/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.invoices.dialogs;

import database.tables.Invoice;
import gui.utilities.cell.CellRendererFactory;
import gui.utilities.table.invoicetable.InvoiceItemTableModel;
import java.awt.BorderLayout;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.JXTableHeader;
import org.jdesktop.swingx.JXTitledPanel;
import tools.StringTools;

/**
 *
 * @author Hannes
 */
public class InvoiceDetailsDialog extends javax.swing.JDialog {

    private final Invoice model;
    private final InvoiceItemTableModel tableModel;
    
    /**
     * Creates new form InvoiceDetailsDialog
     */
    public InvoiceDetailsDialog(java.awt.Frame parent, boolean modal, Invoice invoice) {
        super(parent, modal);
        
        initComponents();
        model = invoice;
        setLocationRelativeTo(null);
        JXTable table = createXTable();
	tableModel = new InvoiceItemTableModel(model.items(), model.getPriceCode());
        table.setModel(tableModel);
	
        
        table.getColumns().get(0).setCellRenderer(CellRendererFactory.createIngredientCellRenderer());
        table.getColumns().get(1).setCellRenderer(CellRendererFactory.createZeroDecimalDoubleCellRenderer());
        table.getColumns().get(2).setCellRenderer(CellRendererFactory.createThreeDecimalDoubleCellRenderer());
        table.getColumns().get(3).setCellRenderer(CellRendererFactory.createThreeDecimalDoubleCellRenderer());
        table.getColumns().get(4).setCellRenderer(CellRendererFactory.createThreeDecimalDoubleCellRenderer());
        JScrollPane articlepanel = new JScrollPane(table);
        
	JXTitledPanel detailstitledpanel = new JXTitledPanel("Details");
	JXTitledPanel articlestitledpanel = new JXTitledPanel("Artikelen");
        JXTitledPanel pricetitledpanel = new JXTitledPanel("Prijs");
        detailstitledpanel.add(detailpanel);
        articlestitledpanel.add(articlepanel);
        pricetitledpanel.add(pricepanel);
        componentpanel.add(detailstitledpanel, BorderLayout.NORTH);
        componentpanel.add(articlestitledpanel, BorderLayout.CENTER);
        componentpanel.add(pricetitledpanel, BorderLayout.SOUTH);
        
	
	this.setTitle("Factuur - " + model.getNumber());
	
	loadModel();
    }
    
    private void loadModel(){
        lblNummer.setText("" + model.getNumber());
        lblKlasse.setText(model.getPriceCode());
        lblDate.setText(model.getDate());
	clientOutlet.setText(StringTools.capitalizeEach(model.getClient().getSortKey()));
        
        lblSave.setText(new DecimalFormat("0.00").format(model.getSave())+" %");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        detailpanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblNummer = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        clientOutlet = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblKlasse = new javax.swing.JLabel();
        pricepanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblSave = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        edit = new javax.swing.JButton();
        close = new javax.swing.JButton();
        componentpanel = new javax.swing.JPanel();

        detailpanel.setLayout(new java.awt.GridLayout(0, 2));

        jLabel6.setBackground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("Nummer");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel6.setOpaque(true);
        detailpanel.add(jLabel6);

        lblNummer.setBackground(new java.awt.Color(242, 242, 242));
        lblNummer.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        lblNummer.setOpaque(true);
        detailpanel.add(lblNummer);

        jLabel4.setText("Datum");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        detailpanel.add(jLabel4);

        lblDate.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        detailpanel.add(lblDate);

        jLabel2.setBackground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Klant");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel2.setOpaque(true);
        detailpanel.add(jLabel2);

        clientOutlet.setBackground(new java.awt.Color(242, 242, 242));
        clientOutlet.setText("<hyperlink to client>");
        clientOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        clientOutlet.setOpaque(true);
        detailpanel.add(clientOutlet);

        jLabel3.setText("Prijsklasse");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        detailpanel.add(jLabel3);

        lblKlasse.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 3, 0));
        detailpanel.add(lblKlasse);

        pricepanel.setLayout(new java.awt.GridLayout(0, 2));

        jLabel5.setText("Korting");
        pricepanel.add(jLabel5);
        pricepanel.add(lblSave);

        jLabel1.setText("Prijs");
        pricepanel.add(jLabel1);
        pricepanel.add(lblPrice);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        edit.setText("Wijzig...");
        jPanel4.add(edit);

        close.setText("Terug");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        jPanel4.add(close);

        jPanel3.add(jPanel4, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        componentpanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(componentpanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        disposeLater();
    }//GEN-LAST:event_closeActionPerformed

    private void disposeLater(){
	SwingUtilities.invokeLater(new Runnable() {

	    @Override
	    public void run() {
		dispose();
	    }
	});
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clientOutlet;
    private javax.swing.JButton close;
    private javax.swing.JPanel componentpanel;
    private javax.swing.JPanel detailpanel;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblKlasse;
    private javax.swing.JLabel lblNummer;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblSave;
    private javax.swing.JPanel pricepanel;
    // End of variables declaration//GEN-END:variables
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
