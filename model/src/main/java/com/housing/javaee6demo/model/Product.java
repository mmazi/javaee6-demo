package com.housing.javaee6demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlIDREF;
import java.io.Serializable;
import java.text.MessageFormat;

/**
 * @author Matija Mazi <br/>
 * @created 9.1.12 17:22
 */
@Entity
public class Product implements Serializable {
    @Id @GeneratedValue
    private Long id;

    @Size(max = 255) @NotNull
    private String name;

    @ManyToOne
    @XmlIDREF
    private Unit unit;

    @ManyToOne
    private ProductCategory category;

    protected Product() { }

    public Product(String name, Unit unit, ProductCategory category) {
        this.name = name;
        this.unit = unit;
        this.category = category;
    }

    public Long getId() {
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Product product = (Product) o;

        if (id != null) {
            return id.equals(product.id);
        } else {
            return product.id == null && super.equals(o);
        }
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return MessageFormat.format("Product[{0} ({1})]", id, name);
    }
}
