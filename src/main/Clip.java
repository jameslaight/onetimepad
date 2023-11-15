package main;

import java.util.HashMap;
import java.util.Map;

public class Clip {

	private final Map<Character, Integer> contents = new HashMap<>();

	public Clip() {
		for (char c = 'a'; c <= 'z'; c++) {
			contents.put(c, 1);
		}
	}

	public boolean has(char c) {
		return count(c) > 0;
	}

	public int count(char c) {
		return contents.getOrDefault(c, 0);
	}

	public void increment(char c) {
		contents.put(c, contents.getOrDefault(c, 0) + 1);
	}

	public void decrement(char c) {
		if (!has(c)) throw new IllegalArgumentException("Clip has no '" + c + "'s");

		contents.put(c, contents.getOrDefault(c, 0) - 1);
	}

	public String getDisplay() {
		StringBuilder builder = new StringBuilder();

		for (char c = 'a'; c <= 'z'; c++) {
			int count = contents.get(c);

			builder.append(switch (count) {
				case 0 -> '_';
				case 1 -> c;
				default -> Character.toUpperCase(c);
			});
		}

		return builder.toString();
	}

}
