package kassid_rt13oop_tg_kal;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AknaKuular implements WindowListener {
//Selle klassi funktsioon on fenoraam ja kassiNupuRaam 
// korraga "sulgeda" (tegelikult peita)
	
	@Override
	public void windowClosing(WindowEvent e) {
		demo2.fenoraam.setVisible(false);
		demo2.kassiNupuRaam.setVisible(false);
	}
	
	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowOpened(WindowEvent e) {}

}