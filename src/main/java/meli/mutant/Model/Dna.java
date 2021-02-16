package meli.mutant.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import meli.mutant.exception.InvalidDnaException;
import meli.mutant.util.DnaAnalyzer;
import org.springframework.data.annotation.Id;


public class Dna {

    @Id
    @ApiModelProperty(value = "The dna to analyze", dataType = "String[]", example = "[ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG]",required = true)
    private String dna;

    @JsonIgnore
    private boolean mutant;

    public Dna(){}

    public String[] getDna(){
        int rows = (int) Math.sqrt(this.dna.length());
        return dna.split(String.format("(?<=\\G.{%d})", rows));
    }

    public void setDna(String [] dna) {
        this.dna = String.join("", dna);
    }

    public void evaluateDna() throws InvalidDnaException {
        setMutant(new DnaAnalyzer().isMutant(getDna()));
    }

    public boolean isMutant() {
        return mutant;
    }

    public void setMutant(boolean mutant) {
        this.mutant = mutant;
    }
}
