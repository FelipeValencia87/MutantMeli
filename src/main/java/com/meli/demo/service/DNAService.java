package com.meli.demo.service;

public class DNAService {
    
    public static boolean isMutant(String[] dna){
        int n = dna.length;
        String letters;
        String[][] adn = new String[n][n];        
        String[] aux;
        
        for (int i = 0; i < n; i++) {
            if (dna[i].length() != n ) { //Se valida que las posiciones tengan el mismo número de caracteres
               return false;
            }
            letters = dna[i];//Se extrae el string en cada una de las posiciones
            letters=letters.toUpperCase();
            aux = letters.split("");//Se separan las letras del string y se ingresan a un array 
            
            for (int j = 0; j < aux.length; j++) {// Validando si las letras contenidas son las aceptadas
                if (aux[j].equals("A") || 
                    aux[j].equals("T") ||
                    aux[j].equals("G") ||
                    aux[j].equals("C")) {
                    
                }else{
                    return false;
                }
                
            }
            for (int j = 0; j < aux.length; j++) { //Ingresando cada una de las letras en la posición
               adn[i][j]= aux[j];                
            }            
            
        }       
        
        return checkDNA(adn); 
    }
    
    
    public static boolean checkDNA(String[][] adn){
        int mutant =0, cadenaD=1, cadenaDI=1,cadena=1;
        
        for (int i = 0; i < adn.length; i++) {
            //Buscar cadena por filas
            for (int j = 0; j < adn[i].length-1; j++) {
                if (adn[i][j].equals(adn[i][j+1]) ) {
                    cadena++;
                    if (cadena == 4) {
                        mutant++;
                        if (mutant == 2) return true;
                    }
                }else{
                    cadena=1;
                }
            } 
            cadena=1;  
            
            //Buscar cadena por Columnas
            for (int j = 0; j < adn[j].length-1; j++) {
                if (adn[j][i].equals(adn[j+1][i]) ) {
                    cadena++;
                    if (cadena == 4) {
                        mutant++;
                        if (mutant == 2) return true;
                    }
                }else{
                    cadena=1;
                }                  
            }
            cadena=1;
            
            
//            Buscar por diagonales
            for (int j = 0; j < adn.length; j++) {
                if (i < adn.length-1 && j < adn[i].length-1 && adn[i][j].equals(adn[i+1][j+1])) {
                    cadenaD++;
                    if (cadenaD == 4) {
                        mutant++;
                        if (mutant == 2) return true;
                    }
                }else{
                    cadenaD=1;
                }
            }
            //Bscar por Diagonales inversas
            for (int j = 0; j < adn.length; j++) {
                if (i < adn.length-1 && j > 0 && adn[i][j].equals(adn[i+1][j-1])) {
                    cadenaDI++;
                    if (cadenaDI == 4) {
                        mutant++;
                        if (mutant == 2) return true;
                    }
                }else{
                    cadenaDI=1;
                }
                
            }
            
        }
        return false;
    }
}
