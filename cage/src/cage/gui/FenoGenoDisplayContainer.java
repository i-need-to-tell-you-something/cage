package cage.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.text.MessageFormat;

import javax.swing.JFrame;
import javax.swing.JTextField;

import cage.gui.menubar.LocaleChangeListener;
import cage.gui.menubar.Locales;
import cage.gui.menubar.MenuLanguageListener;

/**
 * This is a method to show either genotype or fenotype, depending on 
 * parameters passed by the main frame, in a nice box.
 * @author K 
 *  
 */

@SuppressWarnings("serial")
public class FenoGenoDisplayContainer extends JFrame implements LocaleChangeListener{
	// konstandid
	static final int FENOTYPE = 0;
	static final int GENOTYPE = 1;
	int type;
	String catName;
	

	public FenoGenoDisplayContainer(JTextField[] fenotext, String catName, int type) {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.type = type;
		this.catName = catName;
		
		//Setting up a locale-sensitive title
		onLocaleChange();
		//Listing that this component needs to fire whenever there's a locale change
		MenuLanguageListener.addToDeclaredComponents(this);
		
		//Main container
		Container fenojumal = getContentPane();
		fenojumal.setLayout(new BorderLayout());

		//Creating a nice box to show rows of fenotype 
		Container fenotekstikast = new Container();
		fenojumal.add(fenotekstikast, BorderLayout.CENTER);
		fenotekstikast.setLayout(new GridLayout(10, 1));

		//Fenotype text gets added to said box
		for (int i = 0; i < fenotext.length; i++) {
			fenotekstikast.add(fenotext[i], i);
		}
	}


	@Override
	public void onLocaleChange() {
		MessageFormat formatter = new MessageFormat("");
	    formatter.setLocale(Locales.currentLocale);
	    Object [] messageArguments = {catName};
	    if (type==FENOTYPE) {
	    	formatter.applyPattern(Locales.mainbundle.getString("title6"));
	    }
	    else {
	    	formatter.applyPattern(Locales.mainbundle.getString("title5"));
	    }
		this.setTitle(formatter.format(messageArguments));
	}
}
