package com.housing.javaee6demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlIDREF;
import java.io.Serializable;
import java.text.MessageFormat;

/**
 * @author Matija Mazi <br/>
 * @created 19.1.12 16:36
 */
@Entity
public class OrderItem implements Serializable {
    @Id @GeneratedValue private Long id;

    @ManyToOne
    @JoinColumn(updatable = false)
    @XmlIDREF
    private Order order;

    @ManyToOne
    @JoinColumn(updatable = false)
    private Product product;

    private Double quantity;

    protected OrderItem() { }

    public OrderItem(Order order, Product product, Double quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

//    public Order getOrder() {
//        return order;
//    }

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
