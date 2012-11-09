/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Application.java
 *
 * Created on Oct 24, 2012, 1:16:31 PM
 */
package pastahouse;

import database.Configuration;
import database.Supplier;
import gui.IngredientViewController;
import gui.MasterDetailViewController;
import gui.RecipeViewController;
import gui.SupplierViewController;
import java.util.HashMap;

/**
 *
 * @author Warkst
 */
public class Application extends javax.swing.JFrame {
    
    private final int supplierTabIndex = 0;
    private final int ingredientTabIndex = 1;
    private final int recipeTabIndex = 2;

    private HashMap<Integer, MasterDetailViewController> tabs;
    
    /** Creates new form Application */
    public Application() {
	initComponents();
		setTitle("Pasta House");

	setLocationRelativeTo(null);
	
	// load viewControllers
	
	tabs = new HashMap<Integer, MasterDetailViewController>();
	
	tabs.put(supplierTabIndex, new SupplierViewController());
	tabs.put(ingredientTabIndex, new IngredientViewController(this));
	tabs.put(recipeTabIndex, new RecipeViewController());
	
	recipeTab.add(tabs.get(recipeTabIndex).view());
	ingredientTab.add(tabs.get(ingredientTabIndex).view());
	supplierTab.add(tabs.get(supplierTabIndex).view());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtFirma = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtAdres = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtGemeente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtGSM = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtFax = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tabController = new javax.swing.JTabbedPane();
        recipeTab = new javax.swing.JPanel();
        ingredientTab = new javax.swing.JPanel();
        supplierTab = new javax.swing.JPanel();
        menu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        close = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        add = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenuItem();
        viewMenu = new javax.swing.JMenu();
        recipeMenuItem = new javax.swing.JMenuItem();
        ingredientMenuItem = new javax.swing.JMenuItem();
        supplierMenuItem = new javax.swing.JMenuItem();

        jPanel2.setLayout(new java.awt.GridLayout(8, 2));

        jLabel11.setText("Firma");
        jPanel2.add(jLabel11);
        jPanel2.add(txtFirma);

        jLabel10.setText("Contactpersoon");
        jPanel2.add(jLabel10);
        jPanel2.add(txtContact);

        jLabel13.setText("Adres");
        jPanel2.add(jLabel13);
        jPanel2.add(txtAdres);

        jLabel12.setText("Gemeente");
        jPanel2.add(jLabel12);
        jPanel2.add(txtGemeente);

        jLabel9.setText("Telefoon");
        jPanel2.add(jLabel9);
        jPanel2.add(txtTel);

        jLabel14.setText("GSM");
        jPanel2.add(jLabel14);
        jPanel2.add(txtGSM);

        jLabel15.setText("Fax");
        jPanel2.add(jLabel15);
        jPanel2.add(txtFax);

        jLabel16.setText("Email");
        jPanel2.add(jLabel16);
        jPanel2.add(txtEmail);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opmerking"));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(800, 600));
        jScrollPane2.setName(""); // NOI18N

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setText("jButton1");
        jPanel1.add(jButton1);

        jButton2.setText("jButton2");
        jPanel1.add(jButton2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));

        tabController.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tabController.setFocusable(false);

        recipeTab.setFocusable(false);
        recipeTab.setLayout(new java.awt.BorderLayout());
        tabController.addTab("Recepten", recipeTab);

        ingredientTab.setFocusable(false);
        ingredientTab.setLayout(new java.awt.BorderLayout());
        tabController.addTab("Ingrediënten", ingredientTab);

        supplierTab.setFocusable(false);
        supplierTab.setLayout(new java.awt.BorderLayout());
        tabController.addTab("Leveranciers", supplierTab);

        getContentPane().add(tabController, java.awt.BorderLayout.CENTER);
        tabController.getAccessibleContext().setAccessibleName("tabController");

        jMenu1.setText("File");

        close.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        close.setText("Close");
        jMenu1.add(close);

        menu.add(jMenu1);

        jMenu2.setText("Edit");

        add.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        add.setText("Toevoegen...");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jMenu2.add(add);

        edit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        edit.setText("Wijzigen...");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jMenu2.add(edit);

        menu.add(jMenu2);

        viewMenu.setText("View");

        recipeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        recipeMenuItem.setText("Recepten");
        recipeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recipeMenuItemActionPerformed(evt);
            }
        });
        viewMenu.add(recipeMenuItem);

        ingredientMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        ingredientMenuItem.setText("Ingrediënten");
        ingredientMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingredientMenuItemActionPerformed(evt);
            }
        });
        viewMenu.add(ingredientMenuItem);

        supplierMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        supplierMenuItem.setText("Leveranciers");
        supplierMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierMenuItemActionPerformed(evt);
            }
        });
        viewMenu.add(supplierMenuItem);

        menu.add(viewMenu);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void recipeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recipeMenuItemActionPerformed
        tabController.setSelectedIndex(0);
    }//GEN-LAST:event_recipeMenuItemActionPerformed

    private void ingredientMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingredientMenuItemActionPerformed
        tabController.setSelectedIndex(1);
    }//GEN-LAST:event_ingredientMenuItemActionPerformed

    private void supplierMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierMenuItemActionPerformed
        tabController.setSelectedIndex(2);
    }//GEN-LAST:event_supplierMenuItemActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
	tabs.get(tabController.getSelectedIndex()).add();
    }//GEN-LAST:event_addActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        tabs.get(tabController.getSelectedIndex()).edit();
    }//GEN-LAST:event_editActionPerformed

    public void selectAndSwitchToSupplier(Supplier supplier){
	((SupplierViewController)tabs.get(supplierTabIndex)).selectSupplier(supplier);
	tabController.setSelectedIndex(2);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
	/* Set the Nimbus look and feel */
	//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	 */
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException ex) {
	    java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {

	    @Override
	    public void run() {
		new Application().setVisible(true);
	    }
	});
	
	System.out.println(Configuration.center().getDB_URL());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem add;
    private javax.swing.JMenuItem close;
    private javax.swing.JMenuItem edit;
    private javax.swing.JMenuItem ingredientMenuItem;
    private javax.swing.JPanel ingredientTab;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem recipeMenuItem;
    private javax.swing.JPanel recipeTab;
    private javax.swing.JMenuItem supplierMenuItem;
    private javax.swing.JPanel supplierTab;
    private javax.swing.JTabbedPane tabController;
    private javax.swing.JTextField txtAdres;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFax;
    private javax.swing.JTextField txtFirma;
    private javax.swing.JTextField txtGSM;
    private javax.swing.JTextField txtGemeente;
    private javax.swing.JTextField txtTel;
    private javax.swing.JMenu viewMenu;
    // End of variables declaration//GEN-END:variables
}
