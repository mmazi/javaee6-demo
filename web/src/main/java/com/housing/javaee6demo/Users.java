package com.housing.javaee6demo;

import com.housing.javaee6demo.model.Role;
import com.housing.javaee6demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Matija Mazi <br/>
 * @created 2.2.12 17:47
 */
@Named
@SessionScoped
public class Users implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(Users.class);

    private User selectedUser;

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public List<Role> getRoles(User u) {
        return new ArrayList<Role>(u.getRoles());
    }
}
