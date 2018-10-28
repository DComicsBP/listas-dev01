package br.edu.ifrs.restinga.daione.lista03.Lista03.Controller;

import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.EmprestimoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dayon
 */
@RestController
public class EmprestimoController {
    @Autowired
    EmprestimoDAO eDAO; 
    
    public void novoEmprestimo(){
        
    }
    public void listarEmprestimosPorData(){
        
    }
    public void listarEmprestimosNaoDevolvidos(){
        
    }
    
    public void listarEmprestimosEmAtraso(){
        
    }
    
    
    
    
}
