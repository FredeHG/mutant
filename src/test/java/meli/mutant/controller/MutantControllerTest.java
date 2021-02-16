package meli.mutant.controller;


import meli.mutant.Model.Dna;
import meli.mutant.Model.Stats;
import meli.mutant.service.DnaService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MutantControllerTest {

    @Mock
    DnaService dnaService;
    @InjectMocks
    MutantController mutantController = new MutantController();

    Dna dna;

    @BeforeAll
    public void init(){
        MockitoAnnotations.initMocks(this);
        dna = new Dna();
    }

    @Test
    public void test_is_mutant(){
        dna.setMutant(true);
        Mockito.when(dnaService.isMutant(dna)).thenReturn(true);
        ResponseEntity<?> response = mutantController.isMutant(dna);
        assertEquals(new ResponseEntity<>(HttpStatus.OK), response);
    }

    @Test
    public void test_is_not_mutant(){
        dna.setMutant(false);
        ResponseEntity<?> response = mutantController.isMutant(dna);
        assertEquals(new ResponseEntity<>(HttpStatus.FORBIDDEN), response);
    }

    @Test
    public void test_stats(){
        Mockito.when(mutantController.getStats()).thenReturn(new Stats(20L, 100L));
        assertEquals(0.2, mutantController.getStats().getRatio());
    }
}
