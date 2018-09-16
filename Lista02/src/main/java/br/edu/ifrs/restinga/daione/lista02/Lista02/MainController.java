package br.edu.ifrs.restinga.daione.lista02.Lista02;

import br.edu.ifrs.restinga.daione.lista02.Lista02.DAO.LivroDAO;
import br.edu.ifrs.restinga.daione.lista02.Lista02.Entity.Livro;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    LivroDAO livroDAO; 
    
    @RequestMapping(path="/livros/", method = RequestMethod.GET)
    public Iterable<Livro> teste(){
        return livroDAO.findAll();
    }
    
    @RequestMapping(path="/livros/{Id}/", method= RequestMethod.GET)
    public Livro recuperar(@PathVariable String Id){
        int ano = Integer.parseInt(Id); 
            return livroDAO.findById(ano); 
            
    }
    
    @RequestMapping(path="/livros/", method = RequestMethod.POST)
    public Livro inserir(@RequestBody Livro livro){
        if(livro.getAnoPublicacao() >=1800 && livro.getAnoPublicacao() <= Calendar.getInstance().get(Calendar.YEAR)){
            livro.setId(0);
            livroDAO.save(livro);  
           
        }else{
            return null;
           }
        return livro; 
        
    }
    
    @RequestMapping(path="/usuario/", method = RequestMethod.GET)
    public void listarUsuario(){
        
    }
}
