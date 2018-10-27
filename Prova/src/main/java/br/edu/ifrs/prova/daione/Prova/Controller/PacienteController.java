/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.prova.daione.Prova.Controller;

import br.edu.ifrs.prova.daione.Prova.DAO.PacienteDAO;
import br.edu.ifrs.prova.daione.Prova.ERRORS.ERROR400;
import br.edu.ifrs.prova.daione.Prova.Entity.Paciente;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dayon
 */
@RestController
public class PacienteController {
    
    @Autowired
    PacienteDAO pDAO;
    
    
    @RequestMapping(path="/api/pacientes/", method=RequestMethod.GET)
    public Iterable<Paciente> listarPaciente(){
        Iterable<Paciente> pacientes = pDAO.findAll(); 
        return pacientes; 
    }
    
    @RequestMapping(path="/api/pacientes/nome/{nome}", method=RequestMethod.GET)
    public Iterable<Paciente> listarPorNome(@PathVariable String nome){
        Iterable<Paciente> pacientes = pDAO.findAll(); 
        ArrayList<Paciente> pa = new ArrayList<Paciente>(); 
        for(Paciente p: pacientes){
            if(p.getNome() == nome){
                 pa.add(p);
            }
        }
        if(pa == null){
                throw new ERROR400("Não foi possível encontrar o paciente"); 
        }else{
            return pa;
        }
    }
    
}
