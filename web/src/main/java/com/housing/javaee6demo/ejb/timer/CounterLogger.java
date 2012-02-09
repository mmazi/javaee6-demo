package com.housing.javaee6demo.ejb.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author Matija Mazi <br/>
 * @created 9.2.12 8:36
 */
@Startup @Singleton
public class CounterLogger {
    private static final Logger log = LoggerFactory.getLogger(CounterLogger.class);

    @EJB
    private SingletonCounter counter;

//    @Schedule(hour = "*", minute = "*", second = "*/10", persistent = false)
    public void logCount() {
        log.debug("count = {}", counter.getCount());
    }
}
