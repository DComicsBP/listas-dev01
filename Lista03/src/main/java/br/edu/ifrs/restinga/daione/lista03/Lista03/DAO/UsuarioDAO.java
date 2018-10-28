package br.edu.ifrs.restinga.daione.lista03.Lista03.DAO;

import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends CrudRepository<Usuario,Integer>{
        
        Optional<Usuario> findByNome(String nome); 
        Optional<Usuario> findByEmail(String email); 
        Optional<Usuario> findByCpf(String cpf); 


}
