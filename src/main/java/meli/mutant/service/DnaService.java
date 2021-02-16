package meli.mutant.service;

import meli.mutant.Model.Dna;
import meli.mutant.Model.Stats;
import meli.mutant.repository.DnaRepository;
import meli.mutant.util.DnaAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DnaService {

    @Autowired
    DnaRepository dnaRepository;

    public boolean isMutant(Dna dna){
        dna.evaluateDna();
        dnaRepository.save(dna);
        return dna.isMutant();
    }

    public Stats getStats() {
        Long mutants = dnaRepository.countByMutant(true);
        Long total = dnaRepository.count();
        return new Stats(mutants, total);
    }

}
