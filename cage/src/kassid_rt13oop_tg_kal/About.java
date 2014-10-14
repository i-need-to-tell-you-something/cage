package kassid_rt13oop_tg_kal;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class About implements ActionListener {
	String about="UI/About.txt";

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame aboutraam = new JFrame();
		JTextArea tekst = new JTextArea();
		tekst.setEditable(false);
		aboutraam.setTitle("Programmist ja autoritest");
		aboutraam.setVisible(true);
		aboutraam.setSize(300, 300);
		try {
			tekst.setText(Meetod.loe(about));
		} catch (IOException eee) {
			System.out.println("upsi");
		}
		catch (NullPointerException osi){
			System.out.println(osi);//Kui faili ei leia üles
			System.out.println("ei leia dokumenti \""+about+"\"");
		}
		aboutraam.add(tekst);
		tekst.setFont(new Font("Sherif", Font.PLAIN, 15));
//		System.out.println(tekst.getLineCount());
//		tekst.setBackground(Color.lightGray);

		// TODO Auto-generated method stub

	}

}
