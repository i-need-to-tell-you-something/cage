package kassid_rt13oop_tg_kal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.JTextField;

import Visuaal.Merge;


public class d2Nupukuular implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String prikas = e.getActionCommand();
		switch (prikas) {
		
		case "Eemalda":{ 
			for (Kass kass : demo2.kassilist.getSelectedValuesList()) {
				demo2.kassid.removeElement(kass);
			} 
			break;
		}
		
		
		case "Lisa uus": { 
			demo2.kassid.addElement(new Kass()); 
			break;
		}
		
		
		case "Lisa uus geenidega": { 
			demo2.kassiNupuRaam.setVisible(true);
			demo2.fenoraam.setVisible(true);
			break;
		}
		
		
		case "Rista":{ 
			demo2.kassid.addElement(Kass.viljastumine(
					demo2.kassilist.getSelectedValuesList().get(0), 
					demo2.kassilist.getSelectedValuesList().get(1)));
			break;
		}
		
		
		case "Kuva omadusi":{ 
			List<Kass> list = demo2.kassilist.getSelectedValuesList();
			// lugejad aknate paremaks paigutuseks
			int xLugeja = 10;
			int yLugeja = 0;
			// võta iga kass
			for (Kass kass : list) {
				int[] feno = kass.getFenotahel();
				JTextField[] t = new JTextField[feno.length];
				// kelle iga fenotüübi väli saab teksti kujule viidud
				for (int i = 0; i < t.length; i++) {
					t[i] = new JTextField(Fenotyyp.valjasta(feno, i));
					t[i].setEditable(false);//Fenotüübi omaduse väljad teen muutmatuks.
					t[i].setBackground(Color.white);
				}
				// ja siis uude aknasse
				FGKonteiner aken = new FGKonteiner(t, kass.getNimi()+" ",
						FGKonteiner.FENOTYPE);
				aken.setVisible(true);
				// lugejate halle
				aken.setLocation(xLugeja, yLugeja);
				xLugeja = xLugeja + 150;
				if (xLugeja + 350 > java.awt.Toolkit.getDefaultToolkit()
						.getScreenSize().getWidth()) {
					xLugeja = 0;
					yLugeja = yLugeja + 200;
				}
			}
			break;
		}
		

		case "Kuva geene":{ 
			List<Kass> list = demo2.kassilist.getSelectedValuesList();
			// lugejad aknate paremaks paigutuseks
			int xLugeja = 10;
			int yLugeja = 0;
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
					t[i].setEditable(false);//Teen genotüübi muutmatuks(niikuinii ei muudaks see midagi)
					t[i].setBackground(Color.white);//Muudan tekstivälja tausta valgeks, et oleks ilusam
				}
				// ja siis uude aknasse
				FGKonteiner aken = new FGKonteiner(t, kass.getNimi()+" ",
						FGKonteiner.GENOTYPE);//Muuhulgas genotüübi akna tiitli määramine
				aken.setVisible(true);
				// lugejate halle
				aken.setLocation(xLugeja, yLugeja);
				xLugeja = xLugeja + 90;
				aken.setSize(120, 230);//Määran genotüübi akna suuruse (vist pole vaja seda)
				if (xLugeja + 350 > java.awt.Toolkit.getDefaultToolkit()
						.getScreenSize().getWidth()) {
					xLugeja = 0;
					yLugeja = yLugeja + 200;
				}
			}
			break;
		}
		
		case "Kuva pilt": {
			Kass kass = demo2.kassilist.getSelectedValuesList().get(0);
			try {
				Merge.Joonista(kass.getFenotahel());
			} 
			catch (javax.imageio.IIOException e1) {
				System.out.println(e1.getMessage());
//				System.out.println("1");
			}
			catch (FileNotFoundException e1) {
				System.out.println(e1.getMessage());
//				System.out.println("2");
			}
			catch (IOException e1) {
				System.out.println(e1.getMessage());
//				System.out.println("3");
			}
			break;			
		}
		
		
		//error:
		default: System.out.println("tundmatu käsk: " + e.getActionCommand()); break;
		}

	}

}