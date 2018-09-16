package br.edu.ifrs.restinga.daione.lista01.Lista01;
import Entidaades.Livro;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercicio04 {
            ArrayList<Livro> livros = new ArrayList<>(); 

    public void iniciaLivros(){
        livros.add(new Livro("Livro Muito Bom 1","Autor muito Bom 1",7));
        livros.add(new Livro("Livro Muito Bom 2","Autor muito Bom 2",2));
        livros.add(new Livro("Livro Muito Bom 3","Autor muito Bom 3",1));
        livros.add(new Livro("Livro Muito Bom 4","Autor muito Bom 4",5));
        
    }
    @RequestMapping("/novoItem/{titulo}/{autor}/{valor}/")
    public ArrayList<Livro> novoItem(@PathVariable String titulo, @PathVariable String autor, @PathVariable double valor ){
        
        this.iniciaLivros();
        livros.add(new Livro(titulo,autor,valor)); 
        return livros; 
    }
    
    @RequestMapping("/listarItens/")
    
    public ArrayList<Livro> listar(){
        this.iniciaLivros();
        return livros; 
    }
    
}
