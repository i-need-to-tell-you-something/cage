package gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBoxMenuItem;

public class MenuuParentsListener implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		Menuu.setOptionVanemad(( (JCheckBoxMenuItem) e.getItem()).getState());
		Kassiraam.kassilist.repaint();
	}

}
