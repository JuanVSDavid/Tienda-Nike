package com.tiendanike.web.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface CustomProductService {
    abstract public String extension(MultipartFile file) throws IOException;
    abstract public String uploadProductos(MultipartFile file) throws FileNotFoundException, IOException;
    
}