package upgrade;

import main.Fight;

public class Vowels extends Upgrade {

	@Override
	public void apply(Fight fight) {
		for (char c : new char[] {'a', 'e', 'i', 'o', 'u'}) {
			fight.getClip().increment(c);
		}
	}

}
