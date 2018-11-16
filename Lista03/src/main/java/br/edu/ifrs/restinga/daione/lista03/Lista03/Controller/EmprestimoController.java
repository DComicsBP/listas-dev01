package br.edu.ifrs.restinga.daione.lista03.Lista03.Controller;

import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.BibliotecarioDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.EmprestimoDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.LivroDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.UsuarioDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.ERRORS.ERROR400;
import br.edu.ifrs.restinga.daione.lista03.Lista03.ERRORS.ERROR500;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Bibliotecario;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Emprestimo;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Livro;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Modelo.EmprestimoModel;
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
 * @author daione.pavan
 */
@RestController
public class EmprestimoController {

    @Autowired
    EmprestimoDAO eDAO;
    
    @Autowired
    BibliotecarioDAO bDAO;

    @Autowired
    LivroDAO lDAO;
    
    @Autowired
    UsuarioDAO uDAO;

    // 1 - busca todos os emprestimos
    @RequestMapping(path = "/emprestimo/", method = RequestMethod.GET)
    public Iterable<Emprestimo>  getEmprestimos() {
        Iterable<Emprestimo> emprestimos = eDAO.findAll();
        return emprestimos; 
    }

    // 2 - busca todos os livros emprestados
    @RequestMapping(path = "/emprestimo/livrosEmprestados/", method = RequestMethod.GET)
    public List<Emprestimo> getLivrosEmprestado() {

        
        Iterable<Emprestimo> em= eDAO.findAll(); 
        
      
        
        return (List<Emprestimo>) em; 
    }
    
    // 3 - busca todos os livros não emprestados
    @RequestMapping(path = "/emprestimo/livrosNãoEmprestados/", method = RequestMethod.GET)
    public List<Livro> getLivrosNaoEmprestados() {
        List<Livro> livros = new ArrayList<>();

        Iterable<Livro> liv = lDAO.findAll();
        if (liv != null) {
            for (Livro livro : liv) {
                if (livro.getEmprestimos() != null) {
                    if (livro.getEmprestimos().get(livro.getEmprestimos().size() - 1) == null) {
                        livros.add(livro);
                    }
                } else {
                    livros.add(livro);
                }
            }
        } else {
            throw new ERROR400("Não foi encontrado um registro");
        }

        return livros;
    }

    // 4 - busca emprestimos por id
    @RequestMapping(path = "/emprestimo/{id}", method = RequestMethod.GET)
    public Optional<Emprestimo> getEmprestimoById(@PathVariable int id) {
        Optional<Emprestimo> emprestimo = eDAO.findById(id);

        if (emprestimo != null) {
            return emprestimo;
        } else {
            throw new ERROR400("Não foi possivel encontrar o registro");
        }
    }
    
    // 5- lista todos os emprestimos com o campo devolucao nulo 
    @RequestMapping(path = "/emprestimo/naoDevolvidos/", method = RequestMethod.GET)
    public Iterable<Emprestimo> getEmprestmoNaoDevolvido(@PathVariable String email) {

        Iterable<Emprestimo> emprestimos = eDAO.findAll();
        ArrayList<Emprestimo> emp = new ArrayList<>();

        if (emprestimos != null) {
            for (Emprestimo e : emprestimos) {
                if (e.getDevoulucao() == null) {
                    emp.add(e);
                }
            }
        } else {
            throw new ERROR400("Não foi possível encontrar um registro");
        }

        return emp;
    }

    // 6- insere novo emprestimo no sistema
    @RequestMapping(path="/emprestimo/", method = RequestMethod.POST)
    public String inserirEmprestimo(@RequestBody Emprestimo model){
        
            Emprestimo e = new Emprestimo(); 
        String informacoes = ""; 
        
        if(model != null){
            e.setBibliotecario(model.getBibliotecario());
            e.setDevolucaoPrevisao();
            // e.setDevoulucao(model.getDevoulucao());
            e.setLivro(model.getLivro());
            e.setUsuario(model.getUsuario());
            e.setRetirada();
            eDAO.save(e);
            
            informacoes= "\n Bibliotecario: "+e.getBibliotecario().getNome();
            informacoes+="\n Usuario: "+e.getUsuario().getNome(); 
            informacoes+="\n Livro: "+e.getLivro().getTitulo(); 
            informacoes+="\n Retirada: "+e.getRetirada();
            informacoes+="\n Previsão devolucao: "+e.getDevolucaoPrevisao(); 

            
        }else{
            throw new ERROR500("Você não inseriu todos os dados corretamente "); 
        }
        
        return informacoes; 
        
        
    }

    // 7-  lista todos os emprestimos com o campo devolucao maior que o prazo previsto 
    @RequestMapping(path = "/emprestimo/emAtraso/", method = RequestMethod.GET)
    public String getEmprestmosEmAtraso() {

        int count = 1;
        String mensagem = ""; 
        Iterable<Emprestimo> emprestimos = eDAO.findAll();
        
        if (emprestimos != null) {
            for (Emprestimo e : emprestimos) {
                int atraso = e.getDevoulucao().compareTo(e.getDevolucaoPrevisao());

                if (atraso > 0) {
                    mensagem+="\n EMPRESTIMO EM ATRASO "+count;
                    mensagem+="\n O livro "+ e.getLivro().getTitulo()+" foi entregue com um atraso de " +count+ " dias";
                            
                }
            }
        } else {
            throw new ERROR400("NAO FOI ENCONTRADO NENHUM REGISTRO");
        }
        return mensagem;

    }

    // 8 - Faz o mesmo que  o método 2
    @RequestMapping(path = "/emprestimos/naoDevolvidos/", method = RequestMethod.GET)
    public List<Emprestimo> listaEmprestimosEmAberto() {
        Iterable<Emprestimo> emprestimos = eDAO.findAll();
        List<Emprestimo> emp = new ArrayList<>();

        for (Emprestimo e : emprestimos) {

            if (e.getDevoulucao() == null) {

                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setBibliotecario(e.getBibliotecario());
                emprestimo.setDevolucaoPrevisao(e.getDevolucaoPrevisao());
                emprestimo.setDevoulucao(e.getDevoulucao());
                emprestimo.setID(e.getID());
                emprestimo.setLivro(e.getLivro());
                emprestimo.setRetirada();
                emprestimo.setUsuario(e.getUsuario());
                emp.add(emprestimo);
            }
        }
        if (emp.get(0).getID()  == 0) {
            throw new ERROR400("Não existem empréstimos não devolvidos. ");
        }
        return emp;
    }

    // 9 - Busca por intervalo de datas os emprestimos 
    @RequestMapping(path = "/emprestimos/porDatas/{date01}/date02/", method = RequestMethod.GET)
    public Iterable <Emprestimo> listaEmprestimosEmAberto(Date date01, Date date02) {
        Iterable<Emprestimo> emprestimos = eDAO.findAllByRetiradaBetween(date02, date02);
        if(emprestimos == null){
            throw new ERROR400("Não foi encontrado nenhum dado entre as datas informadas"); 
        }
        return emprestimos;
    }
    
}
