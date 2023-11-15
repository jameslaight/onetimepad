package upgrade;

import main.Fight;

public class AsAbove extends Upgrade {

	@Override
	public String getName() {
		return "as_above";
	}

	@Override
	public String getDescription() {
		return "(clip) upgrades BCDFGHJKLM to be double use";
	}

	@Override
	public void apply(Fight fight) {
		for (char c = 'b'; c <= 'm'; c++) {
			if (c != 'e' && c != 'i') {
				fight.getClip().increment(c);
			}
		}
	}

}
