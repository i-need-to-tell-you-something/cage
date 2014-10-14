package kassid_rt13oop_tg_kal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;

//Kuular menüü nupu jaoks
public class KonspektKuular1 implements ActionListener {

	static JTextArea tekst = new JTextArea();

	@Override
	public void actionPerformed(ActionEvent e) {
		// Kui vajutatakse menuu nuppu tehakse lahti uus aken kuhu pannakse
		// sisse tekstiväli kuhu saadakse tekst failist "Konspekt.txt"
		JFrame konspektraam = new JFrame();
		konspektraam.setTitle(Main.mainbundle.getString("title7"));
		konspektraam.addWindowListener(new KonspektKuular2());
		tekst.setEditable(true);
		try {
			tekst.setText(FileToString.loe(KonspektKuular2.konspekt));
		} catch (IOException eeee) {
			//TODO error_standardization
			System.out.println("upsi, IO");
		} catch (NullPointerException ella) {
			System.out.println("upsi, nullpointer");
		}
		konspektraam.setVisible(true);
		konspektraam.setSize(300, 300);
		konspektraam.add(tekst);
		tekst.setToolTipText(Main.tipbundle.getString("tt10"));
		// tekst.setBackground(Color.lightGray);
	}

	public static JTextArea getTekst() {
		return tekst;
	}

	public static void setTekst(JTextArea tekst) {
		KonspektKuular1.tekst = tekst;
	}

}
