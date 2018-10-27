package br.edu.ifrs.restinga.daione.lista03.Lista03.Controller;

import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.AutorDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Autor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dayon
 */
@RestController
public class AutorController {
    @Autowired
    AutorDAO aDAO; 
    
    public boolean checknameAutor(String nomeAutor, String sobrenomeAutor){
        List<Autor> autores = (List<Autor>) aDAO.findAll(); 
        String nomeCompleto  = nomeAutor + "-"+ sobrenomeAutor; 
        boolean flag = false; 
        
        for(Autor a : autores){
         String nomeAux = a.getNome()+"-"+a.getSobrenome(); 
         if(nomeAux == nomeCompleto){
             flag = true; 
         }
        }
        
        return flag;
    }
    
}
