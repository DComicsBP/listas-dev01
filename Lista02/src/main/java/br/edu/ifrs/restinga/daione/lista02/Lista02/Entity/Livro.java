package br.edu.ifrs.restinga.daione.lista02.Lista02.Entity;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    
    @Column(nullable = false)
    private String titulo; 
    
    @Column(nullable = false)
    private String primeiroNomeAutor; 
    private String segundoNomeAutor; 
    private int anoPublicacao; 
    
    @Column(nullable = false)
    private String editora; 
    private boolean doacao; 

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPrimeiroNomeAutor() {
        return primeiroNomeAutor;
    }

    public void setPrimeiroNomeAutor(String primeiroNomeAutor) {
        this.primeiroNomeAutor = primeiroNomeAutor;
    }

    public String getSegundoNomeAutor() {
        return segundoNomeAutor;
    }

    public void setSegundoNomeAutor(String segundoNomeAutor) {
        this.segundoNomeAutor = segundoNomeAutor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public boolean isDoacao() {
        return doacao;
    }

    public void setDoacao(boolean doacao) {
        this.doacao = doacao;
    }
    
    
    
}
