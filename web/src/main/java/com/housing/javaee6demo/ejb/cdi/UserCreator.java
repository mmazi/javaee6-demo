package com.housing.javaee6demo.ejb.cdi;

import com.housing.javaee6demo.model.Role;
import com.housing.javaee6demo.model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Matija Mazi <br/>
 * @created 3.2.12 14:15
 */
public class UserCreator implements Serializable {
    private static void addUser(String username, String password, String name, List<Role> roles, Map<String, User> allUsers) {
        allUsers.put(username, new User(username, password, name, roles));
    }

    public static List<User> createUsers() {
        Map<String, User> allUsers = new HashMap<String, User>();
        addUser("mmazi", "a", "Matija Mazi", Arrays.asList(Role.admin, Role.orderer), allUsers);
        addUser("jnovak", "a", "Janez Novak", Arrays.asList(Role.orderer), allUsers);
        addUser("mhribar", "a", "Marija Hribar", Arrays.asList(Role.orderer), allUsers);
        addUser("nn", "a", "--", Collections.<Role>emptyList(), allUsers);
        return new ArrayList<User>(allUsers.values());
    }

}
