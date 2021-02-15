package meli.mutant.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("ADN")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class Stats {

    private Long countMutantDna;
    private Long countHumanDna;

    public Stats(Long countMutantDna, Long countHumanDna) {
        this.countMutantDna = countMutantDna;
        this.countHumanDna = countHumanDna;
    }

    @JsonProperty("count_mutant_dna")
    public Long getCountMutantDna() {
        return countMutantDna;
    }

    @JsonProperty("count_human_dna")
    public Long getCountHumanDna() {
        return countHumanDna;
    }

    @JsonProperty("ratio")
    public Double getRatio() {
        return (double) countMutantDna / (double) countHumanDna;
    }

}