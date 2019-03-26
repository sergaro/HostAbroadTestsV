package unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.business.User;

import junit.framework.Assert;

public class UserTest {
	private User myUser;

	@Test
	public void test() {
		User aux;
		this.myUser = new User("Adri", 5, "pruebas para buscar un viajero", false, true);
		
		aux = new User("Jose", 2, "este se modifica", true, false);
		
		aux.setNickname("Adri");
		assertEquals(aux.getNickname(), this.myUser.getNickname());
		
		aux.setRating(5);
		assertEquals(aux.getRating(), this.myUser.getRating(), 2);
		
		aux.setDescription("pruebas para buscar un viajero");
		assertEquals(aux.getDescription(), this.myUser.getDescription());
		
		aux.setHost(false);
		assertEquals(aux.getHost(), this.myUser.getHost());
		
		aux.setTraveler(true);
		assertEquals(aux.getTraveler(), this.myUser.getTraveler());
		
	}

}
