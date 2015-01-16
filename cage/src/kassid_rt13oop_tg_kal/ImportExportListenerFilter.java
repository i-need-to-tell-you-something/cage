package kassid_rt13oop_tg_kal;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class ImportExportListenerFilter extends FileFilter implements LocaleChangeListener{
	
	
	
	public ImportExportListenerFilter() {
		super();
		//Listing that this component needs to fire whenever there's a locale change
		MenuuLanguageListener.addToDeclaredComponents(this);
	}


		// faili valiku lingvistiline kirjeldus
		@Override
		public String getDescription() {
			return Main.mainbundle.getString("label3");
		}
	

	// faili valiku loogiline kirjeldus
	@Override
	public boolean accept(File fail) {
		String s6ne = fail.getName();
		int indeks = s6ne.lastIndexOf('.');
		//File must either be a folder or end with .cage 
		if (indeks > 0
				&& indeks < s6ne.length() - 1
				&& s6ne.substring(indeks).toLowerCase()
				.equals(".cage") || fail.isDirectory()) {
			return true;
		} 
		else {
			return false;
		}
	}


	@Override
	public void onLocaleChange() {
		getDescription();
	}

}
