package kassid_rt13oop_tg_kal;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



@SuppressWarnings({ "serial"})
public class LoomisKonteiner extends JFrame implements LocaleChangeListener{
	
	
	static JTextArea fenot = new JTextArea("");
	static String deftekst= Main.mainbundle.getString("label2");
	static JTextField kassinimi = new JTextField(deftekst);
	static JButton kassiloomisnupp = new JButton(Main.mainbundle.getString("button9"));

	
	public LoomisKonteiner(){
		
		//Listing that this component needs to fire when there's a locale change
		MenuuLanguageListener.addToDeclaredComponents(this);
		
		Container fenojumal= getContentPane();
		fenojumal.setLayout(new BorderLayout());
		Container fenotekst= new Container();
		JPanel loomisasjad= new JPanel();
		
		fenojumal.add(fenotekst, BorderLayout.CENTER);
		fenojumal.add(loomisasjad, BorderLayout.SOUTH);
		
		fenotekst.setLayout(new BorderLayout());
		loomisasjad.setLayout(new GridLayout(2,1));

		fenotekst.add(fenot,BorderLayout.CENTER);
		fenot.setEditable(false);
		
		//Loomisasjad
		
		//Fenotüübi kasti kassi nime sisestamise väli	
		loomisasjad.add(kassinimi);
		kassinimi.addFocusListener(new LoominguKuular());
		
		//Fenotüübi kasti "loo kass" nupp
		loomisasjad.add(kassiloomisnupp);
		kassiloomisnupp.addActionListener(new LoominguKuular());
		this.getRootPane().setDefaultButton(kassiloomisnupp);
		
		
	}
//	public static JTextArea getFenot() {
//		return fenot;
//	}

	// Eriline setter kuularile
	public static void setFenot(String fenot) {
		LoomisKonteiner.fenot.setText(fenot);
	}
	
	//Getters and setters
	public static String getDeftekst() {
		return deftekst;
	}
//	public static void setDeftekst(String deftekst) {
//		LoomisKonteiner.deftekst = deftekst;
//	}
//	public static JTextField getKassinimi() {
//		return kassinimi;
//	}
//	public static void setKassinimi(JTextField kassinimi) {
//		LoomisKonteiner.kassinimi = kassinimi;
//	}
//	public static void setFenot(JTextArea fenot) {
//		LoomisKonteiner.fenot = fenot;
//	}
	@Override
	public void onLocaleChange() {
		deftekst = Main.mainbundle.getString("label2");
		kassinimi.setText(deftekst);
		kassiloomisnupp.setText(Main.mainbundle.getString("button9"));
	}	
}