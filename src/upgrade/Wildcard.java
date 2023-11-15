package upgrade;

import main.Fight;

public class Wildcard extends Upgrade {

	@Override
	public void apply(Fight fight) {
		fight.getClip().setWildcard(true);
	}

}
