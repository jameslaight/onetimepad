package program;

import main.Fight;

public class Snip extends Program {

	public Snip(Fight fight) {
		super(fight, "snip");
	}

	@Override
	public boolean execute(String[] args) {
		if (args.length != 1) return false;

		String strTarget = args[0];

		if (strTarget.length() != 1) return false;

		char target = strTarget.charAt(0);

		if (!fight.getClip().has(target)) return false; //ensure clip has target character

		if (!fight.getGate().has(target)) return false; //ensure gate has target character

		fight.getGate().damageFirst(target);
		fight.getClip().decrement(target);

		return true;
	}

}
