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
		
		Pair<Integer, Object> pair, command_pair;
		ArrayList<User> original_list = new ArrayList<User>();
		ArrayList<TUser> command_list;
		User yo = new User("Jose", 5, "pruebas para buscar un host", true, false);
		
		//Para crear un nuevo host en la base de datos manualmente
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tr = em.getTransaction();
//		tr.begin();
//		
//		em.persist(yo);
//		tr.commit();
//		
//		em.close();
//		emf.close();
		
		//añadir todos los hosts que haya en nuestra aplicacion
		original_list.add(yo);
		
		pair = new Pair(1, original_list);
		//da igual lo que pases como transfer ya que esta funcion no lo utiliza
		command_pair = this.commandsh.execute(0);
		command_list = (ArrayList<TUser>) command_pair.getRight();
		
		assertEquals(pair.getLeft(), command_pair.getLeft());
		for(int i = 0; i < original_list.size(); i++) {
			assertEquals(command_list.get(i).getNickname(), original_list.get(i).getNickname());
			assertEquals(command_list.get(i).getDescription(), original_list.get(i).getDescription());
			assertEquals(command_list.get(i).getRating(), original_list.get(i).getRating(), 2);
			assertEquals(command_list.get(i).getHost(), original_list.get(i).getHost());
			assertEquals(command_list.get(i).getTraveler(), original_list.get(i).getTraveler());
		}
		
	}

}
