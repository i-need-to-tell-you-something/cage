package cage.gui.menubar;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBoxMenuItem;

import cage.gui.CAGEFrame;

public class MenuParentsListener implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		Menu.setOptionVanemad(( (JCheckBoxMenuItem) e.getItem()).getState());
		CAGEFrame.getKassilist().repaint();
	}

}
