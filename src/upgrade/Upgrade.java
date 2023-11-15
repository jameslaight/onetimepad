package upgrade;

import main.Fight;

public abstract class Upgrade {

	public abstract String getName();

	public abstract String getDescription();

	public abstract void apply(Fight fight);

}
