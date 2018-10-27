package br.edu.ifrs.restinga.daione.lista03.Lista03.DAO;

import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Editora;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dayon
 */
@Repository
public interface EditoraDAO extends CrudRepository<Editora, Integer>{
    
}
