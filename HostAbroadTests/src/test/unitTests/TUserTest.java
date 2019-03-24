package unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.business.TUser;
import com.business.User;

public class TUserTest {
	private TUser myUser;

	@Test
	public void test() {
		TUser aux;
		this.myUser = new TUser("Adri", 5, "pruebas para buscar un viajero", false, true);
		
		aux = new TUser("Jose", 2, "este se modifica", true, false);
		
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
