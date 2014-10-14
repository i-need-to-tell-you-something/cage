package Visuaal;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Merge {
	//Meetod mis väljastab joonistatud kassi antud fenotüübi ahela alusel
	public static JPanel Joonista(int[] fenoahel) throws IOException{

		//Loon kaks põhivärvi pilti (Kaks, sest kilpkonnakassiga mustriga läheb seda vaja)
		BufferedImage varv1 = ImageIO.read(new File("Blank.png"));
		BufferedImage varv2 = ImageIO.read(new File("Blank.png"));
		BufferedImage varv3 = ImageIO.read(new File("Blank.png"));//siiami jne kassidele

		//Loon kaks triipude pilti (Kaks, sest kilpkonnakassiga mustriga läheb seda vaja)
		BufferedImage triibud1 = ImageIO.read(new File("Blank.png"));
		BufferedImage triibud2 = ImageIO.read(new File("Blank.png"));

		//Uue pildi loomine kassi määramiseks. Eeldame et kõik pildid on ühesuurused
		int w = varv1.getWidth();
		int h = varv1.getHeight();
		BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		// paint both images, preserving the alpha channels
		Graphics g = combined.getGraphics();




		if (Maarang.cLookus(fenoahel)!=7){
			//Kui kass ei ole albiino (võib olla siiam või normaalselt värvunud jne
			if (Maarang.wlookus(fenoahel)!=0){												
				//On valgeks värvunud
				varv1 =  Filter.tootle("Hall1.png", Varvid.hue[12], Varvid.saturation[12], Varvid.lumbon[12]);//Kohal 12 on valge värv
			}
			else{
				//Kui ei ole valgeks värvunud
				if (Maarang.kasKilpkonn(fenoahel)){
					//Juhul kui on kilpkonnamustruga
					int[] x=Maarang.pohivarvid(fenoahel);//List põhivärvidest
					String triibufail = Varvid.triibud[Maarang.tlookus(fenoahel)];

					varv1 =  Filter.tootle("Hall1.png", Varvid.hue[x[0]], Varvid.saturation[x[0]], Varvid.lumbon[x[0]]);
					varv2 =  Filter.tootle("Hall2.png", Varvid.hue[x[1]], Varvid.saturation[x[1]], Varvid.lumbon[x[1]]);

					triibud1 = Filter.tootle(triibufail, Varvid.hue[x[0]], Varvid.saturation[x[0]], Varvid.lumbon[x[0]]);
					triibud2 = Filter.tootle(triibufail, Varvid.hue[x[1]], Varvid.saturation[x[1]], Varvid.lumbon[x[1]]);
				}
				else {
					//Juhul kui pole kilpkonnamustriga
					int x=Maarang.pohivarv(fenoahel);
					String triibufail = Varvid.triibud[Maarang.tlookus(fenoahel)];//Triibu failinimi
					varv1 =  Filter.tootle("Hall.png", Varvid.hue[x], Varvid.saturation[x], Varvid.lumbon[x]);		
					triibud1 =  Filter.tootle(triibufail, Varvid.hue[x], Varvid.saturation[x], Varvid.lumbon[x]-0.1f);	//Triibud tumedamaks tehtud
				}
			}
		}

		//Valgete laikude tegemine				
		BufferedImage laigud = ImageIO.read(new File(Varvid.laigunimi[fenoahel[8]]));				
		BufferedImage karv = ImageIO.read(new File("Pikakarvaline.png"));
		BufferedImage taust = null;

		if (Maarang.kasPikaKarv(fenoahel)){
			//Kui pikakarvaline
			karv = ImageIO.read(new File("Pikakarvaline.png"));
			taust = ImageIO.read(new File("Pikk_taust.png"));
		}

		else{
			//Kui lühikarvaline
			karv = ImageIO.read(new File("Lyhikarvaline.png"));
			taust = ImageIO.read(new File("Lyhike_taust.png"));
		}

		if (Maarang.cLookus(fenoahel)!=1){
			//Kui kass pole c lookusest normaalselt värvunud
			//Pilt peaks silmi kaasama
			String x=Varvid.ceefail[Maarang.cLookus(fenoahel)];
			varv3= ImageIO.read(new File(x));			
		}






		g.drawImage(varv1, 0, 0, null);//Esimene värv	
		g.drawImage(varv2, 0, 0, null);//Teine värv (võib olla blank)

		g.drawImage(triibud1, 0, 0, null);
		g.drawImage(triibud2, 0, 0, null);//võib olla blank
		g.drawImage(laigud, 0, 0, null);//laigud


		g.drawImage(varv3, 0, 0, null);//C lookuse isepärased (võib olla blank)
		g.drawImage(karv, 0, 0, null);//karvapikkus
		g.drawImage(taust, 0, 0, null);//taust

		// Save as new image
		try {
			ImageIO.write(combined, "PNG", new File("combined.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFrame frame = new JFrame("Test");
		JPanel paneel=new JPanel();
		paneel.add(new JLabel(new ImageIcon(combined)));
		//	 paneel.add(new JLabel(new ImageIcon("combined.png")));
		frame.add(paneel);
		frame.setSize(500, 500);
		frame.setVisible(true);	

		return paneel;
	}  			
}
