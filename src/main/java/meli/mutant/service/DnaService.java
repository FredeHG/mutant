package meli.mutant.service;

import meli.mutant.Model.Dna;
import meli.mutant.Model.Stats;
import meli.mutant.repository.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DnaService {

    @Autowired
    DnaRepository dnaRepository;

    public ResponseEntity<?> isMutant(Dna dna){
        dna.setMutant(true);
        dnaRepository.save(dna);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public Stats getStats() {
        Long mutants = dnaRepository.countByMutant(true);
        Long total = dnaRepository.count();
        return new Stats(mutants, total);
    }
}
