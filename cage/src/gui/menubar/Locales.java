package gui.menubar;

import java.awt.im.InputContext;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Handles locale bundles
 *
 */
public class Locales {
	public static ResourceBundle mainBundle;
	public static ResourceBundle tipBundle;
	public static ResourceBundle errBundle;
	public static ResourceBundle characteristicsBundle;
	public static Locale currentLocale;

	public static void Initiate() {
		// Should select the locale currently used in OS
		try {
			Locales.currentLocale = InputContext.getInstance().getLocale();
		} catch (Exception e1) {
			Locales.currentLocale = new Locale("en", "US");
		}

		initResourceBundles();

	}

	public static void initResourceBundles() {
		try {
			Locales.mainBundle = ResourceBundle.getBundle(
					"Locale.MainBundle", Locales.currentLocale);
			Locales.tipBundle = ResourceBundle
					.getBundle("Locale.Tooltips.TooltipBundle",
							Locales.currentLocale);
			Locales.errBundle = ResourceBundle.getBundle(
					"Locale.ErrorMessages.ErrorMessageBundle",
					Locales.currentLocale);
			Locales.characteristicsBundle = ResourceBundle.getBundle(
					"Locale.Characteristics.CharacteristicsBundle",
					Locales.currentLocale);
		} catch (Exception e2) {
			// TODO error standardisation
			e2.printStackTrace();
		}
	}

}
