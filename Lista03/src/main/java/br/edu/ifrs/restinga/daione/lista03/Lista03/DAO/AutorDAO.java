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
    List<Autor> findByNomeAndSobrenome(String nome, String sobrenome);          
                        

    
}
