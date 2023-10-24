package com.practica01.controller;

import com.practica01.domain.Arbol;
import com.practica01.service.ArbolService;
import com.practica01.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/arbol")
public class ArbolController {
    
    @Autowired
    private ArbolService arbolService;
    
    @GetMapping("/listado")
    public String listado(Model model){
       
        var arbols = arbolService.getArbols(false);
        model.addAttribute("arbols", arbols);
        model.addAttribute("totalArbols",arbols.size());
        
        return "/arbol/listado";
    }
    
    @GetMapping("/eliminar/{idArbol}")
    public String eliminar(Arbol arbol){
        arbolService.delete(arbol);
        return "redirect:/arbol/listado";
    }
    
    @GetMapping("/modificar/{idArbol}")
    public String modificar(Arbol arbol, Model model){
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/modifica";
    }
    
    @Autowired
    private FirebaseStorageService firebaseStorageSercive;
   
    @PostMapping("/guardar")
    public String guardar(Arbol arbol, @RequestParam("imagenFile") MultipartFile imagenFile){
        
        if(!imagenFile.isEmpty()){
            arbolService.save(arbol);
            String ruta = firebaseStorageSercive.cargaImagen(imagenFile, "arbol", arbol.getIdArbol());
            
            arbol.setRutaImagen(ruta);
        }
        arbolService.save(arbol);
        return "redirect:/arbol/listado";
    }
    
}
