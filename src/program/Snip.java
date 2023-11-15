package program;

import main.Fight;

public class Snip extends Program {

	public Snip(Fight fight) {
		super(fight, true, "snip", "[c]: expend [c] to destroy first [c] in the gate");
	}

	@Override
	public Result execute(String[] args) {
		if (args.length != 1) return new Result(false, "expected 1 arg, got " + args.length);

		String strTarget = args[0];

		if (strTarget.length() != 1) return new Result(false, "arg must be a character");

		char target = strTarget.charAt(0);

		if (target < 'a' || target > 'z') return new Result(false, "arg must be a character between a-z");

		if (!fight.getClip().has(target)) return new Result(false, "clip does not have '" + target + "'"); //ensure clip has target character

		if (!fight.getGate().has(target)) return new Result(false, "gate does not have '" + target + "'"); //ensure gate has target character

		fight.getGate().damageFirst(target);
		fight.getClip().decrement(target);

		return new Result(true, "snip'd " + target);
	}

}
