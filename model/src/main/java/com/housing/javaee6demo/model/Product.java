package com.housing.javaee6demo.model;

import java.io.Serializable;
import java.text.MessageFormat;

/**
 * @author Matija Mazi <br/>
 * @created 9.1.12 17:22
 */
public class Product implements Serializable {
    private String name;

    private Unit unit;

    private ProductCategory category;

    protected Product() { }

    public Product(String name, Unit unit, ProductCategory category) {
        this.name = name;
        this.unit = unit;
        this.category = category;
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
        return MessageFormat.format("Product[{0}]", name);
    }
}
