package upgrade;

import main.Fight;

public class Vowels extends Upgrade {

	@Override
	public void apply(Fight fight) {
		for (char c : new char[] {'a', 'e', 'i', 'o', 'u', 'y'}) {
			fight.getClip().increment(c);
		}
	}

}
