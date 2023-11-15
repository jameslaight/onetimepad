package main;

import java.util.*;

public class Gate {

	private final char[] code;

	public Gate(int difficulty) {
		code = new char[3 + difficulty * 2];

		List<Character> pool = new ArrayList<>();
		boolean q = new Random().nextBoolean(); //if true, q is added, else u is added (these are effectively the same character)
		for (char c = 'a'; c <= 'z'; c++) {
			if (c == 'q' && !q || c == 'u' && q) continue; //checks for adding correct character based on 'q'

			pool.add(c);
		}
		Collections.shuffle(pool);

		for (int i = 0; i < code.length; i++) {
			code[i] = pool.get(i);
		}
	}

	public boolean has(char target) {
		for (char c : code) {
			if (c == target) {
				return true;
			}
		}

		return false;
	}

	public boolean has(String s) {
		Map<Character, Integer> charCounts = new HashMap<>();
		for (char c : s.toCharArray()) { //count characters
			charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
		}

		for (char c : charCounts.keySet()) { //ensure enough characters in gate
			if (charCounts.get(c) > count(c)) {
				return false;
			}
		}

		return true;
	}

	public int count(char target) {
		int count = 0;

		for (char c : code) {
			if (c == target) {
				count++;
			}
		}

		return count;
	}

	public boolean damageFirst(char target) {
		for (int i = 0; i < code.length; i++) {
			char c = code[i];

			if (c == target) {
				code[i] = '_';

				return true;
			}
		}

		return false;
	}

	public boolean isAlive() {
		for (char c : code) {
			if (c != '_') {
				return true;
			}
		}

		return false;
	}

	public char[] getCode() {
		return code;
	}

	public String getDisplay() {
		StringBuilder builder = new StringBuilder();

		builder.append(">  > >> ");
		for (char c : code) builder.append(c).append(" ");
		builder.append("<< <  <");

		return builder.toString();
	}

}
