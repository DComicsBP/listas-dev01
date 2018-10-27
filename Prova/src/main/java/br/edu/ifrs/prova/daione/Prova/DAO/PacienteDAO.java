/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.prova.daione.Prova.DAO;

import br.edu.ifrs.prova.daione.Prova.Entity.Paciente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dayon
 */
@Repository
public interface PacienteDAO extends CrudRepository<Paciente,Integer> {
    Iterable<Paciente> findByNome(String nome); 
    
}
