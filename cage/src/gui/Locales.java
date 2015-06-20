package gui;

import java.awt.im.InputContext;
import java.util.Locale;
import java.util.ResourceBundle;

public class Locales {
	public static ResourceBundle mainbundle;
	public static ResourceBundle tipbundle;
	public static ResourceBundle errbundle;
	public static Locale currentLocale;

	public static void Initiate() {
		// Should select the locale currently used in OS
		try {
			Locales.currentLocale = InputContext.getInstance().getLocale();
		} catch (Exception e1) {
			Locales.currentLocale = new Locale("en", "GB");
		}

		initResourceBundles();

	}
	
	public static void initResourceBundles() {
		try {
			Locales.mainbundle = ResourceBundle.getBundle("kassid_rt13oop_tg_kal.Locale.MainBundle", Locales.currentLocale);
			Locales.tipbundle = ResourceBundle.getBundle("kassid_rt13oop_tg_kal.Locale.Tooltips.TooltipBundle", Locales.currentLocale);
			Locales.errbundle = ResourceBundle.getBundle( "kassid_rt13oop_tg_kal.Locale.ErrorMessages.ErrorMessageBundle", Locales.currentLocale);
		} catch (Exception e2) {
			//TODO error standardisation
			e2.printStackTrace();
		}
	}

}
