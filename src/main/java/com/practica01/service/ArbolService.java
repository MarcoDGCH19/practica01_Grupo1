
package com.practica01.service;

import com.practica01.domain.Arbol;
import java.util.List;


public interface ArbolService {
 
    public List<Arbol> getArbols(boolean activo);

    //Se obtiene una arbol segun el id pasado por parámetro
    public Arbol getArbol(Arbol arbol);

    //Se actualiza una arbol o se inserta un nueva.. (Si no hay id es un insert)
    public void save(Arbol arbol);

    //Se elimina una arbol segun el id pasado
    public void delete(Arbol arbol);
}
