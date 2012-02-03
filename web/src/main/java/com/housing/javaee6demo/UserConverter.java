package com.housing.javaee6demo;

import com.housing.javaee6demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * @author Matija Mazi <br/>
 * @created 3.2.12 15:15
 */
@FacesConverter(forClass = User.class)
public class UserConverter implements Converter {
    private static final Logger log = LoggerFactory.getLogger(UserConverter.class);

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        log.debug("UserConverter.getAsObject: {}", s);
        return DataHolder.getUser(s);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        log.debug("UserConverter.getAsString: {}", o);
        return ((User)o).getUsername();
    }
}
