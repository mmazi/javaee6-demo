package com.housing.javaee6demo.ejb.cdi;

import com.housing.javaee6demo.model.Order;
import com.housing.javaee6demo.model.Product;
import com.housing.javaee6demo.model.User;

import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * @author Matija Mazi <br/>
 * @created 9.2.12 13:08
 */
@ConversationScoped
@Stateful
@Named
public class OrderManager implements Serializable {

    @PersistenceContext private EntityManager em;
    @Inject @Authenticated private User user;
    @Inject private Conversation conversation;

    private Order editedOrder;

    private Double quantity;
    private Product selectedProduct;


    public String newOrder() {
        return editOrder(new Order(user));
    }

    public String editOrder(Order o) {
        editedOrder = o;
        conversation.begin();
        return "/order-edit-1.xhtml";
    }

    @Produces @Named
    public Order getEditedOrder() {
        return editedOrder;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public void addItem() {
        editedOrder.addItem(selectedProduct, quantity);
    }

    public String saveOrder() {
        em.merge(editedOrder);
        conversation.end();
        return "saved";
    }
}
