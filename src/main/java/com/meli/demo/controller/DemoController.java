package com.meli.demo.controller;

import com.meli.demo.bean.*;
import com.meli.demo.service.DNAService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {


    @PostMapping("/mutant/")
    public ResponseEntity<MutantMessage> isMutant(@RequestBody DNARequest dna){
        MutantMessage message = new MutantMessage("Isn't Mutant");
        boolean isMutant =DNAService.isMutant(dna.getDna());
        
        if (isMutant) {
            message.setMessage("Is Mutant");
            return new ResponseEntity<>(message,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(message,HttpStatus.FORBIDDEN);
		
    }
}
