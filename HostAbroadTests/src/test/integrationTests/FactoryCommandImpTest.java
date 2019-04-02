package integrationTests;

import static org.junit.Assert.assertEquals;

import com.presentation.controller.FactoryCommand;
import com.presentation.controller.FactoryCommandImp;
import org.junit.Test;

import com.presentation.commands.*;

public class FactoryCommandImpTest {
	private FactoryCommandImp fcommand;
	
	@Test
	public void test() {
		this.fcommand = (FactoryCommandImp) FactoryCommand.getInstance();
		Command csh = new CommandSearchHost();
		Command csh_return = this.fcommand.parseCommand(CommandEnum.Commands.CommandSearchHost);
		
		csh.setEventReturn(0);
		
		assertEquals(csh.getEventReturn(), csh_return.getEventReturn());
	}

}
