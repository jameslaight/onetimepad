package upgrade;

import main.Fight;
import program.Rot1;

public class AddRot1 extends Upgrade {

	@Override
	public String getName() {
		return "rot1";
	}

	@Override
	public String getDescription() {
		return "(program) encrypts the gate with ROT1";
	}

	@Override
	public void apply(Fight fight) {
		fight.addProgram(new Rot1(fight));
	}

}
