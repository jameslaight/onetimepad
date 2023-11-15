package main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);

		for (int level = 1; level <= 10; level++) {
			Fight fight = new Fight(level);

			while (fight.getGate().isAlive()) {
				System.out.println(fight.getGate().getDisplay() + "\n");
				System.out.println(fight.getClip().getDisplay());

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
