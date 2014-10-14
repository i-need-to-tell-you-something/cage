package kassid_rt13oop_tg_kal;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Selle klassi funktsioon on fenoraam ja kassiNupuRaa korraga "sulgeda"
 * (tegelikult peita)
 */
public class AknaKuular implements WindowListener {

	@Override
	public void windowClosing(WindowEvent e) {
		Kassiraam.fenoraam.setVisible(false);
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