package com.housing.javaee6demo.ejb;

import javax.ejb.Stateful;

/**
 * @author Matija Mazi <br/>
 * @created 8.2.12 18:07
 */
@Stateful
public class StatefulCounter {
    private int count = 0;

    public int next() {
        return ++count;
    }
}
