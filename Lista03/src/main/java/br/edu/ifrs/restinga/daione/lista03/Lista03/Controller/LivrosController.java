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
    public Autor getAutor(int id) {
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
        if (l != null) {
            return l.get().getEditora();

        } else {
            throw new ERROR400("Não foi possivel encontrar o dado");
        }

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
            throw new ERROR400("Não foi possível encontrar os dados. ");
        }
        return editoras;

    }

    //livros
    @RequestMapping(path = "/livros/", method = RequestMethod.GET)
    public Iterable<Livro> ListarLivros() {
        Iterable<Livro> livros = livroDAO.findAll();
        return livros;

    }

    @RequestMapping(path = "/livros/{idE}/{idA}", method = RequestMethod.POST)
    public Livro insereLivro(@PathVariable String idE, @PathVariable String idA, @RequestBody Livro l) {
        int idAutor = Integer.parseInt(idA); 
        int idEditora = Integer.parseInt(idE); 
        ArrayList<Autor> autores = new ArrayList<>();
        
        if(idAutor != 0){
            Optional<Autor> a = aDAO.findById(idAutor);
            if(a!= null){
            }else{
                throw new ERROR500("Não foi possível encontrar o autor"); 
            }
            
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
        return a;
        }
        return null;
    }

    public Editora checkCNPJEditora(String CNPJ) {
        Optional<Editora> editoras = eDAO.findByCnpj(CNPJ);
        Editora e = new Editora();
        e.setID(editoras.get().getID());
        e.setNome(editoras.get().getNome());
        e.setCnpj(editoras.get().getCnpj());

        if(e != null){
            return e; 
        }
        
        return null; 
    }

}
