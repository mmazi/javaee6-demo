package com.housing.javaee6demo.ejb.cdi;

import com.housing.javaee6demo.model.Order;
import com.housing.javaee6demo.model.Product;
import com.housing.javaee6demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author Matija Mazi <br/>
 * @created 9.2.12 13:36
 */
@DependsOn("PersistentDataInitializer")
@Startup
@Singleton
public class GlobalDataProducer implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(GlobalDataProducer.class);

    @PersistenceContext private EntityManager em;

    private List<Product> allProducts;
    private List<User> allUsers;

    @PostConstruct
    public void readAll() {
        log.debug("GlobalDataProducer.readAll");
        readAllUsers();
        readAllProducts();
    }

    private void readAllUsers() {
        allUsers = em.createQuery("select u from User u order by u.username", User.class)
                .getResultList();
    }

    private void readAllProducts() {
        allProducts = em.createQuery("select p from Product p order by p.name", Product.class)
                .getResultList();
    }

    @Produces @Named @ApplicationScoped
    public List<Order.Status> getAllStatuses() {
        return Arrays.asList(Order.Status.values());
    }

    @Produces @RequestScoped @Named
    public List<Product> getAllProducts() {
        return allProducts;
    }

    @Produces @RequestScoped @Named
    public List<User> getAllUsers() {
        return allUsers;
    }
}
