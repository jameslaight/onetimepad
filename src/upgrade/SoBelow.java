package upgrade;

import main.Fight;

public class SoBelow extends Upgrade {

	@Override
	public void apply(Fight fight) {
		for (char c = 'n'; c <= 'z'; c++) {
			if (c != 'o' && c != 'u' && c != 'y') {
				fight.getClip().increment(c);
			}
		}
	}

}
