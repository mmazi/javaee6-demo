package com.housing.javaee6demo.model;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Matija Mazi <br/>
 * @created 9.1.12 17:22
 */
public class Order implements Serializable {
    private String id;

    private Date created;

    private Date updated;

    private List<OrderItem> items = new ArrayList<OrderItem>();

    private User creator;

    private User assignee;

    private Status status;

    private String comments;

    protected Order() { }

    public Order(User creator) {
        this.creator = creator;
        this.assignee = creator;
        created = new Date();
        status = Status.RCV;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public boolean addItem(OrderItem item) {
        item.setOrder(this);
        return items.add(item);
    }

    public void addItem(Product product, double quantity) {
        addItem(new OrderItem(this, product, quantity));
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public User getCreator() {
        return creator;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Order[{0} {1}, created {2}, assigned to {3}]", id, status, created, assignee);
    }

/*
    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID().toString();
    }
*/

    public enum Status {
        RCV("Received"),
        PAID("Paid"),
        PKG("Packaging"),
        SNT("Sent"),
        DLV("Delivered"),
        ;

        private String description;

        Status(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}
