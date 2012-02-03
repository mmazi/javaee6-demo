package com.housing.javaee6demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.text.MessageFormat;

/**
 * @author Matija Mazi <br/>
 * @created 9.1.12 17:22
 */
@Entity
public class Product implements Serializable {
    @Id @Size(max = 40)
    private String id;

    @Size(max = 255) @NotNull
    private String name;

    @ManyToOne
    private Unit unit;

    @ManyToOne
    private ProductCategory category;

    protected Product() { }

    public Product(String name, Unit unit, ProductCategory category) {
        this.id = name;
        this.name = name;
        this.unit = unit;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Product[{0} ({1})]", id, name);
    }
}
