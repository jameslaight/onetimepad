package program;

import main.Fight;

public class Repl extends Program {

	public Repl(Fight fight) {
		super(fight, "repl");
	}

	@Override
	public boolean execute(String[] args) {
		if (args.length != 2) return false;

		String aStr = args[0], bStr = args[1];

		if (aStr.length() != 1 || bStr.length() != 1) return false;

		char a = aStr.charAt(0), b = bStr.charAt(0);

		boolean replaced = false;
		char[] code = fight.getGate().getCode();
		for (int i = 0; i < code.length; i++) {
			if (code[i] == a) {
				code[i] = b;

				replaced = true;
			}
		}

		if (!replaced) return false; //if no replacements happened, fail

		return true;
	}

}
