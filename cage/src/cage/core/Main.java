package cage.core;

import cage.gui.CAGEFrame;
import cage.gui.menubar.Locales;

/**
 * @author k This class starts it all
 *
 */
public class Main {
	public static CAGEFrame raam;

	public static void main(String[] args) {
		Locales.Initiate();
		raam = new CAGEFrame();

		// TODO this is temporary. will have UI for options.
		Ruleset rule = new Ruleset();
		rule.ReadFile("data/genetic_ruleset1.txt");
	}

}
