package integrationTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.presentation.controller.Controller;
import com.presentation.controller.ControllerImp;
import com.business.TUser;
import com.business.User;
import com.presentation.commands.*;
import com.presentation.commands.CommandEnum.Commands;

public class ControllerImpTest {
	private ControllerImp controlador;

	@Test
	public void actionTest() {
		this.controlador = (ControllerImp) Controller.getInstance();
		Pair<Integer, Object> pair, command_pair;
		ArrayList<User> host_original = new ArrayList<User>();
		ArrayList<TUser> command_list;
		
		User host = new User("Jose", 5, "pruebas para buscar un host", true, false);
		
		/*
		//Para crear un nuevo host manualmente 
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
		host_original.add(host);
		
		pair = new Pair(1, host_original);
		//da igual lo que pases como transfer ya que esta funcion no lo utiliza
		command_pair = this.controlador.action(Commands.CommandSearchHost, 0);
		command_list = (ArrayList<TUser>) command_pair.getRight();
		
		assertEquals(pair.getLeft(), command_pair.getLeft());
		for(int i = 0; i < host_original.size(); i++) {
			assertEquals(command_list.get(i).getNickname(), host_original.get(i).getNickname());
			assertEquals(command_list.get(i).getDescription(), host_original.get(i).getDescription());
			assertEquals(command_list.get(i).getRating(), host_original.get(i).getRating(), 2);
			assertEquals(command_list.get(i).getHost(), host_original.get(i).getHost());
			assertEquals(command_list.get(i).getTraveler(), host_original.get(i).getTraveler());
		}
	}
	
}
