package com.meli.mutant.controller;

import com.meli.mutant.bean.*;
import com.meli.mutant.service.DNAService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MutantController {


    @PostMapping("/mutant/")
    public ResponseEntity<MutantMessage> isMutant(@RequestBody DNARequest dna){// Se recibe la información del objeto
        MutantMessage message = new MutantMessage();
        message.getMessage("Isn't Mutant");

        /*
        * Se extrae la información alojada en el objeto para devolverla como String,
        * el metodo realiza las comprobaciones pertinentes y devuelve el valor boolean correspondiente
        */
        boolean isMutant =DNAService.isMutant(dna.getDna());
        
        if (isMutant) {
            message.setMessage("Is Mutant");
            return new ResponseEntity<>(message,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(message,HttpStatus.FORBIDDEN);
		
    }
}
