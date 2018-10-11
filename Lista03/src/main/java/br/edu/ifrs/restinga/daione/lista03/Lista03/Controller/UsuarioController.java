package br.edu.ifrs.restinga.daione.lista03.Lista03.Controller;

import org.springframework.web.bind.annotation.RestController;
import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.TelefoneDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.UsuarioDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.ERRORS.ERROR400;
import br.edu.ifrs.restinga.daione.lista03.Lista03.ERRORS.ERROR500;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Telefone;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Usuario;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class UsuarioController {

    @Autowired
    TelefoneDAO tDAO;

    @Autowired
    UsuarioDAO uDAO;

   /*@RequestMapping(path = "/usuarios/{id}/telefones/", method = RequestMethod.GET)
    public Telefone getTelefone(@RequestBody int id) {

        Telefone t = tDAO.findById(id);
        return t;
    }

    @RequestMapping(path = "/usuarios/", method = RequestMethod.GET)
    public Iterable<Usuario> getUsuarios() {
        Iterable<Usuario> users = uDAO.findAll();

        if (users != null) {
            return users;
        } else {
            throw new ERROR500("Não foi possível encontrar a lista de usuários");
        }
    }

    @RequestMapping(path = "/usuarios/{id}", method = RequestMethod.GET)
    public Optional<Usuario> getUsuario(@PathVariable Integer id) {
        Optional<Usuario> u = uDAO.findById(id);
        if (u != null) {
            return u;
        } else {
            throw new ERROR400("Deu ruim");
        }
    }
    
    @RequestMapping(path = "/usuarios/", method = RequestMethod.POST)
    public Optional<Usuario> inserir(){
        return null; 
    }
    
    @RequestMapping(path = "/usuarios/", method = RequestMethod.PUT)
    public Optional<Usuario> alterar(){
        return null; 
    }
    
    @RequestMapping(path = "/usuarios/", method = RequestMethod.PUT)
    public Optional<Usuario> deletar(){
        return null; 
    }*/
}

