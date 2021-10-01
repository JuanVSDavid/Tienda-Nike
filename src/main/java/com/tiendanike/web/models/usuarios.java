package com.tiendanike.web.models;

import javax.persistence.*;

@Entity
public class usuarios {

    @Id
    private Long user_cedula;

    private String username;
    private String password;
    private String user_email;
    private String user_name;
    private String roles;

    public long getUser_cedula() {
        return user_cedula;
    }
    public void setUser_cedula(long user_cedula) {
        this.user_cedula = user_cedula;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUser_email() {
        return user_email;
    }
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getRoles() {
        return roles;
    }
    public void setRoles(String roles) {
        this.roles = roles;
    }
    
    @Override
    public String toString() {
        return "usuarios [password=" + password + ", roles=" + roles + ", user_cedula=" + user_cedula + ", user_email="
                + user_email + ", user_name=" + user_name + ", username=" + username + "]";
    }
    
}
