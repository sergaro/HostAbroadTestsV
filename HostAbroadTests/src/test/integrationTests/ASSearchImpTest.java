package integrationTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.business.TUser;
import com.business.User;
import com.business.ASFactory.ASFactory;
import com.business.ASSearch.*;

public class ASSearchImpTest {
	private ASSearchImp assearch;
	
	@Test
	public void searchHostTest() { 
		ArrayList<TUser> returned = new ArrayList<TUser>();
		ArrayList<User> original = new ArrayList<User>();
		User yo = new User("Jose", 5, "pruebas para buscar un host", true, false);
		
		this.assearch = (ASSearchImp) ASFactory.getInstance().createASSearch();
		
		//Para crear usuarios manualmente en la base de datos
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
		
		returned = this.assearch.searchHost();
		
		//añadir todos los hosts que haya en nuestra aplicacion
		original.add(yo);
		
		for(int i = 0; i < original.size(); i++) {
			assertEquals(returned.get(i).getNickname(), original.get(i).getNickname());
			assertEquals(returned.get(i).getDescription(), original.get(i).getDescription());
			assertEquals(returned.get(i).getRating(), original.get(i).getRating(), 2);
			assertEquals(returned.get(i).getHost(), original.get(i).getHost());
			assertEquals(returned.get(i).getTraveler(), original.get(i).getTraveler());
		}
		
	}

	@Test
	public void searchHostByNameTest() {
		User yo = new User("Jose", 5, "pruebas para buscar un host", true, false);
		TUser returned;
		
		this.assearch = (ASSearchImp) ASFactory.getInstance().createASSearch();
		
		//Para crear un usuario manualmente en la base de datos
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
		
		returned = this.assearch.searchHostByName("Jose");
		
		assertEquals(yo.getNickname(), returned.getNickname());
		assertEquals(yo.getDescription(), returned.getDescription());
		assertEquals(yo.getRating(), returned.getRating(), 2);
		assertEquals(yo.getHost(), returned.getHost());
		assertEquals(yo.getTraveler(), returned.getTraveler());
	}
	
}
