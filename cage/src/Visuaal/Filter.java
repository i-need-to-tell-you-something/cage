package Visuaal;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Filter {
	static private BufferedImage pilt;

	static float getlum(int red, int green, int blue) {
		float R2 = red / 255f;
		float G2 = green / 255f;
		float B2 = blue / 255f;
		float max = Math.max(R2, Math.max(G2, B2));
		float min = Math.min(R2, Math.min(G2, B2));
		float light = (max + min) / 2;
		return light;
	}

	public static BufferedImage tootle(String failinimi, float hue, float saturation, float lumbon) {

		//Faili lugemine mida töödelda
		try {
			pilt = ImageIO.read(new File(failinimi));

		} catch (IOException e) {
		}
		
		int rgb;
		int korgus = pilt.getHeight();
		int laius = pilt.getWidth();

		for (int y = 0; y < korgus; y++) {
			for (int x = 0; x < laius; x++) {
				Color pixel = new Color(pilt.getRGB(x, y), true);		
				// int alfa=pixel.getAlpha();//255 on mittel2bipaistev//sama mis
				// alfa
				rgb = pixel.getRGB();
				// rgb=(pilt.getRGB(x, y));//Oli enne vaja
				int alpha = (rgb >> 24) & 0xFF;
				int red = (rgb >> 16) & 0xFF;
				int green = (rgb >> 8) & 0xFF;
				int blue = rgb & 0xFF;

				float lum = getlum(red, green, blue)+lumbon;//Võtan piksli heleduse arvestades antud heleduse boonust
				
				//Kui heleduse boonuse tõttu väljub väärtus piiridest, siis väärtustatakse see maksimumiga
				if (lum>1f){
					lum=1f;
				}
				if (lum<0f){
					lum=0f;
				}

				Color uusPiksel = new Color(Color.HSBtoRGB(hue, saturation, lum),
						true);
				rgb = uusPiksel.getRGB();							
				int red2 = (rgb >> 16) & 0xFF;
				int green2 = (rgb >> 8) & 0xFF;
				int blue2 = rgb & 0xFF;
				Color uusimPiksel = new Color(red2, green2, blue2, alpha);

				pilt.setRGB(x, y, uusimPiksel.getRGB());
				// pilt.setRGB(x, y, 0x0f00ff00);			
			}
		}
		return pilt;
	}



}
