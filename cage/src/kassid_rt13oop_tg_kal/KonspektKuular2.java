package kassid_rt13oop_tg_kal;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author K Salvestab konspekti sulgemisel selles oleva info "konspekt" faili.
 *
 */
public class KonspektKuular2 implements WindowListener {
	static String konspekt = "ui/Konspekt.txt";

	@Override
	public void windowClosing(WindowEvent arg0) {
		// Konspekti akna sulgemisel võetakse tekst ja salvestatakse uuesti
		// konspekti faili
		String outtekst = KonspektKuular1.getTekst().getText() + "      ";
		try {
			FileOutputStream valja = new FileOutputStream(konspekt);
			valja.write(outtekst.getBytes(), 0, outtekst.length());
			valja.close();
		} catch (IOException eino) {
			//TODO error_standardization
			System.out.println("s/v erind");
		} catch (NullPointerException osi) {
			// TODO error_standardization
			System.out.println(osi);// Kui faili ei leia üles
			System.out.println("ei leia dokumenti \"" + konspekt + "\"");
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {}

	@Override
	public void windowClosed(WindowEvent arg0) {}
	
	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	}

}
