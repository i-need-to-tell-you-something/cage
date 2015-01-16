package kassid_rt13oop_tg_kal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * Displays help text about how to use the program.
 * 
 * @author K
 */
public class InstructionsListener implements ActionListener, LocaleChangeListener{

	JTextArea tekst;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFrame kasutusraam = new JFrame();
		tekst = new JTextArea();
		tekst.setEditable(false);
		onLocaleChange();
		kasutusraam.add(tekst);
		kasutusraam.setVisible(true);
		kasutusraam.pack();
		//Listing that this component needs to fire whenever there's a locale change
		MenuuLanguageListener.addToDeclaredComponents(this);
	}

	@Override
	public void onLocaleChange() {
		tekst.setText(Main.mainbundle.getString("help1"));		
	}
}
