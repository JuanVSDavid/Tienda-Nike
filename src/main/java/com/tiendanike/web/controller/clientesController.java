package com.tiendanike.web.controller;

import javax.servlet.http.HttpSession;

import com.tiendanike.web.models.clientes;
import com.tiendanike.web.service.CustomClientServiceImplements;

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
@RequestMapping
public class clientesController {
    
    @Autowired
    @Qualifier("clientesService")
    private CustomClientServiceImplements CCSI;

    @GetMapping("/clientes")
    public ModelAndView listOfClient(Model model){
        model.addAttribute("activePage", "clientes");
        ModelAndView mav = new ModelAndView("clientes");
        mav.addObject("client", CCSI.listOfClients());
        return mav;
    }

    @PostMapping("/addClient")
    public String addClient(@ModelAttribute clientes client, HttpSession session){
        if(CCSI.addCliente(client) != null){
            session.setAttribute("message", "El cliente se agrego correctamente.");
            return "redirect:/clientes";
        }
        session.setAttribute("alert", "El cliente ya existe.");
        return "redirect:/clientes";
    }

    @PostMapping("/updateClient")
    public String updateClient(@ModelAttribute clientes client, HttpSession session){
        if(CCSI.updateClient(client) != null){
            session.setAttribute("message", "El cliente se modifico correctamente.");
            return "redirect:/clientes";
        }
        session.setAttribute("alert", "El cliente no existe.");
        return "redirect:/clientes";
    }

    @GetMapping("/deleteClient/{client_cedula}")
    public String deleteClient(@PathVariable long client_cedula){
        CCSI.deleteClient(client_cedula);
        return "redirect:/clientes";
    }
}
