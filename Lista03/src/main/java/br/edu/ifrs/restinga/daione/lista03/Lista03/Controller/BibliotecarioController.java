/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.daione.lista03.Lista03.Controller;

import br.edu.ifrs.restinga.daione.lista03.Lista03.Commons.Commons;
import br.edu.ifrs.restinga.daione.lista03.Lista03.DAO.BibliotecarioDAO;
import br.edu.ifrs.restinga.daione.lista03.Lista03.ERRORS.ERROR400;
import br.edu.ifrs.restinga.daione.lista03.Lista03.ERRORS.ERROR500;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Bibliotecario;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.security.*;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dayon
 */
@RestController
public class BibliotecarioController {
    
    @Autowired
    BibliotecarioDAO dao;
    
    @RequestMapping(path = "/bibliotecarios/", method = RequestMethod.GET)
    public Iterable<Bibliotecario> getBiliotecarios() {
        Iterable<Bibliotecario> biblio = dao.findAll();
        if (dao.findAll() != null) {
            return biblio;

        } else {
            throw new ERROR400("Deu ruim");
        }
    }

    @RequestMapping(path = "/bibliotecarios/{id}", method = RequestMethod.GET)
    public Optional<Bibliotecario> getBiliotecario(@PathVariable Integer id) {
        Optional<Bibliotecario> b = dao.findById(id);
        ArrayList<Integer> ids;
        ids = new ArrayList<>();
        boolean flag = false;
        Iterable<Bibliotecario> biblio = getBiliotecarios();

        if (biblio != null) {
            for (Bibliotecario bi : biblio) {
                ids.add((Integer) bi.getID());
                System.out.println("IDS ++++>>" + (Integer) bi.getID());
                if ((Integer) bi.getID() == id) {
                    flag = true;
                }
            }   
            if (flag) {
                return b;
            } else {
                throw new ERROR500("Não existem informações contendo esse ID ");
            }

        } else {
            throw new ERROR400("BAD REQUEST");

        }

    }

    @RequestMapping(path = "/bibliotecarios/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Bibliotecario inserir(@RequestBody Bibliotecario bibliotecario) {
    Commons commons = new Commons(); 

        Bibliotecario b = new Bibliotecario();
       // boolean flag =  commons.checkEmail(bibliotecario); 

        if (flag) {
            throw new ERROR400("Você informou um email já existente em nossa base de dados. Por favor informe outro email diferente de: " + bibliotecario.getEmail());
        } else {
            if (bibliotecario.getSenha().length() >= 8) {
                b.setID(0);
                b = dao.save(bibliotecario);
            } else {
                throw new ERROR400("Você não inseriu uma senha válida: maior que 8 dígitos");
            }
        }
        return b;
    }

    @RequestMapping(path = "/bibliotecarios/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void apagar(@PathVariable int id) {
        if (dao.existsById(id)) {
            dao.deleteById(id);
        } else {
            throw new ERROR400("Não encontrado");
        }
    }

    @RequestMapping(path = "/bibliotecarios/{id}", method = RequestMethod.PUT)
    public void atualizaBibliotecario(@PathVariable Integer id, @RequestBody Bibliotecario bibliotecario) {
        Commons commons = new Commons(); 
        boolean flag = commons.checkEmail(bibliotecario);
        if (flag) {
            throw new ERROR400("Você informou um email já existente em nossa base de dados. Por favor informe outro email diferente de: " + bibliotecario.getEmail());
        }
        if (dao.existsById(id)) {
            bibliotecario.setID(id);
            dao.save(bibliotecario);
        } else {
            throw new ERROR400("Não encontrado");
        }

    }

    public String makeHash(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(senha.getBytes("ASCII"));
        byte[] passwordDigest = digest.digest();
        String hexString = new BigInteger(1, digest.digest()).toString(16);
        System.out.println("hexString ===>" + hexString);
        return hexString;
    }

    
}
