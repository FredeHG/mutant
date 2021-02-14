package com.example.mutant.Model;

public class Dna {

    private String [] dna;
    private boolean mutant;

    public Dna(){}

    public String[] getDna(){
        return dna;
    }

    public void setDna(String [] dna) {
        this.dna = dna;
    }

    public boolean isMutant() {
        return mutant;
    }

    public void setMutant(boolean mutant) {
        this.mutant = mutant;
    }
}
