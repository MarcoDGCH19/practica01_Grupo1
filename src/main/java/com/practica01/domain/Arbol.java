package com.practica01.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="arbol")
public class Arbol implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbol")
    private Long idArbol;
    
    private String nombre;
    private int dureza;
    private String tipo;
    private String rutaImagen;
    private boolean extinto;

    public Arbol() {
    }

    public Arbol(String nombre, boolean extinto) {
        this.nombre = nombre;
        this.extinto = extinto;
    }
  
}