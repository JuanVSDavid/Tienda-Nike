package com.tiendanike.web.WebSecurity;

import com.tiendanike.web.models.usuarios;
import com.tiendanike.web.repository.usuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    @Qualifier("usuariosRepository")
    usuariosRepository ur;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final usuarios user = ur.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Username " + username + " not found");
        }
        return new CustomUserDetails(user);
    }
    
}
