package com.tiendanike.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/ventas")
public class ventasController {

    @GetMapping
    public String ventas(){
        return "ventas";
    }
    
}
