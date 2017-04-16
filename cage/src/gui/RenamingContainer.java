package gui;

import gui.menubar.LocaleChangeListener;
import gui.menubar.Locales;
import gui.menubar.MenuLanguageListener;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.text.MessageFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import core.Kass;


/**
 * A frame displayed when renaming a cat.
 * 
 */
@SuppressWarnings("serial")
public class RenamingContainer extends JFrame implements LocaleChangeListener {

	JTextField textField = new JTextField();
	String catName;
	JLabel label = new JLabel();
	JButton button = new JButton();

	public RenamingContainer(Kass kass, Point p) throws HeadlessException {

		// Listing that this component needs to fire whenever there's a locale
		// change
		MenuLanguageListener.addToDeclaredComponents(this);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 90);
		this.setLocation(p);
		this.getContentPane().setLayout(new BorderLayout());
		catName = kass.getNimi();
		// setting up things that are already defined in the method
		// onLocaleChange()
		this.onLocaleChange();
		textField.setText(catName);

		// button
		button.setToolTipText(Locales.tipBundle.getString("tt12"));
		button.addActionListener(new RenamingListener(kass));

		// enter key:
		this.getRootPane().setDefaultButton(button);

		this.add(label, BorderLayout.WEST);
		this.add(textField, BorderLayout.CENTER);
		this.add(button, BorderLayout.SOUTH);

		this.setVisible(true);
	}

	@Override
	public void onLocaleChange() {
		this.setTitle(new MessageFormat(Locales.mainBundle.getString("title8")).format( new Object[] { catName } ) );
		label.setText(Locales.mainBundle.getString("label4"));
		button.setText(Locales.mainBundle.getString("button11"));

	}

}
