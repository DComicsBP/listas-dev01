package br.edu.ifrs.restinga.daione.lista03.Lista03.DAO;

import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Emprestimo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author daione.pavan
 */
@Repository
public interface EmprestimoDAO extends CrudRepository<Emprestimo, Integer> {
    
}
