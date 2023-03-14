package com.myproperty.propertymanagement.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.myproperty.propertymanagement.dto.PropertyDTO;
import com.myproperty.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Autowired
    PropertyService propertyService;
    //RESTful API is just mapping of a url to a java class/function.
    @GetMapping("/hello")
    public String sayhello(){
        return "Hello";
    }

    @Value("${pms.dummy:}")
    private String dummy;

    @Value("${spring.datasource.url:}")
    private String dbUrl;

    @PostMapping("/save")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO prop){
        System.out.println(prop);
        propertyService.saveProperty(prop);
        return new ResponseEntity<>(prop, HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
        System.out.println(dbUrl);
        List<PropertyDTO> prop = propertyService.getAllProperties();
        return new ResponseEntity<>(prop,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<PropertyDTO> updatePropertyDto(@RequestBody PropertyDTO propertyDTO, @PathVariable Long id){
        PropertyDTO savedDto = propertyService.updatePropertyDto(propertyDTO,id);
        return new ResponseEntity<>(savedDto,HttpStatus.OK);
    }

    @PatchMapping("/update/description/{id}")
    public ResponseEntity<PropertyDTO> updateDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long id){
        PropertyDTO savedDTO = propertyService.updateDescription(propertyDTO,id);
        return new ResponseEntity<>(savedDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        propertyService.delete(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
