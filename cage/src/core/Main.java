package core;

import gui.CAGEFrame;
import gui.menubar.Locales;

/**
 * @author k This class starts it all
 *
 */
public class Main {
	public static CAGEFrame raam;

	public static void main(String[] args) {
		Locales.Initiate();
		raam = new CAGEFrame();

		// TODO A single ruleset is temporary. It will have UI for options later.
		Ruleset rule = new Ruleset();
		rule.ReadFile("data/genetic_ruleset1.txt");
	}

}
