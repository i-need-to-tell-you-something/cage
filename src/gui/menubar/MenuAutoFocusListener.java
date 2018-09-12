package gui.menubar;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBoxMenuItem;

public class MenuAutoFocusListener implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		Menu.setOptionFookus(((JCheckBoxMenuItem) e.getItem()).getState());
	}

}
