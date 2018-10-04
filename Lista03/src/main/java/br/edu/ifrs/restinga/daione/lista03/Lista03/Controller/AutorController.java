/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.daione.lista03.Lista03.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 10070269
 */
@RestController
public class AutorController {
    @RequestMapping(path = "/autor/")
    public String autor(){
        return "<h1>teste</h1>"; 
        
    }
    
}
