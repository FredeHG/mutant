package com.example.mutant.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutantController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> isMutant(){
        return new ResponseEntity<String>("Hola Mundo!",HttpStatus.OK);
    }

}
