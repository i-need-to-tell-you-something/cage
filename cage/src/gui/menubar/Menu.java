package gui.menubar;


import gui.CAGEFrameClosingListener;
import gui.menubar.importexport.ImportExportListener;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import core.FilePaths;


@SuppressWarnings("serial")
public class Menu extends JMenuBar implements LocaleChangeListener {
	
	private static HashSet<Locale> localesInLanguageMenu = new HashSet<Locale>();
	//hardcoded default locale will be added to HashSet above 
	private static Locale defaultLocale = new Locale("en", "GB") ;
	
	private static boolean optionFookus = false;
	private static boolean optionVanemad = false;
	
	private static JMenu fileMenu = new JMenu();
	private static JMenu helpMenu = new JMenu();
	private static JMenu optionsMenu = new JMenu();
	private static JMenu languageMenu = new JMenu();
	

	private static JMenuItem f1 = new JMenuItem();
	private static JMenuItem f2 = new JMenuItem();
	private static JMenuItem f3 = new JMenuItem();
	private static JCheckBoxMenuItem o1 = new JCheckBoxMenuItem();
	private static JCheckBoxMenuItem o2 = new JCheckBoxMenuItem();
	private static JMenuItem a2= new JMenuItem();
	private static JMenuItem a1= new JMenuItem();
	private static JMenuItem a3= new JMenuItem();	

	

	public Menu(){
			
		//Listing that this component needs to fire whenever there's a locale change
		MenuLanguageListener.addToDeclaredComponents(this);
		
//		this.setHelpMenu(help); - not implemented by java yet
		this.add(fileMenu);
		this.add(optionsMenu);
		this.add(helpMenu);
		this.add(languageMenu);
		
		//Icon for Language JMenu item
		try {
			ImageIcon languageIcon = new ImageIcon("data//gfx//icons//Language-Icon.png");
			languageMenu.setIcon(languageIcon);
		}
		catch (NullPointerException e) {
			//TODO error standardization
			System.out.println("Erind ikooniga" + e.getMessage());
		}

		//Add elements to menus
		
		fileMenu.add(f1);
		fileMenu.add(f2);
		fileMenu.add(f3);
		
		optionsMenu.add(o1);
		optionsMenu.add(o2);
		
		helpMenu.add(a1);
		helpMenu.add(a2);
		//TODO this is troll button: not implemented							
		helpMenu.add(a3);
		
		//
		
		f2.setActionCommand("Export");
		f3.setActionCommand("Import");
		
		//Listeners to elements in menus
		
		f1.addActionListener(new ConspectListener1());
		f2.addActionListener(new ImportExportListener());
		f3.addActionListener(new ImportExportListener());

		o1.addItemListener(new MenuParentsListener());
		o2.addItemListener(new MenuAutoFocusListener());

		a1.addActionListener(new HelpAboutListener());
		a2.addActionListener(new HelpInstructionsListener());

		//Finds all available locale files and makes language option buttons out of them
		try {
			addAllLocalesInFolder(new File(FilePaths.localePath));
			for (Locale locale : localesInLanguageMenu) {
				addLocaleButton(locale);
			}
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//Adding hotkeys
		
		fileMenu.setMnemonic(KeyEvent.VK_F); //fail
		optionsMenu.setMnemonic(KeyEvent.VK_S);	//seaded
		helpMenu.setMnemonic(KeyEvent.VK_A);	//abi
		
		f1.setMnemonic(KeyEvent.VK_K);	//konspekt
		f2.setMnemonic(KeyEvent.VK_E);  //eksport
		f3.setMnemonic(KeyEvent.VK_I);  //import
		o1.setMnemonic(KeyEvent.VK_V);	//kuva vanemaid
		o2.setMnemonic(KeyEvent.VK_F);  //autofookus
		a1.setMnemonic(KeyEvent.VK_P);	//programmi kohta
		a2.setMnemonic(KeyEvent.VK_H);	//kasutusjuhend
		a3.setMnemonic(KeyEvent.VK_U);	//otsi uuendusi
		
		
		//Getting configuration values from the file if possible and assigning values to options based on those
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(CAGEFrameClosingListener.getConfigFile()));
			boolean b = Boolean.valueOf(prop.getProperty("DisplayParents"));
			setOptionFookus(b);
			o1.setSelected(b);
			boolean a = Boolean.valueOf(prop.getProperty("AutomaticCatListFocus"));
			setOptionFookus(a);
			o2.setSelected(a);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//And now load text onto all the components, which is already defined in the method onLocaleChange()
		onLocaleChange();
		
	}
	
	//Adds all the locales to the data collection of locales to be added to language menu
	private void addAllLocalesInFolder(File folder) {
		//Add default locale to the collection
		localesInLanguageMenu.add(defaultLocale);
		//Check all the files in the given folder
		for (File fileEntry : folder.listFiles()) {
			//Also checking subfolders
			if (fileEntry.isDirectory()) {
				addAllLocalesInFolder(fileEntry);
			//If it's a locale file, try making a new language button 
			} else if (isLocaleFile(fileEntry.getName())) {
				localesInLanguageMenu.add(fileToLocale(fileEntry));
			}
		}
	}
	
	//Add the button to LanguageMenu
	private void addLocaleButton(Locale locale) {
		JMenuItem newLocaleButton = new MenuLanguageMenuItem(locale);
		languageMenu.add(newLocaleButton);
		newLocaleButton.addActionListener(new MenuLanguageListener());
	}
	
	//Turn file into locale. Assumes file validation is already performed
	private Locale fileToLocale (File fileEntry) {
		String fileName = fileEntry.getName();
		int end = fileName.length();
		String country = fileName.substring(end-13, end-11);
		String language = fileName.substring(end-16, end-14);
		Locale localeBeingMade = new Locale(language, country);
		return localeBeingMade;
	}

	//Checks whether a filename matches the pattern of a locale file: foo_en_GB.properties
	private boolean isLocaleFile(String fileName) {
		if (fileName.substring(fileName.length()-11, fileName.length()).equals(".properties")) {
			if (fileName.charAt(fileName.length()-14)=='_') {
				if (fileName.charAt(fileName.length()-17)=='_') {
					return true;
				}
			}
		}
		return false;
	}
	

	//Getters and setters
	public static boolean isOptionFookus() {
		return optionFookus;
	}

	public static void setOptionFookus(boolean optionFookus) {
		Menu.optionFookus = optionFookus;
	}

	public static boolean isOptionVanemad() {
		return optionVanemad;
	}

	public static void setOptionVanemad(boolean optionVanemad) {
		Menu.optionVanemad = optionVanemad;
	}

	@Override
	public void onLocaleChange() {
		
		//Menus
		
		fileMenu.setText(Locales.mainBundle.getString("menulabel1"));
		optionsMenu.setText(Locales.mainBundle.getString("menulabel2"));
		helpMenu.setText(Locales.mainBundle.getString("menulabel3"));
		
		//Items in menus
		
		f1.setText(Locales.mainBundle.getString("menulabel4"));
		f2.setText(Locales.mainBundle.getString("menulabel5"));
		f3.setText(Locales.mainBundle.getString("menulabel6"));

		o1.setText(Locales.mainBundle.getString("menulabel7"));
		o2.setText(Locales.mainBundle.getString("menulabel8"));
		
		a1.setText(Locales.mainBundle.getString("menulabel9"));
		a2.setText(Locales.mainBundle.getString("menulabel10"));
		a3.setText(Locales.mainBundle.getString("menulabel11"));
		
		//Adding tooltips
		
		f1.setToolTipText(Locales.tipBundle.getString("tt13"));
		f2.setToolTipText(Locales.tipBundle.getString("tt14"));
		f3.setToolTipText(Locales.tipBundle.getString("tt15"));
		
		o1.setToolTipText(Locales.tipBundle.getString("tt16"));
		o2.setToolTipText(Locales.tipBundle.getString("tt17"));
		
		a1.setToolTipText(Locales.tipBundle.getString("tt18"));
		a2.setToolTipText(Locales.tipBundle.getString("tt19"));
		a3.setToolTipText(Locales.tipBundle.getString("tt20"));
	}
	
}