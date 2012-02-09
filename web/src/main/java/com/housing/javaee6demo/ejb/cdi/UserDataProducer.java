package com.housing.javaee6demo.ejb.cdi;

import com.housing.javaee6demo.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author Matija Mazi <br/>
 * @created 9.2.12 13:36
 */
@Stateful
@SessionScoped
public class UserDataProducer implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(UserDataProducer.class);

    @PersistenceContext private EntityManager em;

    private List<Order> usersOrders;

    public void readUsersData(@Observes LoginEvent e) {
        log.debug("UserDataProducer.readUsersData");
        usersOrders = em.createQuery("select o from Order o join fetch o.items where o.assignee = :u", Order.class)
                .setParameter("u", e.getUser())
                .getResultList();
        usersOrders = new ArrayList<Order>(new LinkedHashSet<Order>(usersOrders));
    }

    @Produces @SessionScoped @Named
    public List<Order> getUsersOrders() {
        return usersOrders;
    }
}
