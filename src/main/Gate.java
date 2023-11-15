package main;

import java.util.*;

public class Gate {

	private final char[] code;

	public Gate(int difficulty) {
		Random random = new Random();
		List<Character> chars = new ArrayList<>();

		List<Character> notAdded = new ArrayList<>();
		for (char c = 'a'; c <= 'z'; c++) {
			if (c != 'q') notAdded.add(c);
		}

		for (int i = 0; i < difficulty + 3; i++) {
			char added = notAdded.remove(random.nextInt(notAdded.size()));
			chars.add(added);
		}

		int hard = difficulty / 2;
		for (int i = 0; i < hard; i++) {
			char added;
			if (random.nextInt(5) == 0) added = 'q';
			else added = chars.get(random.nextInt(chars.size()));

			chars.add(added);
		}

		Collections.shuffle(chars);

		code = new char[chars.size()];
		for (int i = 0; i < chars.size(); i++) {
			code[i] = chars.get(i);
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
