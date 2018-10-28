/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.daione.lista03.Lista03.DAO;

import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Emprestimo;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author dayon
 */
public interface EmprestimoDAO extends CrudRepository<Emprestimo, Integer> {
    
    
}
