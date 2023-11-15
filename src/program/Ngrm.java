package program;

import main.Dictionary;
import main.Fight;

public class Ngrm extends Program {

	public Ngrm(Fight fight) {
		super(fight, "ngrm");
	}

	@Override
	public boolean execute(String[] args) {
		if (args.length != 1) return false;

		String word = args[0];

		if (!Dictionary.isWord(word)) return false;

		if (!fight.getClip().has(word)) return false;

		if (!fight.getGate().has(word)) return false;

		for (char c : word.toCharArray()) {
			fight.getGate().damageFirst(c);
			fight.getClip().decrement(c);
		}

		return true;
	}

}
