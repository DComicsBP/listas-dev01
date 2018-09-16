package br.edu.ifrs.restinga.daione.lista01.Lista01;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercicio01 {
    
    @RequestMapping("/teste/")
    public String index(){
        return "Hello Wold";
        
    }
    
    @RequestMapping("/imc/{peso}/{altura}")
    public String calculaIMC(@PathVariable double peso, @PathVariable double altura){
       double imc = peso/Math.pow(altura, 2); 
        
       if( imc < 18.5) return "Você está muito magro, seu IMC é de "+ (int) Math.floor(imc);
       if( imc> 18.5 && imc < 24.9) return "Você está muito bem, seu IMC é de "+ (int) Math.floor(imc);
       if( imc > 25 && imc < 29.9 ) return "Você está com sobrepeso, seu IMC é de "+ (int) Math.floor(imc);
       if( imc > 30 && imc < 34.9 ) return "Você está com está com obesidade grau I, seu IMC é de "+ (int) Math.floor(imc);
       if( imc > 30 && imc < 39.9 ) return "Você está com obesidade grau II, seu IMC é de "+ (int) Math.floor(imc);
       if( imc >= 39.9 ) return "Você está com obesidade grau III, seu IMC é de "+ (int) Math.floor(imc);
        
        
        return ""; 
    }    
    
}
