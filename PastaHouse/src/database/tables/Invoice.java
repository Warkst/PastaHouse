/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.tables;

import database.Database;
import database.FunctionResult;
import database.extra.InvoiceItem;
import database.extra.Record;
import database.models.InvoiceModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.Configuration;

/**
 *
 * @author Robin jr
 */
public class Invoice extends Record<Invoice> {

    private int number;
    private String date;
    private Contact client;
    private String priceCode;
    private double save;
    private ArrayList<InvoiceItem> items;
    private Map<Double, List<InvoiceItem>> itemsPerCategory;

    public Invoice(ArrayList<InvoiceItem> items) {
        super(1234656, "");
        this.items = items;
    }

    private Invoice(int id, int number, String date, Contact client, String priceCode, double save) {
        super(id, Configuration.center().getDB_TABLE_INV());
        this.number = number;
        this.date = date;
        this.client = client;
        this.priceCode = priceCode;
        this.save = save;
        this.items = new ArrayList<InvoiceItem>();
    }

    public static Invoice createStub(int id, int number, String date, Contact client, String priceCode, double save) {
        return new Invoice(id, number, date, client, priceCode, save);
    }

    public static Invoice createFromModel(int id, InvoiceModel model) {
        return new Invoice(id, model.getNumber(), model.getDate(), model.getClient(), model.getPriceCode(), model.getSave());
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Contact getClient() {
        return client;
    }

    public void setClient(Contact client) {
        this.client = client;
    }

    public String getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(String priceCode) {
        this.priceCode = priceCode;
    }

    public double getSave() {
        return save;
    }

    public void setSave(double save) {
        this.save = save;
    }

    public void addItem(double amount, double price, double taxes, String name, Article article, String lot) {
        items.add(new InvoiceItem(article, name, amount, price, taxes, lot));
    }

    public ArrayList<InvoiceItem> items() {
        return items;
    }

    public void SetItems(ArrayList<InvoiceItem> items) {
        this.items = items;
    }

    public Map<Double, List<InvoiceItem>> itemsPerTaxesCategory(boolean reset) {
        if (itemsPerCategory == null || reset == true) {
            itemsPerCategory = new HashMap<Double, List<InvoiceItem>>();

            for (InvoiceItem invoiceItem : items()) {
                if (itemsPerCategory.containsKey(invoiceItem.getArticle().getTaxes())) {
                    itemsPerCategory.get(invoiceItem.getArticle().getTaxes()).add(invoiceItem);
                } else {
                    List<InvoiceItem> _items = new ArrayList<InvoiceItem>();
                    _items.add(invoiceItem);
                    itemsPerCategory.put(invoiceItem.getArticle().getTaxes(), _items);
                }
            }
        }
        return itemsPerCategory;
    }

    public Map<Double, List<InvoiceItem>> itemsPerTaxesCategory() {
        return itemsPerTaxesCategory(true);
    }

    public List<Double> netBeforeSave() {
        List<Double> nets = new ArrayList<Double>();

        itemsPerTaxesCategory(false);

        for (List<InvoiceItem> list : itemsPerCategory.values()) {
            double net = 0.0;
            for (InvoiceItem invoiceItem : list) {
                net += invoiceItem.getArticle().getPriceForCode(getPriceCode()) * invoiceItem.getAmount();
            }
            nets.add(net);
        }

        return nets;
    }

    public List<Double> savings() {
        List<Double> savings = new ArrayList<Double>();

        List<Double> nets = netBeforeSave();

        int index = 0;
        for (List<InvoiceItem> list : itemsPerCategory.values()) {
            double sav = nets.get(index) * getSave() / 100;
            savings.add(sav);
            index++;
        }

        return savings;
    }

    public List<Double> netAfterSave() {
        List<Double> nets = new ArrayList<Double>();

        List<Double> net = netBeforeSave();
        List<Double> saves = savings();

        for (int i = 0; i < net.size(); i++) {
            nets.add(net.get(i) - saves.get(i));
        }

        return nets;
    }

    public List<Double> added() {
        List<Double> added = new ArrayList<Double>();

        List<Double> nets = netAfterSave();
        Set<Double> categories = itemsPerTaxesCategory().keySet();

        int index = 0;
        for (Double cat : categories) {
            added.add(cat / 100 * nets.get(index));
        }

        return added;
    }

    public List<Double> total() {
        List<Double> totals = new ArrayList<Double>();

        List<Double> nets = netAfterSave();
        List<Double> adds = added();

        for (int i = 0; i < nets.size(); i++) {
            totals.add(nets.get(i) + adds.get(i));
        }

        return totals;

    }

    @Override
    public FunctionResult<Invoice> update() {
        try {
            return Database.driver().updateInvoice(this);
        } catch (SQLException ex) {
            Logger.getLogger(Recipe.class.getName()).log(Level.SEVERE, null, ex);
            return new FunctionResult<Invoice>(2, null, ex.getMessage());
        }
    }

    @Override
    public boolean delete() {
        return Database.driver().deleteInvoice(this).getCode() == 0;
    }

    public Invoice(Invoice copy) {
        super(copy.getPrimaryKeyValue(), copy.getTableName());
        this.number = copy.getNumber();
        this.date = copy.date;
        this.client = copy.client;
        this.priceCode = copy.priceCode;
        this.save = copy.save;
        this.items = new ArrayList<InvoiceItem>();
        for(InvoiceItem item: copy.items){
            this.items.add(new InvoiceItem(item));
        }
    }

    public void copy(Invoice copy) {
        this.number = copy.getNumber();
        this.date = copy.date;
        this.client = copy.client;
        this.priceCode = copy.priceCode;
        this.save = copy.save;
        this.items = new ArrayList<InvoiceItem>();
        for(InvoiceItem item: copy.items){
            this.items.add(new InvoiceItem(item));
        }
    }
}
