package gui;

import gui.creationframe.CreationFrameClosingListener;
import gui.creationframe.CreationFrameOfConfirmation;
import gui.creationframe.CreationFrameOfSelection;
import gui.menubar.LocaleChangeListener;
import gui.menubar.Locales;
import gui.menubar.Menu;
import gui.menubar.MenuLanguageListener;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

import core.FilePaths;
import core.Kass;


@SuppressWarnings("serial")
public class CAGEFrame extends JFrame implements LocaleChangeListener {

	static JButton n1 = new JButton(Locales.mainBundle.getString("button1"));
	static JButton n2 = new JButton(Locales.mainBundle.getString("button2"));
	static JButton n3 = new JButton(Locales.mainBundle.getString("button3"));
	static JButton n4 = new JButton(Locales.mainBundle.getString("button4"));
	static JButton n5 = new JButton(Locales.mainBundle.getString("button5"));
	static JButton n6 = new JButton(Locales.mainBundle.getString("button6"));
	static JButton n7 = new JButton(Locales.mainBundle.getString("button7"));
	static JButton n8 = new JButton(Locales.mainBundle.getString("button8"));

	private static DefaultListModel<Kass> kassid = new DefaultListModel<Kass>();
	private static JList<Kass> kassilist = new JList<Kass>(kassid);

	static JLabel sildike = new JLabel(Locales.mainBundle.getString("label1"));

	static Menu menu = new Menu();

	// kaks akent. esialgu nähtamatud. enne olid eraldi klassis KassiNupud
	private static CreationFrameOfSelection CFOSelection = new CreationFrameOfSelection();
	private static CreationFrameOfConfirmation CFOConfirmation = new CreationFrameOfConfirmation();

	// väljad läbi ja nüüd konstruktor meetod
	public CAGEFrame() {

		// Listing that this component needs to fire whenever there's a locale
		// change
		MenuLanguageListener.addToDeclaredComponents(this);

		// JFrame raami loomine kassiloomiseks. peidetud
		getCreationFrameOfSelection().setSize(500, 320);
		getCreationFrameOfSelection().setLocation(0, 100);
		getCreationFrameOfSelection().setTitle(
				Locales.mainBundle.getString("title2"));
		getCreationFrameOfSelection().addWindowListener(
				new CreationFrameClosingListener());

		// JFrame raami loomine fenotüübi näitamiseks ja loomiseks. peidetud
		getCreationFrameOfConfirmation().setSize(400, 250);
		getCreationFrameOfConfirmation().setLocation(500, 100);
		getCreationFrameOfConfirmation().setTitle(
				Locales.mainBundle.getString("title3"));
		getCreationFrameOfConfirmation().addWindowListener(
				new CreationFrameClosingListener());

		// põhiraam
		this.setJMenuBar(menu);
		this.setTitle(Locales.mainBundle.getString("title1"));
		this.addWindowListener(new CAGEFrameClosingListener());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			ImageIcon ikoon = new ImageIcon(FilePaths.gfx+"/icons/Program-Icon.png");
			this.setIconImage(ikoon.getImage());
		} catch (NullPointerException e) {
			// TODO error standardization
			System.out.println("Erind ikooniga" + e.getMessage());
		}

		Container sisu = new Container(); // vahekonteiner
		this.setContentPane(sisu);
		sisu.setLayout(new BorderLayout());

		// GUI VASAK POOL
		Container vp = new Container();
		sisu.add(vp, BorderLayout.CENTER);
		vp.setLayout(new BorderLayout());

		// väike kena sildike
		vp.add(sildike, BorderLayout.NORTH);

		// paneme kassilisti JList'i, mille paneme JScrollPane'i
		getKassiList().setVisibleRowCount(-1);
		getKassiList().setValueIsAdjusting(false);
		getKassiList().addListSelectionListener(new CAGEFrameListListener());

		JScrollPane vpvc = new JScrollPane(getKassiList());
		vpvc.setPreferredSize(new Dimension(250, 250));
		vp.add(vpvc, BorderLayout.CENTER);
		getKassiList().setToolTipText(Locales.tipBundle.getString("tt1"));

		// TOOLBAR
		JToolBar toolbar = new JToolBar();
		sisu.add(toolbar, BorderLayout.PAGE_START);
		// toolbar.setFloatable(false);
		// nupud
		MakeAndAddButtons(toolbar, n1, "Kuva omadusi",
				java.awt.event.KeyEvent.VK_O, "tt2", false);
		MakeAndAddButtons(toolbar, n2, "Kuva geene",
				java.awt.event.KeyEvent.VK_G, "tt3", false);
		MakeAndAddButtons(toolbar, n3, "Kuva pilt",
				java.awt.event.KeyEvent.VK_P, "tt4", false);
		MakeAndAddButtons(toolbar, n4, "Lisa uus",
				java.awt.event.KeyEvent.VK_L, "tt5", true);
		MakeAndAddButtons(toolbar, n5, "Lisa uus geenidega",
				java.awt.event.KeyEvent.VK_U, "tt6", true);
		MakeAndAddButtons(toolbar, n6, "Rista", java.awt.event.KeyEvent.VK_R,
				"tt7", false);
		MakeAndAddButtons(toolbar, n7, "Muuda nime",
				java.awt.event.KeyEvent.VK_M, "tt8", false);
		MakeAndAddButtons(toolbar, n8, "Eemalda", java.awt.event.KeyEvent.VK_E,
				"tt9", false);

		this.pack();
		this.setLocation(100, 0);
		this.setVisible(true);

	}

	/**
	 * Configures buttons and adds them to the toolbar of the main frame of this
	 * program
	 *
	 * @param toolbar
	 *            just passing on the reference, too lazy to make it static
	 * @param nupp
	 *            the reference to the button to be manipulated
	 * @param actionCommand
	 *            the command to be called when the button is pressed
	 * @param mnemonic
	 *            set a hotkey to the button in the format of int as specified
	 *            by java.awt.event.KeyEvent constants
	 * @param tooltipID
	 *            the key to the tooltiptext value in the resourcebundle
	 *            "tipbundle"
	 * @param initEnabled
	 *            specifies wether the button is initially (when 0 cats are
	 *            selected) enabled or not.
	 * @return void
	 */
	protected void MakeAndAddButtons(JToolBar toolbar, JButton nupp,
			String actionCommand, int mnemonic, String tooltipID,
			boolean initEnabled) {
		nupp.setMnemonic(mnemonic);
		nupp.setActionCommand(actionCommand);
		nupp.addActionListener(new CAGEFrameToolbarButtonListener());
		nupp.setToolTipText(Locales.tipBundle.getString(tooltipID));
		nupp.setEnabled(initEnabled);
		toolbar.add(nupp);
	}

	@Override
	public void onLocaleChange() {
		this.setTitle(Locales.mainBundle.getString("title1"));
		getCreationFrameOfSelection().setTitle(
				Locales.mainBundle.getString("title2"));
		getCreationFrameOfConfirmation().setTitle(
				Locales.mainBundle.getString("title3"));
		getKassiList().setToolTipText(Locales.tipBundle.getString("tt1"));
		sildike.setText(Locales.mainBundle.getString("label1"));
		n1.setText(Locales.mainBundle.getString("button1"));
		n2.setText(Locales.mainBundle.getString("button2"));
		n3.setText(Locales.mainBundle.getString("button3"));
		n4.setText(Locales.mainBundle.getString("button4"));
		n5.setText(Locales.mainBundle.getString("button5"));
		n6.setText(Locales.mainBundle.getString("button6"));
		n7.setText(Locales.mainBundle.getString("button7"));
		n8.setText(Locales.mainBundle.getString("button8"));
		n1.setToolTipText(Locales.tipBundle.getString("tt2"));
		n2.setToolTipText(Locales.tipBundle.getString("tt3"));
		n3.setToolTipText(Locales.tipBundle.getString("tt4"));
		n4.setToolTipText(Locales.tipBundle.getString("tt5"));
		n5.setToolTipText(Locales.tipBundle.getString("tt6"));
		n6.setToolTipText(Locales.tipBundle.getString("tt7"));
		n7.setToolTipText(Locales.tipBundle.getString("tt8"));
		n8.setToolTipText(Locales.tipBundle.getString("tt9"));
		// This is necessary for updating 4 labels (male, female, doubleY) in
		// method Kass
		this.repaint();
	}

	// Getters and setters

	/**
	 * @return the part of the cat Creation Frame that deals with name,
	 *         displaying fenotype and confirmation
	 */
	public static CreationFrameOfConfirmation getCreationFrameOfConfirmation() {
		return CFOConfirmation;
	}

	/**
	 * @return The list of cats
	 */
	public static JList<Kass> getKassiList() {
		return kassilist;
	}

	/**
	 * @param kass The cat to be added to the list
	 */
	public static void addKass(Kass kass) {
		kassid.addElement(kass);
	}

	/**
	 * @param kass The cat to be removed from the list
	 */
	public static void removeKass(Kass kass) {
		kassid.removeElement(kass);
	}

	/**
	 * @return The part of the cat Creation Frame that deals with selecting the genotype
	 */
	public static CreationFrameOfSelection getCreationFrameOfSelection() {
		return CFOSelection;
	}

}
