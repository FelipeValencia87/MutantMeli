package com.meli.mutant.controller;

import com.meli.mutant.bean.DNARequest;
import com.meli.mutant.bean.MutantMessage;
import com.meli.mutant.service.DNAService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MutantControllerTest {


    @Test
    void isMutant() {
        MutantMessage message = new MutantMessage();
        message.getMessage("Isn't Mutant");

        DNARequest dna = new DNARequest();
        dna.setDna(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});

        boolean mutant= DNAService.isMutant(dna.getDna());

        if (mutant) message.setMessage("Is Mutant");

        Assertions.assertTrue(mutant);
    }

}