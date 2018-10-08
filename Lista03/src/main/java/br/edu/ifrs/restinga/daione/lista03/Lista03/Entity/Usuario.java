package br.edu.ifrs.restinga.daione.lista03.Lista03.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID; 
    @Column(nullable=false)
    private String Nome; 
    @Column(nullable=false, unique=true)
    private String CPF; 
    @Column(nullable=false, unique = true)
    private String Email; 
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> Telefone; 

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
    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public List<Telefone> getTelefone() {
        return Telefone;
    }

    public void setTelefone(List<Telefone> Telefone) {
        this.Telefone = Telefone;
    }
    
    
    
    
    
}
