package kassid_rt13oop_tg_kal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuuKeeleKuular implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		
//		Main.currentLocale = new Locale(e.getActionCommand());
//		
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
		
//		//debug output:
		System.out.println(Main.currentLocale);
//		System.out.print(Main.mainbundle.getString("title2"));
		System.out.println(e.getActionCommand());
		
		
		Main.raam.onLocaleChange();
		Main.raam.pack();

	}

}
