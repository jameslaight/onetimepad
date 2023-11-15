package program;

import main.Dictionary;
import main.Fight;

public class Mu2t extends Program {

	private static final int PENALTY = 3;

	public Mu2t(Fight fight) {
		super(fight, true, "mu2t", "[c] [word]: expend all characters in [word], destroying first (n - 3) [c] characters in the gate (where n is the length of [word]. \n[word] must be a valid english word. \n[c] must be in [word].");
	}

	@Override
	public Result execute(String[] args) {
		if (args.length != 2) return new Result(false, "expected 2 args, got " + args.length);

		String strTarget = args[0], word = args[1];

		int minLength = PENALTY + 1;
		if (!Dictionary.isWord(word)) return new Result(false, "'" + word + "' is not a valid " + minLength + "+ letter word"); //ensure word is valid word

		if (strTarget.length() != 1) return new Result(false, "c must be a character");

		char target = strTarget.charAt(0);

		if (target < 'a' || target > 'z') return new Result(false, "c must be a character between a-z");

		if (!fight.getClip().has(word)) return new Result(false, "clip doesn't contain '" + word + "'"); //ensure clip has word

		if (!word.contains(strTarget)) return new Result(false, "'" + word + "' doesn't contain '" + target + "'"); //ensure word has target within it

		for (char c : word.toCharArray()) {
			fight.getClip().decrement(c);
		}

		int count = word.length() - PENALTY;
		for (int i = 0; i < count; i++) {
			fight.getGate().damageFirst(target);
		}

		return new Result(true, "destroyed " + count + " '" + target + (count != 1 ? "s" : ""));
	}

}
