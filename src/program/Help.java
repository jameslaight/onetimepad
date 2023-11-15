package program;

import main.Fight;

public class Help extends Program {

	public Help(Fight fight) {
		super(fight, false, "help", " [program]: if you don't know how to use this command HOW ARE YOU READING THIS");
	}

	@Override
	public Result execute(String[] args) {
		if (args.length != 1) return new Result(false, "expected 1 arg, got " + args.length);

		for (Program program : fight.getPrograms()) {
			if (program.getName().equals(args[0])) {
				return new Result(true, "here's help for " + program.getName() + ":\n" + program.getUsage());
			}
		}

		return new Result(false, "program '" + args[0] + "' not found");
	}

}
