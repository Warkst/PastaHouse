/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.invoices.controllers;

import database.Database;
import database.tables.Article;
import gui.EmptyPanelManager;
import gui.MasterDetailViewController;
import gui.invoices.delegates.AddArticleDelegate;
import gui.invoices.delegates.EditArticleDelegate;
import gui.invoices.dialogs.AddArticleDialog;
import gui.invoices.dialogs.EditArticleDialog;
import gui.utilities.list.FilterableListModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.swingx.JXTextField;
import org.jdesktop.swingx.JXTitledPanel;

/**
 *
 * @author Warkst
 */
public class ArticleViewController extends javax.swing.JPanel implements MasterDetailViewController<Article>, AddArticleDelegate, EditArticleDelegate {

//    private ArticleListModel listModel;
    private FilterableListModel<Article> listModel;
    private final JXTextField xfilter = new JXTextField("Zoeken");
    
    /**
     * Creates new form ArticleViewController
     */
    public ArticleViewController() {
	initComponents();
	jTextArea1.setBackground(new Color(213, 216, 222));
        jTextArea1.setCaretPosition(0);
//	listModel = new ArticleListModel(database.Database.driver().getArticlesAlphabetically());
	listModel = new FilterableListModel<Article>(database.Database.driver().getArticlesAlphabetically());
	
	listOutlet.setModel(listModel);
	
	listOutlet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	listOutlet.addListSelectionListener(new ListSelectionListener() {

	    @Override
	    public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
		    if(listOutlet.getSelectedValue() != null) updateDetail((Article)listOutlet.getSelectedValue());
		}
	    }
	});
	listOutlet.setSelectedIndex(0);
	
	if (Database.driver().getArticles().isEmpty()) {
	    detail.remove(container);
	    detail.add(EmptyPanelManager.instance(), BorderLayout.CENTER);
	}
	
	container.add(new JXTitledPanel("Details", fixedfields), BorderLayout.NORTH);
	container.add(new JXTitledPanel("Opmerkingen", jScrollPane2), BorderLayout.CENTER);
	
	master.add(xfilter, BorderLayout.NORTH);
	
	xfilter.addKeyListener(new java.awt.event.KeyAdapter() {
	    @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterKeyReleased(evt);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editMenu = new javax.swing.JMenu();
        addMenuItem = new javax.swing.JMenuItem();
        editMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        fixedfields = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameOutlet = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        codeOutlet = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        priceAOutlet = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        priceBOutlet = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        unitOutlet = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        taxesOutlet = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        filter = new javax.swing.JTextField();
        jSplitPane1 = new javax.swing.JSplitPane();
        master = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listOutlet = new javax.swing.JList();
        add = new javax.swing.JButton();
        detail = new javax.swing.JPanel();
        container = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        edit = new javax.swing.JButton();

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

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Zoeken");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem1);

        fixedfields.setLayout(new java.awt.GridLayout(6, 2));

        jLabel1.setText("Naam");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        fixedfields.add(jLabel1);

        nameOutlet.setText("<nameOutlet>");
        nameOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        fixedfields.add(nameOutlet);

        jLabel3.setBackground(new java.awt.Color(239, 239, 239));
        jLabel3.setText("Code");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel3.setOpaque(true);
        fixedfields.add(jLabel3);

        codeOutlet.setBackground(new java.awt.Color(239, 239, 239));
        codeOutlet.setText("<codeOutlet>");
        codeOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        codeOutlet.setOpaque(true);
        fixedfields.add(codeOutlet);

        jLabel5.setText("Prijs A (Excl BTW)");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        fixedfields.add(jLabel5);

        priceAOutlet.setText("<priceAOutlet>");
        priceAOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        fixedfields.add(priceAOutlet);

        jLabel7.setBackground(new java.awt.Color(239, 239, 239));
        jLabel7.setText("Prijs B (Excl BTW)");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel7.setOpaque(true);
        fixedfields.add(jLabel7);

        priceBOutlet.setBackground(new java.awt.Color(239, 239, 239));
        priceBOutlet.setText("<priceBOutlet>");
        priceBOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        priceBOutlet.setOpaque(true);
        fixedfields.add(priceBOutlet);

        jLabel9.setText("Eenheid");
        jLabel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        fixedfields.add(jLabel9);

        unitOutlet.setText("<unitOutlet>");
        unitOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        fixedfields.add(unitOutlet);

        jLabel11.setBackground(new java.awt.Color(239, 239, 239));
        jLabel11.setText("BTW tarief");
        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        jLabel11.setOpaque(true);
        fixedfields.add(jLabel11);

        taxesOutlet.setBackground(new java.awt.Color(239, 239, 239));
        taxesOutlet.setText("<taxesOutlet>");
        taxesOutlet.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 0));
        taxesOutlet.setOpaque(true);
        fixedfields.add(taxesOutlet);

        jScrollPane2.setBorder(null);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(1);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea1);

        filter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterKeyReleased(evt);
            }
        });

        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(200);

        master.setLayout(new java.awt.BorderLayout());

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

        container.add(jPanel1, java.awt.BorderLayout.SOUTH);

        detail.add(container, java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(detail);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        listModel.setFilter(null);
//	filter.setText("");
	xfilter.setText("");
	new AddArticleDialog(null, true, this).setVisible(true);
    }//GEN-LAST:event_addActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        listModel.setFilter(null);
//	filter.setText("");
	xfilter.setText("");
	if(listOutlet.getSelectedValue()!=null) new EditArticleDialog(null, true, this, (Article)listOutlet.getSelectedValue()).setVisible(true);
    }//GEN-LAST:event_editActionPerformed

    private void addMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenuItemActionPerformed
        addActionPerformed(null);
    }//GEN-LAST:event_addMenuItemActionPerformed

    private void editMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuItemActionPerformed
        editActionPerformed(null);
    }//GEN-LAST:event_editMenuItemActionPerformed

    private void filterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterKeyReleased
//        if (filter.getText().isEmpty()) {
        if (xfilter.getText().isEmpty()) {
	    listModel.setFilter(null);
	} else {
//	    listModel.setFilter(filter.getText());
	    listModel.setFilter(xfilter.getText());
	}
	if (listModel.getSize()==0) {
	    System.out.println("No results");
	    /*
	     * TODO: set detail with "no results"
	     */
	    return;
	}
	listOutlet.setSelectedIndex(0);
	if (listOutlet.getSelectedValue()!=null) {
	    updateDetail((Article)listOutlet.getSelectedValue());
	}
    }//GEN-LAST:event_filterKeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
//        filter.requestFocus();
        xfilter.requestFocus();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JMenuItem addMenuItem;
    private javax.swing.JLabel codeOutlet;
    private javax.swing.JPanel container;
    private javax.swing.JPanel detail;
    private javax.swing.JButton edit;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem editMenuItem;
    private javax.swing.JTextField filter;
    private javax.swing.JPanel fixedfields;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JList listOutlet;
    private javax.swing.JPanel master;
    private javax.swing.JLabel nameOutlet;
    private javax.swing.JLabel priceAOutlet;
    private javax.swing.JLabel priceBOutlet;
    private javax.swing.JLabel taxesOutlet;
    private javax.swing.JLabel unitOutlet;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateDetail(Article article) {
	DecimalFormat three = new DecimalFormat("0.000");
	
	nameOutlet.setText(article.getName());
	codeOutlet.setText(article.getCode());
	priceAOutlet.setText(three.format(article.getPriceA())+" euro");
	priceBOutlet.setText(three.format(article.getPriceB())+" euro");
	unitOutlet.setText(article.getUnit());
	taxesOutlet.setText(new DecimalFormat("0.00").format(article.getTaxes())+" %");
        jTextArea1.setCaretPosition(0);
    }
    
    @Override
    public void electFirstResponder() {
	listModel.update();
	
	listOutlet.requestFocus();
    }

    @Override
    public JPanel view() {
	return this;
    }

    @Override
    public JMenu menu() {
	return editMenu;
    }

    @Override
    public void addArticle(Article article) {
//	ArticleListModel dlm = (ArticleListModel)listOutlet.getModel();
//	dlm.update();
	listModel.update();
	if (listModel.getSize() == 1) {
	    detail.removeAll();
	    detail.add(container);
	}
	listOutlet.setSelectedValue(article, true);
	updateDetail(article);
    }

    @Override
    public void editArticle(Article o, Article n) {
//	ArticleListModel dlm = (ArticleListModel)listOutlet.getModel();
//	dlm.edit(n, o);
	listModel.update();
	listModel.edit(n, o);
	listOutlet.setSelectedValue(n, true);
	updateDetail(n);
    }
}
