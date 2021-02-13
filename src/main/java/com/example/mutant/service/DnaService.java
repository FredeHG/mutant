package com.example.mutant.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DnaService {

    public ResponseEntity<?> isMutant(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> getStats() {
        return new ResponseEntity<>("{\n" +
                "    \"ADN\": {\n" +
                "        \"count_mutant_dna\": 40,\n" +
                "        \"count_human_dna\": 100,\n" +
                "        \"ratio\": 0.4\n" +
                "    }\n" +
                "}", HttpStatus.OK);
    }
}
