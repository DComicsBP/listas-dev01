package Entidaades;

public class Livro {
    String Titulo; 
    double Valor;
    String Autor; 

    
    public Livro(String titulo, String autor, double valor){
        this.Titulo = titulo; 
        this.Valor = valor; 
        this.Autor = autor; 
    }
    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }
    
    
}
