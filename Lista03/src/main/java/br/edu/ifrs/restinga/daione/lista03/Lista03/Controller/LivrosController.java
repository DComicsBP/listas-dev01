package br.edu.ifrs.restinga.daione.lista03.Lista03.Controller;

import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.AutorDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.EditoraDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.LivroDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.ERRORS.ERROR400;
import br.edu.ifrs.restinga.daione.lista03.Lista03.ERRORS.ERROR500;
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

    //autores
    @RequestMapping(path = "/autores/", method = RequestMethod.GET)
    public Iterable<Autor> ListarAutores() {
        Iterable<Autor> autores = aDAO.findAll();
        return autores;

    }

    @RequestMapping(path = "/livros/{id}/autores/", method = RequestMethod.GET)
    public List<Autor> listaAutoresPeloLivro(@PathVariable int id) {
        Optional<Livro> l = livroDAO.findById(id);
        return l.get().getAutor();

    }
    
    @RequestMapping(path = "/livros/autores/{id}", method = RequestMethod.GET)
    public Autor getAutor(int id){
        Autor autor = new Autor(); 
        Optional<Autor> a = aDAO.findById(id);
        
        autor.setID(a.get().getID());
        autor.setLivros(a.get().getLivros());
        autor.setNome(a.get().getNome());
        autor.setSobrenome(a.get().getSobrenome());
        
        return autor;
    }
    
    // editoras
    @RequestMapping(path = "/editora/", method = RequestMethod.GET)
    public Editora ListarEditoraById(int id) {
        Optional<Editora> editora = eDAO.findById(id);
        Editora e = new Editora();

        e.setID(editora.get().getID());
        e.setNome(editora.get().getNome());
        e.setNome(editora.get().getCnpj());

        return e;
    }

    @RequestMapping(path = "/editoras/", method = RequestMethod.GET)
    public Iterable<Editora> ListarEditoras() {
        Iterable<Editora> editoras = eDAO.findAll();
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

    @RequestMapping(path = "/livros/{id}/editora/", method = RequestMethod.GET)
    public List<Editora> listaEditorasPeloLivro(@PathVariable int id) {
        Optional<Livro> l = livroDAO.findById(id);
        return l.get().getEditora();

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

    //livros
    @RequestMapping(path = "/livros/", method = RequestMethod.GET)
    public Iterable<Livro> ListarLivros() {
        Iterable<Livro> livros = livroDAO.findAll();
        return livros;

    }

    @RequestMapping(path = "/livros/{idEditora}/{idAutor}", method = RequestMethod.POST)
    public Livro insereLivro(@PathVariable int idEditora, @PathVariable int idAutor, @RequestBody List<Livro> l) {

        if (l!=null) {
            for (Livro liv : l) {
                liv.setID(0);
                Livro livro = new Livro();

                List<Editora> editoras = liv.getEditora();
                List<Editora> edi = new ArrayList<>();

                List<Autor> autores = liv.getAutor();
                List<Autor> aut = new ArrayList<>();

                for (Autor autor : autores) {

                    Autor autorInterno = new Autor();
                    Autor aux = new Autor(); 

                    if (autor.getID() == 0) {
                        autorInterno.setNome(autor.getNome());
                        autorInterno.setSobrenome(autor.getSobrenome());
                    }
                    if(autor.getID()> 0){
                        
                    }
                        aux = checkNameAutor(autor.getNome(), autor.getSobrenome());
                        if (aux.getID() != 0 && idAutor == 0) {
                            aut.add(aux);
                        }else{
                            autorInterno.setID(aDAO.save(autorInterno).getID());
                            aut.add(autorInterno);
                        }
                        if(idAutor > 0){
                            aut.add(this.getAutor(idAutor)); 
                        }
                        //if(aux.getID())
                    }

                for (Editora editora : editoras) {
                    Editora editoraInterna = new Editora();
                    Editora aux = this.checkCNPJEditora(editora.getCnpj());
                        Editora edit = new Editora(); 

                    if (editora.getID() == 0) {

                        editoraInterna.setCnpj(editora.getCnpj());
                        editoraInterna.setNome(editora.getNome());

                        if (aux != null ) {
                            edi.add(aux); 
                        }else{
                         editoraInterna.setID(eDAO.save(editoraInterna).getID());
                        edi.add(editoraInterna);   
                        }
                        if(idEditora != 0){
                            edi.add(this.ListarEditoraById(idEditora)); 
                        }
                    }
                }
                livro.setAnoPublicacao(liv.getAnoPublicacao());
                livro.setAutor(aut);
                livro.setEditora(edi);
                livro.setTitulo(liv.getTitulo());
                livroDAO.save(livro);
            }
        } else {
            throw new ERROR400("nao deu!!");
        }

        return null;

    }

    // checks and Utils



public Autor checkNameAutor(String nomeAutor, String sobrenomeAutor) {
        List<Autor> autores = aDAO.findByNomeAndSobrenome(nomeAutor, sobrenomeAutor);
        Autor a = new Autor();

        for (Autor aut : autores) {

            a.setID(aut.getID());
            a.setLivros(aut.getLivros());
            a.setNome(aut.getNome());
            a.setSobrenome(aut.getSobrenome());
        }
        return a;

    }

    public Editora checkCNPJEditora(String CNPJ) {
        List<Editora> editoras = eDAO.findByCnpj(CNPJ);
        Editora e = new Editora();
        for(Editora edi : editoras){
            e.setCnpj(edi.getCnpj());
            e.setID(edi.getID());
            e.setNome(e.getNome());
        }
        
        return e;
    }

}
