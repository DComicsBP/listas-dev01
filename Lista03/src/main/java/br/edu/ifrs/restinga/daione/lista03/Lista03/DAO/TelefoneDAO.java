/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.daione.lista03.Lista03.DAO;

import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Telefone;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author 10070269
 */
@Repository
public interface TelefoneDAO extends CrudRepository<Telefone,Integer>{

    Telefone findById(int id);
    List<Telefone> findByUser(Usuario usuario);
    
    
}
