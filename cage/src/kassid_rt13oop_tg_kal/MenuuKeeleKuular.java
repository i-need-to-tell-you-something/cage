package kassid_rt13oop_tg_kal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class MenuuKeeleKuular implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

//		Main.currentLocale = new Locale(e.getActionCommand());
//		try {
//			Main.mainbundle = ResourceBundle.getBundle("kassid_rt13oop_tg_kal.Locale.MainBundle", Main.currentLocale);
////			Main.tipbundle = ResourceBundle.getBundle("kassid_rt13oop_tg_kal.Locale.Tooltips.TooltipBundle", Main.currentLocale);
////			Main.errbundle = ResourceBundle.getBundle( "kassid_rt13oop_tg_kal.Locale.ErrorMessages.ErrorMessageBundle", Main.currentLocale);
//		} catch (Exception e2) {
//			e2.printStackTrace();
//		}
//		Locale.setDefault(new Locale(e.getActionCommand()));
		
		Main.loadLocale(new Locale(e.getActionCommand()));
//		//debug output:
//		System.out.println(Main.currentLocale);
//		System.out.println(Main.mainbundle.getString("title2"));
		
		Main.raam.onLocaleChange();
		Main.raam.pack();

	}

}
