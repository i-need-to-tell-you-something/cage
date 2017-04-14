package gui.menubar;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class HelpAboutListener implements ActionListener, LocaleChangeListener {
	static String about = "ui/About.txt";
	static String lingid = "ui/Aboutlingid.txt";
	private JFrame aboutraam;
	JTextArea tekst;

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Listing that this component needs to fire whenever there's a locale change
		MenuLanguageListener.addToDeclaredComponents(this);
		
		aboutraam = new JFrame();
//		JTextArea tekst = new JTextArea();
		tekst = new JTextArea();
		JEditorPane  tekstlingid = new JEditorPane();
		tekst.setEditable(false);
		tekstlingid.setEditable(false);
		aboutraam.setSize(400, 300);
		aboutraam.getContentPane().setLayout(new BorderLayout());
		onLocaleChange();
		try {
			tekstlingid.setText(FileToString.process(lingid));
		} catch (IOException eee) {
			//TODO error standardisation
			System.out.println("upsi");
		} catch (NullPointerException osi){;//Kui faili ei leia üles
			//TODO error standardisation
			System.out.println("ei leia dokumenti \""+lingid+"\"");
		}
		aboutraam.add(tekst, BorderLayout.NORTH);
		aboutraam.add(tekstlingid, BorderLayout.SOUTH);
		tekst.setFont(new Font("Sherif", Font.PLAIN, 15));
		aboutraam.setVisible(true);

	}

	@Override
	public void onLocaleChange() {
		aboutraam.setTitle(Locales.mainBundle.getString("title4"));
		tekst.setText(Locales.mainBundle.getString("help2"));
	}

}
