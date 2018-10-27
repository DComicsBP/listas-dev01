package br.edu.ifrs.restinga.daione.lista03.Lista03.Controller;

import org.springframework.web.bind.annotation.RestController;
import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.TelefoneDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.UsuarioDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.ERRORS.ERROR400;
import br.edu.ifrs.restinga.daione.lista03.Lista03.ERRORS.ERROR500;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Telefone;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Usuario;
import java.util.ArrayList;
import java.util.List;
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

    @RequestMapping(path = "/usuarios/", method = RequestMethod.GET)
    public Iterable<Usuario> getUsuarios() {
        Iterable<Usuario> users = uDAO.findAll();

        if (users != null) {
            return users;
        } else {
            throw new ERROR500("Não foi possível encontrar a lista de usuários");
        }
    }
   @RequestMapping(path = "/usuarios/{id}/telefones/", method = RequestMethod.GET)
    public Telefone getTelefone(@PathVariable int id) {

        Optional<Usuario> u = this.getUsuario(id);
        
         Telefone t = (Telefone) u.get().getTelefone();
         return t;
    }   

    @RequestMapping(path = "/usuario/{id}/telefone/", method= RequestMethod.POST)
    public List<Telefone> inserirTelefone(@PathVariable int id, @RequestBody ArrayList<Telefone> tele){
        Usuario u = this.getUsuario(id).get();
        List<Telefone> telefones = this.getUsuario(id).get().getTelefone();
        for(Telefone tel : tele) {

            Telefone t = new Telefone();
            t.setArea(tel.getArea());
            t.setNumero(tel.getNumero());
            t.setRamal(tel.getRamal());
            t.setTipo(tel.getTipo());
            t.setUser(u);
            t.setID(tDAO.save(t).getID());
            telefones.add(t); 
            }

        u.setTelefone(telefones);
        uDAO.save(u);
            
        return telefones; 
            
    }
    
    @RequestMapping(path = "/usuarios/", method = RequestMethod.POST)
    public Optional<Usuario> inserir(@RequestBody Usuario usuario){
        Usuario u = new Usuario();
        if(usuario.getSenha().length() > 8){
                u.setID(0);
                u = uDAO.save(usuario);
            } else {
                throw new ERROR400("Você não inseriu uma senha válida: maior que 8 dígitos");
            }
        
        return null; 
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
    
}

