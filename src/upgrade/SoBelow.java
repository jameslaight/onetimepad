package upgrade;

import main.Fight;

public class SoBelow extends Upgrade {

	@Override
	public String getName() {
		return "so_below";
	}

	@Override
	public String getDescription() {
		return "(clip) upgrades NPQRSTVWXZ to be double use";
	}

	@Override
	public void apply(Fight fight) {
		for (char c = 'n'; c <= 'z'; c++) {
			if (c != 'o' && c != 'u' && c != 'y') {
				fight.getClip().increment(c);
			}
		}
	}

}
