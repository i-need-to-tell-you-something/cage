package kassid_rt13oop_tg_kal;

//import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;

//Kuular menüü nupu jaoks
public class Konspekt implements ActionListener {

	static JTextArea tekst = new JTextArea();

	@Override
	public void actionPerformed(ActionEvent e) {
		// Kui vajutatakse menuu nuppu tehakse lahti uus aken kuhu pannakse
		// sisse tekstiväli kuhu saadakse tekst failist "Konspekt.txt"
		JFrame konspektraam = new JFrame();
		konspektraam.setTitle("Konspekt");
		konspektraam.addWindowListener(new Konspekt2());
		tekst.setEditable(true);
		try {
			tekst.setText(Meetod.loe(Konspekt2.konspekt));
		} 
		catch (IOException eeee) {
			System.out.println("upsi, IO");
		}
		catch (NullPointerException ella) {
			System.out.println ("upsi, nullpointer");
		}
		konspektraam.setVisible(true);
		konspektraam.setSize(300, 300);
		konspektraam.add(tekst);
		tekst.setToolTipText("Mina olen default konspekt" 
				+ "Siia kirjuta märkusi mida oled täheldanud ja" 
				+ "tahad meelde j"
				+ "Kuidas erinevaid värve saada (helehelehall)"
				+ "Kuidas mingi rea fonti muu");
		// tekst.setBackground(Color.lightGray);
	}

	public static JTextArea getTekst() {
		return tekst;
	}

	public static void setTekst(JTextArea tekst) {
		Konspekt.tekst = tekst;
	}

}
