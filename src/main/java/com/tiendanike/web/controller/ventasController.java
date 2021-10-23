package com.tiendanike.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.tiendanike.web.models.clientes;
import com.tiendanike.web.models.detalle_venta;
import com.tiendanike.web.models.productos;
import com.tiendanike.web.models.usuarios;
import com.tiendanike.web.service.CustomClientService;
import com.tiendanike.web.service.CustomProductService;
import com.tiendanike.web.service.CustomSaleDetailsService;
import com.tiendanike.web.service.CustomSaleService;
import com.tiendanike.web.service.CustomUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ventas")
public class ventasController {
    @Autowired
    @Qualifier("ventaService")
    private CustomSaleService CSS;

    @Autowired
    @Qualifier("detalle_ventaService")
    private CustomSaleDetailsService CSDS;

    @Autowired
    @Qualifier("productosService")
    private CustomProductService CPS;

    @Autowired
    @Qualifier("clientesService")
    private CustomClientService clienteService;

    @Autowired
    @Qualifier("detalle_ventaService")
    private CustomSaleDetailsService detailService;

    @Autowired
    @Qualifier("usuarioService")
    private CustomUserService CUS;

    private static Long x;
    private static detalle_venta i;
    Long code;
    //Usuarios entidad
    usuarios usuario = new usuarios();
    //Buscar el cliente
    private static clientes cliente = new clientes();
    //La lista con todos los prductos
    private static List<detalle_venta> ventasde = new ArrayList<detalle_venta>();
    //Esto es el numeor de la factura
    //Variables de ventas
    private static Double iva_venta = (double) 0;
    private static Double total_venta = (double) 0;
    private static Double valor_venta = (double) 0;
    private static Long client_cedula;
    private static List<Long> id_productos = new ArrayList<Long>();

    //Obtener Usuario del contexto
    public void getUser_id(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if(principal instanceof UserDetails){
            userDetails = (UserDetails) principal;
        }
        usuario = CUS.getUserByUsername(userDetails.getUsername());
    }


    public void showClient(Model model){
        try {
            if(cliente.getClient_name() != null){
                model.addAttribute("client_name", cliente.getClient_name());
            }else{
                model.addAttribute("client_name", null);
            }
        } catch (Exception e) {
        }
    }

    @GetMapping
    public ModelAndView ventas(Model model, RedirectAttributes ra){
        ModelAndView map = new ModelAndView("ventas");
        model.addAttribute("activePage", "ventas");
        if(CSS.countSale() == null || CSS.countSale() == 0) {
            code = (long) 1;
        }else{
            code = CSS.countSale() + 1;
        }
        map.addObject("sale_code", code);
        map.addObject("productos", CPS.listProduct());
        map.addObject("clientes", clienteService.listOfClients());
        map.addObject("listventas", ventasde);
        map.addObject("iva_venta", iva_venta);
        map.addObject("total_venta", total_venta);
        map.addObject("valor_venta", valor_venta);
        getUser_id();
        if(cliente != null){
            showClient(model);
        }
        return map;        
    }

    @PostMapping("/uploadProduct")
    public String uploadSale(HttpSession session, @RequestParam("product_id") String product_id, @RequestParam("cantidad_producto") Integer cantidad_producto, RedirectAttributes ra){
        if(cantidad_producto < 1  || cantidad_producto == null ){
            session.setAttribute("alert", "La cantidad del producto no puede ser cero, o menor que uno");
            return "redirect:/ventas";
        }
        detalle_venta producto = new detalle_venta();
        productos p = CPS.searchProduct(Long.parseLong(product_id));
        if(id_productos.indexOf(p.getProduct_id()) != -1){
            session.setAttribute("alert", "El producto con el codigo " + p.getProduct_id() + " ya esta agregado");
            return "redirect:/ventas";
        }        
        producto.setProductos(p);
        producto.setCantidad_producto(cantidad_producto);
        producto.setValor_iva(cantidad_producto * (p.getProduct_price()*(p.getProduct_sale_iva()/100)));
        producto.setValor_venta(p.getProduct_sale_price()* cantidad_producto);
        producto.setValor_total(p.getProduct_price()* cantidad_producto);
        iva_venta += producto.getValor_iva();
        total_venta += producto.getValor_total();
        valor_venta += producto.getValor_venta();
        id_productos.add(p.getProduct_id());
        ventasde.add(producto);
        ra.addFlashAttribute("iva_venta", iva_venta);
        ra.addFlashAttribute("total_venta", total_venta);
        ra.addFlashAttribute("valor_venta", valor_venta);
        return "redirect:/ventas";
    }

    public void minusSale(RedirectAttributes ra){
        iva_venta = (double) 0;
        total_venta = (double) 0;
        valor_venta = (double) 0;
        for (detalle_venta e  : ventasde) {
            iva_venta += e.getValor_iva();
            total_venta += e.getValor_total();
            valor_venta += e.getValor_venta();
        }
        ra.addFlashAttribute("iva_venta", iva_venta);
        ra.addFlashAttribute("total_venta", total_venta);
        ra.addFlashAttribute("valor_venta", valor_venta);
    }

    @RequestMapping("/saveClient")
    public String saveClient(@RequestParam("client_cedula") String client_id){
        client_cedula = Long.parseLong(client_id);
        cliente = clienteService.findbyId(Long.parseLong(client_id));
        System.out.println(cliente);
        return "redirect:/ventas";
    }

    @GetMapping("/undo")
    public String undo(Model model){
        ventasde.clear();
        id_productos.clear();
        iva_venta = (double) 0;
        total_venta = (double) 0;
        valor_venta = (double) 0;
        Long client_cedula = null;
        cliente.setClient_name(null);
        return "redirect:/ventas";
    }

    @GetMapping("/delete")
    public String delete(RedirectAttributes ra, HttpSession session){
        if(ventasde.size() != 0){i = ventasde.get(ventasde.size() - 1);
        ventasde.remove(i);
        minusSale(ra);
        x = id_productos.get(id_productos.size() - 1);
        id_productos.remove(x);
        return "redirect:/ventas";}
        session.setAttribute("alert", "No hay productos por eliminar");
        return "redirect:/ventas";
    }


    @PostMapping("/saveSale")
    public String saveSaleAndSaleDetails(HttpSession session){
        if(cliente.getClient_name() == null && ventasde.isEmpty()){
            session.setAttribute("alert", "No hay productos, ni clientes en la venta.");
            return "redirect:/ventas";
        }
        if(ventasde.isEmpty()){
            session.setAttribute("alert", "No hay productos en la venta.");
            return "redirect:/ventas";
        }
        if(cliente.getClient_name() == null){
            session.setAttribute("alert", "No hay un cliente seleccionado.");
            return "redirect:/ventas";
        }
        getUser_id();
        com.tiendanike.web.models.ventas v = new com.tiendanike.web.models.ventas();
        v.setIva_venta(iva_venta);
        v.setTotal_venta(total_venta);
        v.setValor_venta(valor_venta);
        v.setUsuarios(usuario);
        v.setClientes(clienteService.findbyId(client_cedula));
        CSS.saveSale(v);
        for (detalle_venta e  : ventasde) {
            e.setVentas(v);
            detailService.saveSaleDetails(e);
        }
        ventasde.clear();
        id_productos.clear();
        iva_venta = (double) 0;
        total_venta = (double) 0;
        valor_venta = (double) 0;
        Long client_cedula;
        cliente = new clientes();
        session.setAttribute("message", "Se guardo correctamente la venta");
        return "redirect:/ventas";
    }

}