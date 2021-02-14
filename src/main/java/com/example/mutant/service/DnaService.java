package com.example.mutant.service;

import com.example.mutant.Model.Dna;
import com.example.mutant.Model.Stats;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;

@Service
public class DnaService {

    public ResponseEntity<?> isMutant(Dna dna){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public Stats getStats() {
        return new Stats(40, 100);
    }
}
