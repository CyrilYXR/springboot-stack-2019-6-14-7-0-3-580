package com.tw.apistackbase.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by jxzhong on 18/08/2017.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    Map<Integer, Employee> employeeMap = new HashMap<>();

    @GetMapping()
    public ResponseEntity getAll(){
        employeeMap.put(1, new Employee(1, "zhangsan", 18, "male"));
        return ResponseEntity.ok().body(employeeMap.values());
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody Employee employee){
        employeeMap.put(employee.getId(), employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody Employee employee){
        employeeMap.put(id, employee);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id){
        employeeMap.remove(id);
        return ResponseEntity.ok().build();
    }


}
