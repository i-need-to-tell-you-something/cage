package gui;

import graphics.Merge;
import gui.creationframe.CreationFrameOfSelection;
import gui.menubar.Menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextField;

import core.Kass;


/**
 * This method describes what happens after pressing a button on the main
 * frame's toolbar
 * 
 * @author K
 */
public class CAGEFrameToolbarButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		switch (actionCommand) {

		case "Eemalda": {
			for (Kass kass : CAGEFrame.getKassiList().getSelectedValuesList()) {
				CAGEFrame.removeKass(kass);
			}
			break;
		}

		case "Muuda nime": {
			for (Kass kass : CAGEFrame.getKassiList().getSelectedValuesList()) {
				new RenamingContainer(kass,
						((Component) e.getSource()).getLocationOnScreen());
			}
			break;
		}

		case "Lisa uus": {
			CAGEFrame.addKass(new Kass());
			break;
		}

		case "Lisa uus geenidega": {
			CAGEFrame.getCreationFrameOfSelection().setVisible(true);
			CAGEFrame.getCreationFrameOfConfirmation().setVisible(true);
			break;
		}

		case "Rista": {
			CAGEFrame.addKass(Kass.viljastumine(CAGEFrame.getKassiList()
					.getSelectedValuesList().get(0), CAGEFrame.getKassiList()
					.getSelectedValuesList().get(1)));
			break;
		}

		case "Kuva omadusi": {
			List<Kass> list = CAGEFrame.getKassiList().getSelectedValuesList();
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
					t[i] = new JTextField(FenotypeToStrings.giveText(feno, i));
					t[i].setEditable(false);// Fenotüübi omaduse väljad teen
											// muutmatuks.
					t[i].setBackground(Color.white);
				}
				// ja siis uude aknasse
				FenoGenoDisplayContainer aken = new FenoGenoDisplayContainer(t, kass.getNimi(),
						FenoGenoDisplayContainer.FENOTYPE);
				aken.setSize(xSuurus, ySuurus); // Määran fenotüübiakna suuruse
				aken.setVisible(true);
				// lugejate halle
				aken.setLocation(xLugeja, yLugeja);
				xLugeja = xLugeja + xSuurus / 2;
				if (xLugeja + xSuurus / 4 * 3 > java.awt.Toolkit
						.getDefaultToolkit().getScreenSize().getWidth()) {
					xLugeja = 0;
					yLugeja = yLugeja + ySuurus - 10;
				}
			}
			break;
		}

		case "Kuva geene": {
			List<Kass> list = CAGEFrame.getKassiList().getSelectedValuesList();
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
					t[i] = new JTextField(CreationFrameOfSelection.genoInt2String(i,
							geno1[i])
							+ "  -  "
							+ CreationFrameOfSelection.genoInt2String(i, geno2[i]));
					t[i].setEditable(false);// Teen genotüübi
											// muutmatuks(niikuinii ei muudaks
											// see midagi)
					t[i].setBackground(Color.white);// Muudan tekstivälja tausta
													// valgeks, et oleks ilusam
				}
				// ja siis uude aknasse
				FenoGenoDisplayContainer aken = new FenoGenoDisplayContainer(t, kass.getNimi(),
						FenoGenoDisplayContainer.GENOTYPE);// Muuhulgas genotüübi akna tiitli
												// määramine
				aken.setSize(xSuurus, ySuurus); // Määran genotüübiakna suuruse
				aken.setVisible(true);
				// lugejate halle
				aken.setLocation(xLugeja, yLugeja);
				xLugeja = xLugeja + xSuurus / 2;
				if (xLugeja + xSuurus / 4 * 3 > java.awt.Toolkit
						.getDefaultToolkit().getScreenSize().getWidth()) {
					xLugeja = 0;
					yLugeja = yLugeja + ySuurus - 10;
				}
			}
			break;
		}

		case "Kuva pilt": {
			List<Kass> list = CAGEFrame.getKassiList().getSelectedValuesList();
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
					xLugeja = xLugeja + xSuurus / 2;
					if (xLugeja + xSuurus / 4 * 3 > java.awt.Toolkit
							.getDefaultToolkit().getScreenSize().getWidth()) {
						xLugeja = 0;
						yLugeja = yLugeja + ySuurus - 10;
					}
					// erindite püüdmine
				} catch (FileNotFoundException e1) {
					// TODO error_standardization
					System.out
							.println("Viga pildiraami kutsumisel nupukuularis: "
									+ e1.getMessage());
				} catch (IOException e1) {
					System.out
							.println("Viga pildiraami kutsumisel nupukuularis: "
									+ e1.getMessage());
				}
			}
			break;
		}

		// error:
		default:
			// TODO error_standardization
			System.out.println("tundmatu käsk: " + e.getActionCommand());
			break;
		}

		// kui vastav option siis fookus listile uuesti
		if (Menu.isOptionFookus()) {
			CAGEFrame.getKassiList().requestFocusInWindow();
		}
	}

}
