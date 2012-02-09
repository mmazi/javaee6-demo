package com.housing.javaee6demo.ejb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author Matija Mazi <br/>
 * @created 8.2.12 18:07
 */
@Startup @Singleton
public class CounterClient1 {
    private static final Logger log = LoggerFactory.getLogger(CounterClient1.class);

    @EJB private StatelessCounterX statelessCounter;
    @EJB private StatefulCounter statefulCounter;

    @PostConstruct
    public void count() {
        log.debug("Counting.... ");
        for (int i = 1; i <= 100; i++) {
            for (int i1 = 1; i1 <= 100; i1++) {
                statefulCounter.next();
            }
            for (int i1 = 1; i1 <= 100; i1++) {
                statelessCounter.next();
            }
        }
        log.debug("Final stateful value: {}", statefulCounter.next());
        log.debug("Final stateless value: {}", statelessCounter.next());
    }

}
