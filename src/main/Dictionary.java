package main;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Dictionary {

	private static int DEFAULT_MIN_LENGTH = 4;

	private static boolean loaded = false;
	private static final Set<String> words = new HashSet<>();

	public static boolean isWord(String word, int minLength) {
		if (!loaded) {
			try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
				reader.lines().forEach(words::add);

				loaded = true;
			} catch (IOException e) {
				throw new RuntimeException("words.txt failed to load.");
			}
		}

		return word.length() >= minLength && words.contains(word);
	}

	public static boolean isWord(String word) {
		return isWord(word, DEFAULT_MIN_LENGTH);
	}

}
