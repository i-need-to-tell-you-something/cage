package gui.creationframe;

import gui.CAGEFrame;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


/**
 * The purpose of this class is to "close" {@link CreationFrameOfSelection} and {@link CreationFrameOfConfirmation} at the
 * same time (actually hide them)
 */
public class CreationFrameClosingListener implements WindowListener {

	@Override
	public void windowClosing(WindowEvent e) {
		CAGEFrame.getCreationFrameOfConfirmation().setVisible(false);
		CAGEFrame.getCreationFrameOfSelection().setVisible(false);
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

}