/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.daione.lista03.Lista03.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 10070269
 */
@Entity
public class Telefone {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID; 
    private String Tipo; 
    private int Numero; 
    private int Area; 
    private int Ramal; 

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public int getArea() {
        return Area;
    }

    public void setArea(int Area) {
        this.Area = Area;
    }

    public int getRamal() {
        return Ramal;
    }

    public void setRamal(int Ramal) {
        this.Ramal = Ramal;
    }
    
    
}
