/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.invoices.dialogs;

import database.tables.Invoice;
import gui.invoices.delegates.EditInvoiceDelegate;
import gui.utilities.cell.CellRendererFactory;
import gui.utilities.table.invoicetable.InvoiceItemTableModel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
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
public class InvoiceDetailsDialog extends javax.swing.JDialog implements EditInvoiceDelegate{

    private Invoice model;
    private InvoiceItemTableModel tableModel;
    
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
	
	table.getColumns().get(0).setPreferredWidth(400);
        
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
	
	saveOutlet.setText(model.getSave()==0?"0%":"- "+model.getSave()+"%");
	
	updatePrices();
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
        taxespanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        saveOutlet = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        totalpricepanel = new javax.swing.JPanel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jLabel11 = new javax.swing.JLabel();
        totalSavingsOutlet = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        totalNetsOutlet = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        totalAddedOutlet = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        totalOutlet = new javax.swing.JLabel();
        pricesContainer = new javax.swing.JPanel();
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

        pricepanel.setLayout(new java.awt.BorderLayout());

        taxespanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 20));
        taxespanel.setLayout(new java.awt.GridLayout(0, 1));

        jLabel1.setText("BTW%");
        taxespanel.add(jLabel1);

        jLabel5.setText("Bedrag");
        taxespanel.add(jLabel5);

        saveOutlet.setText("Korting");
        taxespanel.add(saveOutlet);

        jLabel8.setText("Exclu");
        taxespanel.add(jLabel8);

        jLabel9.setText("BTW");
        taxespanel.add(jLabel9);

        jLabel10.setText("Totaal");
        taxespanel.add(jLabel10);

        pricepanel.add(taxespanel, java.awt.BorderLayout.WEST);

        totalpricepanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 20));
        totalpricepanel.setLayout(new java.awt.GridLayout(6, 2));
        totalpricepanel.add(filler4);
        totalpricepanel.add(filler8);
        totalpricepanel.add(filler3);
        totalpricepanel.add(filler9);

        jLabel11.setText("Tot Korting");
        totalpricepanel.add(jLabel11);

        totalSavingsOutlet.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        totalpricepanel.add(totalSavingsOutlet);

        jLabel12.setText("Tot Exclu");
        totalpricepanel.add(jLabel12);

        totalNetsOutlet.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        totalpricepanel.add(totalNetsOutlet);

        jLabel13.setText("BTW");
        totalpricepanel.add(jLabel13);

        totalAddedOutlet.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        totalpricepanel.add(totalAddedOutlet);

        jLabel14.setText("Totaal");
        totalpricepanel.add(jLabel14);

        totalOutlet.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        totalpricepanel.add(totalOutlet);

        pricepanel.add(totalpricepanel, java.awt.BorderLayout.EAST);

        pricesContainer.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pricesContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 0));
        pricepanel.add(pricesContainer, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 800));
        setPreferredSize(new java.awt.Dimension(800, 800));

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        edit.setText("Wijzig...");
        edit.setFocusable(false);
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel4.add(edit);

        close.setText("Terug");
        close.setFocusable(false);
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

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        new EditInvoiceDialog(null, true, this,model).setVisible(true);
    }//GEN-LAST:event_editActionPerformed

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
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblKlasse;
    private javax.swing.JLabel lblNummer;
    private javax.swing.JPanel pricepanel;
    private javax.swing.JPanel pricesContainer;
    private javax.swing.JLabel saveOutlet;
    private javax.swing.JPanel taxespanel;
    private javax.swing.JLabel totalAddedOutlet;
    private javax.swing.JLabel totalNetsOutlet;
    private javax.swing.JLabel totalOutlet;
    private javax.swing.JLabel totalSavingsOutlet;
    private javax.swing.JPanel totalpricepanel;
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

    @Override
    public void editInvoice(Invoice oldInvoice, Invoice newInvoice) {
        model.copy(newInvoice);
        tableModel.setData(model.items(), model.getPriceCode());
	saveOutlet.setText(model.getSave()==0?"0%":"- "+model.getSave()+"%");
        updatePrices();
    }

    private void updatePrices(){
	try{
	    pricesContainer.removeAll();
	    
	    totalNetsOutlet.setText("");
	    totalSavingsOutlet.setText("");
	    totalAddedOutlet.setText("");
	    totalOutlet.setText("");
	    
	    Invoice i = new Invoice(model.items());
	    i.setSave(model.getSave());
	    i.setClient(model.getClient());
	    i.setPriceCode(tableModel.priceCode());

	    Set<Double> cats = i.itemsPerTaxesCategory().keySet();

	    List<Double> net = i.netBeforeSave();
	    List<Double> save = i.savings();
	    List<Double> nets = i.netAfterSave();
	    List<Double> add = i.added();
	    List<Double> tot = i.total();

	    DecimalFormat threeFormatter = new DecimalFormat("0.000");
	    DecimalFormat twoFormatter = new DecimalFormat("0.00");

	    int index = 0;
	    double totalSavings = 0.0;
	    double totalNets = 0.0;
	    double totalAdded = 0.0;
	    double total = 0.0;
	    for (Double c : cats) {
		/*
		 * Format a new panel
		 */
		JPanel p = new JPanel(new GridLayout(6, 1));
		p.add(new JLabel(""+c.intValue()+" %", SwingConstants.TRAILING));
		p.add(new JLabel(threeFormatter.format(net.get(index)), SwingConstants.TRAILING));
		p.add(new JLabel(threeFormatter.format(save.get(index)), SwingConstants.TRAILING));
		totalSavings+=save.get(index);
		p.add(new JLabel(threeFormatter.format(nets.get(index)), SwingConstants.TRAILING));
		totalNets+=nets.get(index);
		p.add(new JLabel(threeFormatter.format(add.get(index)), SwingConstants.TRAILING));
		totalAdded+=add.get(index);
		p.add(new JLabel(twoFormatter.format(tot.get(index))+"  ", SwingConstants.TRAILING));
		total+=tot.get(index);

		/*
		 * Add the panel
		 */
		pricesContainer.add(p);
		index++;
	    }
	    
	    totalNetsOutlet.setText(threeFormatter.format(totalNets));
	    totalSavingsOutlet.setText(threeFormatter.format(totalSavings));
	    totalAddedOutlet.setText(threeFormatter.format(totalAdded));
	    totalOutlet.setText(twoFormatter.format(total)+"  ");
	    
	    pricesContainer.repaint();
	    pricesContainer.validate();
	} catch (Exception e){
	    e.printStackTrace();
	}
    }
}
