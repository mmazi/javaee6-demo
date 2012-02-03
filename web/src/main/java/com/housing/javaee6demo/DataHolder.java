package com.housing.javaee6demo;

import com.housing.javaee6demo.model.Role;
import com.housing.javaee6demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
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
public class DataHolder implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(DataHolder.class);

    private static Map<String, User> allUsers;

    static {
        log.debug("DataHolder.static intializer");
        allUsers = new HashMap<String, User>();
        addUser("mmazi", "a", "Matija Mazi", Arrays.asList(Role.admin, Role.orderer));
        addUser("jnovak", "a", "Janez Novak", Arrays.asList(Role.orderer));
        addUser("mhribar", "a", "Marija Hribar", Arrays.asList(Role.orderer));
        addUser("nn", "a", "--", Collections.<Role>emptyList());
    }

    private static void addUser(String username, String password, String name, List<Role> roles) {
        allUsers.put(username, new User(username, password, name, roles));
    }

    @Produces @Named @ApplicationScoped
    public static List<User> getAllUsers() {
        return new ArrayList<User>(allUsers.values());
    }

    static User getUser(String username) {
        return allUsers.get(username);
    }
}
