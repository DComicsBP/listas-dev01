package br.edu.ifrs.restinga.daione.lista03.Lista03.Controller;

import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.AutorDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.EditoraDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.LivroDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.ERRORS.ERROR400;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Autor;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Editora;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Livro;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dayon
 */
@RestController
public class LivrosController {

    @Autowired
    LivroDAO livroDAO;

    @Autowired
    EditoraDAO eDAO;

    @Autowired
    AutorDAO aDAO;

    
    @RequestMapping(path = "/livros/", method = RequestMethod.GET)
    public Iterable<Livro> ListarLivros() {
        Iterable<Livro> livros = livroDAO.findAll();
        return livros;

    }

    @RequestMapping(path = "/livros/{id}/autores/", method = RequestMethod.GET)
    public List<Autor> listaAutoresPeloLivro(@PathVariable int id) {
        Optional<Livro> l = livroDAO.findById(id);
        return l.get().getAutor();

    }
    
    @RequestMapping(path = "/livros/{id}/editora/", method = RequestMethod.GET)
    public List<Editora> listaEditorasPeloLivro(@PathVariable int id) {
        Optional<Livro> l = livroDAO.findById(id);
        return l.get().getEditora();

    }

    @RequestMapping(path = "/livros/{idEditora}/{idAutor}", method = RequestMethod.POST)
    public Livro insereLivro(@PathVariable int idEditora, @PathVariable int idAutor, @RequestBody List<Livro> l) {
        List<Livro> livros = new ArrayList<>();

        if (idAutor == 0 && idEditora == 0) {
            for (Livro liv : l) {

                Livro livro = new Livro();

                List<Editora> editoras = liv.getEditora();
                List<Editora> edi = new ArrayList<>();

                List<Autor> autores = liv.getAutor();
                List<Autor> aut = new ArrayList<>();

                for (Autor autor : autores) {
                   
                    int value = checkNameAutor(autor.getNome(),autor.getSobrenome());
                    if( value == 0){
                        
                    Autor autorInterno = new Autor();
                    autorInterno.setNome(autor.getNome());
                    autorInterno.setSobrenome(autor.getSobrenome());
                    autorInterno.setID(aDAO.save(autorInterno).getID());
                    aut.add(autorInterno);
                    } else{
                        Autor autorAux = (Autor) aDAO.findById(value).get(); 
                        aut.add(autorAux);
                    }
                    
                }

                for (Editora editora : editoras) {
                    Editora editoraInterna = new Editora();

                    editoraInterna.setCnpj(editora.getCnpj());
                    editoraInterna.setNome(editora.getNome());
                    editoraInterna.setID(eDAO.save(editora).getID());
                    edi.add(editoraInterna);
                }

                liv.setAutor(aut);
                liv.setEditora(edi);

                livro.setAnoPublicacao(liv.getAnoPublicacao());
                livro.setAutor(liv.getAutor());
                livro.setEditora(liv.getEditora());
                livro.setTitulo(liv.getTitulo());
                livro.setID(livroDAO.save(liv).getID());

                livroDAO.save(livro);

            }
        } else {
            throw new ERROR400("nao deu!!");
        }

        return null;

    }

    @RequestMapping(path = "/livros/editora/", method = RequestMethod.POST)
    public List<Editora> insereEditora(@RequestBody List<Editora> e) {
        List<Editora> editoras = new ArrayList<>();

        if (e != null) {
            for (Editora editora : e) {
                Editora edi = new Editora();
                edi.setCnpj(editora.getCnpj());
                edi.setNome(editora.getNome());
                eDAO.save(edi);
                editoras.add(edi);
            }

        } else {

            throw new ERROR400("Você não informou os dados corretamente");
        }
        return editoras;

    }

    @RequestMapping(path = "/livros/autores/", method = RequestMethod.POST)
    public List<Autor> insereAutor(@RequestBody List<Autor> a) {

        List<Autor> autores = new ArrayList<>();

        if (a != null) {

            for (Autor autor : a) {
                Autor aut = new Autor();
                aut.setNome(autor.getNome());
                aut.setSobrenome(autor.getNome());

                aDAO.save(aut);
                autores.add(aut);
            }

        } else {

            throw new ERROR400("Você não informou os dados corretamente");
        }
        return autores;

    }

    public int checkNameAutor(String nomeAutor, String sobrenomeAutor){
        List<Autor> autores = (List<Autor>) aDAO.findAll(); 
        String nomeCompleto  = nomeAutor + "-"+ sobrenomeAutor; 
        boolean flag = false; 
        int value = 0; 
        for(Autor a : autores){
         String nomeAux = a.getNome()+"-"+a.getSobrenome(); 
         if(nomeAux == nomeCompleto){
            value =  a.getID();
         }
        }
        
        return value;
    }


}


