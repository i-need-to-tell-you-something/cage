package kassid_rt13oop_tg_kal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Kasutusjuhend implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFrame kasutusraam = new JFrame();
		JTextArea tekst = new JTextArea();
		tekst.setEditable(false);
		tekst.setText(Main.mainbundle.getString("help1"));
		kasutusraam.add(tekst);
		kasutusraam.setVisible(true);
		kasutusraam.pack();
	}
}
