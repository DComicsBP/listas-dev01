package br.edu.ifrs.restinga.daione.lista03.Lista03.Entity;

import java.io.Serializable;
import static java.lang.Integer.min;
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
    
    
    @Column(nullable=false)
    private String Senha; 

    @OneToMany
    private List<Telefone> Telefone; 
    
    @OneToMany
    private List<Emprestimo> Emprestimos; 
    

    public List<Emprestimo> getEmprestimos() {
        return Emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> Emprestimos) {
        this.Emprestimos = Emprestimos;
    }
    

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    
  
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
