package kassid_rt13oop_tg_kal;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBoxMenuItem;

public class MenuuFrameNameKuular implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		Menuu.setOptionFrameName(( (JCheckBoxMenuItem) e.getItem()).getState());
		Kassiraam.kassilist.repaint();
	}

}
