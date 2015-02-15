package kassid_rt13oop_tg_kal;


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

@SuppressWarnings("serial")
public class Menuu extends JMenuBar implements LocaleChangeListener {
	
	private static HashSet<Locale> localesInLanguageMenu = new HashSet<Locale>();
	
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

	

	public Menuu(){
			
		//Listing that this component needs to fire whenever there's a locale change
		MenuuLanguageListener.addToDeclaredComponents(this);
		
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
		
		f1.addActionListener(new KonspektKuular1());
		f2.addActionListener(new ImportExportListener());
		f3.addActionListener(new ImportExportListener());

		o1.addItemListener(new MenuuParentsListener());
		o2.addItemListener(new MenuuAutoFookusKuular());

		a1.addActionListener(new HelpAboutListener());
		a2.addActionListener(new HelpInstructionsListener());

		//Finds all available locale files and makes language option buttons out of them
		try {
			addAllLocalesInFolder(new File("bin/kassid_rt13oop_tg_kal/Locale"));
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
			prop.load(new FileInputStream(KassiRaamiSulgemisKuular.configFail));
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
	
	//Finds all the files in this folder and its subfolders
	private void addAllLocalesInFolder(File folder) {
		for (File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				addAllLocalesInFolder(fileEntry);
			//If it's a locale file, try making a new language button 
			} else if (isLocaleFile(fileEntry.getName())) {
				addLocaleButton(fileEntry.getName());
			}
		}
	}
	
	private void addLocaleButton(String fileName) {
		String language = (fileName.substring(fileName.length() - 16, fileName.length() - 14));
		String region = (fileName.substring(fileName.length() - 13, fileName.length() - 11));
		Locale locale = new Locale(language, region);
		//check if duplicate of those already in language menu
		for (Locale elem : localesInLanguageMenu) {
			if (elem.equals(locale)) {
				//exit button adding sequence if duplicate
				return;
			}
		}
		//otherwise add button to menu
		localesInLanguageMenu.add(locale);
		JMenuItem newLocaleButton = new MenuuLanguageMenuItem(locale);
		languageMenu.add(newLocaleButton);
		newLocaleButton.addActionListener(new MenuuLanguageListener());
	}

	//Checks whether a filename matches the pattern of a locale file: foo_en_GB.properties
	private boolean isLocaleFile(String filename) {
		if (filename.substring(filename.length()-11, filename.length()).equals(".properties")) {
			if (filename.charAt(filename.length()-14)=='_') {
				if (filename.charAt(filename.length()-17)=='_') {
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
		Menuu.optionFookus = optionFookus;
	}

	public static boolean isOptionVanemad() {
		return optionVanemad;
	}

	public static void setOptionVanemad(boolean optionVanemad) {
		Menuu.optionVanemad = optionVanemad;
	}

	@Override
	public void onLocaleChange() {
		
		//Menus
		
		fileMenu.setText(Main.mainbundle.getString("menulabel1"));
		optionsMenu.setText(Main.mainbundle.getString("menulabel2"));
		helpMenu.setText(Main.mainbundle.getString("menulabel3"));
		
		//Items in menus
		
		f1.setText(Main.mainbundle.getString("menulabel4"));
		f2.setText(Main.mainbundle.getString("menulabel5"));
		f3.setText(Main.mainbundle.getString("menulabel6"));

		o1.setText(Main.mainbundle.getString("menulabel7"));
		o2.setText(Main.mainbundle.getString("menulabel8"));
		
		a1.setText(Main.mainbundle.getString("menulabel9"));
		a2.setText(Main.mainbundle.getString("menulabel10"));
		a3.setText(Main.mainbundle.getString("menulabel11"));
		
		//Adding tooltips
		
		f1.setToolTipText(Main.tipbundle.getString("tt13"));
		f2.setToolTipText(Main.tipbundle.getString("tt14"));
		f3.setToolTipText(Main.tipbundle.getString("tt15"));
		
		o1.setToolTipText(Main.tipbundle.getString("tt16"));
		o2.setToolTipText(Main.tipbundle.getString("tt17"));
		
		a1.setToolTipText(Main.tipbundle.getString("tt18"));
		a2.setToolTipText(Main.tipbundle.getString("tt19"));
		a3.setToolTipText(Main.tipbundle.getString("tt20"));
	}
	
}