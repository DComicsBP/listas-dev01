package br.edu.ifrs.restinga.daione.lista03.Lista03.DAO;

import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Editora;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dayon
 */
@Repository
public interface EditoraDAO extends CrudRepository<Editora, Integer>{
    
    Optional<Editora> findByCnpj(String cnpj); 
}
