package com.housing.javaee6demo.model;

import java.io.Serializable;
import java.text.MessageFormat;

/**
 * @author Matija Mazi <br/>
 * @created 19.1.12 16:36
 */
public class OrderItem implements Serializable {

    private Order order;

    private Product product;

    private Double quantity;

    protected OrderItem() { }

    public OrderItem(Order order, Product product, Double quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    protected void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return MessageFormat.format("OrderItem[{0} {1} of {2} in {3}]", quantity, product == null ? null : product.getUnit(), product, order);
    }
}
