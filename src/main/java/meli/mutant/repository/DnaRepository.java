package meli.mutant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import meli.mutant.Model.Dna;

@Repository
public interface DnaRepository extends MongoRepository<Dna, String> {

    public Long countByMutant(boolean isMutant);

}