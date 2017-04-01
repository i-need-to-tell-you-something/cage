package gui.creationframe;
import gui.menubar.LocaleChangeListener;
import gui.menubar.Locales;
import gui.menubar.MenuLanguageListener;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * @author k This class displays the frame used for creating a new cat.
 *
 */



@SuppressWarnings({ "serial"})
public class CreationFrameOfConfirmation extends JFrame implements LocaleChangeListener{
	
	
	static JTextArea fenot = new JTextArea("");
	static String deftext= Locales.mainbundle.getString("label2");
	private static JTextField catName = new JTextField(deftext);
	static JButton kassiloomisnupp = new JButton(Locales.mainbundle.getString("button9"));

	
	public CreationFrameOfConfirmation(){
		
		//Listing that this component needs to fire when there's a locale change
		MenuLanguageListener.addToDeclaredComponents(this);
		
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
		loomisasjad.add(catName);
		catName.addFocusListener(new CreationListener());
		
		//Fenotüübi kasti "loo kass" nupp
		loomisasjad.add(kassiloomisnupp);
		kassiloomisnupp.addActionListener(new CreationListener());
		this.getRootPane().setDefaultButton(kassiloomisnupp);
		
		
	}
//	public static JTextArea getFenot() {
//		return fenot;
//	}

	// Eriline setter kuularile
	public static void setFenot(String fenot) {
		CreationFrameOfConfirmation.fenot.setText(fenot);
	}
	
	//Getters and setters
	public static String getDeftekst() {
		return deftext;
	}
	public static String getCatName() {
		return catName.getText();
	}
	public static void setCatName(String newCatName) {
		CreationFrameOfConfirmation.catName.setText(newCatName);
	}
//	public static void setFenot(JTextArea fenot) {
//		CreationFrameOfConfirmation.fenot = fenot;
//	}
	@Override
	public void onLocaleChange() {
		deftext = Locales.mainbundle.getString("label2");
		catName.setText(deftext);
		kassiloomisnupp.setText(Locales.mainbundle.getString("button9"));
	}	
}