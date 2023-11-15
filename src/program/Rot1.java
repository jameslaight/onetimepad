package program;

import main.Fight;

public class Rot1 extends Program {

	public Rot1(Fight fight) {
		super(fight, true, "rot1", "(no args): encrypt the gate with ROT1");
	}

	@Override
	public Result execute(String[] args) {
		if (args.length != 0) return new Result(false, "expected 0 args, got " + args.length);

		char[] code = fight.getGate().getCode();

		for (int i = 0; i < code.length; i++) {
			int ascii = code[i];

			if (ascii < 'a' || ascii > 'z') continue;

			ascii -= 'a';
			ascii = (ascii + 1) % 26;
			ascii += 'a';
			code[i] = (char) ascii;
		}

		return new Result(true, "encryption successful");
	}

}
