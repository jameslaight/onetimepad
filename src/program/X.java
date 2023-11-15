package program;

import main.Dictionary;
import main.Fight;

public class X extends Program { //needed to be short for a multiuse program, no inspiration taken from social media sites run by megalomaniacs

	public X(Fight fight) {
		super(fight, false, "x", "[c] [word]: expend all characters in [word] to damage first [c] in gate." +
				"\n[word] must be a valid english word (" + Dictionary.DEFAULT_MIN_LENGTH + "+ letters)." +
				"\n[c] must be in [word].");
	}

	@Override
	public Result execute(String[] args) {
		return XUtil.runX(args, fight, true);
	}

}
