package kassid_rt13oop_tg_kal;


import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Menuu extends JMenuBar{
	public static boolean optionFookus = false;
	public static boolean optionVanemad = false;
//	public static boolean optionFrameName = false;	

	

	Menuu(){
		
		//menüü elemendid
		
		JMenu file = new JMenu(Main.mainbundle.getString("menulabel1"));
		JMenu options= new JMenu(Main.mainbundle.getString("menulabel2"));
		JMenu abi= new JMenu(Main.mainbundle.getString("menulabel3"));

		this.add(file);
		this.add(options);
		this.add(abi);
//		this.setHelpMenu(abi); //not implemented by java yet

		//File
		JMenuItem f1 = new JMenuItem(Main.mainbundle.getString("menulabel4"));
		f1.addActionListener(new KonspektKuular1());
		JMenuItem f2 = new JMenuItem(Main.mainbundle.getString("menulabel5"));
		f2.addActionListener(new MigratsiooniKuular());
		JMenuItem f3 = new JMenuItem(Main.mainbundle.getString("menulabel6"));
		f3.addActionListener(new MigratsiooniKuular());
		
		
		//Options
		JCheckBoxMenuItem o1 = new JCheckBoxMenuItem(Main.mainbundle.getString("menulabel7"));
		o1.addItemListener(new MenuuVanemadKuular());
		JCheckBoxMenuItem o2 = new JCheckBoxMenuItem(Main.mainbundle.getString("menulabel8"));
		o2.addItemListener(new MenuuAutoFookusKuular());
//		JCheckBoxMenuItem o3 = new JCheckBoxMenuItem("Kasside nimed ka akende sees");
//		o3.addItemListener(new MenuuFrameNameKuular());

		

		//Abi
		JMenuItem a1= new JMenuItem(Main.mainbundle.getString("menulabel9"));
		a1.addActionListener(new About());
		JMenuItem a2= new JMenuItem(Main.mainbundle.getString("menulabel10"));
		a2.addActionListener(new Kasutusjuhend());
		JMenuItem a3= new JMenuItem(Main.mainbundle.getString("menulabel11"));

		file.add(f1);
		file.add(f2);
		file.add(f3);
		options.add(o1);
		options.add(o2);
		abi.add(a1);
		abi.add(a2);
		abi.add(a3);

		//tooltipid
		f1.setToolTipText(Main.tipbundle.getString("tt13"));
		f2.setToolTipText(Main.tipbundle.getString("tt14"));
		f3.setToolTipText(Main.tipbundle.getString("tt15"));
		o1.setToolTipText(Main.tipbundle.getString("tt16"));
		o2.setToolTipText(Main.tipbundle.getString("tt17"));
		a1.setToolTipText(Main.tipbundle.getString("tt18"));
		a2.setToolTipText(Main.tipbundle.getString("tt19"));
		a3.setToolTipText(Main.tipbundle.getString("tt20"));
		
		//klahvid
		file.setMnemonic(KeyEvent.VK_F); //fail
		options.setMnemonic(KeyEvent.VK_S);	//seaded
		abi.setMnemonic(KeyEvent.VK_A);	//abi
		f1.setMnemonic(KeyEvent.VK_K);	//konspekt
		f2.setMnemonic(KeyEvent.VK_E);  //eksport
		f3.setMnemonic(KeyEvent.VK_I);  //import
		o1.setMnemonic(KeyEvent.VK_V);	//kuva vanemaid
		o2.setMnemonic(KeyEvent.VK_F);  //autofookus
		a1.setMnemonic(KeyEvent.VK_P);	//programmi kohta
		a2.setMnemonic(KeyEvent.VK_H);	//kasutusjuhend
		a3.setMnemonic(KeyEvent.VK_U);	//otsi uuendusi
		
		
		//properties laadimine failist
		Properties prop = new Properties();
		try {
			// ja siis nuppude ja väärtuste seadmine selle järgi
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
	
//	public static boolean isOptionFrameName() {
//		return optionFrameName;
//	}
//
//	public static void setOptionFrameName(boolean optionFrameName) {
//		Menuu.optionFrameName = optionFrameName;
//	}

	//getterid ja setterid
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