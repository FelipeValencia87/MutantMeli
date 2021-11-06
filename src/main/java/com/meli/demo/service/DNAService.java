package com.meli.demo.service;

public class DNAService {
    
    public static boolean isMutant(String[] dna){
        int n = dna.length, m =  dna[0].length();
        
        String letras;
        String[][] adn = new String[n][m];        
        String[] aux ;
        
        for (int i = 0; i < n; i++) {
            letras = dna[i];//Se extrae el string en cada una de las posiciones
            aux = letras.split("");//Se separan las letras del string y se ingresan a un array 
            for (int j = 0; j < aux.length; j++) { //Ingresando cada una de las letras en la posición
               adn[i][j]= aux[j];                
            }            
            
        }       
        
        return checkDNA(adn); 
    }
    
    static boolean checkDNA(String[][] adn){
        int mutant =0, cadenaR=1, cadenaC=1;
        //Buscar cadena por filas
        for (int i = 0; i < adn.length; i++) {
            for (int j = 0; j < adn[i].length-1; j++) {
                if (adn[i][j].equals(adn[i][j+1]) ) {
                    cadenaR++;
                    if (cadenaR == 4) {
                        mutant++;
                    }
                }else{
                    cadenaR=1;
                }
                
            }
            
            cadenaR=1;
            
            if (mutant >= 2) {
                System.out.println("Es Mutante");
                return true;
            }
        }
        
        //Buscar cadena por Columnas
        for (int j = 0; j < adn.length; j++) {
            for (int i = 0; i < adn[i].length-1; i++) {
                if (adn[i][j].equals(adn[i+1][j]) ) {
                    cadenaC++;
                    if (cadenaC == 4) {
                        mutant++;
                    }
                }else{
                    cadenaC=1;
                }                   
                
            }
            
            cadenaC=1;
            
            if (mutant >= 2) {
                System.out.println("Es Mutante");
                return true;
            }
            
           
        }
        
        //Imprimir matriz
        for (int i = 0; i < adn.length; i++) {
            for (int j = 0; j < adn[i].length; j++) {
                System.out.print(adn[i][j] + " ");                
            }
            System.out.println("");
        }
        return false;
    }
}
