package com.housing.javaee6demo.ws;

import com.housing.javaee6demo.model.Order;
import com.housing.javaee6demo.model.OrderItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateful;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * @author Matija Mazi <br/>
 * @created 11.2.12 12:30
 */
@WebService
@Stateful
public class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    @PersistenceContext private EntityManager em;

    public List<Order> getOrders() {
        CriteriaQuery<Order> query = em.getCriteriaBuilder().createQuery(Order.class);
        query.from(Order.class);
        return em.createQuery(query).getResultList();
    }

    public List<OrderItem> getItems(String orderId) {
        return em.createQuery("select i from OrderItem i where i.order.id = :oid", OrderItem.class)
                .setParameter("oid", orderId)
                .getResultList();
    }

    public boolean exists(Order o) {
        log.debug("o = {}", o);
        return em.createQuery("select count(o) from Order o where o.id = :oid", Number.class)
                .setParameter("oid", o.getId())
                .getSingleResult().intValue() > 0;
    }
}
