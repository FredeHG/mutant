package com.example.mutant.controller;

import com.example.mutant.Model.Dna;
import com.example.mutant.Model.Stats;
import com.example.mutant.service.DnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutantController {

    @Autowired
    private DnaService dnaService;

    @RequestMapping(value = "/mutant", method = RequestMethod.POST)
    public ResponseEntity<?> isMutant(@RequestBody Dna dna){
        return dnaService.isMutant(dna);
    }

    @RequestMapping(value = "/stats", method = RequestMethod.GET)
    public Stats getStats(){
        return dnaService.getStats();
    }

}
