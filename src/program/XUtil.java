package program;

import main.Dictionary;
import main.Fight;

public abstract class XUtil {

	public static Program.Result runX(String[] args, Fight fight, boolean cInWord) {
		if (args.length != 2) return new Program.Result(false, "expected 2 args, got " + args.length);

		String strTarget = args[0], word = args[1];

		if (!Dictionary.isWord(word)) return new Program.Result(false, "'" + word + "' is not a valid " + Dictionary.DEFAULT_MIN_LENGTH + "+ letter word"); //ensure word is valid word

		if (strTarget.length() != 1) return new Program.Result(false, "c must be a character");

		char target = strTarget.charAt(0);

		if (target < 'a' || target > 'z') return new Program.Result(false, "c must be a character between a-z");

		if (!fight.getClip().has(word)) return new Program.Result(false, "clip doesn't contain '" + word + "'"); //ensure clip has word

		if (!fight.getGate().has(target)) return new Program.Result(false, "gate doesn't contain '" + target + "'"); //ensure gate has target character

		if (cInWord && !word.contains(strTarget)) return new Program.Result(false, "'" + word + "' doesn't contain '" + target + "'"); //ensure word has target within it

		fight.getGate().damageFirst(target);

		for (char c : word.toCharArray()) { //expend all characters in word
			fight.getClip().decrement(c);
		}

		return new Program.Result(true, "destroyed '" + target + "' with '" + word + "'");
	}

}
