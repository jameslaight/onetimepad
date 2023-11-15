package upgrade;

import main.Fight;
import program.Ngrm;

public class AddNgrm extends Upgrade {

	@Override
	public void apply(Fight fight) {
		fight.addProgram(new Ngrm(fight));
	}

}
