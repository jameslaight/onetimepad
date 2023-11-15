package upgrade;

import main.Fight;
import program.Snip;

public class AddSnip extends Upgrade {

	@Override
	public void apply(Fight fight) {
		fight.addProgram(new Snip(fight));
	}

}
