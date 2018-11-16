package br.edu.ifrs.restinga.daione.lista03.Lista03.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Emprestimo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    int ID; 
    
    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy") // formatação Json de data
    @Temporal(TemporalType.DATE) // formatação JPA de data
    Date retirada;
    
    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy") // formatação Json de data
    @Temporal(TemporalType.DATE) // formatação JPA de data
    Date DevolucaoPrevisao; 

    
    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy") // formatação Json de data
    @Temporal(TemporalType.DATE) // formatação JPA de data
    Date Devoulucao; 
    
    @ManyToOne
    Usuario usuario;
    
    @ManyToOne
    Livro Livro; 
    
    @ManyToOne
    Bibliotecario Bibliotecario; 

     public void setRetirada() {
        this.retirada = new Date(System.currentTimeMillis());;
    }

    public void setDevolucaoPrevisao(Date DevolucaoPrevisao) {
        this.DevolucaoPrevisao = DevolucaoPrevisao;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getRetirada() {
        return this.retirada;
    }


    public Date getDevolucaoPrevisao() {
            
        return this.DevolucaoPrevisao;
        
    }

    public void setDevolucaoPrevisao() {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, 7);        
            this.DevolucaoPrevisao = calendar.getTime();  
        
    }

    public Date getDevoulucao() {
        return this.getDevoulucao();
    }

    public void setDevoulucao(Date Devoulucao) {
        this.Devoulucao = Devoulucao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.usuario = Usuario;
    }

    public Livro getLivro() {
        return Livro;
    }

    public void setLivro(Livro Livro) {
        this.Livro = Livro;
    }

    public Bibliotecario getBibliotecario() {
        return Bibliotecario;
    }

    public void setBibliotecario(Bibliotecario Bibliotecario) {
        this.Bibliotecario = Bibliotecario;
    }
    
    
    
    
}
