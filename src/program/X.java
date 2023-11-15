package program;

import main.Fight;

import java.util.HashMap;
import java.util.Map;

public class X extends Program { //needed to be short for a multiuse program, no inspiration taken from social media sites run by megalomaniacs

	public X(Fight fight) {
		super(fight, "x");
	}

	@Override
	public boolean execute(String[] args) {
		if (args.length != 2) return false;

		String strTarget = args[0], word = args[1];

		if (strTarget.length() != 1) return false;

		char target = strTarget.charAt(0);

		if (!fight.getGate().has(target)) return false; //ensure target has target character

		if (!word.contains(strTarget)) return false; //ensure word has target within it

		Map<Character, Integer> charCounts = new HashMap<>();
		for (char c : word.toCharArray()) { //count characters
			charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
		}

		for (char c : charCounts.keySet()) { //ensure enough characters in clip
			if (charCounts.get(c) > fight.getClip().count(c)) {
				return false;
			}
		}

		fight.getGate().damageFirst(target);

		for (char c : word.toCharArray()) { //expend all characters in word
			fight.getClip().decrement(c);
		}

		return true;
	}

}
