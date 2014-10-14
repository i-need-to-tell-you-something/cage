package kassid_rt13oop_tg_kal;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBoxMenuItem;

public class MenuuVanemadKuular implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		Menuu.setOptionVanemad(( (JCheckBoxMenuItem) e.getItem()).getState());
		Kassiraam.kassilist.repaint();
	}

}
