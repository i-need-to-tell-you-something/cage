package kassid_rt13oop_tg_kal;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;


@SuppressWarnings("serial")
public class Kassiraam extends JFrame {


	static JButton n1 = new JButton("Kuva omadusi");
	static JButton n2 = new JButton("Kuva geene");
	static JButton n3 = new JButton("Kuva pilt");
	static JButton n4 = new JButton("Lisa uus");
	static JButton n5 = new JButton("Lisa uus geenidega");
	static JButton n6 = new JButton("Rista");
	static JButton n7 = new JButton("Muuda nime");
	static JButton n8 = new JButton("Eemalda");

	static DefaultListModel<Kass> kassid = new DefaultListModel<Kass>();
	static JList<Kass> kassilist = new JList<Kass>(kassid);

	// kaks akent. esialgu nähtamatud. enne olid eraldi klassis KassiNupud
	static KassiNupuKonteiner kassiNupuRaam = new KassiNupuKonteiner();
	static LoomisKonteiner fenoraam = new LoomisKonteiner();

	// väljad läbi ja nüüd konstruktor meetod
	public Kassiraam() {

		// JFrame raami loomine kassiloomiseks
		kassiNupuRaam.setTitle("Kassi loomine");
		kassiNupuRaam.setSize(500, 320);
		kassiNupuRaam.setLocation(0, 100);
		kassiNupuRaam.addWindowListener(new AknaKuular());

		// JFrame raami loomine fenotüübi näitamiseks ja loomiseks
		fenoraam.setSize(400, 250);
		fenoraam.setLocation(500, 100);
		fenoraam.setTitle("Loodava kassi fenotüüp");
		fenoraam.addWindowListener(new AknaKuular());

		// põhiraam
		this.setJMenuBar(new Menuu());
		this.setTitle("CAGE");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			ImageIcon ikoon = new ImageIcon("data//gfx//icons//icon1.png");
			this.setIconImage(ikoon.getImage());
		}
		catch (NullPointerException e) {
			System.out.println("Erind ikooniga" + e.getMessage());
		}

		Container sisu = new Container(); // vahekonteiner
		this.setContentPane(sisu);
		sisu.setLayout(new BorderLayout());

		// GUI VASAK POOL
		Container vp = new Container();
		sisu.add(vp, BorderLayout.CENTER);
		vp.setLayout(new BorderLayout());
		//		((GridLayout) sisu.getLayout()).setHgap(10);

		// väike kena sildike
		vp.add(new JLabel("Kassid:"), BorderLayout.NORTH);

		// paneme kassilisti JList'i, mille paneme JScrollPane'i
		kassilist.setVisibleRowCount(-1);
		kassilist.setValueIsAdjusting(false);
		kassilist.addListSelectionListener(new KassiRaamiListikuular());

		JScrollPane vpvc = new JScrollPane(kassilist);
		vpvc.setPreferredSize(new Dimension(150, 100));
		vp.add(vpvc, BorderLayout.CENTER);
		kassilist
		.setToolTipText("Siin on kõik vaatluse all olevad kassid. Neil saab kasutada paremal olevaid käsklusi. "
				+ "Mitu kassi saab valida hoides all CTRL nuppu.");

		// GUI PAREM POOL
		Container pp = new Container(); // põhikonteiner
		Container ppvc = new Container(); // vahekonteiner jälle
		sisu.add(pp, BorderLayout.EAST);
		pp.add(ppvc);

		// nende layoutid
		pp.setLayout(new FlowLayout());
		ppvc.setLayout(new GridLayout(8, 1));
		((GridLayout) ppvc.getLayout()).setVgap(10); // kosm. nüanss

		// nupud

		n1.setMnemonic(java.awt.event.KeyEvent.VK_O);
		n2.setMnemonic(java.awt.event.KeyEvent.VK_G);
		n3.setMnemonic(java.awt.event.KeyEvent.VK_P);
		n4.setMnemonic(java.awt.event.KeyEvent.VK_L);
		n5.setMnemonic(java.awt.event.KeyEvent.VK_U);
		n6.setMnemonic(java.awt.event.KeyEvent.VK_R);
		n7.setMnemonic(java.awt.event.KeyEvent.VK_M);
		n8.setMnemonic(java.awt.event.KeyEvent.VK_E);
		//				n7.setMnemonic(java.awt.event.KeyEvent.VK_DELETE);
		n1.addActionListener(new KassiRaamiNupukuular());
		n2.addActionListener(new KassiRaamiNupukuular());
		n3.addActionListener(new KassiRaamiNupukuular());
		n4.addActionListener(new KassiRaamiNupukuular());
		n5.addActionListener(new KassiRaamiNupukuular());
		n6.addActionListener(new KassiRaamiNupukuular());
		n7.addActionListener(new KassiRaamiNupukuular());
		n8.addActionListener(new KassiRaamiNupukuular());
		n1.setToolTipText("Ava aknakesed valitud kasside fenotüüpide kirjeldustega");
		n2.setToolTipText("Ava aknakesed valitud kasside genotüüpidega");
		n3.setToolTipText("Ava aknake valitud kassi pildiga");
		n4.setToolTipText("Lisa uus suvalise genotüübiga Kass");
		n5.setToolTipText("Ava aknake, kus valida lisatava Kassi genotüüpi");
		n6.setToolTipText("Rista kaht valitud vastassoost Kassi");
		n7.setToolTipText("Ava aknakesed valitud kasside nimede muutmiseks");
		n8.setToolTipText("Eemalda valitud Kassid");
		n1.setEnabled(false);
		n2.setEnabled(false);
		n3.setEnabled(false);
		n6.setEnabled(false);
		n7.setEnabled(false);
		n8.setEnabled(false);
		ppvc.add(n1);
		ppvc.add(n2);
		ppvc.add(n3);
		ppvc.add(n4);
		ppvc.add(n5);
		ppvc.add(n6);
		ppvc.add(n7);
		ppvc.add(n8);
	}
}
