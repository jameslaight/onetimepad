package main;

import java.util.*;

public class Gate {

	private final char[] code;

	public Gate(int difficulty) {
		code = new char[3 + difficulty];

		List<Character> pool = new ArrayList<>();
		for (char c = 'a'; c <= 'z'; c++) pool.add(c);
		Collections.shuffle(pool);

		for (int i = 0; i < code.length; i++) {
			code[i] = pool.get(i);
		}
	}

}
