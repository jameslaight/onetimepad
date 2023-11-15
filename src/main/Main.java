package main;

import program.Program;
import upgrade.*;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);

		List<Upgrade> upgrades = new ArrayList<>(); //all upgrades collected by the user
		List<Upgrade> shop = new ArrayList<>(List.of(
				new AddNgrm(),
				new AddR3rr(),
				new AddRepl(),
				new AddRot1(),
				new AddSnip(),
				new AsAbove(),
				new SoBelow(),
				new Vowels(),
				new Wildcard()
		)); //all upgrades that are yet to be acquired
		Collections.shuffle(shop); //these are given in a random order

		int maxLevel = 8;
		System.out.println("< WELCOME >" +
				"\nhack thru all " + maxLevel + " GATEs, formed of characters" +
				"\neach GATE you get letters a-z stored in your CLIP" +
				"\nuse the 'x [char] [word]' to destroy [char] in the GATE" +
				"\nbeware, [char] must be in [word] and all letters in [word] are removed from your CLIP" +
				"\n! REMEMBER 'PANIC' COMMAND TO ABORT IF A GATE TRAPS YOU !");

		int level = 1;
		loop:
		while (true) {
			System.out.println("\n< GATE " + level + "/" + maxLevel + " >");

			//region fight
			Fight fight = new Fight(level);

			upgrades.forEach(u -> u.apply(fight)); //apply upgrades to fight

			while (fight.getGate().isAlive()) {
				System.out.println("\nGATE: " + fight.getGate().getDisplay());
				System.out.println("CLIP: " + fight.getClip().getDisplay());

				StringBuilder builder = new StringBuilder("PRGM: ");
				boolean first = true;
				for (Program program : fight.getPrograms()) {
					if (first) first = false;
					else builder.append(", ");

					builder.append(program.getName());
				}
				System.out.println(builder);

				String input = scanner.nextLine();

				if (input.equals("PANIC")) {
					System.out.println("! PANIC SEQUENCE INITIATED, TERMINATING CONNECTION !");
					break loop;
				}

				String[] split = input.split(" ");

				String programName = split[0];
				String[] args = Arrays.copyOfRange(split, 1, split.length);

				boolean found = false;
				for (Program program : fight.getPrograms()) {
					if (!program.getName().equals(programName)) continue;

					Program.Result result = program.execute(args);

					System.out.println(program.getName() + " " + (result.success() ? "SUCCESS" : "FAILURE") + ": " + result.message());

					if (result.success() && program.isOneTimeUse()) { //most programs are one time use!
						fight.removeProgram(program);
					}

					found = true;
					break;
				}

				if (!found) {
					System.out.println("command not found");
				}
			}
			//endregion

			level++;

			if (level >= maxLevel) {
				break;
			}

			System.out.println("\n< VICTORY: CHOOSE INDEX OF AN UPGRADE >");

			//region upgrade
			List<Upgrade> offered = new ArrayList<>(); //upgrades that can be picked
			for (int i = 0; i < 2 && !shop.isEmpty(); i++) offered.add(shop.remove(0));

			if (!offered.isEmpty()) {
				for (int i = 0; i < offered.size(); i++) {
					Upgrade upgrade = offered.get(i);

					System.out.println("[" + i + "] " + upgrade.getName() + ": " + upgrade.getDescription());
				}

				int pick;
				while (true) {
					try {
						pick = Integer.parseInt(scanner.nextLine());

						if (pick >= 0 && pick < offered.size()) {
							break;
						}
					} catch (NumberFormatException ignored) {}

					System.out.println("Invalid input. Enter 0-" + (offered.size() - 1) + ".");
				}

				upgrades.add(offered.remove(pick));
				shop.addAll(offered); //remaining upgrades are placed on the end of the queue
			} else {
				System.out.println("No upgrades detected.");
			}
			//endregion
		}

		System.out.println();
		if (level == maxLevel) {
			System.out.println("< GRAND VICTORY >" +
					"\nsystem compromised.");
		} else {
			System.out.println("< PANIC INITIATED >" +
					"\nconnection terminated." +
					"\ndefeated by gate " + level + "/" + maxLevel);
		}

		System.out.println("upgrade list (" + upgrades.size() + "):");
		for (Upgrade upgrade : upgrades) {
			System.out.println("- " + upgrade.getName());
		}
	}

}
