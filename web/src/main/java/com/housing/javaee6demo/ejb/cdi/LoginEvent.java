package com.housing.javaee6demo.ejb.cdi;

import com.housing.javaee6demo.model.User;

/**
 * @author Matija Mazi <br/>
 * @created 9.2.12 14:00
 */
public class LoginEvent {
    private User user;

    public LoginEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
