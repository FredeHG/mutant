package meli.mutant.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

public class Dna {

    @ApiModelProperty(value = "The dna to analyze", dataType = "List", example = "[ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG]",required = true)
    private String [] dna;

    @JsonIgnore
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
