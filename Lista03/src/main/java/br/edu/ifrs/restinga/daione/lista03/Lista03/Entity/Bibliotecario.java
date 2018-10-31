/*
perce a relacao ou quando perde o objeto inteiro. 
 */
package br.edu.ifrs.restinga.daione.lista03.Lista03.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Bibliotecario implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)     
   private int ID; 
   @Column(nullable = false)
   private String Nome; 
   @Column(nullable = false, unique = true)
   private String email; 
  
   @Column(nullable = false)
   @JsonIgnore
   @Size(min = 8, max = 8)
   private String Senha; 
   
   @OneToMany
   private List<Emprestimo> emprestimos; 

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

   
    
}
