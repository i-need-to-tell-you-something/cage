package kassid_rt13oop_tg_kal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Kasutusjuhend implements ActionListener {
	String kasutusjuhend="UI/Kasutamisjuhend.txt";

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFrame kasutusraam = new JFrame();
		JTextArea tekst = new JTextArea();
		tekst.setEditable(false);
		kasutusraam.setVisible(true);
		kasutusraam.setSize(500, 800);
		try {
			tekst.setText(Meetod.loe(kasutusjuhend));
		} catch (IOException eee) {
			System.out.println("upsi");
		}
		catch (NullPointerException osi){
			System.out.println(osi);//Kui faili ei leia üles
			System.out.println("ei leia dokumenti \""+kasutusjuhend+"\"");
		}
		kasutusraam.add(tekst);
//		tekst.setBackground(Color.lightGray);
		// TODO Auto-generated method stub

	}
}
