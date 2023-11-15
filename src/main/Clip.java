package main;

import java.sql.RowIdLifetime;
import java.util.HashMap;
import java.util.Map;

public class Clip {

	private final Map<Character, Integer> contents = new HashMap<>();
	private boolean wildcard = false;

	public Clip() {
		for (char c = 'a'; c <= 'z'; c++) {
			contents.put(c, 1);
		}
	}

	public boolean has(char c) {
		return wildcard || count(c) > 0;
	}

	public boolean has(String s) {
		boolean hasWildcard = wildcard;

		Map<Character, Integer> charCounts = new HashMap<>();
		for (char c : s.toCharArray()) { //count characters
			charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
		}

		for (char c : charCounts.keySet()) { //ensure enough characters in clip
			int surplus = count(c) - charCounts.get(c);

			if (surplus < 0) {
				if (surplus == -1 && hasWildcard) {
					hasWildcard = false;
				} else {
					return false;
				}
			}
		}

		return true;
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

	public void setWildcard(boolean wildcard) {
		this.wildcard = wildcard;
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

		if (wildcard) builder.append("*");

		return builder.toString();
	}

}
