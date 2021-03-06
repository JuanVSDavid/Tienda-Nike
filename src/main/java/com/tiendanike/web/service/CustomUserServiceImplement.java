package com.tiendanike.web.service;

import java.util.List;

import com.tiendanike.web.models.usuarios;
import com.tiendanike.web.repository.usuariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("usuarioService")
public class CustomUserServiceImplement implements CustomUserService{

    @Autowired
    @Qualifier("usuariosRepository")
    public usuariosRepository ur;

    @Override
    public List<usuarios> listOfUsuarios() {
        return ur.findAll();
    }

    @Override
    public usuarios addUser(usuarios user) {
        if(!ur.existsById(user.getUser_cedula())){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            return ur.save(user);
        }
        return null;
    }

    @Override
    public usuarios updateUser(usuarios user) {
        if(ur.existsById(user.getUser_cedula())){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            return ur.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(long user_cedula) {
        ur.deleteById(user_cedula);
    }

    @Override
    public usuarios getUserByUsername(String username) {
        return ur.findByUsername(username);
    }

}
