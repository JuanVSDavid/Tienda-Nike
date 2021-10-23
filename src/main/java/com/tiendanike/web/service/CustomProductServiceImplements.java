package com.tiendanike.web.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tiendanike.web.models.productos;
import com.tiendanike.web.repository.productosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("productosService")
public class CustomProductServiceImplements implements CustomProductService {

    @Autowired
    @Qualifier("productosRepository")
    private productosRepository pr;

    @Autowired
    @Qualifier("proveedoresService")
    private CustomSupplierServiceImplements sr;
    @Override
    public String extension(MultipartFile file) throws IOException {
        File files = new File(file.getOriginalFilename());
        String nameFile = files.getName();
        String ext = "";
        int i = nameFile.lastIndexOf('.');
        if (i > 0) {
            ext = nameFile.substring(i + 1);
        }
        if (ext.equals("csv")) {
            return "CSV";
        }
        return null;
    }

    private File FileConverter(MultipartFile file) throws IOException {
        File File = new File(file.getOriginalFilename());
        FileOutputStream fileOut = new FileOutputStream(File);
        fileOut.write(file.getBytes());
        fileOut.close();
        return File;
    }
    @Override
    public String uploadProductos(MultipartFile file) throws FileNotFoundException, IOException {
        String productosNoAgregados = "";
        ArrayList<productos> listProductos = new ArrayList<productos>();
        if (!file.isEmpty()) {
            File productosFile = FileConverter(file);
            BufferedReader reader = new BufferedReader(new FileReader(productosFile.getName()));
            String line;
            Boolean emptyLine = false;
            do {
                line = reader.readLine();
                if (line != null) {
                    String tmpLine = line.replace("\"", "'");
                    ArrayList<String> splitList = new ArrayList<String>(Arrays.asList(tmpLine.split(";")));
                    if (splitList.size() <= 6) {
                        try {
                            if (sr.searchSupplier(Long.parseLong(splitList.get(2))) != null) {
                                productos product = new productos();
                                product.setProduct_id(Long.parseLong(splitList.get(0)));
                                product.setProduct_name(splitList.get(1).replace("'", ""));
                                product.setProveedores(sr.searchSupplier(Long.parseLong(splitList.get(2))));
                                product.setProduct_price(Double.parseDouble(splitList.get(3)));
                                product.setProduct_sale_iva(Double.parseDouble(splitList.get(4)));
                                product.setProduct_sale_price(Double.parseDouble(splitList.get(5)));
                                listProductos.add(product);
                            } else {
                                // Por si el proveedor no existe
                                productosNoAgregados += "El producto " + "\"" + splitList.get(1) + "\"" + " con el id: "
                                        + "\"" + splitList.get(0) + "\"" + " su proveedor" + "(" + splitList.get(2)
                                        + ")" + " no existe; ";
                            }
                        } catch (Exception e) {
                            try {
                                // Por si el id o algun valor numerico es un String
                                productosNoAgregados += "El producto " + "\"" + splitList.get(1) + "\"" + " con el id: "
                                        + "\"" + splitList.get(0) + "\"" + " tiene errores en sus datos; ";
                            } catch (Exception ex) {
                                // Tiene lineas vacias
                                emptyLine = true;
                            }
                        }
                    } else {
                        // Es por si la cadena es mayor a 6 es decir que la linea que se evaluo tiene
                        // mas de 6 propiedades
                        productosNoAgregados += "El producto " + "\"" + splitList.get(1) + "\"" + " con el id: " + "\""
                                + splitList.get(0) + "\"" + " tiene más de 6 propiedades; ";
                    }
                }
            } while (line != null);
            if(!listProductos.isEmpty()){
                pr.deleteAll();
                pr.saveAll(listProductos);
            }
            reader.close();
            if(emptyLine) {
                return "El archivo tiene lineas vacias o esta vacio; " + productosNoAgregados;
            }
            return productosNoAgregados;
        }
        return null;
    }

    @Override
    public List<productos> listProduct() {
        return pr.findAll();
    }

    @Override
    public productos searchProduct(Long product_id) {
        return pr.getById(product_id);
    }
}
