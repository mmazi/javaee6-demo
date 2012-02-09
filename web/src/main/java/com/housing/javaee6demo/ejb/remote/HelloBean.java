package com.housing.javaee6demo.ejb.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * @author Matija Mazi <br/>
 */
@Stateless
@Remote(Hello.class)
public class HelloBean implements Hello {
    private static final Logger log = LoggerFactory.getLogger(HelloBean.class);

    @Override
    public String sayHello(String who) {
        log.debug("who = {}", who);
        return "Hello, " + who + "!";
    }
}
