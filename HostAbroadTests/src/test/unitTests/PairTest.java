package unitTests;

import static org.junit.Assert.assertEquals;

import com.presentation.commands.Pair;
import org.junit.Test;



public class PairTest {
	private Pair par;

	@Test
	public void test() {
		this.par = new Pair(1, "Adri");
		
		assertEquals(1, this.par.getLeft());
		assertEquals("Adri", par.getRight());
	}

}
