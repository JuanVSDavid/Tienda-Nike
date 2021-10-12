package com.tiendanike.web.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import com.tiendanike.web.service.CustomProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/productos")
public class productosController {

    @Autowired
    @Qualifier("productosService")
    private CustomProductService CPS;

    @GetMapping
    public String productos(Model model) {
        model.addAttribute("activePage", "productos");
        return "productos";
    }

    @RequestMapping(value = "/upload")
    public String uploadProductos(@RequestParam("file") MultipartFile file, HttpSession session)
            throws FileNotFoundException, IOException {
        if (CPS.extension(file) != null) {
            if (CPS.uploadProductos(file) != null) {
                if (CPS.uploadProductos(file).isEmpty()) {
                    session.setAttribute("message", "Todos los productos se agregaron");
                    return "redirect:/productos";
                } else {
                    String list = CPS.uploadProductos(file);
                    String errores = "En estos productos hubieron errores: " + list;
                    session.setAttribute("alert", errores);
                    return "redirect:/productos";
                }
            }
            session.setAttribute("alert", "El archivo que subio esta vacio.");
            return "redirect:/productos";
        }
        session.setAttribute("alert", "El archivo que subio no es .csv");
        return "redirect:/productos";
    }
}
