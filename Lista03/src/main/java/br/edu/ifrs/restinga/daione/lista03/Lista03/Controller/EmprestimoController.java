package br.edu.ifrs.restinga.daione.lista03.Lista03.Controller;

import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.EmprestimoDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.ERRORS.ERROR400;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Emprestimo;
import java.time.Period;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(path = "/emprestimo/", method = RequestMethod.GET)
    public Iterable<Emprestimo> getUsuariosNome() {
        Iterable<Emprestimo> emprestimos = eDAO.findAll();
        if(emprestimos != null){
            return emprestimos;

        }else{
            throw new ERROR400("Nenhum dado encontrado"); 
        }
    }

    @RequestMapping(path = "/emprestimo/{id}", method = RequestMethod.GET)
    public Optional<Emprestimo> getEmprestimoById(@PathVariable int id) {
        Optional<Emprestimo> emprestimo = eDAO.findById(id);

        if(emprestimo != null){
                    return emprestimo;

        }else{
            throw new ERROR400("Não foi possivel encontrar o registro"); 
        }
    }

    @RequestMapping(path = "/emprestimo/naoDevolvidos/", method = RequestMethod.GET)
    public Iterable<Emprestimo> getEmprestmoNaoDevolvido(@PathVariable String email) {

        Iterable<Emprestimo> emprestimos = eDAO.findAll();
        ArrayList<Emprestimo> emp = new ArrayList<>();

        if(emprestimos != null){
            for (Emprestimo e : emprestimos) {
                if (e.getDevoulucao() == null) {
                    emp.add(e);
                }
            }    
      }else{
            throw new ERROR400("Não foi possível encontrar um registro"); 
        }
        
        return emp;
    }

    @RequestMapping(path = "/emprestimo/emAtraso/", method = RequestMethod.GET)
    public Iterable<Emprestimo> getEmprestmosEmAtraso(@PathVariable String email) {

        Iterable<Emprestimo> emprestimos = eDAO.findAll();
        ArrayList<Emprestimo> emp = new ArrayList<>();

        if(emprestimos != null){
          for (Emprestimo e : emprestimos) {
                if (e.getDevoulucao().compareTo(e.getDevolucaoPrevisao()) > 0) {
                    emp.add(e);
                }
            }
        }else{
            throw new ERROR400("NAO FOI ENCONTRADO NENHUM REGISTRO"); 
        }
        return emp;

    }
}
