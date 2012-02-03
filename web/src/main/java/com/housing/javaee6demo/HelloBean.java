package com.housing.javaee6demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.text.MessageFormat;

/**
 * @author Matija Mazi <br/>
 * @created 2.2.12 17:47
 */
@Named
@SessionScoped
public class HelloBean implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(HelloBean.class);

    @NotNull @Size(min = 1, max = 31)
    private String name;

    private Integer age;
    private String greeting;
    private boolean gospod;
    private String[] letters;

    public void sayHello() {
        log.debug("HelloBean.sayHello");
        greeting = MessageFormat.format("Hello, {0}!", name);
        gospod = name.startsWith("g.");
        letters = name.split("");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGreeting() {
        return greeting;
    }

    public boolean isGospod() {
        return gospod;
    }

    public String[] getLetters() {
        return letters;
    }
}
