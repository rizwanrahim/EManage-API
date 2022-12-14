package com.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AppController<TEntity, T extends AppService> {
    protected final T service;

    @Autowired
    public AppController(T service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TEntity>> GetAll() {
        return new ResponseEntity(service.GetAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<TEntity> Save(@RequestBody TEntity e) {
        var result = service.Save(e);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public  ResponseEntity<TEntity> Find(@PathVariable("id") Long Id) {
        var result = service.Find(Id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> Delete(@PathVariable("id") Long Id) {
        service.Delete(Id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
