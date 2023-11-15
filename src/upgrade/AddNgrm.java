package upgrade;

import main.Fight;
import program.Ngrm;

public class AddNgrm extends Upgrade {

	@Override
	public String getName() {
		return "ngrm";
	}

	@Override
	public String getDescription() {
		return "(program) destroys anagrams (min length 2) found in the gate";
	}

	@Override
	public void apply(Fight fight) {
		fight.addProgram(new Ngrm(fight));
	}

}
