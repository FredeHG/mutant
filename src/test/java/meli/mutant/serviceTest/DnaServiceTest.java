package meli.mutant.serviceTest;

import meli.mutant.Model.Dna;
import meli.mutant.Model.Stats;
import meli.mutant.exception.InvalidDnaException;
import meli.mutant.repository.DnaRepository;
import meli.mutant.service.DnaService;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DnaServiceTest {

    @Mock private DnaRepository dnaRepository;
    @InjectMocks
    DnaService dnaService = new DnaService();

    String[] mutantDna          = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
    String[] notMutantDna       = {"GGGGCC","ATATAT","GCGCGC","ATATAT","GCGCGC","ATATAT"};
    String[] invalidDnaLen      = {"ATGCGA","TTATGT","CCCCTA","TCACTG","AGAAGG","CAGTGC", "AAAAAA"};
    String[] invalidDnaLetter   = {"Z"};

    Dna dna;

    @BeforeAll
    public void init() {
        MockitoAnnotations.initMocks(this);
        dna = new Dna();
    }

    @Test
    public void test_is_mutant() {
        dna.setDna(mutantDna);
        dna.evaluateDna();
        assertTrue(dna.isMutant());
    }

    @Test
    public void test_is_not_mutant() {
        dna.setDna(notMutantDna);
        dna.evaluateDna();
        assertFalse(dna.isMutant());
    }

    @Test
    public void test_save_fails_with_invalid_dna_letter() {
        dna.setDna(invalidDnaLetter);
        assertThrows(InvalidDnaException.class, () ->{
            dna.evaluateDna();
        });
    }

    @Test
    public void test_save_fails_with_invalid_dna_length() {
        dna.setDna(invalidDnaLen);
        assertThrows(InvalidDnaException.class, () ->{
            dna.evaluateDna();
        });
    }

    @Test
    public void test_stats_mutants_count() {
        mockDnaRepository();
        Stats stats = dnaService.getStats();
        assertEquals(50L, stats.getCountMutantDna());
    }

    @Test
    public void test_stats_human_count() {
        mockDnaRepository();
        Stats stats = dnaService.getStats();
        assertEquals(100L, stats.getCountHumanDna());
    }

    @Test
    public void test_stats_ratio() {
        mockDnaRepository();
        Stats stats = dnaService.getStats();
        assertEquals(0.5, stats.getRatio());
    }

    private void mockDnaRepository() {
        Mockito.when(dnaRepository.count()).thenReturn(100L);
        Mockito.when(dnaRepository.countByMutant(true)).thenReturn(50L);
    }

}