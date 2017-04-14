package gui.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * Displays help text about how to use the program.
 * 
 * @author K
 */
public class HelpInstructionsListener implements ActionListener, LocaleChangeListener{

	JFrame kasutusraam = new JFrame();
	JTextArea tekst = new JTextArea();
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		tekst.setEditable(false);
		onLocaleChange();
		kasutusraam.add(tekst);
		kasutusraam.setVisible(true);
		kasutusraam.pack();
		//Listing that this component needs to fire whenever there's a locale change
		MenuLanguageListener.addToDeclaredComponents(this);
	}

	@Override
	public void onLocaleChange() {
		tekst.setText(Locales.mainBundle.getString("help1"));		
	}
}
