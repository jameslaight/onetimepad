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
		if (args.length != 2) return new Result(false, "expected 2 args, got " + args.length);

		String strTarget = args[0], word = args[1];

		if (!Dictionary.isWord(word)) return new Result(false, "'" + word + "' is not a valid " + Dictionary.DEFAULT_MIN_LENGTH + "+ letter word"); //ensure word is valid word

		if (strTarget.length() != 1) return new Result(false, "c must be a character");

		char target = strTarget.charAt(0);

		if (target < 'a' || target > 'z') return new Result(false, "c must be a character between a-z");

		if (!fight.getClip().has(word)) return new Result(false, "clip doesn't contain '" + word + "'"); //ensure clip has word

		if (!fight.getGate().has(target)) return new Result(false, "gate doesn't contain '" + target + "'"); //ensure gate has target character

		if (!word.contains(strTarget)) return new Result(false, "'" + word + "' doesn't contain '" + target + "'"); //ensure word has target within it

		fight.getGate().damageFirst(target);

		for (char c : word.toCharArray()) { //expend all characters in word
			fight.getClip().decrement(c);
		}

		return new Result(true, "destroyed '" + target + "' with '" + word + "'");
	}

}
