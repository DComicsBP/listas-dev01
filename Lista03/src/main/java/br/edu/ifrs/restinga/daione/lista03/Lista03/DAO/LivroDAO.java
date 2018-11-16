/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.daione.lista03.Lista03.DAO;

import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Emprestimo;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Livro;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dayon
 */
@Repository
public interface LivroDAO extends CrudRepository<Livro, Integer> {
    Optional<Livro> findByEmprestimos(Emprestimo e); 
}
