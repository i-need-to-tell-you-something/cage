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
  this.add(troll);
  
  //Options
  JCheckBoxMenuItem vanemad = new JCheckBoxMenuItem("Kuva vanemaid");
  vanemad.setMnemonic(KeyEvent.VK_V);
  vanemad.addItemListener(new MenuuVanemadKuular());
  options.add(vanemad);
  
  //Abi
  JMenuItem p1= new JMenuItem("Programmi kohta");
  abi.add(p1);
  JMenuItem p2= new JMenuItem("Kasutusjuhend");
  abi.add(p2);
  
  
  
  
  
 }

}