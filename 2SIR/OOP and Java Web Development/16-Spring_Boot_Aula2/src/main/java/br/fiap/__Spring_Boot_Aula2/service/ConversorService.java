package br.fiap.__Spring_Boot_Aula2.service;

import org.springframework.stereotype.Service;

@Service
public class ConversorService {
     public double converteFahrenheit(double temperatura){
         return temperatura * 9 / 5 + 32;
     }

}
