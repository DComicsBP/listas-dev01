/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.daione.lista03.Lista03.ERRORS;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author dayon
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ERROR400 extends RuntimeException{
  public ERROR400(String mensagem){
      super(mensagem); 
  }
    
}
