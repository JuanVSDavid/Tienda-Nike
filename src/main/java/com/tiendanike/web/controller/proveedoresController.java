package com.tiendanike.web.controller;

import javax.servlet.http.HttpSession;

import com.tiendanike.web.models.proveedores;
import com.tiendanike.web.service.CustomSupplierService;

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
public class proveedoresController {

    @Autowired
    @Qualifier("proveedoresService")
    private CustomSupplierService CSSI;

    @GetMapping("/proveedores")
    public ModelAndView listOfSuppliers(Model model) throws Exception {
        model.addAttribute("activePage", "proveedores");
        ModelAndView mav = new ModelAndView("proveedores");
        mav.addObject("supplier", CSSI.listOfSupplier());
        return mav;
    }

    @PostMapping("/addSupplier")
    public String addSupplier(@ModelAttribute proveedores supplier, HttpSession session){
        if(CSSI.addSupplier(supplier) != null){
            session.setAttribute("message", "El proveedor se agrego correctamente.");
            return "redirect:/proveedores";
        }
        session.setAttribute("alert", "El proveedor ya existe.");
        return "redirect:/proveedores";
    }

    @PostMapping("/updateSupplier")
    public String updateSupplier(@ModelAttribute proveedores supplier, HttpSession session){
        if(CSSI.updateSupplier(supplier) != null){
            session.setAttribute("message", "El proveedor se modifico correctamente.");
            return "redirect:/proveedores";
        }
        session.setAttribute("alert", "El proveedor no existe.");
        return "redirect:/proveedores";
    }
    
    @GetMapping("/deleteSupplier/{supplier_nit}")
    public String deleteSupplier(@PathVariable long supplier_nit, HttpSession session){
        CSSI.deleteSupplier(supplier_nit);
        return "redirect:/proveedores";
    }
}
