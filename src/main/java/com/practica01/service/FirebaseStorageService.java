package com.practica01.service;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    
    final String BucketName = "practica01-57304.appspot.com";

    
    final String rutaSuperiorStorage = "practica01";

    
    final String rutaJsonFile = "firebase";

    
    final String archivoJsonFile = "practica01-57304-firebase-adminsdk-v0se4-b68b7575b4.Json";
}
