package com.housing.javaee6demo.ejb;

import javax.ejb.Stateless;

/**
 * @author Matija Mazi <br/>
 * @created 8.2.12 18:07
 */
@Stateless
public class StatelessCounterX {
    private int count = 0;

    public int next() {
        return ++count;
    }
}
