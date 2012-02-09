package com.housing.javaee6demo.client;

import com.housing.javaee6demo.ejb.remote.Hello;
import com.housing.javaee6demo.ejb.remote.HelloGoodbye;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author Matija Mazi <br/>
 */
public class EjbRemoteClient {
    public static void main(String[] args) throws Exception {
        invokeStateless("Luka");
        invokeStateful("Janez");
        HelloGoodbye hg = invokeStateful("Rajko");
        try {
            hg.getWho();
        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }
        invokeStateful("Milan");
    }

    private static void invokeStateless(String who) throws NamingException {
        Hello hello = InitialContext.doLookup("ejb:/javaee6-demo//HelloBean!com.housing.javaee6demo.ejb.remote.Hello");
        System.out.println("Got " + hello);
        System.out.println(hello.sayHello(who));
    }

    private static HelloGoodbye invokeStateful(String who) throws NamingException {
        HelloGoodbye helloGoodbye = InitialContext.doLookup("ejb:/javaee6-demo//HelloGoodbyeBean!com.housing.javaee6demo.ejb.remote.HelloGoodbye?stateful");
        System.out.println("Got " + helloGoodbye);
        System.out.println(helloGoodbye.getWho());
        System.out.println(helloGoodbye.sayHello(who));
        System.out.println(helloGoodbye.sayGoodbye());
        return helloGoodbye;
    }
}
