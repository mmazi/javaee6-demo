package com.housing.javaee6demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ResourceBundle;

/**
 * @author Matija Mazi <br/>
 * @created 2.2.12 17:47
 */
@Named
@SessionScoped
public class MessagesAction implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(MessagesAction.class);

    private ResourceBundle messages;

    public MessagesAction() {
        messages = ResourceBundle.getBundle("com.housing.javaee6demo.myMessages", FacesContext.getCurrentInstance().getExternalContext().getRequestLocale());
    }

    public void doSomething() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(messages.getString("msg.buttonClicked")));
    }
}
