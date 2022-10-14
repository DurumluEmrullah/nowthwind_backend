package com.edurumluemrullah.northwind_backend.common.controller;

import com.edurumluemrullah.northwind_backend.common.exceptions.UserNotFoundException;
import com.edurumluemrullah.northwind_backend.common.services.abstracts.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
public class BaseController<T> {


    private final BaseService baseService;

    public BaseController(BaseService baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0",name = "page") int page ,@RequestParam(defaultValue = "10",name = "size") int size){
       return ResponseEntity.ok(baseService.getAll(page,size));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam("id") int id){
        return ResponseEntity.ok(baseService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody T entity){
        return ResponseEntity.ok(baseService.create(entity));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@Valid @RequestBody T entity){
        return ResponseEntity.ok(baseService.update(entity));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam(value = "id") int id){
        return ResponseEntity.ok(baseService.delete(id));
    }

}
