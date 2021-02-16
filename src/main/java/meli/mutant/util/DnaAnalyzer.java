package meli.mutant.util;

import meli.mutant.exception.InvalidDnaException;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DnaAnalyzer {

    private final String SEQUENCE_REPEAT_REGEX      = "([A,T,C,G])\\1\\1\\1";
    private final int SEQUENCE_LEN                  = 4;
    private final int POSITIVE                      = 2;
    private int sequences;

    public boolean isMutant(String[] dna){
        validateDna(dna);
        return analyzeRows(dna) || analyzeColumns(dna) || analyzeRightObliques(dna) || analyzeLeftObliques(dna);
    }

    private boolean analyzeLeftObliques(String[] dna) {
        int len = dna.length - 1;
        for (int row = len; row >= SEQUENCE_LEN - 1 ; row--){
            int initial = (row == len)? (dna.length - (SEQUENCE_LEN - 1)) : 1;
            for (int i = 0; i < initial; i++){
                StringBuilder sequence = new StringBuilder();
                for (int column = (row - i); column >= 0 ; column--){
                    sequence.append(dna[row - column].charAt(column + i));
                    if (evaluateSequence(sequence.toString()))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean analyzeRightObliques(String[] dna) {
        for (int row = 0; (dna.length - row) >= SEQUENCE_LEN; row++){
            int initial = (row == 0)? (dna.length - (SEQUENCE_LEN - 1)) : 1;
            for (int i = 0; i < initial; i++){
                StringBuilder sequence = new StringBuilder();
                for (int column = 0; column < (dna.length - row - i); column++){
                    sequence.append(dna[row + column].charAt(column + i));
                    if (evaluateSequence(sequence.toString()))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean analyzeColumns(String[] dna) {
        for (int row = 0; row < dna.length; row++){
            StringBuilder sequence = new StringBuilder();
            for (String s : dna) {
                sequence.append(s.charAt(row));
                if(evaluateSequence(sequence.toString()))
                    return true;
            }
        }
        return false;
    }

    private boolean analyzeRows(String[] dna){
        for (String sequence:dna)
            if (evaluateSequence(sequence))
                return true;
        return false;
    }

    private boolean evaluateSequence(String str){
        Pattern pattern = Pattern.compile(SEQUENCE_REPEAT_REGEX);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find())
            sequences++;
        return sequences >= POSITIVE;
    }

    private void validateDna(String[] dna) {
        String VALIDATE_LETTERS_REGEX = String.format("\\b[A,T,C,G]{%d}\\b", dna.length);
        for (String sequence: dna ) {
            if (!sequence.matches(VALIDATE_LETTERS_REGEX))
                throw new InvalidDnaException("El DNA contiene letras invalidas o la longitud no es NxN");
        }
    }
}
