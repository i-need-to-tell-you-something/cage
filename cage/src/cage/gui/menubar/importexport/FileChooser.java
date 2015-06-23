package cage.gui.menubar.importexport;

import javax.swing.JFileChooser;

import cage.gui.menubar.LocaleChangeListener;
import cage.gui.menubar.MenuLanguageListener;

/**
 * Normal JFileChooser with added real-time locale change functionality
 * 
 * @author K
 *
 */
public class FileChooser extends JFileChooser implements
		LocaleChangeListener {

	/**
	 * I don't know exactly what this is
	 */
	private static final long serialVersionUID = 1L;

	public FileChooser(String currentDirectoryPath) {
		super(currentDirectoryPath);
		// Listing that this component needs to fire whenever there's a locale
		// change
		MenuLanguageListener.addToDeclaredComponents(this);
	}

	@Override
	public void onLocaleChange() {
		this.repaint();
	}

}
