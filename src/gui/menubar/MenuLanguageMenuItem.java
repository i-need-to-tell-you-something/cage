package gui.menubar;

import java.util.Locale;

import javax.swing.JMenuItem;

public class MenuLanguageMenuItem extends JMenuItem {

	//Fields
	private static final long serialVersionUID = 1L;
	
	//Constructor
	public MenuLanguageMenuItem(Locale menuItemLocale) {
		super(menuItemLocale.getDisplayLanguage(menuItemLocale));
		this.menuItemLocale = menuItemLocale;
	}
	
	//Getters and setters
	Locale menuItemLocale;
	public Locale getMenuItemLocale() {
		return menuItemLocale;
	}
	public void setMenuItemLocale(Locale menuItemLocale) {
		this.menuItemLocale = menuItemLocale;
	}
	
}
