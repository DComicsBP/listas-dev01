package br.edu.ifrs.restinga.daione.lista03.Lista03.Controller;

import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.AutorDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.EditoraDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.EmprestimoDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.LivroDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.ERRORS.ERROR400;
import br.edu.ifrs.restinga.daione.lista03.Lista03.ERRORS.ERROR500;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Autor;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Editora;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Livro;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    EmprestimoDAO emprestimoDAO;

    //init autores
    // 1- Lista os autores
    @RequestMapping(path = "/autores/", method = RequestMethod.GET)
    public Iterable<Autor> ListarAutores() {
        Iterable<Autor> autores = aDAO.findAll();
        if(autores == null){
            throw new ERROR400("Não foi possivel encontrar um registro"); 
        }
        return autores;
    }

    // 2 - lista os autores do livro
    @RequestMapping(path = "/livros/{id}/autores/", method = RequestMethod.GET)
    public List<Autor> listaAutoresPeloLivro(@PathVariable int id) {
        Optional<Livro> l = livroDAO.findById(id);
        l.get().setAutor(aDAO.findByLivro(l.get()));
       
        if(l.get().getAutor() == null ){
            throw new ERROR400("Não foi possivel achar livros para esse autor"); 
        }
        
        return l.get().getAutor();

    }

    // 3 - busca autor específico 
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
    // finish autores

    // init editoras
    // 4 - pega a editora pelo seu ID
    @RequestMapping(path = "/editoras/{id}", method = RequestMethod.GET)
    public Editora ListarEditoraById(@PathVariable String id) {
        Optional<Editora> editora = eDAO.findById(Integer.parseInt(id)  );
        Editora e = new Editora();

        e.setID(editora.get().getID());
        e.setNome(editora.get().getNome());
        e.setNome(editora.get().getCnpj());

        return e;
    }

    //5 - Busca todas as editoras
    @RequestMapping(path = "/editoras/", method = RequestMethod.GET)
    public Iterable<Editora> ListarEditoras() {
        Iterable<Editora> editoras = eDAO.findAll();
        return editoras;
    }

    //6 - Insere todos os autores de um livro
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

    // 7 - Busca todas as editoras de um livro
    @RequestMapping(path = "/livros/{id}/editora/", method = RequestMethod.GET)
    public List<Editora> listaEditorasPeloLivro(@PathVariable int id) {
        Optional<Livro> l = livroDAO.findById(id);
        if (l != null) {
            return l.get().getEditora();

        } else {
            throw new ERROR400("Não foi possivel encontrar o dado");
        }

    }

    // 8 - Insere nova editora 
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
    // finish editoras 

    //init livros
    // 9 - Lista todos os livros
    @RequestMapping(path = "/livros/", method = RequestMethod.GET)
    public Iterable<Livro> ListarLivros() {
        Iterable<Livro> livros = livroDAO.findAll();
        if(livros == null){
            throw new ERROR400("Não foi possível encontrar livro registrado. "); 
        }
        return livros;
    }

    // 10 - lista livros pelo nome e sobrenome do autor
    @RequestMapping(path = "/livros/listar/sobrenome/{nome}/{sobrenome}", method = RequestMethod.GET)
    public List<Livro> ListarLivrosPorAutor(@PathVariable String sobrenome, @PathVariable String nome) {
        Iterable<Livro> livros = livroDAO.findAll();
        List<Livro> livrosFiltrados = new ArrayList<>();

        for (Livro l : livros) {
            if (l.getAutor() != null) {
                for (Autor a : l.getAutor()) {
                    if (a.getNome() == nome && a.getSobrenome() == sobrenome) {
                        livrosFiltrados.add(l);
                    }
                }
            }
        }
        if (livrosFiltrados == null) {
            throw new ERROR400("Não foi encontrado registro com os valores informados");
        }
        return livrosFiltrados;

    }
    // 11 - Lista os livros pela editora
    @RequestMapping(path = "/livros/listar/livro/editora/{editora}", method = RequestMethod.GET)
    public List<Livro> ListarLivrosPorEditora(@PathVariable String editora) {
        Iterable<Livro> livros = livroDAO.findAll();
        List<Livro> livrosFiltrados = new ArrayList<>();

        for (Livro l : livros) {
            if (l.getEditora() != null) {
                for (Editora e : l.getEditora()) {
                    if (e.getNome() == editora || e.getCnpj() == editora) {
                        livrosFiltrados.add(l);
                    }
                }
            } else {
                throw new ERROR500("Os dados que você inseriu são inválidos");
            }
        }
        if (livrosFiltrados == null) {
            throw new ERROR400("Não foi encontrado resultado com a pesquisa acima");
        }
        return livrosFiltrados;

    }
    
    // 12 - Faz update do autor
    @RequestMapping(path = "/autor/{idAutor}/", method = RequestMethod.PUT)
    public Autor AtualizaAutor(@PathVariable String idAutor, Autor autores) {
        int id = Integer.parseInt(idAutor);
        Autor aut = new Autor();
        if (aDAO.existsById(id)) {
            aut.setID(id);
            aDAO.save(aut);
        } else {
            throw new ERROR400("Autor não encontrado");
        }

        return null;

    }

    // 13 - Insere o livro pelo id da editora e/ou o id do autor
    @RequestMapping(path = "/livros/{idE}/{idA}", method = RequestMethod.POST)
    public List<Livro> insereLivro(@PathVariable String idE, @PathVariable String idA, @RequestBody List<Livro> l) {

        int idAutor = Integer.parseInt(idA);
        Integer idEditora = Integer.parseInt(idE);
        ArrayList<Autor> autores = new ArrayList<>();
        ArrayList<Editora> editoras = new ArrayList<>();
        ArrayList<Livro> livros = new ArrayList<>();
        Autor autor = new Autor();
        Editora editora = new Editora();

        for (Livro livro : l) {
            // Autor 
            if (idAutor != 0) {
                Optional<Autor> a = aDAO.findById(idAutor);
                if (a != null) {

                    autor.setID(idAutor);
                    autor.setNome(a.get().getNome());
                    autor.setSobrenome(a.get().getSobrenome());
                    autores.add(autor);
                } else {
                    throw new ERROR400("Você não informou um usuário existente");
                }
            } else if (idAutor == 0) {

                for (Autor aut : livro.getAutor()) {
                    autor = new Autor();
                    autor.setNome(aut.getNome());
                    autor.setSobrenome(aut.getSobrenome());

                    Autor check = checkNameAutor(aut.getNome(), aut.getSobrenome());
                    if (check.getID() > 0) {
                        autor.setID(check.getID());
                    }
                    if (check.getID() == 0) {
                        autor.setID(aDAO.save(autor).getID());

                    }
                    autores.add(autor);
                }
            }

            // Editora 
           if (idEditora != 0) {
                Optional<Editora> e = eDAO.findById(idEditora);
                if (e != null) {
                    editora.setID(idEditora);
                    editora.setNome(e.get().getNome());
                    editora.setCnpj(e.get().getCnpj());
                    editoras.add(editora);
                } else {
                    throw new ERROR400("Você não informou um usuário existente");
                }
            } else if (idEditora == 0) {

                for (Editora edi : livro.getEditora()) {
                    editora.setNome(edi.getNome());
                    editora.setCnpj(edi.getCnpj());

                    Editora check = checkCNPJEditora(edi.getCnpj());
                    if (check.getID() > 0) {
                        editora.setID(check.getID());
                    }
                    if (check.getID() == 0) {
                        editora.setID(eDAO.save(editora).getID());
                    }
                    editoras.add(editora);
                }
            }

            
            Date d = new Date();
            livro.setAnoPublicacao(d.getDate());
            livro.setAutor(autores);
            livro.setDoacao(livro.isDoacao());
            livro.setEditora(editoras);
            livro.setTitulo(livro.getTitulo());
            livro.setID(livroDAO.save(livro).getID());

            }
        

        return l;

    }
    // finish livros

    // checks and Utils
    // 14 - busca o nome do autor
    public Autor checkNameAutor(String nomeAutor, String sobrenomeAutor) {
        Iterable<Autor> autores = aDAO.findAll();
        Iterable<Autor> at = aDAO.findByNomeAndSobrenome(nomeAutor, sobrenomeAutor);
        Autor aux = new Autor();

        for (Autor a : at) {
            aux.setID(a.getID());
            aux.setLivros(a.getLivros());
            aux.setNome(a.getNome());
            aux.setSobrenome(a.getSobrenome());
            break;

        }
        return aux;

    }

    // 15 - ve se um cnpj já está cadastrado 
    public Editora checkCNPJEditora(String CNPJ) {
        List<Editora> editoras = eDAO.findByCnpj(CNPJ);
        Editora e = new Editora();

        for (Editora edi : editoras) {

            if (editoras.isEmpty()) {
                return null;
            } else {

                e.setID(edi.getID());
                e.setNome(edi.getNome());
                e.setCnpj(edi.getCnpj());
                break; 

            }
        }

        return e;
    }
    // finish check and Utils

}
