package gui.creationframe;

import gui.FenotypeToStrings;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import core.Kass;


/**
 * @author k
 *
 *         This method manages the buttons needed for constructing a cat with
 *         custom genetics
 */
@SuppressWarnings("serial")
public class CreationFrameOfSelection extends JFrame {

	// Esimese ahela väljad
	static String dnaStrand1 = "ah1";
	static String dnaStrand2 = "ah2";

	static JTextField dnaStrand1TextField[] = new JTextField[] { new JTextField(dnaStrand1),
			new JTextField(dnaStrand1), new JTextField(dnaStrand1), new JTextField(dnaStrand1),
			new JTextField(dnaStrand1), new JTextField(dnaStrand1), new JTextField(dnaStrand1),
			new JTextField(dnaStrand1), new JTextField(dnaStrand1), new JTextField(dnaStrand1) };

	// Teise ahela väljad

	static JTextField dnaStrand2TextField[] = new JTextField[] { new JTextField(dnaStrand2),
			new JTextField(dnaStrand2), new JTextField(dnaStrand2), new JTextField(dnaStrand2),
			new JTextField(dnaStrand2), new JTextField(dnaStrand2), new JTextField(dnaStrand2),
			new JTextField(dnaStrand2), new JTextField(dnaStrand2), new JTextField(dnaStrand2) };

	// konstruktor
	public CreationFrameOfSelection() {

		// Konteineri loomine Kolme kasti jaoks
		Container rootContainer = getContentPane();
		rootContainer.setLayout(new GridLayout(3, 1));

		// Esimese ahela valikute paneeli loomine
		JPanel box1 = new JPanel();
		box1.setLayout(new GridLayout(1, dnaStrand1TextField.length));
		box1.setName("ahKast1"); // nimi kastile, et hiljem identifitseerida
									// saaks

		// Toimivate ahela paneeli loomine
		JPanel box2 = new JPanel();
		box2.setLayout(new GridLayout(2, dnaStrand1TextField.length));

		// Teise ahela valikute paneeli loomine
		JPanel box3 = new JPanel();
		box3.setLayout(new GridLayout(1, dnaStrand1TextField.length));
		box3.setName("ahKast2"); // nimi kastile, et hiljem identifitseerida
									// saaks

		// Kastide lisamine suurde konteinerisse
		rootContainer.add(box1);
		rootContainer.add(box2);
		rootContainer.add(box3);

		// 1. ahela tekstikasti väärtuste manuaalselt muutumatuks tegemine ja
		// selle kasti
		// lisamine
		for (int i = 0; i < dnaStrand1TextField.length; i++) {
			dnaStrand1TextField[i].setEditable(false);
			box2.add(dnaStrand1TextField[i]);
		}
		// 2. ahela tekstikasti väärtuste manuaalselt muutumatuks tegemine ja
		// selle kasti
		// lisamine
		for (int i = 0; i < dnaStrand2TextField.length; i++) {
			dnaStrand2TextField[i].setEditable(false);
			box2.add(dnaStrand2TextField[i]);
		}

		// Sõne järjendite loomine, kus esimesel kohal on alleeli tähistus ja
		// teisel kohal selle (lühi)kirjeldus
		String[] alleela = { "a",
				"a on retsessiivne tunnus. Mõlemal ahelal peab olema see, et see avalduks" };
		String[] alleelA = { "A",
				"A on dominantne tunnus akuuti värvusele. Võimaldab triipude teket" };
		String[] alleelB = { "B",
				"B - mustad kassid, domineerib teiste alleelide üle" };
		String[] alleelb = { "b",
				"b - šokolaadipruunid kassid, retsessiivne alleeli \"B\" suhtes, domineerib \"bl\" alleeli üle" };
		String[] alleelbl = { "bl",
				"bl - karvkate roostepruun, retsessiivne teiste alleelide suhtes" };
		String[] alleelC = { "C",
				"C - tagab kassi normaalse karva värvumise, dominantne kõigi alleelide suhtes" };
		String[] alleelcb = { "cb",
				"cb - Birma kassid (värvus pruun, soojemates kohtades heledate laikudega), \"C\"-le retsessiivne" };
		String[] alleelcs = { "cs",
				"cs - Siiami kassid (Kere on hele, kõrvad, nägu, saba, käpad tumedad. Silmad intensiivsinised), \"C\"-le retsessiivne" };
		String[] alleelc = { "c",
				"c - albiino (karvad ei värvu, silmad punased), retsessiivne kõigi teiste tunnuste suhtes " };
		String[] alleelD = { "D",
				"D - ei toimu lahjenemist, dominantne \"d\" üle" };
		String[] alleeld = { "d",
				"d - ei toimu lahjenemist, retsessiivne \"D\" suhtes" };
		String[] alleelL = { "L",
				"L - lühikarvalisus, dominantne \"l\" alleeli üle" };
		String[] alleell = { "l",
				"l - pikakarvalisus, retsessiivne \"L\" alleeli suhtes" };
		String[] alleelO = { "O",
				"O - oranž karvavärvus, dominantne \"o\" alleeli üle" };
		String[] alleelo = { "o",
				"o - tavaline karvavärvus, retsessiivne \"O\" alleeli suhtes" };
		String[] alleelS = { "S",
				"S - Valged laigud, semidominantne \"s\" alleeli üle \n (SS puhul üle 50% kehast valgete laikudega kaetud, Ss puhul < 50% kehast" };
		String[] alleels = { "s",
				"s - ühtlane värvumine, ss puhul pole ühtegi valget laiku" };
		String[] alleelT = { "T",
				"T - tiigertüüpi vöödid, ss puhul pole ühtegi valget laiku" };
		String[] alleelTa = { "Ta",
				"Ta - vööte peaaegu pole, peened jooned. Intermediaalne teiste alleelidega" };
		String[] alleeltb = { "tb",
				"tb - laienenud vöödid, nagu oleksid piklikud laigud reas, retsessiivne alleeli \"T\" suhtes" };
		String[] alleelW = { "W", "W - valge värvumine, dominantne \"w\" üle" };
		String[] alleelw = { "w",
				"w - mittevalge värvumine, retsessiivne \"w\" suhtes" };
		String[] alleelX = { "X", "X - sugukromosoom" };
		String[] alleelY = { "Y", "Y - sugukromosoom" };

		// Ahelatele lookuste kirjeldus
		String[] lookKir = new String[10];
		lookKir[0] = "A lookus on akuutivärvuse lookus. Annab kassile hallikas-kollaka varjundi, nn metsikloomavärvuse e aguutivärvuse. Ainult A alleeli olemasolul võivad karvkattes ilmneda vöödid ja triibud";
		lookKir[1] = "B lookus määrab karva põhivärvuse. Kui d lookus avaldub, siis on seda värvi mis sealt tuleb (nt must kass pole must vaid sinakashall)";
		lookKir[2] = "C lookus tagav karvkatte värvumise. Retsessiivne epistaas A,B,D,O,S,T,W suhtes.";
		lookKir[3] = "D on värvilahjenduslookus. Retsessiivse alleeli korral karvavärv lahjeneb.";
		lookKir[4] = "L määrab karva pikkuse. Retsessiivse alleeli korral on pikad karvad.";
		lookKir[5] = "O lookus määrab oranži värvumise. Suguliiteline (asub X kromosoomil. Y kromosoomil seda pole)";
		lookKir[6] = "S on laigulisuse lookus. Mite rohkem dominantseid alleele, seda rohkem valgeid laike. ";
		lookKir[7] = "T määrav vöötide kuju. Vöötide esinemiseks peab olema dominante akuuti alleel või oranž karvavärvus. ";
		lookKir[8] = "W on mittealbiinovalge lookus. Dominantse puhul on kass valget värvi (aga pole albiino)";
		lookKir[9] = "X on sugukromosoom. XX on naissoost, XY on meessoost.";

		// Tekstiväljadele tooltipi lisamine

		for (int i = 0; i < lookKir.length; i++) {
			dnaStrand1TextField[i].setToolTipText(lookKir[i]);
			dnaStrand2TextField[i].setToolTipText(lookKir[i]);
		}

		// Esimese ahela raadionuppude lisamine esimesse kasti
		box1.add(doSmt(dnaStrand1TextField[0], alleelA, alleela));
		box1.add(doSmt(dnaStrand1TextField[1], alleelB, alleelb, alleelbl));
		box1.add(doSmt(dnaStrand1TextField[2], alleelC, alleelcb, alleelcs, alleelc));
		box1.add(doSmt(dnaStrand1TextField[3], alleelD, alleeld));
		box1.add(doSmt(dnaStrand1TextField[4], alleelL, alleell));
		box1.add(doSmt(dnaStrand1TextField[5], alleelO, alleelo));
		box1.add(doSmt(dnaStrand1TextField[6], alleelS, alleels));
		box1.add(doSmt(dnaStrand1TextField[7], alleelT, alleelTa, alleeltb));
		box1.add(doSmt(dnaStrand1TextField[8], alleelW, alleelw));
		box1.add(doSmt(dnaStrand1TextField[9], alleelX, alleelY));

		// Teise ahela raadionuppude lisamine kolmandasse kasti
		box3.add(doSmt(dnaStrand2TextField[0], alleelA, alleela));
		box3.add(doSmt(dnaStrand2TextField[1], alleelB, alleelb, alleelbl));
		box3.add(doSmt(dnaStrand2TextField[2], alleelC, alleelcb, alleelcs, alleelc));
		box3.add(doSmt(dnaStrand2TextField[3], alleelD, alleeld));
		box3.add(doSmt(dnaStrand2TextField[4], alleelL, alleell));
		box3.add(doSmt(dnaStrand2TextField[5], alleelO, alleelo));
		box3.add(doSmt(dnaStrand2TextField[6], alleelS, alleels));
		box3.add(doSmt(dnaStrand2TextField[7], alleelT, alleelTa, alleeltb));
		box3.add(doSmt(dnaStrand2TextField[8], alleelW, alleelw));
		box3.add(doSmt(dnaStrand2TextField[9], alleelX, alleelY));

	}

	/**
	 * Meetod raadionuppude loomiseks valikute jaoks. Tuleb sööta talle
	 * tekstiväli, mida raadionupud mõjutama hakkavad ja määramata arv sõne
	 * järjendeid kus esimesel kohal alleel ja teisel kohal selle alleeli
	 * iseloomustav tekst.
	 * 
	 * @param tekstfield
	 * @param others
	 *            {"a" , "a alleeli kirjeldus"},{"A", "A alleeli kirjeldus"}
	 * @return
	 */
	private JPanel doSmt(final JTextField tekstfield, String[]... others) {
		JPanel yldpaneel = new JPanel();
		yldpaneel.setLayout(new BorderLayout());
		JPanel paneel = new JPanel();
		paneel.setLayout(new GridLayout(others.length, 1));
		if (tekstfield.getText().equals(dnaStrand1)) {
			yldpaneel.add(paneel, BorderLayout.SOUTH);
		} else if (tekstfield.getText().equals(dnaStrand2)) {
			yldpaneel.add(paneel, BorderLayout.NORTH);
		}

		// MyListener myListener = new MyListener(tekstfield); Pole vaja, oli
		// eraldi kuulariklass
		ButtonGroup grupp = new ButtonGroup();
		int loendaja = 0;// Selle abil saab tsüklis tshekata, et ainult esimene
							// variant
							// saaks "true" väärtuse
		for (String[] name : others) {
			JRadioButton nupp = new JRadioButton(name[0]);
			nupp.setToolTipText(name[1]);
			grupp.add(nupp);
			paneel.add(nupp, BorderLayout.SOUTH);

			nupp.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) { // Kuulari tegemine
					// Kuulari osa, mis muudab tekstivälja väärtust nupule
					// vajutades
					tekstfield.setText(((JRadioButton) e.getItem()).getText());

					// Koodijupp, mis reguleerib nuppude ja tekstide haldust
					// sugukromosoomide valimisega seoses (O ja teise ahela Y)
					if (((JRadioButton) e.getItem()).getText().equals("Y")) {
						boolean valitud = ((JRadioButton) e.getItem())
								.isSelected();
						// muutuja sama ahela O lookuse madalaima JPanel'i
						// jaoks. lihtsustab elu veidi
						Container paneel = (Container) ((Container) ((JRadioButton) e
								.getItem()).getParent().getParent().getParent()
								.getComponent(5)).getComponent(0);
						// O lookuse valimise disable/enable'imine
						for (Component c : paneel.getComponents()) {
							c.setEnabled(!valitud);
						}
						if (paneel.getParent().getParent().getName()
								.equals("ahKast1")) {
							// vastaspoole Y disable'imine
							((JRadioButton) (Container) ((Container) ((Container) ((Container) (paneel
									.getParent().getParent().getParent())
									.getComponent(2)).getComponent(9))
									.getComponent(0)).getComponent(1))
									.setEnabled(!valitud);
							// O lookuse teksti asendamine miinusega
							if (valitud) {
								dnaStrand1TextField[5].setText("-");
							} else {
								// O lookuse teksti tagasi muutmine
								for (int i = 0; i < 2; i++) {
									if (((JRadioButton) paneel.getComponent(i))
											.isSelected()) {
										dnaStrand1TextField[5].setText(((JRadioButton) paneel
												.getComponent(i)).getText());
									}
								}
							}
						} else if (paneel.getParent().getParent().getName()
								.equals("ahKast2")) {
							// vastaspoole Y disable'imine
							((JRadioButton) (Container) ((Container) ((Container) ((Container) (paneel
									.getParent().getParent().getParent())
									.getComponent(0)).getComponent(9))
									.getComponent(0)).getComponent(1))
									.setEnabled(!valitud);
							// O lookuse teksti asendamine miinusega
							if (valitud) {
								dnaStrand2TextField[5].setText("-");
							} else {
								// O lookuse teksti tagasi muutmine
								for (int i = 0; i < 2; i++) {
									if (((JRadioButton) paneel.getComponent(i))
											.isSelected()) {
										dnaStrand2TextField[5].setText(((JRadioButton) paneel
												.getComponent(i)).getText());
									}
								}
							}
						}
					}

					// Kuulari osa mis raadionuppu vajutades määrab uue
					// fenotüübi
					StringBuilder fenotypeText = new StringBuilder("");
					for (int i = 0; i < dnaStrand1TextField.length; i++) {
						int[] fenahel = Kass.genotypeToFenotype(
								genoString2int(ahela1geno()),
								genoString2int(ahela1geno()));
						fenotypeText.append(FenotypeToStrings.giveText(fenahel, i));
						fenotypeText.append("\n");
					}
					CreationFrameOfConfirmation.setFenotypeFrameText(fenotypeText.toString());

				}
			});
			// Esimese alleeli paneb automaatselt True'ks
			if (loendaja == 0) {
				nupp.setSelected(true);
			}
			loendaja = 1;

		}
		return yldpaneel;
	}

	// KOOD ITEMEXTRACLASSLISTENER koodisurnuaiast

	// 1. ahela tekstiväljadest genotüübi ahelate korjamine sõne järjendisse
	// (meetod)

	public static String[] ahela1geno() {
		String[] x = new String[getAhel1().length];
		for (int i = 0; i < x.length; i++) {
			x[i] = ((getAhel1()[i].getText().equals("-")) ? getDnaStrand2TextField()[i]
					.getText() : getAhel1()[i].getText());
		}
		return x;
	}

	// 2. ahela tekstiväljadest genotüübi korjamine sõne järjendisse
	public static String[] ahela2geno() {
		String[] x = new String[getDnaStrand2TextField().length];
		for (int i = 0; i < x.length; i++) {
			x[i] = ((getDnaStrand2TextField()[i].getText().equals("-")) ? getAhel1()[i]
					.getText() : getDnaStrand2TextField()[i].getText());
		}
		return x;
	}

	// Meetod mis teeb järjendist täisarvude järjendi (nt o asendub 0-ga ja
	// C 1-ga jne)
	public static int[] genoString2int(String[] gString) {
		int[] intgeno = new int[gString.length];
		for (int i = 0; i < gString.length; i++) {
			if (gString[i].equals("a") || gString[i].equals("b")
					|| gString[i].equals("c") || gString[i].equals("d")
					|| gString[i].equals("l") || gString[i].equals("o")
					|| gString[i].equals("s") || gString[i].equals("Ta")
					|| gString[i].equals("s") || gString[i].equals("w")
					|| gString[i].equals("X")) {
				intgeno[i] = 0;
			} else if (gString[i].equals("A") || gString[i].equals("B")
					|| gString[i].equals("C") || gString[i].equals("D")
					|| gString[i].equals("L") || gString[i].equals("O")
					|| gString[i].equals("S") || gString[i].equals("T")
					|| gString[i].equals("S") || gString[i].equals("W")
					|| gString[i].equals("Y")) {
				intgeno[i] = 1;

			} else if (gString[i].equals("cb") || gString[i].equals("bl")
					|| gString[i].equals("tb")) {
				intgeno[i] = 3;
			} else if (gString[i].equals("cs")) {
				intgeno[i] = 7;
			} else if (!gString[i].equals("ah1") && !gString[i].equals("ah2")) {
				// TODO Error standardisation
				System.out.println("Error genoString2int meetodi juures: "
						+ gString[i]);
			}
		}
		return intgeno;
	}

	// Eelmisele meetodile peaaegu vastupidine
	// lookus + väärtus muudetakse sõneks
	public static String genoInt2String(int lookus, int gInt) {
		String gString = new String();

		switch (lookus) {
		// A lookus
		case 0: {
			switch (gInt) {
			case 0:
				gString = "a";
				break;
			case 1:
				gString = "A";
				break;
			// TODO error_standardization
			default:
				gString = "viga";
				break;
			}
			break;
		}
		// B lookus
		case 1: {
			switch (gInt) {
			case 0:
				gString = "b";
				break;
			case 1:
				gString = "B";
				break;
			case 3:
				gString = "bl";
				break;
			default:
				gString = "viga";
				break;
			}
			break;
		}
		// C lookus
		case 2: {
			switch (gInt) {
			case 0:
				gString = "c";
				break;
			case 1:
				gString = "C";
				break;
			case 3:
				gString = "cb";
				break;
			case 7:
				gString = "cs";
				break;
			default:
				gString = "viga";
				break;
			}
			break;
		}
		// D lookus
		case 3: {
			switch (gInt) {
			case 0:
				gString = "d";
				break;
			case 1:
				gString = "D";
				break;
			default:
				gString = "viga";
				break;
			}
			break;
		}
		// L lookus
		case 4: {
			switch (gInt) {
			case 0:
				gString = "l";
				break;
			case 1:
				gString = "L";
				break;
			default:
				gString = "viga";
				break;
			}
			break;
		}
		// O lookus
		case 5: {
			switch (gInt) {
			case 0:
				gString = "o";
				break;
			case 1:
				gString = "O";
				break;
			default:
				gString = "viga";
				break;
			}
			break;
		}
		// S lookus
		case 6: {
			switch (gInt) {
			case 0:
				gString = "s";
				break;
			case 1:
				gString = "S";
				break;
			default:
				gString = "viga";
				break;
			}
			break;
		}
		// T lookus
		case 7: {
			switch (gInt) {
			case 0:
				gString = "t";
				break;
			case 1:
				gString = "T";
				break;
			case 3:
				gString = "tb";
				break;
			default:
				gString = "viga";
				break;
			}
			break;
		}
		// W lookus
		case 8: {
			switch (gInt) {
			case 0:
				gString = "w";
				break;
			case 1:
				gString = "W";
				break;
			default:
				gString = "viga";
				break;
			}
			break;
		}
		// sugulookus
		case 9: {
			switch (gInt) {
			case 0:
				gString = "X";
				break;
			case 1:
				gString = "Y";
				break;
			default:
				gString = "viga";
				break;
			}
			break;
		}
		default:
			break;
		}
		return gString;
	}

	// Getterid ja Setterid
	public static JTextField[] getAhel1() {
		return dnaStrand1TextField;
	}

	public void setDnaStrand1TextField(JTextField[] dnaStrand1) {
		CreationFrameOfSelection.dnaStrand1TextField = dnaStrand1;
	}

	public static JTextField[] getDnaStrand2TextField() {
		return dnaStrand2TextField;
	}

	public void setDnaStrand2TextField(JTextField[] dnaStrand2) {
		CreationFrameOfSelection.dnaStrand2TextField = dnaStrand2;
	}

	public static String getDnaStrand1() {
		return dnaStrand1;
	}

	public static void setDnaStrand1(String dnaStrand1) {
		CreationFrameOfSelection.dnaStrand1 = dnaStrand1;
	}

	public static String getDnaStrand2() {
		return dnaStrand2;
	}

	public static void setDnaStrand2(String dnaStrand2) {
		CreationFrameOfSelection.dnaStrand2 = dnaStrand2;
	}

}
