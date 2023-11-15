package program;

import main.Fight;

public class Rot1 extends Program {

	public Rot1(Fight fight) {
		super(fight, "rot1");
	}

	@Override
	public boolean execute(String[] args) {
		if (args.length != 0) return false;

		char[] code = fight.getGate().getCode();

		for (int i = 0; i < code.length; i++) {
			int ascii = code[i];
			ascii -= 'a';
			ascii = (ascii + 1) % 26;
			ascii += 'a';
			code[i] = (char) ascii;
		}

		return true;
	}

}
