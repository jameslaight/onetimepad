package upgrade;

import main.Fight;
import program.Repl;

public class AddRepl extends Upgrade {

	@Override
	public String getName() {
		return "repl";
	}

	@Override
	public String getDescription() {
		return "(program) replaces all of a character in the gate with another";
	}

	@Override
	public void apply(Fight fight) {
		fight.addProgram(new Repl(fight));
	}

}
