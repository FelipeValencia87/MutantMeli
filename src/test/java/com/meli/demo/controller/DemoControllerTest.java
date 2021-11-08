package com.meli.demo.controller;

import com.meli.demo.bean.DNARequest;
import com.meli.demo.bean.MutantMessage;
import com.meli.demo.service.DNAService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class DemoControllerTest {


    @Test
    void isMutant() {
        DNARequest dna = new DNARequest();
        dna.setDna(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});

        boolean isMutant= DNAService.isMutant(dna.getDna());

        Assertions.assertTrue(isMutant);
    }

}