package com.housing.javaee6demo.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Matija Mazi <br/>
 * @created 9.1.12 17:22
 */
@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {
    @Id @Size(max = 40)
    private String id;

    private Date created;

    @Version
    private Timestamp updated;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("product")
    private List<OrderItem> items = new ArrayList<OrderItem>();

    @ManyToOne
    private User creator;

    @ManyToOne
    private User assignee;

    @Enumerated(EnumType.STRING)
    @Column(length = 31)
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

    @PrePersist
    public void prePersist() {
        this.id = MessageFormat.format("O/{0,date,medium}_{0,time,medium}", new Date());
    }

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
