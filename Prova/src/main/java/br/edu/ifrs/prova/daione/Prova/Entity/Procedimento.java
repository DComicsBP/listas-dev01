package br.edu.ifrs.prova.daione.Prova.Entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author dayon
 */
@Entity
public class Procedimento {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id; 
   
   @Column(nullable = false )
   private String nome; 
   
   @Min(0)
   @Column(nullable = false)
   private double valor; 
   
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    
    
}
