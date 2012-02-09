package com.housing.javaee6demo.ejb.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Matija Mazi <br/>
 * @created 9.2.12 17:58
 */
@Named("sbc")
@Stateful
@SessionScoped
public class SlowBeanCaller implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(SlowBeanCaller.class);

    @EJB private SlowBean slowBean;

    private Future<String> future;

    public void callLengthyOperation() {
        future = slowBean.doLengthyOperation();
    }

    public boolean cancel() {
        return future.cancel(true);
    }

    public boolean isDone() {
        return future.isDone();
    }

    public String getResult() throws InterruptedException, ExecutionException {
        return future.get();
    }

    public boolean isStarted() {
        return future != null;
    }
}
