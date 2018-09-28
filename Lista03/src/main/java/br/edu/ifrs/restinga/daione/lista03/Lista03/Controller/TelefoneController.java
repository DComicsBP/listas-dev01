package br.edu.ifrs.restinga.daione.lista03.Lista03.Controller;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TelefoneController {
     @RequestMapping("/teste02/")
    public String teste02(){
        return "teste  dois ";
    }
    
}
