package com.housing.javaee6demo.ejb.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Matija Mazi <br/>
 * @created 9.2.12 17:58
 */
@Named
@Stateless
public class SlowBean {
    private static final Logger log = LoggerFactory.getLogger(SlowBean.class);

    public void doLengthyOperation() {
        log.debug("SlowBean.doLengthyOperation....");

        Calendar nextOutput = Calendar.getInstance();
        for (int i = 0; i < 10;) {
            if (new Date().after(nextOutput.getTime())) {
                nextOutput.add(Calendar.SECOND, 1);
                log.debug("i = {}", ++i);
            }
        }
        log.debug("Done.");
    }
}
