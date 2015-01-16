package kassid_rt13oop_tg_kal;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * The purpose of this class is to "close" fenoFrame and catButtonFrame at the
 * same time (actually hide them)
 */
public class WindowsClosingListener implements WindowListener {

	@Override
	public void windowClosing(WindowEvent e) {
		Kassiraam.getFenoraam().setVisible(false);
		Kassiraam.kassiNupuRaam.setVisible(false);
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