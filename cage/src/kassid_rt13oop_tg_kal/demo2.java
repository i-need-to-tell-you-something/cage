package kassid_rt13oop_tg_kal;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class demo2 {

	static JButton n1 = new JButton("Kuva omadusi");
	static JButton n2 = new JButton("Kuva geene");
	static JButton n3 = new JButton("Kuva pilt");
	static JButton n4 = new JButton("Lisa uus");
	static JButton n5 = new JButton("Lisa uus geenidega");
	static JButton n6 = new JButton("Rista");
	static JButton n7 = new JButton("Eemalda");
	
	static boolean vanemad = false;
	
	static DefaultListModel<Kass> kassid = new DefaultListModel<Kass>();
	static JList<Kass> kassilist = new JList<Kass>(kassid);

	// kaks akent. esialgu nähtamatud. enne olid eraldi klassis KassiNupud
	static KassiNupuKonteiner kassiNupuRaam = new KassiNupuKonteiner();
	static LoomisKonteiner fenoraam = new LoomisKonteiner();

	static void regnuppe(boolean[] nupud) {
		n1.setEnabled(nupud[0]);
		n2.setEnabled(nupud[1]);
		n3.setEnabled(nupud[2]);
		n6.setEnabled(nupud[3]);
		n7.setEnabled(nupud[4]);
	}

	// väljad läbi ja nüüd main meetod
	public static void main(String[] args) throws IOException {
		
		//Testimaks kas loeb lookusboonuse faili korrektselt sisse
//		for (int i = 0; i < 10; i++) {
//			System.out.println();
//			for (int j = 0; j < Andmed.tabel[i].length; j++) {
//				System.out.print(Andmed.tabel[i][j]);
//				System.out.print(" ");
//			}
//		}

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

		// JFrame põhiraam
		JFrame raam = new JFrame();
		raam.setJMenuBar(new Menuu());
		
		raam.setTitle("CATS");
		raam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		raam.setSize(500, 500);
		raam.setLocation(100, 0);
		
	
		Container sisu = new Container(); // vahekonteiner
		raam.setContentPane(sisu);
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
		kassilist.addListSelectionListener(new d2Listikuular());

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
		ppvc.setLayout(new GridLayout(7, 1));
		((GridLayout) ppvc.getLayout()).setVgap(10); // kosm. nüanss

		// nupud
				n1.setMnemonic(java.awt.event.KeyEvent.VK_O);
				n2.setMnemonic(java.awt.event.KeyEvent.VK_G);
				n3.setMnemonic(java.awt.event.KeyEvent.VK_P);
				n4.setMnemonic(java.awt.event.KeyEvent.VK_L);
				n5.setMnemonic(java.awt.event.KeyEvent.VK_U);
				n6.setMnemonic(java.awt.event.KeyEvent.VK_R);
				n7.setMnemonic(java.awt.event.KeyEvent.VK_E);
//				n7.setMnemonic(java.awt.event.KeyEvent.VK_DELETE);
				n1.addActionListener(new d2Nupukuular());
				n2.addActionListener(new d2Nupukuular());
				n3.addActionListener(new d2Nupukuular());
				n4.addActionListener(new d2Nupukuular());
				n5.addActionListener(new d2Nupukuular());
				n6.addActionListener(new d2Nupukuular());
				n7.addActionListener(new d2Nupukuular());
				n1.setToolTipText("Ava aknakesed valitud kasside fenotüüpide kirjeldustega");
				n2.setToolTipText("Ava aknakesed valitud kasside genotüüpidega");
				n3.setToolTipText("Ava aknake valitud kassi pildiga");
				n4.setToolTipText("Lisa uus suvalise genotüübiga Kass");
				n5.setToolTipText("Ava aknake, kus valida lisatava Kassi genotüüpi");
				n6.setToolTipText("Rista kaht valitud vastassoost Kassi");
				n7.setToolTipText("Eemalda valitud Kassid");
				n1.setEnabled(false);
				n2.setEnabled(false);
				n3.setEnabled(false);
				n6.setEnabled(false);
				n7.setEnabled(false);
				ppvc.add(n1);
				ppvc.add(n2);
				ppvc.add(n3);
				ppvc.add(n4);
				ppvc.add(n5);
				ppvc.add(n6);
				ppvc.add(n7);

				raam.setVisible(true);

			}

		}
