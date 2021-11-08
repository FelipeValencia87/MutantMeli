# Prueba Mercadolibre - MutantMeli

## Lenguaje y Tecnologías
La prueba se realizó bajo el Lenguaje Java, utilizando las tecnologías SpringBoot y hoosteada en AWS, la clase publica para ejecutar el programa se encuentra en com.meli.demo > DemoApplication
```
* Java 16.0.1
* Maven
```
## Consumo API

Consumo IsMutant Controlador

```
POST /mutant/
```
La API recibe una petición POST con un JSON como parametro en el Body.

Este objeto es convertido y validado por el sistema de acuerdo a los diferentes requerimientos, devolviendo las dos posibles respuestas solicitadas

### Afirmativa
    Envío: 
    {
     "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
    }
    
    Respuesta:
    Status: 200 Ok

    Headers:
    Content-Type: application/json

    Body: 
    {
        "message": "Is Mutant"
    }
  
 ### Negativa
    Envío: 
    {
     "dna":["STGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
    }
    
    Respuesta:
    Status: 403 Forbidden

    Headers:
    Content-Type: application/json

    Body: 
    {
        "message": "Isn't Mutant"
    }
