package program;

import main.Dictionary;
import main.Fight;

public class R3rr extends Program {

	public R3rr(Fight fight) {
		super(fight, true, "r3rr", "[c] [word]: expend all characters in [word] to damage first [c] in gate." +
				"\n[word] must be a valid english word (" + Dictionary.DEFAULT_MIN_LENGTH + "+ letters).");
	}

	@Override
	public Result execute(String[] args) {
		return XUtil.runX(args, fight, false);
	}

}
