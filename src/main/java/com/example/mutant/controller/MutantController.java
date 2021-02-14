package com.example.mutant.controller;

import com.example.mutant.service.DnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutantController {

    @Autowired
    private DnaService dnaService;


    @RequestMapping(value = "/mutant", method = RequestMethod.POST)
    public ResponseEntity<?> isMutant(){
        return dnaService.isMutant();
    }

    @RequestMapping(value = "/stats", method = RequestMethod.GET)
    public ResponseEntity<?> getStats(){
        return dnaService.getStats();
    }

}
