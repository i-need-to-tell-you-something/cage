package kassid_rt13oop_tg_kal;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBoxMenuItem;

public class MenuuVanemadKuular implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		demo2.vanemad=( (JCheckBoxMenuItem) e.getItem()).getState();
		demo2.kassilist.repaint();
		
		
		
		
//		if (e.getStateChange()==1) {
//			demo2.kassilist.setBackground(Color.ORANGE);
//		}

	}

}
