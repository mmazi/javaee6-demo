package com.housing.javaee6demo.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Matija Mazi <br/>
 * @created 9.1.12 17:22
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id @Size(max = 40)
    private String username;

    @Size(max = 127)
    private String name;

    private Date created;

    @Version
    private Date updated;

    @Size(max = 63)
    private String password;

    @Size(max = 127)
    private String email;

    @ElementCollection
    @Enumerated(value = EnumType.STRING)
    private Set<Role> roles = new HashSet<Role>();

    protected User() { }

    public User(String username) {
        this.username = username;
        created = new Date();
    }

    public User(String username, String password, String name, Collection<Role> roles) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.roles = new HashSet<Role>(roles);
    }

    public String getId() {
        return getUsername();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /** Do not use this for adding/removing roles; use addRole/removeRole instead. */
    public Set<Role> getRoles() {
        return roles;
    }

    protected void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /** @return true iff this user didn't already have the role (ie. the role was actually added). */
    public boolean addRole(Role role) {
        return roles.add(role);
    }

    /** @return true iff this user had the role (ie. the role was actually removed). */
    public boolean removeRole(Role role) {
        return roles.remove(role);
    }

    public boolean hasRole(Role role) {
        return roles.contains(role);
    }

    @Override
    public String toString() {
        return MessageFormat.format("User[{0} ({1})]", username, name);
    }
}
