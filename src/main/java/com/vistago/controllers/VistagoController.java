package com.vistago.controllers;


import com.vistago.dtos.ExampleVistagoTableDto;
import com.vistago.entities.ExampleVistagoTable;
import com.vistago.services.ExampleVistagoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class VistagoController {
    @Autowired
    private ExampleVistagoTableService exampleVistagoTableService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<ExampleVistagoTable> list(){
        return exampleVistagoTableService.findAll();
    }


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ExampleVistagoTable add(@RequestBody ExampleVistagoTableDto exampleVistagoTableDto){
        return exampleVistagoTableService.save(exampleVistagoTableDto);
    }

}
