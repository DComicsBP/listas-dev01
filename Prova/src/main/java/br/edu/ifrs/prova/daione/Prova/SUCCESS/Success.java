package br.edu.ifrs.prova.daione.Prova.SUCCESS;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author dayon
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class Success extends RuntimeException {

    public Success(String mensagem) {
        super(mensagem);
    }

}
