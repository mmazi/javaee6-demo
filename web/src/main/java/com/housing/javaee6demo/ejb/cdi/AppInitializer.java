package com.housing.javaee6demo.ejb.cdi;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author Matija Mazi <br/>
 * @created 9.2.12 13:52
 */
@Startup @Singleton
@DependsOn("PersistentDataInitializer")
public class AppInitializer {
    @EJB private GlobalDataProducer globalDataProducer;

    @PostConstruct
    public void init() {
        globalDataProducer.readAll();
    }
}
