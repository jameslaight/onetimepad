package main;

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

		for (char c : word.toCharArray()) { //ensure clip has all characters in word
			if (!fight.getClip().has(c)) {
				return false;
			}
		}

		for (char c : word.toCharArray()) { //expend all characters in word
			fight.getClip().decrement(c);
		}

		return true;
	}

}
