package br.edu.ifrs.restinga.daione.lista03.Lista03;

import br.edu.ifrs.restinga.daione.lista03.Lista03.Entity.Emprestimo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Lista03ApplicationTests {

	@Test
	public void contextLoads() {
            Emprestimo emprestimo = new Emprestimo(); 
            
            emprestimo.setRetirada(emprestimo.getRetirada());
            System.out.println("Emprestimo == data ==> "+ emprestimo.getRetirada());
            emprestimo.setDevolucaoPrevisao();
        }

}
