package kassid_rt13oop_tg_kal;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;

public class AboutListener implements ActionListener {
	static String about = "ui/About.txt";
	static String lingid = "ui/Aboutlingid.txt";

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame aboutraam = new JFrame();
//		JTextArea tekst = new JTextArea();
		JEditorPane  tekst = new JEditorPane();
		JEditorPane  tekstlingid = new JEditorPane();
		tekst.setEditable(false);
		tekstlingid.setEditable(false);
		aboutraam.setTitle(Main.mainbundle.getString("title4"));
		aboutraam.setVisible(true);
		aboutraam.setSize(400, 300);
		aboutraam.getContentPane().setLayout(new BorderLayout());
		try {
			tekst.setText(FileToString.loe(about));
		} catch (IOException eee) {
			System.out.println("upsi");
		} catch (NullPointerException osi){ //Kui faili ei leia üles
			System.out.println("ei leia dokumenti \""+about+"\"");
		}
		try {
			tekstlingid.setText(FileToString.loe(lingid));
		} catch (IOException eee) {
			System.out.println("upsi");
		} catch (NullPointerException osi){;//Kui faili ei leia üles
			System.out.println("ei leia dokumenti \""+lingid+"\"");
		}
		aboutraam.add(tekst, BorderLayout.NORTH);
		aboutraam.add(tekstlingid, BorderLayout.SOUTH);
		tekst.setFont(new Font("Sherif", Font.PLAIN, 15));


	}

}
