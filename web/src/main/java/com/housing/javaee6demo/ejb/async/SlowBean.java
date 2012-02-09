package com.housing.javaee6demo.ejb.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Future;

/**
 * @author Matija Mazi <br/>
 * @created 9.2.12 17:58
 */
@Stateless
public class SlowBean {
    private static final Logger log = LoggerFactory.getLogger(SlowBean.class);

    @Resource
    private SessionContext sessionContext;

    @Asynchronous
    public Future<String> doLengthyOperation() {
        log.debug("SlowBean.doLengthyOperation....");

        Calendar nextOutput = Calendar.getInstance();
        for (int i = 0; i < 10;) {
            if (new Date().after(nextOutput.getTime())) {
                if (sessionContext.wasCancelCalled()) {
                    log.debug("Cancelled.");
                    return new AsyncResult<String>("Cancelled.");
                }
                nextOutput.add(Calendar.SECOND, 1);
                log.debug("i = {}", ++i);
            }
        }
        log.debug("Done.");
        return new AsyncResult<String>("Ok.");
    }
}
