package br.edu.ifrs.restinga.daione.lista03.Lista03.Controller;

import org.springframework.web.bind.annotation.RestController;
import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.TelefoneDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Telefone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@RestController
public class UsuarioController {
    
    @Autowired
    TelefoneDAO tDAO;
    
    @RequestMapping(path="/usuarios/{id}/telefones/", method=RequestMethod.GET)
    public Telefone getTelefone(@RequestBody int id){
        
        Telefone t = tDAO.findById(id); 
        return t; 
    }
}
