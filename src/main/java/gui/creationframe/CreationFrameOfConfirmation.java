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
	
	
	private static JTextArea fenotypeFrameText = new JTextArea("");
	private static String deftext= Locales.mainBundle.getString("label2");
	private static JTextField catName = new JTextField(deftext);
	private static JButton catCreationButton = new JButton(Locales.mainBundle.getString("button9"));

	
	public CreationFrameOfConfirmation(){
		
		//Listing that this component needs to fire when there's a locale change
		MenuLanguageListener.addToDeclaredComponents(this);
		
		Container fenotypeFrameRoot= getContentPane();
		fenotypeFrameRoot.setLayout(new BorderLayout());
		Container fenotypeFrameMain= new Container();
		JPanel fenotypeFrameLower= new JPanel();
		
		fenotypeFrameRoot.add(fenotypeFrameMain, BorderLayout.CENTER);
		fenotypeFrameRoot.add(fenotypeFrameLower, BorderLayout.SOUTH);
		
		fenotypeFrameMain.setLayout(new BorderLayout());
		fenotypeFrameLower.setLayout(new GridLayout(2,1));

		fenotypeFrameMain.add(fenotypeFrameText,BorderLayout.CENTER);
		fenotypeFrameText.setEditable(false);
		
		//Loomisasjad
		
		//Fenotüübi kasti kassi nime sisestamise väli	
		fenotypeFrameLower.add(catName);
		catName.addFocusListener(new CreationListener());
		
		//Fenotüübi kasti "loo kass" nupp
		fenotypeFrameLower.add(catCreationButton);
		catCreationButton.addActionListener(new CreationListener());
		this.getRootPane().setDefaultButton(catCreationButton);
		
		
	}

	//Getters and setters
	
	public static void setFenotypeFrameText(String newFenotypeFrameText) {
		CreationFrameOfConfirmation.fenotypeFrameText.setText(newFenotypeFrameText);
	}
	
	public static String getDeftext() {
		return deftext;
	}
	public static String getCatName() {
		return catName.getText();
	}
	public static void setCatName(String newCatName) {
		CreationFrameOfConfirmation.catName.setText(newCatName);
	}

	@Override
	public void onLocaleChange() {
		deftext = Locales.mainBundle.getString("label2");
		catName.setText(deftext);
		catCreationButton.setText(Locales.mainBundle.getString("button9"));
	}	
}
