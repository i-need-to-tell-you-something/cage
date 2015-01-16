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
		
		// Should select the locale currently used in OS
		try {
			currentLocale = InputContext.getInstance().getLocale();
		} catch (Exception e1) {
			currentLocale = new Locale("en", "GB");
		}
		
		initResourceBundles();
		
		// raam.setSize(500, 500);
		raam = new Kassiraam();
		raam.pack();
		raam.setLocation(100, 0);
		raam.setVisible(true);
	}
//	Main.loadLocale(Main.currentLocale);
	public static void initResourceBundles() {
		try {
			mainbundle = ResourceBundle.getBundle("kassid_rt13oop_tg_kal.Locale.MainBundle", currentLocale);
			tipbundle = ResourceBundle.getBundle("kassid_rt13oop_tg_kal.Locale.Tooltips.TooltipBundle", currentLocale);
			errbundle = ResourceBundle.getBundle( "kassid_rt13oop_tg_kal.Locale.ErrorMessages.ErrorMessageBundle", currentLocale);
		} catch (Exception e2) {
			//TODO error standardisation
			e2.printStackTrace();
		}
	}	

}
