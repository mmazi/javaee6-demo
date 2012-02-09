package com.housing.javaee6demo.ejb.timer;

import javax.ejb.Singleton;
import javax.inject.Named;

/**
 * @author Matija Mazi <br/>
 * @created 8.2.12 18:07
 */
@Singleton
@Named
public class SingletonCounter {
    private int count = 0;

    public int next() {
        return ++count;
    }

    public int getCount() {
        return count;
    }
}
