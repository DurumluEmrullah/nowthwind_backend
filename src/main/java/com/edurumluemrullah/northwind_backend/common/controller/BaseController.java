package com.edurumluemrullah.northwind_backend.common.controller;

import com.edurumluemrullah.northwind_backend.common.services.abstracts.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public class BaseController<T> {


    private final BaseService baseService;

    public BaseController(BaseService baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(baseService.getAll());
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam("id") int id){
        return ResponseEntity.ok(baseService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody T entity){
        return ResponseEntity.ok(baseService.create(entity));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody T entity){
        return ResponseEntity.ok(baseService.update(entity));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") int id){
        return ResponseEntity.ok(baseService.delete(id));
    }

}
