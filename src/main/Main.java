package main;

import program.Program;
import upgrade.AsAbove;
import upgrade.SoBelow;
import upgrade.Upgrade;
import upgrade.Vowels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);

		List<Upgrade> upgrades = new ArrayList<>(); //all upgrades collected by the user
		upgrades.add(new Vowels());
		upgrades.add(new AsAbove());
		upgrades.add(new SoBelow());

		for (int level = 1; level <= 10; level++) {
			Fight fight = new Fight(level);

			upgrades.forEach(u -> u.apply(fight)); //apply upgrades to fight

			while (fight.getGate().isAlive()) {
				System.out.println("GATE:\t" + fight.getGate().getDisplay());
				System.out.println("CLIP: " + fight.getClip().getDisplay());

				String[] split = scanner.nextLine().split(" ");
				String programName = split[0];
				String[] args = Arrays.copyOfRange(split, 1, split.length);

				for (Program program : fight.getPrograms()) {
					if (!program.getName().equals(programName)) continue;

					program.execute(args);
					break;
				}
			}
		}
	}

}
