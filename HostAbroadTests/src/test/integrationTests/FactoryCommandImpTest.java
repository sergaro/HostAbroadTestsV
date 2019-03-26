package integrationTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.presentation.commands.*;
import com.presentation.commands.CommandEnum.Commands;
import com.presentation.controller.FactoryCommand;
import com.presentation.controller.FactoryCommandImp;

public class FactoryCommandImpTest {
	private FactoryCommandImp fcommand;
	
	@Test
	public void test() {
		this.fcommand = (FactoryCommandImp) FactoryCommand.getInstance();
		Command csh = new CommandSearchHost();
		Command csh_return = this.fcommand.parseCommand(Commands.CommandSearchHost);
		
		csh.setEventReturn(0);
		
		assertEquals(csh.getEventReturn(), csh_return.getEventReturn());
	}

}
