package kassid_rt13oop_tg_kal;

import javax.swing.JFileChooser;

/**
 * Normal JFileChooser with added real-time locale change functionality
 * 
 * @author K
 *
 */
public class ImportExportFileChooser extends JFileChooser implements
		LocaleChangeListener {

	/**
	 * I don't know exactly what this is
	 */
	private static final long serialVersionUID = 1L;

	public ImportExportFileChooser(String currentDirectoryPath) {
		super(currentDirectoryPath);
		// Listing that this component needs to fire whenever there's a locale
		// change
		MenuuLanguageListener.addToDeclaredComponents(this);
	}

	@Override
	public void onLocaleChange() {
		this.repaint();
	}

}
