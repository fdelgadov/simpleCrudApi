package com.example.demoSimpleCRUD;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path = "catalogo")
public class CatalogoController {
    @Autowired
    CatalogoService cs;
    
    @GetMapping
    public ArrayList<Catalogo> getCatalogos() {
        return cs.getCatalogos();
    }
    
    @PostMapping
    public Catalogo saveCatalogo(@RequestBody Catalogo c) {
        return cs.saveCatalogo(c);
    }
    
    @PostMapping(path = "{id}")
    public Catalogo updateCatalogo(@PathVariable("id") Long id, @RequestBody Catalogo c) {
        c.setID(id);
        return cs.saveCatalogo(c);
    }
        
    @DeleteMapping(path = "{id}")
    public boolean deleteCatalogo(@PathVariable("id") Long id) {
        return cs.deleteCatalogo(id);
    }
}
