package core;

import gui.CAGEFrame;
import gui.menubar.Locales;

/**
 * @author k This class starts it all
 *
 */
public class Main {
	public static CAGEFrame raam;

	public static void main (String[] args) {
		Locales.Initiate();
		raam = new CAGEFrame();
	}

}
