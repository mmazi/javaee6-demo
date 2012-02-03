package com.housing.javaee6demo.model;

import java.io.Serializable;
import java.text.MessageFormat;

/**
 * @author Matija Mazi <br/>
 * @created 9.1.12 17:22
 */
public class ProductCategory implements Serializable {
    private String name;

    protected ProductCategory() { }

    public ProductCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return MessageFormat.format("ProductCategory[{0}]", name);
    }
}
