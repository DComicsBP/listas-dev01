package br.edu.ifrs.restinga.daione.lista01.Lista01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercicio02 {
    
    @RequestMapping("/diaDaSemana/{dia}/{mes}/{ano}/")
    public String diaDaSemana(@PathVariable int dia, @PathVariable int mes, @PathVariable int ano) {
        
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date data = null;
        try {
            data = sdf.parse(dia+"/"+ mes+"/"+ano);
        } catch (ParseException ex) {
            Logger.getLogger(Exercicio02.class.getName()).log(Level.SEVERE, null, ex);
        }
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(data);
            int diaDaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK);
            
            System.out.println("Dia da semana ===>"+ diaDaSemana);
            String val = null; 
            switch(diaDaSemana){
                case 1 : val = "Domingo"; break; 
                case 2 : val = "Segunda"; break; 
                case 3 : val = "Terça"; break; 
                case 4 : val = "Quarta"; break; 
                case 5 : val = "Quinta"; break; 
                case 6 : val = "Sexta"; break; 
                case 7 : val = "Sabado"; break; 
                default: break; 

            }
            return val; 
    }
}
