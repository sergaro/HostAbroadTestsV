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
		ArrayList<TUser> aux = new ArrayList<TUser>();
		ArrayList<User> original = new ArrayList<User>();
		User yo = new User("Adri", 5, "estoy haciendo pruebas", true);
		
		this.assearch = (ASSearchImp) ASFactory.getInstance().createASSearch();
		
		/*
		//Para crear usuarios manualmente en la base de datos
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		em.persist(yo);
		tr.commit();
		
		em.close();
		emf.close();
		*/
		
		aux = this.assearch.searchHost();
		
		//añadir todos los hosts que haya en nuestra aplicacion
		original.add(yo);
		
		for(int i = 0; i < original.size(); i++) {
			assertEquals(aux.get(i).getNickname(), original.get(i).getNickname());
			assertEquals(aux.get(i).getDescription(), original.get(i).getDescription());
			assertEquals(aux.get(i).getRating(), original.get(i).getRating(), 2);
			assertEquals(aux.get(i).getHost(), original.get(i).getHost());
		}
		
	}

	
	@Test
	public void searchHostByNameTest() {
		ArrayList<TUser> aux = new ArrayList<TUser>();
		TUser yo = new TUser("Adri", 5, "estoy haciendo pruebas", true);
		TUser encontrado;
		
		this.assearch = (ASSearchImp) ASFactory.getInstance().createASSearch();
		
		/*
		//Para crear un usuario manualmente en la base de datos
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		em.persist(yo);
		tr.commit();
		
		em.close();
		emf.close();
		*/
		
		encontrado = this.assearch.searchHostByName("Adri");
		
		assertEquals(yo.getNickname(), encontrado.getNickname());
		assertEquals(yo.getDescription(), encontrado.getDescription());
		assertEquals(yo.getRating(), encontrado.getRating(), 2);
		assertEquals(yo.getHost(), encontrado.getHost());
	}
	
}
