package gui.menubar.importexport;

import gui.menubar.Locales;

import java.io.File;

import javax.swing.filechooser.FileFilter;


/**
 * This class makes sure that the FileChooser having this will normally only
 * display .cage files and directories
 * 
 */
public class ImportExportFilter extends FileFilter {

	// Linguistic/textual description of file filter
	@Override
	public String getDescription() {
		return Locales.mainBundle.getString("label3");
	}

	// Logical/algorithmic description of file filter
	@Override
	public boolean accept(File fail) {
		String s6ne = fail.getName();
		int indeks = s6ne.lastIndexOf('.');
		// File must either be a folder or end with .cage
		if (indeks > 0 && indeks < s6ne.length() - 1
				&& s6ne.substring(indeks).toLowerCase().equals(".cage")
				|| fail.isDirectory()) {
			return true;
		} else {
			return false;
		}
	}
}
