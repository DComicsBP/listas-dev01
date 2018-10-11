package br.edu.ifrs.restinga.daione.lista03.Lista03.Commons;

import br.edu.ifrs.restinga.daione.lista03.Lista03.Controller.BibliotecarioController;
import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Bibliotecario;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author dayon
 */
public class Commons {
    
    public String makeHash(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(senha.getBytes("ASCII"));
        byte[] passwordDigest = digest.digest();
        String hexString = new BigInteger(1, digest.digest()).toString(16);
        System.out.println("hexString ===>" + hexString);
        return hexString;
    }

    public boolean checkEmail(Bibliotecario bibliotecario) {
        Iterable<Bibliotecario> biblio = new BibliotecarioController().getBiliotecarios();
        ArrayList<String> emails;
        emails = new ArrayList<String>();
        boolean flag = false;

        if (biblio != null) {
            for (Bibliotecario bi : biblio) {
                emails.add(bi.getEmail());
                if (bi.getEmail() == bibliotecario.getEmail()) {
                    flag = true;
                }
            }
        }

        return flag;
    }
    
    
}
