package com.example.demoSimpleCRUD;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogoService {
    @Autowired
    CatalogoRepository cr;
    
    public ArrayList<Catalogo> getCatalogos(){
        return (ArrayList<Catalogo>) cr.findAll(); 
    }
    
    public Catalogo saveCatalogo(Catalogo c) {
        return cr.save(c);
    }
}
