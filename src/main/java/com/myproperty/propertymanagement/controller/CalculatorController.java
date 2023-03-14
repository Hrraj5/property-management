package com.myproperty.propertymanagement.controller;

import com.myproperty.propertymanagement.dto.CalculatorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {
    @GetMapping("/add")
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2){
        return num1+num2;
    }

    @GetMapping("/sub/{num1}/{num2}")//Map the values of url to java variable by Path Variable method.
    public Double sub(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2){
        Double result =  null;
        result = Math.abs(num1-num2);
        return result;
    }

    @PostMapping("/mul")
    public ResponseEntity<Double> mul(@RequestBody CalculatorDto caldto){
        Double result = caldto.getNum1() * caldto.getNum2();
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

}
