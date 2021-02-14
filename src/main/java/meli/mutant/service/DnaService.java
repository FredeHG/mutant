package meli.mutant.service;

import meli.mutant.Model.Dna;
import meli.mutant.Model.Stats;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DnaService {

    public ResponseEntity<?> isMutant(Dna dna){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public Stats getStats() {
        return new Stats(40, 100);
    }
}
