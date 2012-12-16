/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ingredients;

import database.tables.Contact;
import gui.MasterDetailViewController;
import gui.TabbedViewController;
import gui.ingredients.controllers.BasicIngredientViewController;
import gui.ingredients.controllers.RecipeViewController;
import gui.ingredients.controllers.SupplierViewController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import pastahouse.ApplicationInvoices;

/**
 *
 * @author Hannes
 */
public class RecipeTabbedViewController extends javax.swing.JPanel implements TabbedViewController{

    private final int recipeTabIndex = 0;
    private final int ingredientTabIndex = 1;
    private final int supplierTabIndex = 2;
    private HashMap<Integer, MasterDetailViewController> tabs;
    
    /**
     * Creates new form RecipeTabbedViewController
     */
    public RecipeTabbedViewController(final ApplicationInvoices frame) {
        initComponents();
	
        tabs = new HashMap<Integer, MasterDetailViewController>();
        
	tabs.put(supplierTabIndex, new SupplierViewController());
	tabs.put(ingredientTabIndex, new BasicIngredientViewController(this));
	tabs.put(recipeTabIndex, new RecipeViewController());
	
	recipeTab.add(tabs.get(recipeTabIndex).view());
	ingredientTab.add(tabs.get(ingredientTabIndex).view());
	supplierTab.add(tabs.get(supplierTabIndex).view());
	
	tabController.addChangeListener(new ChangeListener() {

	    @Override
	    public void stateChanged(ChangeEvent e) {
		tabs.get(tabController.getSelectedIndex()).electFirstResponder();
		frame.updateMenus();
	    }
	});
    }
    
    public void electFirstResponder(){
	tabs.get(tabController.getSelectedIndex()).electFirstResponder();
    }
    
    public void selectAndSwitchToSupplier(Contact supplier){
	tabController.setSelectedIndex(supplierTabIndex);
	((SupplierViewController)tabs.get(supplierTabIndex)).selectSupplier(supplier);
    }
    
    @Override
    public JPanel view(){
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

        tabMenu = new javax.swing.JMenu();
        recipeMenuItem = new javax.swing.JMenuItem();
        ingredientMenuItem = new javax.swing.JMenuItem();
        supplierMenuItem = new javax.swing.JMenuItem();
        tabController = new javax.swing.JTabbedPane();
        recipeTab = new javax.swing.JPanel();
        ingredientTab = new javax.swing.JPanel();
        supplierTab = new javax.swing.JPanel();

        tabMenu.setText("Tabs");

        recipeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        recipeMenuItem.setText("Recepten");
        recipeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recipeMenuItemActionPerformed(evt);
            }
        });
        tabMenu.add(recipeMenuItem);

        ingredientMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        ingredientMenuItem.setText("Ingrediënten");
        ingredientMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingredientMenuItemActionPerformed(evt);
            }
        });
        tabMenu.add(ingredientMenuItem);

        supplierMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        supplierMenuItem.setText("Leveranciers");
        supplierMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierMenuItemActionPerformed(evt);
            }
        });
        tabMenu.add(supplierMenuItem);

        setFocusable(false);
        setLayout(new java.awt.BorderLayout());

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

        add(tabController, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void supplierMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierMenuItemActionPerformed
        tabController.setSelectedIndex(supplierTabIndex);
    }//GEN-LAST:event_supplierMenuItemActionPerformed

    private void recipeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recipeMenuItemActionPerformed
        tabController.setSelectedIndex(recipeTabIndex);
    }//GEN-LAST:event_recipeMenuItemActionPerformed

    private void ingredientMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingredientMenuItemActionPerformed
        tabController.setSelectedIndex(ingredientTabIndex);
    }//GEN-LAST:event_ingredientMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ingredientMenuItem;
    private javax.swing.JPanel ingredientTab;
    private javax.swing.JMenuItem recipeMenuItem;
    private javax.swing.JPanel recipeTab;
    private javax.swing.JMenuItem supplierMenuItem;
    private javax.swing.JPanel supplierTab;
    private javax.swing.JTabbedPane tabController;
    private javax.swing.JMenu tabMenu;
    // End of variables declaration//GEN-END:variables

    @Override
    public List<JMenu> menus() {
	List<JMenu> l = new ArrayList<JMenu>();
	l.add(tabMenu);
	l.add(tabs.get(tabController.getSelectedIndex()).menu());
	return l;
    }
}
