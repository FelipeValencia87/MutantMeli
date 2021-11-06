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
    
    private static boolean checkDNA(String[][] adn){
        
        int mutant =0, cadenaD=1, cadena=1;
        String aux=" ";
        
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
            
            
//            Buscar diagonales derecha
            for (int j = 0; j < adn.length; j++) {
                if (i < adn.length-1 && j< adn[i].length-1 && adn[i][j].equals(adn[i+1][j+1])) {
                    cadenaD++;
                    if (cadenaD == 4) {
                        mutant++;
                        if (mutant == 2) return true;
                    }
                }
            }
//              Diagonal inversa
//            for (int j = 0; j < adn.length; j++) {
//                if ((i+j) == adn.length-1 && j> 0 && adn[i][j].equals(adn[i+1][j-1])) {
//                    
//                    System.out.println("i: " + i +" " + "j: " + j +" ");
//                    System.out.println("Entra a la diago ");
//                }
//                
//            }
            
            
        }
        return false;
    }
}
