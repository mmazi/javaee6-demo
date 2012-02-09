package com.housing.javaee6demo.ejb.cdi;

import com.housing.javaee6demo.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 * @author Matija Mazi <br/>
 * @created 3.2.12 15:15
 */
@RequestScoped
@Named
public class ProductConverter implements Converter {
    private static final Logger log = LoggerFactory.getLogger(ProductConverter.class);

    @Inject private EntityManager em;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String productId) {
        return em.find(Product.class, Long.parseLong(productId));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return Long.toString(((Product)o).getId());
    }
}
