/*
perce a relacao ou quando perde o objeto inteiro. 
 */
package br.edu.ifrs.restinga.daione.lista03.Lista03.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Bibliotecario implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)     
   int ID; 
   @Column(nullable = false)
   String Nome; 
   @Column(nullable = false, unique = true)
   String Email; 
  
   @Column(nullable = false)
   @JsonIgnore
   @Size(min = 8, max = 8)
   String Senha; 

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
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
   
   
   
    
}
