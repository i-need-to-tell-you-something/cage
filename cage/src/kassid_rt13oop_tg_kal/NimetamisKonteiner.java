package kassid_rt13oop_tg_kal;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.text.MessageFormat;

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
		String kassinimi = k.getNimi();
		MessageFormat formatter = new MessageFormat("");
	    formatter.setLocale(Main.currentLocale);
	    Object [] messageArguments = {kassinimi};
	    formatter.applyPattern(Main.mainbundle.getString("title8"));
	    this.setTitle(formatter.format(messageArguments));
		
		//komponendid
		JLabel silt = new JLabel(Main.mainbundle.getString("label4"));
		JButton nupp = new JButton(Main.mainbundle.getString("button11"));
		lahter.setText(kassinimi);
		
		//nupp
		nupp.setToolTipText(Main.tipbundle.getString("tt12"));
		nupp.addActionListener(new NimetamisKuular(k));
		
		//enter klahv:
		this.getRootPane().setDefaultButton(nupp);
		
		this.add(silt, BorderLayout.WEST);
		this.add(lahter, BorderLayout.CENTER);
		this.add(nupp, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

}
