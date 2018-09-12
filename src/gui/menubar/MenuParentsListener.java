package gui.menubar;

import gui.CAGEFrame;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBoxMenuItem;


public class MenuParentsListener implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		Menu.setOptionVanemad(( (JCheckBoxMenuItem) e.getItem()).getState());
		CAGEFrame.getKassiList().repaint();
	}

}
