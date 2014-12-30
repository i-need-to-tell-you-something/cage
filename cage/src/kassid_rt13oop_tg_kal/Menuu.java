package kassid_rt13oop_tg_kal;


import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Menuu extends JMenuBar{
	private static boolean optionFookus = false;
	private static boolean optionVanemad = false;
	
	private static JMenu fileMenu;
	private static JMenu helpMenu;
	private static JMenu optionsMenu;
	private static JMenu languageMenu;

	

	Menuu(){
		
		//menüü elemendid
		
		fileMenu = new JMenu(Main.mainbundle.getString("menulabel1"));
		this.add(fileMenu);
		optionsMenu = new	 JMenu(Main.mainbundle.getString("menulabel2"));
		this.add(optionsMenu);
		helpMenu = new JMenu(Main.mainbundle.getString("menulabel3"));
		this.add(helpMenu);
//		this.setHelpMenu(help); //not implemented by java yet
		languageMenu = new JMenu();
		this.add(languageMenu);
		try {
			ImageIcon languageIcon = new ImageIcon("data//gfx//icons//Language-Icon.png");
			languageMenu.setIcon(languageIcon);
		}
		catch (NullPointerException e) {
			//TODO error standardization
			System.out.println("Erind ikooniga" + e.getMessage());
		}

		
		//Items in file menu
		JMenuItem f1 = new JMenuItem(Main.mainbundle.getString("menulabel4"));
		f1.addActionListener(new KonspektKuular1());
		fileMenu.add(f1);
		JMenuItem f2 = new JMenuItem(Main.mainbundle.getString("menulabel5"));
		f2.addActionListener(new MigratsiooniKuular());
		fileMenu.add(f2);
		JMenuItem f3 = new JMenuItem(Main.mainbundle.getString("menulabel6"));
		f3.addActionListener(new MigratsiooniKuular());
		fileMenu.add(f3);
		
		
		//Items in options menu
		JCheckBoxMenuItem o1 = new JCheckBoxMenuItem(Main.mainbundle.getString("menulabel7"));
		o1.addItemListener(new MenuuVanemadKuular());
		optionsMenu.add(o1);
		JCheckBoxMenuItem o2 = new JCheckBoxMenuItem(Main.mainbundle.getString("menulabel8"));
		o2.addItemListener(new MenuuAutoFookusKuular());
		optionsMenu.add(o2);

		
		//Items in help menu
		JMenuItem a1= new JMenuItem(Main.mainbundle.getString("menulabel9"));
		a1.addActionListener(new AboutListener());
		helpMenu.add(a1);
		JMenuItem a2= new JMenuItem(Main.mainbundle.getString("menulabel10"));
		a2.addActionListener(new Kasutusjuhend());
		helpMenu.add(a2);
		//TODO this is troll button: not implemented
		JMenuItem a3= new JMenuItem(Main.mainbundle.getString("menulabel11"));								
		helpMenu.add(a3);

		
		listDifferentLocale();
		//Items in language menu
//		JMenuItem l1 = new JMenuItem("en_GB");
//		languageMenu.add(l1);
//		l1.addActionListener(new MenuuKeeleKuular());
//		JMenuItem l2 = new JMenuItem("et_EE");
//		languageMenu.add(l2);
//		l2.addActionListener(new MenuuKeeleKuular());
//		JMenuItem l3 = new JMenuItem("ru_RU");
//		languageMenu.add(l3);
//		l3.addActionListener(new MenuuKeeleKuular());
//		
		
		//Adding tooltips
		f1.setToolTipText(Main.tipbundle.getString("tt13"));
		f2.setToolTipText(Main.tipbundle.getString("tt14"));
		f3.setToolTipText(Main.tipbundle.getString("tt15"));
		o1.setToolTipText(Main.tipbundle.getString("tt16"));
		o2.setToolTipText(Main.tipbundle.getString("tt17"));
		a1.setToolTipText(Main.tipbundle.getString("tt18"));
		a2.setToolTipText(Main.tipbundle.getString("tt19"));
		a3.setToolTipText(Main.tipbundle.getString("tt20"));
		
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
		
	}
	
	//language list needs this
	private void listFilesForFolder(File folder) {
		for (File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else if (isLocaleFile(fileEntry.getName())) {
				String fileName = fileEntry.getName();
				String language = (fileName.substring(fileName.length()-16, fileName.length()-14));
				String region = (fileName.substring(fileName.length()-13, fileName.length()-11));
				JMenuItem newLocaleButton = new MenuuLanguageMenuItem(new Locale(language, region));
				languageMenu.add(newLocaleButton);
				newLocaleButton.addActionListener(new MenuuKeeleKuular());
			}
		}
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
	
	//finds all available locale files
	private void listDifferentLocale() {
		try {
			listFilesForFolder(new File("bin/kassid_rt13oop_tg_kal/Locale"));
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		}
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
	
}