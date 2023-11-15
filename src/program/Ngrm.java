package program;

import main.Dictionary;
import main.Fight;

public class Ngrm extends Program {

	public Ngrm(Fight fight) {
		super(fight, true, "ngrm", "[word]: expend all characters from [word] to damage them in the gate." +
				"\n[word] must be a valid english word (2+ letters).");
	}

	@Override
	public Result execute(String[] args) {
		if (args.length != 1) return new Result(false, "expected 1 arg, got " + args.length);

		String word = args[0];

		if (!Dictionary.isWord(word, 2)) return new Result(false, "'" + word + "' is not a word");

		if (!fight.getClip().has(word)) return new Result(false, "'" + word + "' is not contained in the clip");

		if (!fight.getGate().has(word)) return new Result(false, "'" + word + "' is not contained in the gate");

		for (char c : word.toCharArray()) {
			fight.getGate().damageFirst(c);
			fight.getClip().decrement(c);
		}

		return new Result(true, "'" + word + "' destroyed");
	}

}
