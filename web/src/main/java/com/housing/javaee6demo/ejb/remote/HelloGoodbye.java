package com.housing.javaee6demo.ejb.remote;

/**
 * @author Matija Mazi <br/>
 * @created 9.2.12 7:30
 */
public interface HelloGoodbye extends Hello {
    String getWho();

    String sayGoodbye();
}
