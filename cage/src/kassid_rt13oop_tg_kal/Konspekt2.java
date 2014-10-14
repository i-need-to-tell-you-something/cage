package kassid_rt13oop_tg_kal;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileOutputStream;
import java.io.IOException;

public class Konspekt2 implements WindowListener {
	static String konspekt="Konspekt.txt";

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {

		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		
		//Konspekti akna sulgemisel võetakse tekst ja salvestatakse uuesti konspekti faili
		String outtekst = Konspekt.getTekst().getText();
		try {
			FileOutputStream valja = new FileOutputStream(konspekt);
			valja.write(outtekst.getBytes(), 0, outtekst.length());
			valja.close();
		} catch (IOException eino) {
			System.out.println("eino süü");
		}
		catch (NullPointerException osi){
			System.out.println(osi);//Kui faili ei leia üles
			System.out.println("ei leia dokumenti \""+konspekt+"\"");
		}

		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {

		// TODO Auto-generated method stub

	}

}
