/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.daione.lista03.Lista03.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author 10070269
 */
@Entity
public class Livro implements Serializable {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID; 
    private String titulo; 
    private int AnoPublicacao; 
    private boolean doacao; 
    @OneToOne
    private Autor Autor; 
    @OneToOne
    private Editora Editora; 

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPublicacao() {
        return AnoPublicacao;
    }

    public void setAnoPublicacao(int AnoPublicacao) {
        this.AnoPublicacao = AnoPublicacao;
    }

    public boolean isDoacao() {
        return doacao;
    }

    public void setDoacao(boolean doacao) {
        this.doacao = doacao;
    }

    public Autor getAutor() {
        return Autor;
    }

    public void setAutor(Autor Autor) {
        this.Autor = Autor;
    }

    public Editora getEditora() {
        return Editora;
    }

    public void setEditora(Editora Editora) {
        this.Editora = Editora;
    }
    
    
    
    
}
