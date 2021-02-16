package meli.mutant.util;

import meli.mutant.Model.Dna;
import meli.mutant.exception.InvalidDnaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DnaAnalyzerTest {

    private DnaAnalyzer dnaAnalyzer = new DnaAnalyzer();

    @Test
    public void test_is_mutant(){
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        assertTrue(dnaAnalyzer.isMutant(dna));
    }

    @Test
    public void test_is_not_mutant(){
        String[] dna = {"GGGGCC","ATATAT","GCGCGC","ATATAT","GCGCGC","ATATAT"};
        assertFalse(dnaAnalyzer.isMutant(dna));
    }

    @Test
    public void test_is_not_valide_dna(){
        String[] dna = {"ATGCGA","TTATGT","CCCCTA","TCACTG","AGAAGG","CAGTGC", "AAAAAA"};
        assertThrows(InvalidDnaException.class, ()->{
            dnaAnalyzer.isMutant(dna);
        });
    }

    @Test
    public void test_with_two_sequences_in_the_same_line(){
        String[] dna = {"AAAACCCC", "TCACTGTG", "CAGTGCGT", "TCACTGCA", "TTATGTGT", "ATGCGATG", "ATGCGACG", "TTATGTGC"};
        assertTrue(dnaAnalyzer.isMutant(dna));
    }
}
