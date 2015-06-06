package kassid_rt13oop_tg_kal;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.text.MessageFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/** A frame displayed when renaming a cat.
 * @author K 
 */
@SuppressWarnings("serial")
public class NamingContainer extends JFrame implements LocaleChangeListener {

	JTextField lahter = new JTextField();
	String kassinimi;
	JLabel silt = new JLabel(); 
	JButton nupp = new JButton();
	
	public NamingContainer(Kass k, Point p) throws HeadlessException {
		
		//Listing that this component needs to fire whenever there's a locale change
		MenuuLanguageListener.addToDeclaredComponents(this);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 90);
		this.setLocation(p);
		this.getContentPane().setLayout(new BorderLayout());
		kassinimi = k.getNimi();
		// setting up things that are already defined in the method onLocaleChange()
		this.onLocaleChange();
		lahter.setText(kassinimi);
		
		//button
		nupp.setToolTipText(Main.tipbundle.getString("tt12"));
		nupp.addActionListener(new NamingListener(k));
		
		//enter key:
		this.getRootPane().setDefaultButton(nupp);
		
		this.add(silt, BorderLayout.WEST);
		this.add(lahter, BorderLayout.CENTER);
		this.add(nupp, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

	@Override
	public void onLocaleChange() {
		MessageFormat formatter = new MessageFormat("");
	    formatter.setLocale(Main.currentLocale);
	    Object [] messageArguments = {kassinimi};
	    formatter.applyPattern(Main.mainbundle.getString("title8"));
	    this.setTitle(formatter.format(messageArguments));
	    silt.setText(Main.mainbundle.getString("label4"));     
	    nupp.setText(Main.mainbundle.getString("button11")); 
		
	}

}
