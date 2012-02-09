package com.housing.javaee6demo.ejb.cdi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Matija Mazi <br/>
 * @created 9.2.12 12:48
 */
@RequestScoped
@Named
public class Credentials implements Serializable {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
