package graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import core.Kass;


public class Merge {
	// Meetod mis väljastab joonistatud kassi akna kujul antud fenotüübi ahela alusel
	public static JFrame Joonista(Kass kiisu) throws IOException {
		// Väärtustan värvid. Võiks elida mooduse kuidas seda peaks vaid üks
		// kord tegema ja mitte iga kord kui kassi joonistan
		// Demo klassi seda panna ei saanud, ta ei saanud aru et see mingi
		// meetod oleks
		Varvid.koigivarvidevaartustamine();
		
		int[] fenoahel = kiisu.getFenotahel();

		// Loon kaks põhivärvi pilti (Kaks, sest kilpkonnakassiga mustriga läheb
		// seda vaja)
		BufferedImage varv1 = ImageIO.read(new File("data/gfx/Blank.png"));
		BufferedImage varv2 = ImageIO.read(new File("data/gfx/Blank.png"));
		BufferedImage varv3 = ImageIO.read(new File("data/gfx/Blank.png"));// siiami
																				// jne
																				// kassidele

		// Loon kaks triipude pilti (Kaks, sest kilpkonnakassiga mustriga läheb
		// seda vaja)
		BufferedImage triibud1 = ImageIO.read(new File("data/gfx/Blank.png"));
		BufferedImage triibud2 = ImageIO.read(new File("data/gfx/Blank.png"));

		// Uue pildi loomine kassi määramiseks. Eeldame et kõik pildid on
		// ühesuurused
		int w = varv1.getWidth();
		int h = varv1.getHeight();
		BufferedImage combined = new BufferedImage(w, h,
				BufferedImage.TYPE_INT_ARGB);
		// paint both images, preserving the alpha channels
		Graphics g = combined.getGraphics();

		if (Maarang.cLookus(fenoahel) != 7) {
			// Kui kass ei ole albiino (võib olla siiam või normaalselt värvunud
			// jne
			if (Maarang.wlookus(fenoahel) != 0) {
				// On valgeks värvunud
				varv1 = Filter.tootle("data/gfx/Hall.png", Varvid.hue[12],
						Varvid.saturation[12], Varvid.lumbon[12]);// Kohal 12 on
																	// valge
																	// värv
			} else {
				// Kui ei ole valgeks värvunud
				if (Maarang.kasKilpkonn(fenoahel)) {
					// Juhul kui on kilpkonnamustruga
					int[] x = Maarang.pohivarvid(fenoahel);// List põhivärvidest
					String triibufail = Varvid.triibud[Maarang
							.tlookus(fenoahel)];

					varv1 = Filter.tootle("data/gfx/Hall-1.png",
							Varvid.hue[x[0]], Varvid.saturation[x[0]],
							Varvid.lumbon[x[0]]);
					varv2 = Filter.tootle("data/gfx/Hall-2.png",
							Varvid.hue[x[1]], Varvid.saturation[x[1]],
							Varvid.lumbon[x[1]]);

					// Enam ei saa mõlemad kihid triipe(nt akuuti puudumisel
					// vaid oranžil triibud)

					triibud1 = Filter.tootle(
							triibufail + "-2.png",// Oranži kassi triibud
							Varvid.hue[x[1]], Varvid.saturation[x[1]],
							Varvid.lumbon[x[1]] + 0.2f);
					if (Maarang.alookus(fenoahel) == 5) {
						// Juhul kui on akuut, siis on triibud teisel kihil ka
						triibud2 = Filter.tootle(triibufail + "-1.png",
								Varvid.hue[x[0]], Varvid.saturation[x[0]],
								Varvid.lumbon[x[0]]+ 0.2f);
					}
				} else {
					// Juhul kui pole kilpkonnamustriga
					int x = Maarang.pohivarv(fenoahel);// kasutab meetodit
														// põhivärvi indeksi
														// leidmiseks
					System.out.println(Varvid.kassivarv[x] + "(Merge klass)");
					varv1 = Filter.tootle("data/gfx/Hall.png", Varvid.hue[x],
							Varvid.saturation[x], Varvid.lumbon[x]);
					if (Maarang.kasTriibud(fenoahel)) {
						String triibufail = Varvid.triibud[Maarang
								.tlookus(fenoahel)] + ".png";// Triibu failinimi
						triibud1 = Filter.tootle(triibufail, Varvid.hue[x],
								Varvid.saturation[x], Varvid.lumbon[x] + 0.2f);
						// Triibud tuleb siin heledamaks teha, sest fail millest
						// loob on tumedam
						System.out.println(triibufail);						
					}
				}
			}
		}

		// Valgete laikude tegemine:
		BufferedImage laigud = null;
		if (Maarang.wlookus(fenoahel) == 0) {
			//laigud = ImageIO.read(new File(Varvid.laigunimi[fenoahel[6]])); //Varem olid laikude pildid valged värvi
			laigud=Filter.tootle(Varvid.laigunimi[fenoahel[6]], Varvid.hue[12],
					Varvid.saturation[12], Varvid.lumbon[12]);
		}

		BufferedImage karv = null;
		BufferedImage taust = null;
		BufferedImage silmad = ImageIO.read(new File("data/gfx/Blank.png"));

		// Kassi silma värvi määramine (vaid albiino ja siiamilaadsete puhul)
		if (Maarang.cLookus(fenoahel) == 7) {// Albiino
			silmad = Filter.tootle("data/gfx/Silmad.png", 1 / 360f, 0.90f,
					0.4f);
			System.out.println("Albiino silmad");
		} else if (Maarang.cLookus(fenoahel) != 7
				&& Maarang.cLookus(fenoahel) != 1) {
			silmad = Filter.tootle("data/gfx/Silmad.png", 224 / 360f, 0.77f,
					0.5f);
			System.out.println("Siiami/Burma/Birma silmad");
		}

		if (Maarang.kasPikaKarv(fenoahel)) {
			// Kui pikakarvaline
			karv = ImageIO.read(new File("data/gfx/Pikakarvaline.png"));
			taust = ImageIO.read(new File("data/gfx/Pikk_taust.png"));
		}

		else {
			// Kui lühikarvaline
			karv = ImageIO.read(new File("data/gfx/Lyhikarvaline.png"));
			taust = ImageIO.read(new File("data/gfx/Lyhike_taust.png"));
		}

		if (Maarang.cLookus(fenoahel) != 1) {
			// Kui kass pole c lookusest normaalselt värvunud
			// Pilt ei kaasa silmi sest see ei jää peale
			String x = Varvid.ceefail[Maarang.cLookus(fenoahel)];
			System.out.println(x);
			
			//Filtri lisasin march2015, et ka hallist template pildist tuleks hele, aga tõenäoliselt oleks vaja paremaks teha. 
			laigud=Filter.tootle(x, Varvid.hue[12],
					Varvid.saturation[12], Varvid.lumbon[12]);

			varv3 = ImageIO.read(new File(x));
		}

		g.drawImage(varv1, 0, 0, null);// Esimene värv
		g.drawImage(varv2, 0, 0, null);// Teine värv (võib olla blank)
										// (Kilpkonnamustril vaja)
		
		g.drawImage(triibud1, 0, 0, null);
		
		g.drawImage(triibud2, 0, 0, null);// võib olla blank (Kilpkonnamustril
											// vaja)
		
		g.drawImage(laigud, 0, 0, null);// laigud

		g.drawImage(varv3, 0, 0, null);// C lookuse isepärased (võib olla blank)
		g.drawImage(karv, 0, 0, null);// karvapikkus(kõrvad, piirjooned, silmad)
		g.drawImage(silmad, 0, 0, null);// Silmad(C lookuste erijuhtude jaoks)
		g.drawImage(taust, 0, 0, null);// taust

		// Save as new image
		try {
			ImageIO.write(combined, "PNG", new File("combined.png"));
		} catch (IOException e) {
			System.out.println("viga combine.png salvestamisel" + e.getMessage()); //TODO: error standardization
		}
		
		//actual raami loomine
		JFrame raam = new JFrame("Kassi " + kiisu.getNimi() + " pilt"); //TODO: localization
		raam.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		raam.add(new JLabel(new ImageIcon(combined)));

		return raam;
	}
}
