package kassid_rt13oop_tg_kal;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NimetamisKonteiner extends JFrame {

	JTextField lahter = new JTextField();
	
	public NimetamisKonteiner(Kass k, Point p) throws HeadlessException {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 90);
		this.setLocation(p);
		this.getContentPane().setLayout(new BorderLayout());
		this.setTitle("Kassi " + k.getNimi() + " nime muutmine");
		
		//komponendid
		JLabel silt = new JLabel("Uus nimi:");
		JButton nupp = new JButton("OK");
		lahter.setText(k.getNimi());
		
		//nupp
		nupp.setToolTipText("Vajuta, et kinnitada hetkel sisestatud nimi [ENTER]");
		nupp.addActionListener(new NimetamisKuular(k));
		
		//enter klahv:
		this.getRootPane().setDefaultButton(nupp);
		
		this.add(silt, BorderLayout.WEST);
		this.add(lahter, BorderLayout.CENTER);
		this.add(nupp, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

}
