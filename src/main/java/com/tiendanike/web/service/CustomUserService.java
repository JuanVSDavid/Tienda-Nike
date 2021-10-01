package com.tiendanike.web.service;

import java.util.List;

import com.tiendanike.web.models.usuarios;

public interface CustomUserService {
    
    public abstract List<usuarios> listOfUsuarios();

    public abstract usuarios addUser(usuarios user);

    public abstract usuarios updateUser(usuarios user);

    public abstract String deleteUser(long user_cedula);
}
