package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

/**
 * This class sets the new locale from a locale button and tell main frame to
 * update
 * @author K
 */

public class MenuuLanguageListener implements ActionListener {

	public static HashSet<Object> components = new HashSet<Object>();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Locales.currentLocale = ((MenuuLanguageMenuItem) e.getSource())
				.getMenuItemLocale();
		Locales.initResourceBundles();
//		//this cannot be static, im sure i dont understand
//		Main.raam.onLocaleChange(); 
//		Kassiraam.getFenoraam().onLocaleChange();
////		((LocaleChangeListener) Main.raam.getMenuBar()).onLocaleChange();
////		Menuu.onLocaleChange();
		for (Object elem : components) {
			((LocaleChangeListener) elem).onLocaleChange();
		}
	}
	
	public static void addToDeclaredComponents(Object component) {
		components.add(component);
	}

}

////Listing that this component needs to fire whenever there's a locale change
//		MenuuLanguageListener.addToDeclaredComponents(this);
