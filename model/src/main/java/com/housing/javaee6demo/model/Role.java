package com.housing.javaee6demo.model;

/**
 * @author Matija Mazi
 */
public enum Role {
    admin("Administrator"),
    orderer("Orderer"),
    ;

    private String description;

    Role(String description) {
        this.description = description;
    }

    public String getId() {
        return toString();
    }

    public String getDescription() {
        return description;
    }
}
