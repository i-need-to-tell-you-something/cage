package kassid_rt13oop_tg_kal;

import java.awt.im.InputContext;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
	public static ResourceBundle mainbundle;
	public static ResourceBundle tipbundle;
	public static ResourceBundle errbundle;
	public static Locale currentLocale;
	public static Kassiraam raam;

	public static void main(String[] args) {
		
		// peaks valima (windowsi?) hetkel kasutuses oleva lokaadi
		try {
			currentLocale = InputContext.getInstance().getLocale();
		} catch (Exception e1) {
			currentLocale = new Locale("en", "GB");
		}
		loadLocale(currentLocale);
//		try {
//			mainbundle = ResourceBundle.getBundle("kassid_rt13oop_tg_kal.Locale.MainBundle", currentLocale);
//			tipbundle = ResourceBundle.getBundle("kassid_rt13oop_tg_kal.Locale.Tooltips.TooltipBundle", currentLocale);
//			errbundle = ResourceBundle.getBundle( "kassid_rt13oop_tg_kal.Locale.ErrorMessages.ErrorMessageBundle", currentLocale);
//		} catch (Exception e2) {
//			e2.printStackTrace();
//		}
		
		raam = new Kassiraam();
		// raam.setSize(500, 500);
		raam.pack();
		raam.setLocation(100, 0);
		raam.setVisible(true);
	}
	
	public static void loadLocale(Locale mainLocale) {

		try {
			mainbundle = ResourceBundle.getBundle("kassid_rt13oop_tg_kal.Locale.MainBundle", mainLocale);
			tipbundle = ResourceBundle.getBundle("kassid_rt13oop_tg_kal.Locale.Tooltips.TooltipBundle", mainLocale);
			errbundle = ResourceBundle.getBundle( "kassid_rt13oop_tg_kal.Locale.ErrorMessages.ErrorMessageBundle", mainLocale);
		} catch (Exception e2) {
			//TODO error standardisation
			e2.printStackTrace();
		}
		
	}

}
