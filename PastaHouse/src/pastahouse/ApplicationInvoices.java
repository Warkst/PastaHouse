/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pastahouse;

import gui.TabbedViewController;
import gui.contacts.ContactsTabbedViewController;
import gui.ingredients.RecipeTabbedViewController;
import gui.invoices.InvoiceTabbedViewController;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import tools.Configuration;
import tools.Utilities;

/**
 *
 * @author Hannes
 */
public class ApplicationInvoices extends javax.swing.JFrame {

    private final RecipeTabbedViewController rtvc;
    private final InvoiceTabbedViewController itvc;
    private final ContactsTabbedViewController ctvc;
    
    private TabbedViewController activeTabbedViewController;

    
    /**
     * Creates new form ApplicationInvoices
     */
    public ApplicationInvoices() {
	initComponents();
	/*
	 * Set full screen
	 */
	setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setLocationRelativeTo(null);
        setTitle("Pasta House");
	
	ToolTipManager.sharedInstance().setInitialDelay(0);
	ToolTipManager.sharedInstance().setDismissDelay(Integer.MAX_VALUE);
	ToolTipManager.sharedInstance().setLightWeightPopupEnabled(true);
	
	rtvc = new RecipeTabbedViewController(this);
        itvc = new InvoiceTabbedViewController(this);
        ctvc = new ContactsTabbedViewController();
	
	activeTabbedViewController = null;

        getContentPane().removeAll();
        getContentPane().add(rtvc, BorderLayout.CENTER);
        getContentPane().removeAll();
	getContentPane().add(itvc, BorderLayout.CENTER);
        getContentPane().removeAll();
	getContentPane().add(ctvc, BorderLayout.CENTER);
        validate();

        getContentPane().removeAll();
//	ImagePanelBean ipb = new ImagePanelBean();
//	ipb.setBackgroundImage(new ImageIcon(ImagePanelBean.class.getResource("logo.png")), getSize());
//	getContentPane().add(ipb);
//	ipb.add(buttonPanel);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        validate();
    }

    public void updateMenus(){
	removeActiveMenus();
	addActiveMenus();
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

        buttonPanel = new javax.swing.JPanel();
        fillerWest = new javax.swing.Box.Filler(new java.awt.Dimension(40, 0), new java.awt.Dimension(40, 0), new java.awt.Dimension(40, 32767));
        fillerEast = new javax.swing.Box.Filler(new java.awt.Dimension(40, 0), new java.awt.Dimension(40, 0), new java.awt.Dimension(40, 32767));
        fillerNorth = new javax.swing.Box.Filler(new java.awt.Dimension(0, 40), new java.awt.Dimension(0, 40), new java.awt.Dimension(32767, 40));
        fillerSouth = new javax.swing.Box.Filler(new java.awt.Dimension(0, 40), new java.awt.Dimension(0, 40), new java.awt.Dimension(32767, 40));
        jPanel1 = new javax.swing.JPanel();
        btnRecipes = new javax.swing.JButton();
        btnInvoices = new javax.swing.JButton();
        btnContacts = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        homeMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        recipeMenuItem = new javax.swing.JMenuItem();
        invoiceMenuItem = new javax.swing.JMenuItem();
        contactsMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        quitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(1000, 800));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                ResizeHandler(evt);
            }
        });

        buttonPanel.setFocusable(false);
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new java.awt.GridBagLayout());

        fillerWest.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 1.0;
        buttonPanel.add(fillerWest, gridBagConstraints);

        fillerEast.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 1.0;
        buttonPanel.add(fillerEast, gridBagConstraints);

        fillerNorth.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        buttonPanel.add(fillerNorth, gridBagConstraints);

        fillerSouth.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        buttonPanel.add(fillerSouth, gridBagConstraints);

        jPanel1.setFocusable(false);
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(3, 1, 0, 10));

        btnRecipes.setText("Recepten");
        btnRecipes.setFocusable(false);
        btnRecipes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecipesActionPerformed(evt);
            }
        });
        jPanel1.add(btnRecipes);

        btnInvoices.setText("Facturatie");
        btnInvoices.setFocusable(false);
        btnInvoices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvoicesActionPerformed(evt);
            }
        });
        jPanel1.add(btnInvoices);

        btnContacts.setText("Adressenboek");
        btnContacts.setFocusable(false);
        btnContacts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContactsActionPerformed(evt);
            }
        });
        jPanel1.add(btnContacts);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 1.0;
        buttonPanel.add(jPanel1, gridBagConstraints);

        getContentPane().add(buttonPanel, java.awt.BorderLayout.CENTER);

        jMenu1.setText("PastaHouse");

        homeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        homeMenuItem.setText("Home");
        homeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(homeMenuItem);
        jMenu1.add(jSeparator2);

        recipeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.SHIFT_MASK));
        recipeMenuItem.setText("Recepten");
        recipeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recipeMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(recipeMenuItem);

        invoiceMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.SHIFT_MASK));
        invoiceMenuItem.setText("Facturatie");
        invoiceMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(invoiceMenuItem);

        contactsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.SHIFT_MASK));
        contactsMenuItem.setText("Adressenboek");
        contactsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactsMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(contactsMenuItem);
        jMenu1.add(jSeparator1);

        quitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        quitMenuItem.setText("Quit");
        quitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(quitMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setContent(JPanel content){
	getContentPane().removeAll();
        getContentPane().add(content);
        validate();
	repaint();
    }
    
    private void removeActiveMenus(){
	jMenuBar1.removeAll();
	jMenuBar1.add(jMenu1);
    }
    
    private void addActiveMenus(){
	if (activeTabbedViewController != null) {
	    for (JMenu jMenu : activeTabbedViewController.menus()) {
		if (jMenu!=null) {
		    addMenu(jMenu);
		}
	    }
	}
    }
    
    private void removeMenu(JMenu toRemove){
	jMenuBar1.remove(toRemove);
    }
    
    private void addMenu(JMenu toAdd){
	jMenuBar1.add(toAdd);
    }
    
    private void btnRecipesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecipesActionPerformed
	removeActiveMenus();
	setContent(rtvc);
        rtvc.electFirstResponder();
	activeTabbedViewController = rtvc;
	addActiveMenus();
    }//GEN-LAST:event_btnRecipesActionPerformed

    private void ResizeHandler(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ResizeHandler
    }//GEN-LAST:event_ResizeHandler

    private void btnInvoicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvoicesActionPerformed
        removeActiveMenus();
	setContent(itvc);
	activeTabbedViewController = itvc;
	addActiveMenus();
    }//GEN-LAST:event_btnInvoicesActionPerformed

    private void btnContactsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContactsActionPerformed
        removeActiveMenus();
	setContent(ctvc);
	activeTabbedViewController = ctvc;
	addActiveMenus();
    }//GEN-LAST:event_btnContactsActionPerformed

    private void homeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeMenuItemActionPerformed
        removeActiveMenus();
	setContent(buttonPanel);
	activeTabbedViewController = null;
	addActiveMenus();
    }//GEN-LAST:event_homeMenuItemActionPerformed

    private void quitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitMenuItemActionPerformed
        logging.MyLogger.log("Exiting system through menu accelerator");
	System.exit(0);
    }//GEN-LAST:event_quitMenuItemActionPerformed

    private void recipeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recipeMenuItemActionPerformed
        btnRecipesActionPerformed(evt);
    }//GEN-LAST:event_recipeMenuItemActionPerformed

    private void invoiceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceMenuItemActionPerformed
        btnInvoicesActionPerformed(evt);
    }//GEN-LAST:event_invoiceMenuItemActionPerformed

    private void contactsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactsMenuItemActionPerformed
        btnContactsActionPerformed(evt);
    }//GEN-LAST:event_contactsMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ApplicationInvoices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplicationInvoices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplicationInvoices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicationInvoices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        database.Database.driver();

        UIManager.getLookAndFeelDefaults().put("defaultFont", new Font("Arial", Font.PLAIN, Utilities.fontSize()));

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ApplicationInvoices().setVisible(true);
            }
        });

        System.out.println(Configuration.center().getDB_URL());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContacts;
    private javax.swing.JButton btnInvoices;
    private javax.swing.JButton btnRecipes;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JMenuItem contactsMenuItem;
    private javax.swing.Box.Filler fillerEast;
    private javax.swing.Box.Filler fillerNorth;
    private javax.swing.Box.Filler fillerSouth;
    private javax.swing.Box.Filler fillerWest;
    private javax.swing.JMenuItem homeMenuItem;
    private javax.swing.JMenuItem invoiceMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem quitMenuItem;
    private javax.swing.JMenuItem recipeMenuItem;
    // End of variables declaration//GEN-END:variables
}
