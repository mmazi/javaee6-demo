package com.housing.javaee6demo.ejb.cdi;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * @author Matija Mazi <br/>
 * @created 9.1.12 17:58
 */
public class EmProducer implements Serializable {
    @PersistenceContext
    @Produces
    private EntityManager entityManager;
}
