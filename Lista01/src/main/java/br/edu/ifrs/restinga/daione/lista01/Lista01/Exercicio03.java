/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.daione.lista01.Lista01;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercicio03 {
    
    @RequestMapping("/adicao/{num01}/{num02}")
    public String adicao(@PathVariable double num01, @PathVariable double num02){
        
    return "O resultado é "+ (num01+num02); 
    
    }
    @RequestMapping("/subtracao/{num01}/{num02}")
    public String subtracao(@PathVariable double num01, @PathVariable double num02){
        return "O resultado é " + (num01-num02); 
    }
    
    @RequestMapping("/divisao/{num01}/{num02}")
    public String divisao(@PathVariable double num01, @PathVariable double num02){
        return "O resultado é "+ (num01/num02); 
    }
    @RequestMapping("/multiplicacao/{num01}/{num02}")
    public String multiplicacao(@PathVariable double num01, @PathVariable double num02){
        return "O resultado é "+ (num01*num02); 
    }
}
