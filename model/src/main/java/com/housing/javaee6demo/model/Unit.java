package com.housing.javaee6demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Matija Mazi <br/>
 * @created 19.1.12 16:41
 */
@Entity
public class Unit implements Serializable {
    @Id @Size(max = 40)
    private String id;

    @NotNull
    private String name;

    protected Unit() { }

    public Unit(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id;
    }
}
