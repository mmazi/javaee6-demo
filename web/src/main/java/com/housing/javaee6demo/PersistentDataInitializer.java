package com.housing.javaee6demo;

import com.housing.javaee6demo.model.Order;
import com.housing.javaee6demo.model.Product;
import com.housing.javaee6demo.model.Role;
import com.housing.javaee6demo.model.Unit;
import com.housing.javaee6demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;

/**
 * @author Matija Mazi <br/>
 * @created 5.2.12 13:49
 */
@Startup @Singleton
public class PersistentDataInitializer {
    private static final Logger log = LoggerFactory.getLogger(PersistentDataInitializer.class);

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void initData() {
        User mm = new User("mm", "a", "Matija", Arrays.asList(Role.admin, Role.orderer));
        Order order = new Order(mm);

        Unit no = new Unit("št.", "");
        Unit kg = new Unit("kg", "Kilogram");

        Product glasses = new Product("Očala", no, null);
        Product ladder = new Product("Lestev", no, null);
        Product flour = new Product("Moka", kg, null);

        order.addItem(glasses, 2.);
        order.addItem(flour, 1.3);
        order.addItem(ladder, 3.);

        em.persist(mm);
        em.persist(no);
        em.persist(kg);
        em.persist(glasses);
        em.persist(flour);
        em.persist(ladder);
        em.persist(order);

        em.flush();

        log.debug("Done initializing, now querying...");

        Unit unitKgFind = em.find(Unit.class, "kg");
        log.debug("kg unit (find): {}", unitKgFind);
        Unit unitKgQuery = em.createQuery("select u from Unit u where u.id = :uid", Unit.class).setParameter("uid", "kg").getSingleResult();
        log.debug("kg unit (query): {}", unitKgQuery);

        log.debug("Enakost kg: {}, {}", unitKgFind == unitKgQuery, kg == unitKgFind);

        Product moka = em.createQuery("select p from Product p where p.name = :fname", Product.class)
                .setParameter("fname", "Moka")
                .getSingleResult();
        log.debug("Moka: {}", moka);

        log.debug("Enakost kg pri moki: {}", kg == moka.getUnit());

        Number totalItems = em.createQuery(
                "select sum(i.quantity) " +
                        "from Order o join o.items i join i.product p " +
                        "where p.unit.id = :nounitid and o.creator.username = :cun", Number.class)
                .setParameter("nounitid", "št.")
                .setParameter("cun", "mm")
                .getSingleResult();

        log.debug("totalItems = {}", totalItems);

    }

}
