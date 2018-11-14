package br.edu.ifrs.restinga.daione.lista03.Lista03.DAO;

import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Emprestimo;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Usuario;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author daione.pavan
 */
@Repository
public interface EmprestimoDAO extends CrudRepository<Emprestimo, Integer> {
 
    Iterable<Emprestimo> findAllByRetiradaBetween(Date publicationTimeStart, Date publicationTimeEnd);
    List<Emprestimo> findByUsuario(Usuario user); 
    
}
