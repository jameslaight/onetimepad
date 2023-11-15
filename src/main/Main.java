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
				new AddRepl(),
				new AddRot1(),
				new AddSnip(),
				new AsAbove(),
				new SoBelow(),
				new Vowels()
		)); //all upgrades that are yet to be acquired
		Collections.shuffle(shop); //these are given in a random order

		for (int level = 1; level <= 10; level++) {
			Fight fight = new Fight(level);

			upgrades.forEach(u -> u.apply(fight)); //apply upgrades to fight

			while (fight.getGate().isAlive()) {
				System.out.println("GATE:\t" + fight.getGate().getDisplay());
				System.out.println("CLIP: " + fight.getClip().getDisplay());

				String[] split = scanner.nextLine().split(" ");
				String programName = split[0];
				String[] args = Arrays.copyOfRange(split, 1, split.length);

				boolean found = false;
				for (Program program : fight.getPrograms()) {
					if (!program.getName().equals(programName)) continue;

					Program.Result result = program.execute(args);

					System.out.println(program.getName() + " " + (result.success() ? "SUCCESS" : "FAILURE") + ": " + result.message());

					found = true;
					break;
				}

				if (!found) {
					System.out.println("no command found");
				}
			}

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
		}
	}

}
