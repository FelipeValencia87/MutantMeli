package com.meli.mutant.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class DNAServiceTest {
    @Autowired

    @Test
    void isMutant() {
        String[] dna ={"aTGCGa","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        boolean check = DNAService.isMutant(dna);
        Assertions.assertTrue(check);
    }

    @Test
    void checkDNA(){
       String[][] dna = {{"A","T","G","C","G","A"},
                        {"C","A","G","T","G","C"},
                        {"T","T","A","T","G","T"},
                        {"A","G","A","A","G","G"},
                        {"C","C","C","C","T","A"},
                        {"T","C","A","C","T","G"}};

       boolean check = DNAService.checkDNA(dna);
       Assertions.assertTrue(check);

    }
}