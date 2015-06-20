package kassid_rt13oop_tg_kal;

import gui.Kassiraam;
import gui.Locales;

/**
 * @author k This class starts it all
 *
 */
public class Main {
	public static Kassiraam raam;

	public static void main(String[] args) {
		Locales.Initiate();
		raam = new Kassiraam();

		// TODO this is temporary. will have UI for options.
		Ruleset rule = new Ruleset();
		rule.ReadFile("data/genetic_ruleset1.txt");
	}

}
