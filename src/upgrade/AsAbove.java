package upgrade;

import main.Fight;

public class AsAbove extends Upgrade {

	@Override
	public void apply(Fight fight) {
		for (char c = 'b'; c <= 'm'; c++) {
			if (c != 'e' && c != 'i') {
				fight.getClip().increment(c);
			}
		}
	}

}
