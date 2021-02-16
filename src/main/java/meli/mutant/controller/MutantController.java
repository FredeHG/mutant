package meli.mutant.controller;

import meli.mutant.Model.Dna;
import meli.mutant.Model.Stats;
import meli.mutant.exception.InvalidDnaException;
import meli.mutant.service.DnaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@EnableMongoRepositories(basePackages={"meli.mutant.repository"})
@Api(tags = {"Dna Analyzer"})
public class MutantController {

    @Autowired
    private DnaService dnaService;

    @ApiOperation(value = "Send dna and know if it is a mutant", notes = "200 mean it's a mutant!",tags = "Dna Analyzer")
    @ApiResponses({
            @ApiResponse(code = 200, response = Object.class, message = "It's mutant"),
            @ApiResponse(code = 403, message = "Not a mutant")
    })
    @RequestMapping(value = "/api/v1/mutant", method = RequestMethod.POST)
    public ResponseEntity<?> isMutant(@RequestBody Dna dna){
        return dnaService.isMutant(dna);
    }

    @ApiOperation(value = "Get Stats of examiner", tags = "Dna Analyzer")
    @RequestMapping(value = "/api/v1/stats", method = RequestMethod.GET)
    public Stats getStats(){
        return dnaService.getStats();
    }

    @ExceptionHandler({ InvalidDnaException.class })
    public ResponseEntity<?> handleInvalidDNAException(InvalidDnaException e) {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", e.getMessage());
        response.put("status", HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
