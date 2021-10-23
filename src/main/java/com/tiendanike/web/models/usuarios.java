package com.tiendanike.web.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class usuarios {

    @Id
    private Long user_cedula;
    
    @Column(unique = true)
    private String username;

    private String password;
    private String user_email;
    private String user_name;
    private String roles;

    @OneToMany(mappedBy = "usuarios", fetch = FetchType.LAZY)
    private List<ventas> ventas;

    public usuarios() {
    }

    public usuarios(Long user_cedula, String username, String password, String user_email, String user_name,
            String roles, List<com.tiendanike.web.models.ventas> ventas) {
        this.user_cedula = user_cedula;
        this.username = username;
        this.password = password;
        this.user_email = user_email;
        this.user_name = user_name;
        this.roles = roles;
        this.ventas = ventas;
    }

    public Long getUser_cedula() {
        return user_cedula;
    }

    public void setUser_cedula(Long user_cedula) {
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

    public List<ventas> getVentas() {
        return ventas;
    }

    public void setVentas(List<ventas> ventas) {
        this.ventas = ventas;
    }

}
