package kassid_rt13oop_tg_kal;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JList;

public class MenuuVanemadKuular implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println(((JCheckBoxMenuItem)e.getSource()).getActionCommand());
		demo2.kassilist.setBackground( (e.getStateChange()==1) ? Color.ORANGE: Color.WHITE);
		for (Kass elem : demo2.kassid) {
			//TODO pooleli.
		}
		
		
		
		
//		if (e.getStateChange()==1) {
//			demo2.kassilist.setBackground(Color.ORANGE);
//		}

	}

}
