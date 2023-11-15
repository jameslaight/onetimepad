package upgrade;

import main.Fight;
import program.Rot1;

public class AddRot1 extends Upgrade {

	@Override
	public void apply(Fight fight) {
		fight.addProgram(new Rot1(fight));
	}

}
