/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.daione.lista03.Lista03.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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
    
    @OneToMany
    private List<Autor> Autor; 
    
    @OneToMany
    private List<Editora> Editora; 

    @OneToMany
    private List<Emprestimo> emprestimos; 
    
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

    public List<Autor> getAutor() {
        return Autor;
    }

    public void setAutor(List<Autor> Autor) {
        this.Autor = Autor;
    }

    public List<Editora> getEditora() {
        return Editora;
    }

    public void setEditora(List<Editora> Editora) {
        this.Editora = Editora;
    }
    
    
    
    
}
