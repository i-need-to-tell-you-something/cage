package kassid_rt13oop_tg_kal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuuKeeleKuular implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		
//		Main.raam.setLocale(new Locale(e.getActionCommand()));
//		Main.currentLocale = new Locale("en", "GB");
//		ResourceBundle.clearCache();
//		Main.raam.repaint();
		
//		try {
//			Main.mainbundle = ResourceBundle.getBundle("kassid_rt13oop_tg_kal.Locale.MainBundle", Main.currentLocale);
////			Main.tipbundle = ResourceBundle.getBundle("kassid_rt13oop_tg_kal.Locale.Tooltips.TooltipBundle", Main.currentLocale);
////			Main.errbundle = ResourceBundle.getBundle( "kassid_rt13oop_tg_kal.Locale.ErrorMessages.ErrorMessageBundle", Main.currentLocale);
//		} catch (Exception e2) {
//			e2.printStackTrace();
//		}
		
//		//tundus et ei tee midagi
//		Locale.setDefault(new Locale(e.getActionCommand()));
		
		//tundus et ei tee midagi
//		Main.loadLocale(new Locale(e.getActionCommand()));
		
//		switch (e.getActionCommand()) {
//		case "et_EE": {
//			Main.currentLocale = new Locale("et", "EE"); break;
//		}
//		case "en_GB": {
//			Main.currentLocale = new Locale("en", "GB"); break;
//		}
//		}
//		System.out.println(((MenuuLanguageMenuItem)e.getSource()).getMenuItemLocale() );
		Main.currentLocale = ((MenuuLanguageMenuItem)e.getSource()).getMenuItemLocale();
//		Main.currentLocale = new Locale("et", "EE");		
		Main.raam.onLocaleChange();
		
//		//debug output:
//		System.out.println(e.getActionCommand());
//		System.out.println(new Locale(e.getActionCommand()));
//		System.out.println(Main.currentLocale);
//		System.out.println("raam.getLocale - "+Main.raam.getLocale());

	}

}
