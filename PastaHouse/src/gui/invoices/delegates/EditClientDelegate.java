/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.invoices.delegates;

import database.tables.Client;

/**
 *
 * @author Warkst
 */
public interface EditClientDelegate {
    public void updateClient(Client o, Client n);
}
