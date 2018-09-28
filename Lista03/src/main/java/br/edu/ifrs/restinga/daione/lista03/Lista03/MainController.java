package br.edu.ifrs.restinga.daione.lista03.Lista03;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MainController {
   
    @RequestMapping("/teste/")
    public String teste(){
        return "<h1>Teste</h1>"; 
    }
    
}
