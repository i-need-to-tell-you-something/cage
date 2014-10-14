package kassid_rt13oop_tg_kal;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

//see kuular salvestab settingud siis kui akna sulged
public class KassiRaamiSulgemisKuular implements WindowListener {
	static String configFail = "save/options.cfg";

	@Override
	public void windowClosing(WindowEvent arg0) {
		
		Properties prop = new Properties();

		try {
			prop.setProperty("DisplayParents", Boolean.toString(Menuu.isOptionVanemad()) );
			prop.setProperty("AutomaticCatListFocus", Boolean.toString(Menuu.isOptionFookus()) );
			
			prop.store(new FileOutputStream(configFail), null);
		} catch (IOException e) {
			//TODO error_standardization
			e.printStackTrace();
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
