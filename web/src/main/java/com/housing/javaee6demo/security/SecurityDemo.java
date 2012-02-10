package com.housing.javaee6demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateful;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @author Matija Mazi <br/>
 * @created 10.2.12 17:26
 */
@Named
@Stateful
public class SecurityDemo implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(SecurityDemo.class);

    public Object getPrincipal() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return request.getUserPrincipal();
    }

    @PermitAll
    public void forAllUsers() {
        log.debug("SecurityDemo.forAllUsers");
    }

    @RolesAllowed("admin")
    public void adminOnly() {
        log.debug("SecurityDemo.adminOnly");
    }

    @DenyAll
    public void nobody() {
        log.debug("SecurityDemo.nobody");
    }
}
