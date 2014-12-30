package kassid_rt13oop_tg_kal;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Visuaal.Merge;

/**
 * @author K See meetod kirjeldab seda, mis juhtub nupu vajutamise järel.
 * 
 */
public class KassiRaamiNupukuular implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String prikas = e.getActionCommand();
		switch (prikas) {

		case "Eemalda": {
			for (Kass kass : Kassiraam.kassilist.getSelectedValuesList()) {
				Kassiraam.kassid.removeElement(kass);
			}
			break;
		}
		
		case "Muuda nime": {
			for (Kass kass : Kassiraam.kassilist.getSelectedValuesList()) {
				new NimetamisKonteiner(kass, ((Component)e.getSource()).getLocationOnScreen());
			}
			break;
		}

		case "Lisa uus": {
			Kassiraam.kassid.addElement(new Kass());
			break;
		}

		case "Lisa uus geenidega": {
			Kassiraam.kassiNupuRaam.setVisible(true);
			Kassiraam.fenoraam.setVisible(true);
			break;
		}

		case "Rista": {
			Kassiraam.kassid.addElement(Kass.viljastumine(Kassiraam.kassilist
					.getSelectedValuesList().get(0), Kassiraam.kassilist
					.getSelectedValuesList().get(1)));
			break;
		}

		case "Kuva omadusi": {
			List<Kass> list = Kassiraam.kassilist.getSelectedValuesList();
			// lugejad aknate paremaks paigutuseks
			int xLugeja = 10;
			int yLugeja = 0;
			int xSuurus = 400;
			int ySuurus = 250;
			// võta iga kass
			for (Kass kass : list) {
				int[] feno = kass.getFenotahel();
				JTextField[] t = new JTextField[feno.length];
				// kelle iga fenotüübi väli saab teksti kujule viidud
				for (int i = 0; i < t.length; i++) {
					t[i] = new JTextField(Fenotyyp.valjasta(feno, i));
					t[i].setEditable(false);// Fenotüübi omaduse väljad teen
											// muutmatuks.
					t[i].setBackground(Color.white);
				}
				// ja siis uude aknasse
				FGKonteiner aken = new FGKonteiner(t, kass.getNimi(),
						FGKonteiner.FENOTYPE);
				aken.setSize(xSuurus, ySuurus); //Määran fenotüübiakna suuruse
				aken.setVisible(true);
				// lugejate halle
				aken.setLocation(xLugeja, yLugeja);
				xLugeja = xLugeja + xSuurus/2;
				if (xLugeja + xSuurus/4*3 > java.awt.Toolkit.getDefaultToolkit()
						.getScreenSize().getWidth()) {
					xLugeja = 0;
					yLugeja = yLugeja + ySuurus - 10;
				}
			}
			break;
		}

		case "Kuva geene": {
			List<Kass> list = Kassiraam.kassilist.getSelectedValuesList();
			// lugejad aknate paremaks paigutuseks
			int xLugeja = 10;
			int yLugeja = 0;
			int xSuurus = 100;
			int ySuurus = 250;
			// võta iga kass
			for (Kass kass : list) {
				int[] geno1 = kass.getAhel1();
				int[] geno2 = kass.getAhel2();
				JTextField[] t = new JTextField[geno1.length];
				// kelle iga genotüübi väli saab teksti kujule viidud
				for (int i = 0; i < t.length; i++) {
					t[i] = new JTextField(KassiNupuKonteiner.genoInt2String(i,
							geno1[i])
							+ "  -  "
							+ KassiNupuKonteiner.genoInt2String(i, geno2[i]));
					t[i].setEditable(false);// Teen genotüübi
											// muutmatuks(niikuinii ei muudaks
											// see midagi)
					t[i].setBackground(Color.white);// Muudan tekstivälja tausta
													// valgeks, et oleks ilusam
				}
				// ja siis uude aknasse
				FGKonteiner aken = new FGKonteiner(t, kass.getNimi(),
						FGKonteiner.GENOTYPE);// Muuhulgas genotüübi akna tiitli
												// määramine
				aken.setSize(xSuurus, ySuurus); //Määran genotüübiakna suuruse
				aken.setVisible(true);
				// lugejate halle
				aken.setLocation(xLugeja, yLugeja);
				xLugeja = xLugeja + xSuurus/2;
				if (xLugeja + xSuurus/4*3 > java.awt.Toolkit.getDefaultToolkit()
						.getScreenSize().getWidth()) {
					xLugeja = 0;
					yLugeja = yLugeja + ySuurus - 10;
				}
			}
			break;
		}

		case "Kuva pilt": {
			List<Kass> list = Kassiraam.kassilist.getSelectedValuesList();
			// lugejad aknate paremaks paigutuseks
			int xLugeja = 10;
			int yLugeja = 0;
			int xSuurus = 350;
			int ySuurus = 450;
			// võta iga kass
			for (Kass kass : list) {
				JFrame aken;
				try {
					aken = Merge.Joonista(kass);
					aken.setSize(xSuurus, ySuurus);
					aken.setLocation(xLugeja, yLugeja);
					aken.setVisible(true);
					// lugejate halle
					xLugeja = xLugeja + xSuurus/2;
					if (xLugeja + xSuurus/4*3 > java.awt.Toolkit.getDefaultToolkit()
							.getScreenSize().getWidth()) {
						xLugeja = 0;
						yLugeja = yLugeja + ySuurus - 10;
					}
				//erindite püüdmine
				} catch (FileNotFoundException e1) {
					//TODO error_standardization
					System.out.println("Viga pildiraami kutsumisel nupukuularis: " + e1.getMessage());
				} catch (IOException e1) {
					System.out.println("Viga pildiraami kutsumisel nupukuularis: " + e1.getMessage());
				}
			}
			break;
		}

		// error:
		default:
			//TODO error_standardization
			System.out.println("tundmatu käsk: " + e.getActionCommand());
			break;
		}
		
		//kui vastav option siis fookus listile uuesti
		if (Menuu.isOptionFookus()) { Kassiraam.kassilist.requestFocusInWindow(); }
	}

}
