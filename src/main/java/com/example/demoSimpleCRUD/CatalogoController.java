package com.example.demoSimpleCRUD;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Catalogo> saveCatalogo(@RequestBody Catalogo c) {
        Catalogo temp = cs.saveCatalogo(c);
        
        try {
            return ResponseEntity.created(new URI("/catalogo/" + temp.getID())).body(temp);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
