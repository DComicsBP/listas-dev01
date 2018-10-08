package br.edu.ifrs.restinga.daione.lista03.Lista03.Entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Emprestimo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    int ID; 
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    Date Retirada;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    Date DevolucaoPrevisao; 
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    Date Devoulucao; 
    @OneToOne
    Usuario Usuario;
    @OneToOne
    Livro Livro; 
    @OneToOne
    Bibliotecario Bibliotecario; 

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getRetirada() {
        return Retirada;
    }

    public void setRetirada() {
        
        this.Retirada = new Date(System.currentTimeMillis());
    }

    public Date getDevolucaoPrevisao() {
        
        return DevolucaoPrevisao;
    }

    public void setDevolucaoPrevisao() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 7);        
        this.DevolucaoPrevisao = calendar.getTime();        
        System.out.println("DATA +++>" + this.DevolucaoPrevisao);
    }

    public Date getDevoulucao() {
        return Devoulucao;
    }

    public void setDevoulucao(Date Devoulucao) {
        this.Devoulucao = Devoulucao;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
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
