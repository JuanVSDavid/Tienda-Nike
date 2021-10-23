package com.tiendanike.web.controller;

import java.util.ArrayList;
import java.util.List;

import com.tiendanike.web.models.ventas;
import com.tiendanike.web.service.CustomClientService;
import com.tiendanike.web.service.CustomSaleService;
import com.tiendanike.web.service.CustomUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/reportes")
public class reportesController {

    @Autowired
    @Qualifier("usuarioService")
    private CustomUserService CUS;

    @Autowired
    @Qualifier("clientesService")
    private CustomClientService CCS;

    @Autowired
    @Qualifier("ventaService")
    private CustomSaleService sale;

    private static Double d = (double) 0;
    private static List<ventas> ve = new ArrayList<ventas>();

    @GetMapping
    public ModelAndView reportes(Model model){
        d = (double) 0;
        model.addAttribute("activePage", "reportes");
        ModelAndView mav = new ModelAndView("reportes");
        ve = sale.listOfSale();
        mav.addObject("usuarios", CUS.listOfUsuarios());
        mav.addObject("clientes", CCS.listOfClients());
        mav.addObject("ventas", ve);
        for (ventas e : ve) {
            d += e.getValor_venta();
        }
        model.addAttribute("total", d);
        return mav;
    }
}
