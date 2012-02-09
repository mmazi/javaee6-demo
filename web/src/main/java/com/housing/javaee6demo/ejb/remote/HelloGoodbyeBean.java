package com.housing.javaee6demo.ejb.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * @author Matija Mazi <br/>
 */
@Stateful
@Remote(HelloGoodbye.class)
public class HelloGoodbyeBean implements HelloGoodbye {
    private static final Logger log = LoggerFactory.getLogger(HelloGoodbyeBean.class);
    private String who = "nobody";

    @Override
    public String sayHello(String who) {
        this.who = who;
        log.debug("who = {}", this.who);
        return "Hello, " + who + "!";
    }

    @Override
    public String getWho() {
        return who;
    }

    @Override
    @Remove
    public String sayGoodbye() {
        log.debug("HelloGoodbyeBean.sayGoodbye: {}", who);
        return "Goodbye, " + who + "!";
    }
}