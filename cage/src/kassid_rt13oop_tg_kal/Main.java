package kassid_rt13oop_tg_kal;

import java.awt.im.InputContext;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
	public static ResourceBundle mainbundle;
	public static ResourceBundle tipbundle;
	public static ResourceBundle errbundle;
	static Locale currentLocale;
	public static Kassiraam raam;

	public static void main(String[] args) {

		// peaks valima (windowsi?) hetkel kasutuses oleva lokaadi
		try {
//			currentLocale = Locale.getDefault();
			currentLocale = InputContext.getInstance().getLocale();
		} catch (Exception e1) {
			currentLocale = new Locale("en", "GB");
		}
		loadLocale(currentLocale);
		
		
		raam = new Kassiraam();
		// raam.setSize(500, 500);
		raam.pack();
		raam.setLocation(100, 0);
		raam.setVisible(true);
	}
	
	public static void loadLocale(Locale lokaat) {

		try {
			mainbundle = ResourceBundle.getBundle("kassid_rt13oop_tg_kal.Locale.MainBundle", lokaat);
			tipbundle = ResourceBundle.getBundle("kassid_rt13oop_tg_kal.Locale.Tooltips.TooltipBundle", lokaat);
			errbundle = ResourceBundle.getBundle( "kassid_rt13oop_tg_kal.Locale.ErrorMessages.ErrorMessageBundle", lokaat);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}

}
