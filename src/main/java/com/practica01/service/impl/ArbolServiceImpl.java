package com.practica01.service.impl;

import com.practica01.dao.ArbolDao;
import com.practica01.domain.Arbol;
import com.practica01.service.ArbolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


    
    @Service
public class ArbolServiceImpl
        implements ArbolService {
    
    @Autowired
    private ArbolDao arbolDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Arbol> getArbols(boolean activo) {
        var arbols = arbolDao.findAll();

      
        if (activo) {
            arbols.removeIf(e -> !e.isExtinto());
        }
        
        return arbols;
    }

    @Transactional(readOnly = true)
    public Arbol getArbol(Arbol arbol) {
        return arbolDao.findById(arbol.getIdArbol()).orElse(null);
    }

    
    public void save(Arbol arbol) {
        arbolDao.save(arbol);
    }

   
    public void delete(Arbol arbol) {
        arbolDao.delete(arbol);
    }
    
}
