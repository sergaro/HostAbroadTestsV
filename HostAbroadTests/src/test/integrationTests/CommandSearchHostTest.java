package integrationTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.business.TUser;
import com.business.User;
import com.presentation.commands.CommandSearchHost;
import com.presentation.commands.Pair;

public class CommandSearchHostTest {
	private CommandSearchHost commandsh;

	@Test
	public void test() {
		this.commandsh = new CommandSearchHost();
		
		Pair<Integer, Object> par, par_comando;
		ArrayList<User> original = new ArrayList<User>();
		ArrayList<TUser> lista_comando;
		User yo = new User("Adri", 5, "estoy haciendo pruebas", true);
		
		/*
		//Para crear un nuevo host en la base de datos manualmente
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		em.persist(yo);
		tr.commit();
		
		em.close();
		emf.close();
		*/
		
		//añadir todos los hosts que haya en nuestra aplicacion
		original.add(yo);
		
		par = new Pair(1, original);
		//da igual lo que pases como transfer ya que esta funcion no lo utiliza
		par_comando = this.commandsh.execute(0);
		lista_comando = (ArrayList<TUser>) par_comando.getRight();
		
		assertEquals(par.getLeft(), par_comando.getLeft());
		for(int i = 0; i < original.size(); i++) {
			assertEquals(lista_comando.get(i).getNickname(), original.get(i).getNickname());
			assertEquals(lista_comando.get(i).getDescription(), original.get(i).getDescription());
			assertEquals(lista_comando.get(i).getRating(), original.get(i).getRating(), 2);
			assertEquals(lista_comando.get(i).getHost(), original.get(i).getHost());
		}
		
	}

}
