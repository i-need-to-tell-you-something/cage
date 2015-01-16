package kassid_rt13oop_tg_kal;

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


@SuppressWarnings("serial")
public class Kassiraam extends JFrame implements LocaleChangeListener {

	static JButton n1 = new JButton(Main.mainbundle.getString("button1"));
	static JButton n2 = new JButton(Main.mainbundle.getString("button2"));
	static JButton n3 = new JButton(Main.mainbundle.getString("button3"));
	static JButton n4 = new JButton(Main.mainbundle.getString("button4"));
	static JButton n5 = new JButton(Main.mainbundle.getString("button5"));
	static JButton n6 = new JButton(Main.mainbundle.getString("button6"));
	static JButton n7 = new JButton(Main.mainbundle.getString("button7"));
	static JButton n8 = new JButton(Main.mainbundle.getString("button8"));

	static DefaultListModel<Kass> kassid = new DefaultListModel<Kass>();
	static JList<Kass> kassilist = new JList<Kass>(kassid);
	
	static JLabel sildike = new JLabel(Main.mainbundle.getString("label1"));
	
	static Menuu menu = new Menuu();

	// kaks akent. esialgu nähtamatud. enne olid eraldi klassis KassiNupud
	static KassiNupuKonteiner kassiNupuRaam = new KassiNupuKonteiner();
	private static LoomisKonteiner fenoraam = new LoomisKonteiner();

	// väljad läbi ja nüüd konstruktor meetod
	public Kassiraam() {
		
		//Listing that this component needs to fire whenever there's a locale change
		MenuuLanguageListener.addToDeclaredComponents(this);
		
		// JFrame raami loomine kassiloomiseks. peidetud
		kassiNupuRaam.setSize(500, 320);
		kassiNupuRaam.setLocation(0, 100);
		kassiNupuRaam.setTitle(Main.mainbundle.getString("title2"));
		kassiNupuRaam.addWindowListener(new AknaKuular());

		// JFrame raami loomine fenotüübi näitamiseks ja loomiseks. peidetud
		getFenoraam().setSize(400, 250);
		getFenoraam().setLocation(500, 100);
		getFenoraam().setTitle(Main.mainbundle.getString("title3"));
		getFenoraam().addWindowListener(new AknaKuular());

		// põhiraam
		this.setJMenuBar(menu);
		this.setTitle(Main.mainbundle.getString("title1"));
		this.addWindowListener(new KassiRaamiSulgemisKuular());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			ImageIcon ikoon = new ImageIcon("data//gfx//icons//Program-Icon.png");
			this.setIconImage(ikoon.getImage());
		}
		catch (NullPointerException e) {
			//TODO error standardization
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
		kassilist.setVisibleRowCount(-1);
		kassilist.setValueIsAdjusting(false);
		kassilist.addListSelectionListener(new KassiRaamiListikuular());

		JScrollPane vpvc = new JScrollPane(kassilist);
		vpvc.setPreferredSize(new Dimension(250, 250));
		vp.add(vpvc, BorderLayout.CENTER);
		kassilist.setToolTipText(Main.tipbundle.getString("tt1"));

		
		// TOOLBAR
		JToolBar toolbar = new JToolBar();
		sisu.add(toolbar,BorderLayout.PAGE_START);
//		toolbar.setFloatable(false);
		// nupud
		MakeAndAddButtons(toolbar, n1, "Kuva omadusi", java.awt.event.KeyEvent.VK_O, "tt2", false);
		MakeAndAddButtons(toolbar, n2, "Kuva geene", java.awt.event.KeyEvent.VK_G, "tt3", false);
		MakeAndAddButtons(toolbar, n3, "Kuva pilt", java.awt.event.KeyEvent.VK_P, "tt4", false);
		MakeAndAddButtons(toolbar, n4, "Lisa uus", java.awt.event.KeyEvent.VK_L, "tt5", true);
		MakeAndAddButtons(toolbar, n5, "Lisa uus geenidega", java.awt.event.KeyEvent.VK_U, "tt6", true);
		MakeAndAddButtons(toolbar, n6, "Rista", java.awt.event.KeyEvent.VK_R, "tt7", false);
		MakeAndAddButtons(toolbar, n7, "Muuda nime", java.awt.event.KeyEvent.VK_M, "tt8", false);
		MakeAndAddButtons(toolbar, n8, "Eemalda", java.awt.event.KeyEvent.VK_E, "tt9", false);
		
	}
	
	/**
	 * Configures buttons and adds them to the toolbar of the main frame of this program
	 *
	 * @param  toolbar  just passing on the reference, too lazy to make it static 
	 * @param  nupp  the reference to the button to be manipulated
	 * @param  actionCommand  the command to be called when the button is pressed
	 * @param  mnemonic  set a hotkey to the button in the format of int as specified by java.awt.event.KeyEvent constants
	 * @param  tooltipID the key to the tooltiptext value in the resourcebundle "tipbundle"
	 * @param  initEnabled specifies wether the button is initially (when 0 cats are selected) enabled or not.
	 * @return      void
	 */
	protected void MakeAndAddButtons(JToolBar toolbar, JButton nupp, String actionCommand, int mnemonic, String tooltipID, boolean initEnabled) {
		nupp.setMnemonic(mnemonic);
		nupp.setActionCommand(actionCommand);
		nupp.addActionListener(new KassiRaamiNupukuular());
		nupp.setToolTipText(Main.tipbundle.getString(tooltipID));
		nupp.setEnabled(initEnabled);
		toolbar.add(nupp);
	}

	@Override
	public void onLocaleChange() {
		this.setTitle(Main.mainbundle.getString("title1"));
		kassiNupuRaam.setTitle(Main.mainbundle.getString("title2"));
		getFenoraam().setTitle(Main.mainbundle.getString("title3"));
		kassilist.setToolTipText(Main.tipbundle.getString("tt1"));
		sildike.setText(Main.mainbundle.getString("label1"));
		n1.setText(Main.mainbundle.getString("button1"));
		n2.setText(Main.mainbundle.getString("button2"));
		n3.setText(Main.mainbundle.getString("button3"));
		n4.setText(Main.mainbundle.getString("button4"));
		n5.setText(Main.mainbundle.getString("button5"));
		n6.setText(Main.mainbundle.getString("button6"));
		n7.setText(Main.mainbundle.getString("button7"));
		n8.setText(Main.mainbundle.getString("button8"));
		n1.setToolTipText(Main.tipbundle.getString("tt2"));
		n2.setToolTipText(Main.tipbundle.getString("tt3"));
		n3.setToolTipText(Main.tipbundle.getString("tt4"));
		n4.setToolTipText(Main.tipbundle.getString("tt5"));
		n5.setToolTipText(Main.tipbundle.getString("tt6"));
		n6.setToolTipText(Main.tipbundle.getString("tt7"));
		n7.setToolTipText(Main.tipbundle.getString("tt8"));
		n8.setToolTipText(Main.tipbundle.getString("tt9"));
	}


	//Getters and setters
	
	public static LoomisKonteiner getFenoraam() {
		return fenoraam;
	}

	public static void setFenoraam(LoomisKonteiner fenoraam) {
		Kassiraam.fenoraam = fenoraam;
	}
}
