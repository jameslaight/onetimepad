package upgrade;

import main.Fight;

public class Wildcard extends Upgrade {

	@Override
	public String getName() {
		return "wildcard";
	}

	@Override
	public String getDescription() {
		return "(clip) adds one wildcard (*) to the clip";
	}

	@Override
	public void apply(Fight fight) {
		fight.getClip().setWildcard(true);
	}

}
