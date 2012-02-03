package com.housing.javaee6demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.text.MessageFormat;

/**
 * @author Matija Mazi <br/>
 * @created 9.1.12 17:22
 */
@Entity
public class ProductCategory implements Serializable {
    @Id @Size(max = 40)
    private String id;

    @Size(max = 255) @NotNull
    private String name;

    protected ProductCategory() { }

    public ProductCategory(String name) {
        this.id = name;
        this.name = name;
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

    @Override
    public String toString() {
        return MessageFormat.format("ProductCategory[{0} ({1})]", id, name);
    }
}
