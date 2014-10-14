package Visuaal;


public class Maarang {

	static int blookus(int[] fenoahel) {
		int x = 0;
		// B lookus.
		switch (fenoahel[1]) {
		case 6:
			if (dlookus(fenoahel)) {// lahjendunud roostepruun(kollakaspruun)
				x = 9;
			} else {
				x = 6;
			}
			break; // Roostepruun
		case 0:
		case 3:
			if (dlookus(fenoahel)) {// lahjendunud šokolaadipruun(sirelililla)
				x = 2;
			} else {
				x = 10;
			}
			break; // šokolaadipruun
		case 1:
		case 2:
		case 4:
			if (dlookus(fenoahel)) {// lahjendunud must (sinakashall)
				x = 3;
			} else {
				x = 7;
			}
			break; // Must
		default:
			x = 7;
			System.out.println("Bviga");
			break;
		}
		return x;
	}

	static boolean dlookus(int[] fenoahel) {// Kas on lahjendunud või mitte
		boolean x = false;
		switch (fenoahel[3]) {
		case 1:
		case 2:
			x = false;
			break;// Lahjenemata, normaalselt värvunud
		case 0:
			x = true;
			break;// Kreemjas (lahjendunud oranž) kass
		}
		return x;
	}

	static int olookus(int[] fenoahel) {
		int x = 0;
		// O lookus. suguliiteline (hiljem vaatab kas kuidas muudab)
		switch (fenoahel[5]) {// kui 0 siis pole oranž
		case 0:
			x = 0;// Pole oranž (suvaline number)
			break;
		case 1:
			x = 15;// Kilpkonnamustriga
			break;
		case 2:
			if (dlookus(fenoahel)) {
				x = 4;// lahjendunud oranž
			} else {
				x = 1; // tavaline oranž
			}
			break;
		}
		return x;
	}

	static int wlookus(int[] fenoahel) {
		if (fenoahel[8] == 0) {
			return 0; // normaalselt värvunud
		} else
			return 12; // valge
	}

	static int alookus(int[] fenoahel) {
		if (fenoahel[0] == 0) {
			return 0;// Pole akuuti värvi
		} else
			return 1;// on akuuti värvi
	}

	static boolean kasTriibud(int[] fenoahel) {
		if (fenoahel[0] != 0 || fenoahel[5] == 2 || fenoahel[5] == 1) {
			return true;// on akuuti värvi või oranz
		}

		else
			return true;// on akuuti värvi
	}

	static boolean kasKilpkonn(int[] fenoahel) {
		if (fenoahel[9] == 0 && fenoahel[5] == 1) {
			return true;
		} else
			return false;
	}

	static int tlookus(int[] fenoahel) {// Eeldab, et on triibud. Ei tohi
										// kasutada seda meetodit kui ei tohi
										// triipe olla
		int a = fenoahel[7];
		if (a == 6) {
			return 1;// laienenud vöödid
		} else if (a == 2 || a == 4) {
			return 2;// Tiigertüüpi vöödid
		} else if (a == 0) {
			return 3;// "Ainult näos ja käppadel on peened triibud" TaTa
		} else
			return 4;// Vööte on käppadel, sabal ja näos. Osa keha pinnast on ka
						// triibuline" //TaT;Tatb

	}
	
//	static int sLookus(int[] fenoahel){
//		int x=0;	
//		if (fenoahel[8]==1){
//			//Kui vähem kui 50% kehast laiguline
//			BufferedImage laigud = ImageIO.read(new File("S.png"));				
//			}
//		else if (fenoahel[8]==2){
//			//Kui üle 50% kehast laiguline
//			x=2;
//		}
//		else{
//			//kui pole laike
//			x=0;
//		}

	public static boolean kasPikaKarv(int[] ahel) {
		if (ahel[4] == 0) {
			return true;
		} else
			return false;
	}

	public static int cLookus(int[] ahel) {
		int x = 0;
		switch (ahel[2]) {
		case 0:
			x = 7;
			break;// Albiino

		case 1:
		case 2:
		case 4:
		case 8:
			x = 1;
			break; // Normaalne

		case 6:
			x = 3;
			break; // soojemates kohtades heledate laikudega (kõht,
					// lõuaalune)//Birma
		case 3:
			x = 6;
			break;// Heldeam birma

		case 14:
			x = 2;
			break; // kere on hele, kõrvad, nägu, saba, käpad tumedad. Silmad
					// intensiivsinised.//Siiam
		case 7:
			x = 5;
			break;// Hele Siiam

		case 10:
			x = 4;
			break; // Siiami ja Birma vahepealne
		}
		return x;
	}

	public static int pohivarv(int[] ahel) {// Töötab mittevalgete,
		// mittealbiinode ja
		// mittekilpkonnade puhul.
		// Arvestab lahjendatust
		int pohivarv;
		if (wlookus(ahel) == 0) {
			if (olookus(ahel) == 0) {// pole oranž
				if (alookus(ahel) == 0) {// Pole akuut
					// Tavaline kass (võib olla lahjendatud)
					pohivarv = blookus(ahel);
				}
				// On akuut:
				else {
					pohivarv = alookus(ahel);
				}
			}
			// on oranž:
			else {
				pohivarv = olookus(ahel);
			}
		}
		// on valge W lookusest
		else {
			pohivarv = olookus(ahel);// Valge
		}
		return pohivarv;

	}

	public static int[] pohivarvid(int[] ahel) {// Eeldab kilpkonnamustrit
		int[] pohivarvid = new int[2];

		if (alookus(ahel) == 0) {// Pole akuut
			// Tavaline kass (võib olla lahjendatud)
			pohivarvid[0] = blookus(ahel);
		}
		// On akuut:
		else {
			pohivarvid[0] = alookus(ahel);
		}
		// on oranž (sest eeldab, et kilpkonnamustriga):
		pohivarvid[1] = olookus(ahel);
		return pohivarvid;

	}

	public static void main(String[] args) {
		int[] ahel = new int[] { 1, 1, 2, 0, 0, 2, 0, 0, 0, 0 };

		// Põhivärvi määramine
		int pohivarv = 0;
		if (kasKilpkonn(ahel) == true) {
			// kilpkonn
			pohivarv = olookus(ahel);
			int pohivarv2;
			if (alookus(ahel) == 0) {// Pole akuut
				pohivarv2 = blookus(ahel);
			}
			// On akuut:
			else {
				pohivarv2 = alookus(ahel);
			}
		} else {// Ei ole kilpkonn
			pohivarv = pohivarv(ahel);
		}
		// Triipude määramine
		int triibud;// Määrab millist triipude faili kasutatakse 0 puhul pole
					// triipe
		if (kasTriibud(ahel)) {
			triibud = tlookus(ahel);
		} else
			triibud = 0;
		System.out.println("Kilpkonn: " + kasKilpkonn(ahel));
		System.out.println("Triibud: " + kasTriibud(ahel));
		System.out.println(pohivarv);
		Varvid.varvivaartustamine();
		Varvid.triibuvaartustamine();
		System.out.println(Varvid.triibud[tlookus(ahel)]);
		System.out.println(Varvid.kassivarv[pohivarv]);// Kilpkonn 15

	}

}
