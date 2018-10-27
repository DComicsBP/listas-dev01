package br.edu.ifrs.prova.daione.Prova.Controller;

import br.edu.ifrs.prova.daione.Prova.DAO.ProcedimentoDAO;
import br.edu.ifrs.prova.daione.Prova.ERRORS.ERROR500;
import br.edu.ifrs.prova.daione.Prova.Entity.Procedimento;
import java.util.ArrayList;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dayon
 */
@RestController
public class ProcedimentoController {

    @Autowired
    ProcedimentoDAO proDAO;

    @RequestMapping(path = "/procedimentos/", method = RequestMethod.GET)
    public Iterable<Procedimento> listaProcedimento() {
        Iterable<Procedimento> procedimentos = proDAO.findAll();
        return procedimentos;
    }

    @RequestMapping(path = "/api/procedimentos/pesquisar/valor/{valor01}/{valor02}/", method = RequestMethod.GET)
    public Iterable<Procedimento> listaProcedimentoPeloValor(@PathVariable String valor01, @PathVariable String valor02) {
        double v1 = Double.parseDouble(valor01);
        double v2 = Double.parseDouble(valor02);
        Iterable<Procedimento> proc = proDAO.findAll(); 
        ArrayList<Procedimento> procedimentos = new ArrayList<Procedimento>(); 
        for(Procedimento p: proc){
            if(p.getValor() >= v1 && p.getValor() < v2){
                procedimentos.add(p);
            }
        }
        return procedimentos;
    }
    

}
