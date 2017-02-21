package gui.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;

//Kuular menüü nupu jaoks
public class ConspectListener1 implements ActionListener, LocaleChangeListener {

	static JTextArea tekst = new JTextArea();
	JFrame konspektraam;

	@Override
	public void actionPerformed(ActionEvent e) {
		//Listing that this component needs to fire whenever there's a locale change
		MenuLanguageListener.addToDeclaredComponents(this);
		
		// Kui vajutatakse menuu nuppu tehakse lahti uus aken kuhu pannakse
		// sisse tekstiväli kuhu saadakse tekst failist "Konspekt.txt"
		konspektraam = new JFrame();
		konspektraam.addWindowListener(new ConspectListener2());
		tekst.setEditable(true);
		onLocaleChange();
		try {
			tekst.setText(FileToString.process(ConspectListener2.konspekt));
		} catch (IOException eeee) {
			//TODO error_standardization
			System.out.println("upsi, IO");
		} catch (NullPointerException ella) {
			System.out.println("upsi, nullpointer");
		}
		konspektraam.setVisible(true);
		konspektraam.setSize(300, 300);
		konspektraam.add(tekst);
		// tekst.setBackground(Color.lightGray);
	}

	public static JTextArea getTekst() {
		return tekst;
	}

	public static void setTekst(JTextArea tekst) {
		ConspectListener1.tekst = tekst;
	}

	@Override
	public void onLocaleChange() {
		konspektraam.setTitle(Locales.mainbundle.getString("title7"));
		tekst.setToolTipText(Locales.tipbundle.getString("tt10"));
		
	}

}
