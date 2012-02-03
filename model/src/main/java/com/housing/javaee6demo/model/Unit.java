package com.housing.javaee6demo.model;

import java.io.Serializable;

/**
 * @author Matija Mazi <br/>
 * @created 19.1.12 16:41
 */
public class Unit implements Serializable {
    private String id;

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
