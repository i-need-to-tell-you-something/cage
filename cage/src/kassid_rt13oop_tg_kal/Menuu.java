package kassid_rt13oop_tg_kal;


import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Menuu extends JMenuBar{


	Menuu(){
		//  JMenuBar menu = new JMenuBar();
		JMenu options= new JMenu("Valikud");
		JMenu abi= new JMenu("Abi");
		JMenu troll= new JMenu("Troll");

		this.add(options);
		this.add(abi);
//		this.setHelpMenu(abi); //not implemented by java yet
		this.add(troll);

		//Options
		JMenuItem o1= new JMenuItem("Konspekt");
		o1.addActionListener(new Konspekt());
		JCheckBoxMenuItem o2 = new JCheckBoxMenuItem("Kuva vanemaid");
		o2.addItemListener(new MenuuVanemadKuular());

		options.add(o1);
		options.add(o2);

		//Abi
		JMenuItem p1= new JMenuItem("Programmi kohta");
		p1.addActionListener(new About());
		JMenuItem p2= new JMenuItem("Kasutusjuhend");
		p2.addActionListener(new Kasutusjuhend());
		JMenuItem p3= new JMenuItem("Otsi uuendusi");

		abi.add(p1);
		abi.add(p2);
		abi.add(p3);

		//klahvid
		options.setMnemonic(KeyEvent.VK_D);	//valikud
		abi.setMnemonic(KeyEvent.VK_A);	//abi
		o1.setMnemonic(KeyEvent.VK_K);	//konspekt
		o2.setMnemonic(KeyEvent.VK_V);	//kuva vanemaid
		p1.setMnemonic(KeyEvent.VK_P);	//programmi kohta
		p2.setMnemonic(KeyEvent.VK_H);	//kasutusjuhend
		p3.setMnemonic(KeyEvent.VK_U);	//otsi uuendusi
	}
}