/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.prova.daione.Prova.Controller;

import br.edu.ifrs.prova.daione.Prova.DAO.ConsultaDAO;
import br.edu.ifrs.prova.daione.Prova.ERRORS.ERROR400;
import br.edu.ifrs.prova.daione.Prova.ERRORS.ERROR500;
import br.edu.ifrs.prova.daione.Prova.Entity.Consulta;
import br.edu.ifrs.prova.daione.Prova.Entity.Procedimento;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dayon
 */
@RestController
public class ConsultaController {
    @Autowired
    ConsultaDAO cDAO; 
    
    @RequestMapping(path="/consultas/", method = RequestMethod.GET)
    public Iterable<Consulta> listaConsulta(){
        Iterable<Consulta> consultas = cDAO.findAll() ;  
        return consultas; 
    }
    
    @RequestMapping(path="/api/consultas/pesquisar/{data01}/{data02}/", method = RequestMethod.GET)
    public Iterable<Consulta> consultasPorData(@PathVariable String data01, @PathVariable String data02 ) throws ParseException{
        Iterable<Consulta> consultas = cDAO.findAll(); 
        ArrayList<Consulta> con = new ArrayList<Consulta>(); 
       
        String target1 = data01;
         DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
         Date result1 =  df.parse(target1);  
        
         String target2 = data02;
         DateFormat df2 = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
         Date result2 =  df2.parse(target2);  
        
         for(Consulta c : consultas){
             if(c.getData().after(result1) && c.getData().after(result2)){
                 con.add(c);
             }
         }
         
         if(con == null){
          throw new ERROR400("Não foi possível encontrar consulta no período informado");    
         }
         
       return con; 
     }
    
    @RequestMapping(path="/api/consultas/pesquisar/paciente")
    public Iterable<Consulta> consultasPorPaciente(@PathVariable String id){
        Iterable<Consulta> consultas = cDAO.findAll(); 
        ArrayList<Consulta> con = new ArrayList<Consulta>(); 
        ArrayList<Integer> idPacientes = new ArrayList<Integer>();; 
        for(Consulta c : consultas){
             if(c.getPaciente().getId() == Integer.parseInt(id)){
                 con.add(c);
             }
             idPacientes.add(c.getPaciente().getId()); 
         }
           if(con == null){
               throw new ERROR400("Não foi possível encontrar uma consulta para esse paciente"); 
               
           }
           if(idPacientes == null){
               throw new ERROR400("Não existe paciente com a informação passada. "); 

           }
       
        return con;
    }
    
        
     @RequestMapping(path = "/consultas/{id}/procedimentos", method = RequestMethod.GET)
    public void inserir(@RequestBody Procedimento procedimento, @PathVariable String id){
        Integer idIn = Integer.parseInt(id); 
        Optional<Consulta> consultas = cDAO.findById(idIn);
        
        
        
        
        
    }

    
}
