package upgrade;

import main.Fight;
import program.Repl;

public class AddRepl extends Upgrade {

	@Override
	public void apply(Fight fight) {
		fight.addProgram(new Repl(fight));
	}

}
