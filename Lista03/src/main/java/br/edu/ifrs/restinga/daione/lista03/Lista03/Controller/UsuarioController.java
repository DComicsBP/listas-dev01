package br.edu.ifrs.restinga.daione.lista03.Lista03.Controller;

import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.EmprestimoDAO;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.TelefoneDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.UsuarioDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.ERRORS.ERROR400;
import br.edu.ifrs.restinga.daione.lista03.Lista03.ERRORS.ERROR500;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Emprestimo;
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
    
    @Autowired
    EmprestimoDAO eDAO; 
    
    
   
    // 1 -busca o emprestimo pelo nome cpf ou email do usuario 
    @RequestMapping(path = "/emprestimo/{usuario}", method = RequestMethod.GET)
    public Iterable<Emprestimo> getEmprestimoUsuarios(@PathVariable String usuario) {
        Iterable<Emprestimo> emprestimos =  eDAO.findAll();
        List<Emprestimo> emprestimosFiltrados = new ArrayList<Emprestimo>(); 
        for(Emprestimo e: emprestimos){
            if(e.getUsuario() != null){
                if(e.getUsuario().getCPF() == usuario|| e.getUsuario().getEmail() == usuario|| e.getUsuario().getNome() == usuario){
                    emprestimosFiltrados.add(e); 
                }else{
                    throw new ERROR500("Você não inseriu dados previamente existentes");
                }
            }else{
                throw new ERROR500("Não existem registros no servidor"); 
            }
        }
        return emprestimosFiltrados;
    }
    
    // 2 -busca usuario pelo nome
    @RequestMapping(path = "/usuarios/nome/{nome}", method = RequestMethod.GET)
    public Optional<Usuario> getUsuariosNome(@PathVariable String nome) {
        Optional<Usuario> users =  uDAO.findByNome(nome);
        return users;
    }
    
    // 3 - busca usuario pelo cpf
    @RequestMapping(path = "/usuarios/cpf/{cpf}", method = RequestMethod.GET)
    public Optional<Usuario> getUsuariosCpf(@PathVariable String cpf) {
        Optional<Usuario> users =  uDAO.findByCpf(cpf);
        return users;
    }
    
    // 4 - busca usuario por email
    @RequestMapping(path = "/usuarios/email/{email}", method = RequestMethod.GET)
    public Optional<Usuario> getUsuariosEmail(@PathVariable String email) {
        Optional<Usuario> users =  uDAO.findByEmail(email);
        return users; 
     }
    
    // 5 -  busca usuario pelo nome email ou cpf
    @RequestMapping(path = "/usuarios/dado/{dado}", method = RequestMethod.GET)
    public Iterable<Usuario> getUsuariosEmailNomeOuCpf (@PathVariable String dado) {
        Iterable<Usuario> users =  uDAO.findAll();
        List<Usuario> usuarioFiltrado = new ArrayList<>(); 
        
        for(Usuario u: users){
            if(u.getCPF() == dado || u.getEmail() == dado || u.getNome() == dado){
                usuarioFiltrado.add(u); 
            }else{
                throw new ERROR400("Não foi encontrado um registro com o dado fornecido");
            }
        }
        return usuarioFiltrado; 
     }
    
    // 6 - busca todos os usuarios do sistema
    @RequestMapping(path = "/usuarios/", method = RequestMethod.GET)
    public Iterable<Usuario> getUsuarios() {
        Iterable<Usuario> users = uDAO.findAll();

        if (users != null) {
            return users;
        } else {
            throw new ERROR500("Não foi possível encontrar a lista de usuários");
        }
    }
    
    // 7 - lista todos os telefones de um usuario
    @RequestMapping(path = "/usuarios/{id}/telefones/", method = RequestMethod.GET)
    public List<Telefone> getTelefone(@PathVariable int id) {

        Optional<Usuario> u = this.getUsuario(id);
        
         List<Telefone> t = u.get().getTelefone();
         return t;
    }   

    // 8 - insere telefone no usuario
    @RequestMapping(path = "/usuario/{id}/telefone/", method= RequestMethod.POST)
    public List<Telefone> inserirTelefones(@PathVariable int id, @RequestBody ArrayList<Telefone> tele){
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
    
    // 9 - insere novo usuario 
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
    
    // 10 - busca pelo id do usuario 
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

