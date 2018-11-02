package br.edu.ifrs.restinga.daione.lista03.Lista03.DAO;

import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Autor;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author dayon
 */
public interface AutorDAO extends CrudRepository<Autor,Integer> {
    Iterable<Autor> findByNomeAndSobrenome(String nome, String sobrenome);          
                        
    List<Autor> findByNomeInAndSobrenomeIn(String nome, String sobrenome);
    
}
