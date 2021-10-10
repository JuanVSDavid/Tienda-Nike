package com.tiendanike.web.controller;

import javax.servlet.http.HttpSession;

import com.tiendanike.web.models.usuarios;
import com.tiendanike.web.service.CustomUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class usuarioController {

    @Autowired
    @Qualifier("usuarioService")
    private CustomUserService CUS;

    @GetMapping("/usuarios")
    public ModelAndView tablaUsuarios(Model model, HttpSession session){
        // session.setAttribute("displayUsuario", CUD.getUsername());
        model.addAttribute("activePage", "usuarios");
        ModelAndView mav = new ModelAndView("usuarios");
        mav.addObject("user", CUS.listOfUsuarios());
        return mav;
    }
    
    @PostMapping("/addUser")
    public String addUsers(@ModelAttribute usuarios userRegister, HttpSession session){
        if(CUS.addUser(userRegister) != null){
            session.setAttribute("message", "Usuario se agregó correctamente.");
            return "redirect:/admin/usuarios";
        }
        session.setAttribute("alert", "El Usuario ya existe.");
        return "redirect:/admin/usuarios";
    }

    @PostMapping("/updateUser")
    public String updateUser(HttpSession session, @ModelAttribute usuarios userRegister){
        if(CUS.updateUser(userRegister) != null){
            session.setAttribute("message", "Se actualizo correctamente el usuario");
            return "redirect:/admin/usuarios";
        }
        session.setAttribute("alert", "El Usuario no existe.");
        return "redirect:/admin/usuarios";
    }

    @GetMapping("/deleteUser/{user_cedula}")
    public String deleteUser(@PathVariable long user_cedula){
        CUS.deleteUser(user_cedula);
        return "redirect:/admin/usuarios";
    } 
}
