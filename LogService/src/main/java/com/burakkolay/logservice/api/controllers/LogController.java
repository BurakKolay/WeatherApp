package com.burakkolay.logservice.api.controllers;

import com.burakkolay.logservice.business.abstracts.LogService;
import com.burakkolay.logservice.entities.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/log")
public class LogController {
    private final LogService service;

    @GetMapping
    public ResponseEntity<List<Log>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Log> getById(@PathVariable String id){
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable String id){
        service.deleteById(id);
        return ResponseEntity.ok().body("Deleted");
    }

}
