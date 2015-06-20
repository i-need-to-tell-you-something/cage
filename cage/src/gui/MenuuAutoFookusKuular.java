package gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBoxMenuItem;

public class MenuuAutoFookusKuular implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		Menuu.setOptionFookus(((JCheckBoxMenuItem) e.getItem()).getState());
	}

}
