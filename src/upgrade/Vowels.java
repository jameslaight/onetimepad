package upgrade;

import main.Fight;

public class Vowels extends Upgrade {

	@Override
	public String getName() {
		return "vowels";
	}

	@Override
	public String getDescription() {
		return "(clip) upgrades AEIOUY to be double use";
	}

	@Override
	public void apply(Fight fight) {
		for (char c : new char[] {'a', 'e', 'i', 'o', 'u', 'y'}) {
			fight.getClip().increment(c);
		}
	}

}
