package cage.gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import cage.gui.menubar.Menu;

/**
 * This listener saves your settings when closing the program
 * 
 */
public class CAGEFrameClosingListener implements WindowListener {
	private static String configFail = "save/options.cfg";

	@Override
	public void windowClosing(WindowEvent arg0) {

		Properties prop = new Properties();

		try {
			prop.setProperty("DisplayParents",
					Boolean.toString(Menu.isOptionVanemad()));
			prop.setProperty("AutomaticCatListFocus",
					Boolean.toString(Menu.isOptionFookus()));

			prop.store(new FileOutputStream(getConfigFile()), null);
		} catch (IOException e) {
			// TODO error_standardization
			e.printStackTrace();
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
	}

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

	/**
	 * @return the configFail
	 */
	public static String getConfigFile() {
		return configFail;
	}

}
