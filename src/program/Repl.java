package program;

import main.Fight;

public class Repl extends Program {

	public Repl(Fight fight) {
		super(fight, "repl", "[a] [b]: replace all [a] characters in the gate with [b]");
	}

	@Override
	public Result execute(String[] args) {
		if (args.length != 2) return new Result(false, "expected 2 args, got " + args.length);

		String aStr = args[0], bStr = args[1];

		if (aStr.length() != 1 || bStr.length() != 1) return new Result(false, "args must be characters");

		char a = aStr.charAt(0), b = bStr.charAt(0);

		if (a < 'a' || a > 'z') return new Result(false, "a must be a character between a-z");
		if (b < 'a' || b > 'z') {
			if (b == '_') return new Result(false, "very clever. unfortunately, no");
			else return new Result(false, "b must be a character between a-z");
		}

		int replaced = 0;
		char[] code = fight.getGate().getCode();
		for (int i = 0; i < code.length; i++) {
			if (code[i] == a) {
				code[i] = b;

				replaced++;
			}
		}

		if (replaced == 0) return new Result(false, "no replacements made"); //if no replacements happened, fail

		return new Result(true, replaced + " replacement" + (replaced != 1 ? "s" : "") + " made");
	}

}
