package com.tienda.service;


import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {
    
    public String cargaImagen(
        MultipartFile archivoLocalCliente,
        String carpeta,
        Long id
    );
    
    final String BucketName="techshop-1092e.appspot.com";
    final String rutaSuperiorStorage="techshop";
    final String rutaJsonFile="firebase";
    final String archivoJsonFile="techshop-1092e-firebase-adminsdk-midie-c0df2b7ab0.json";
}
