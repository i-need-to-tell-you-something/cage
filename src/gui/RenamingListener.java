package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.Kass;


/**
 * Listener for renaming a cat.
 *
 */
public class RenamingListener implements ActionListener {

	private Kass kass;

	public RenamingListener(Kass kass) {
		this.kass = kass;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//nimetamiskonteiner tüüpi aken kus event toimus
		RenamingContainer aken = (RenamingContainer)((Component)e.getSource()).getParent().getParent().getParent().getParent();

		//muudame nime ära selleks mis on kastis
		kass.setName(aken.textField.getText());
		CAGEFrame.getKassiList().repaint();
		aken.dispose();
	}
}
