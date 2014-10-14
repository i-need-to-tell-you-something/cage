package kassid_rt13oop_tg_kal;


public class algus {

	
	
	public static void main(String[] args) {
		
		Kass mäu = new Kass(); //kasside mäu, näu, meow ja nya genereerimine
		Kass näu = new Kass();
		Kass meow = new Kass();
		Kass nya = new Kass();
		
		
	
		näu.fenotahel[9]=1; //Näu isaseks tegemine
		näu.ahel1[9]=0;
		näu.ahel2[9]=1;
		
		mäu.fenotahel[9]=0; //Mäu emaseks tegemine
		mäu.ahel1[9]=0;
		mäu.ahel2[9]=0;
		//A	 B	C	D	L	O	S	T	W	Sugu
		//0	 1	2	3	4	5	6	7	8	9
		
//		int[] random1 = {0,0,1,0,1,0,1,0,0,0};//annab kassile meow geenidlookuste alleelid
//		int[] random2 = {0,0,0,1,1,0,0,0,0,0};
//		meow.ahel1 = random1;
//		meow.ahel2 = random2;
//		
//		int[] random3 = {0,0,3,0,1,0,1,0,0,0};//annab kassile nya geenidlookuste alleelid
//		int[] random4 = {0,0,0,0,0,0,0,0,1,1};
//		nya.ahel1=random3;
//		nya.ahel2=random4;
//		meow.fenotahel=Fenotyyp.genereeri(meow.ahel1,meow.ahel2); //arvutab fenotääbi
		
		nya.fenotahel=Fenotyyp.genereeri(nya.ahel1,nya.ahel2); //arvutab fenotääbi
		
		meow.ahel1[2]=1; //teen kindlaks et meow värvuks
		meow.fenotahel[2]=4; 
		meow.ahel2[2]=3;
		System.out.println("meow: \n"+meow); //Kuvab meow genotääpi fenotääpi
		for (int j=0; j<meow.getFenotahel().length;j++) {
			System.out.println(Fenotyyp.valjasta(meow.getFenotahel(),j));	
		}
		System.out.println("nya: " +nya);
		for (int j=0; j<nya.getFenotahel().length;j++) {
			System.out.println(Fenotyyp.valjasta(nya.getFenotahel(),j));	
		}
		
//		new Kass();
		Kass miisu = Kass.viljastumine(mäu,näu);
		System.out.println("miisu: "+ miisu);
		for (int j=0; j<miisu.getFenotahel().length;j++) {
			System.out.println(Fenotyyp.valjasta(miisu.getFenotahel(),j));	
		}
	
	
	
		//Kass nurr = new Kass().viljastumine(mäu,näu);
		//System.out.println(nurr);
		//Kass karnäu = new Kass().viljastumine(meow,nya);
		System.out.println(mäu);
		for (int j=0; j<mäu.getFenotahel().length;j++) {
			System.out.println(Fenotyyp.valjasta(mäu.getFenotahel(),j));	
		}
		System.out.println(näu);
		for (int j=0; j<näu.getFenotahel().length;j++) {
			System.out.println(Fenotyyp.valjasta(näu.getFenotahel(),j));	
		}
		
//		new Kass();
		Kass karnäu = Kass.viljastumine(mäu,näu);
		System.out.println(karnäu);
		for (int j=0; j<karnäu.getFenotahel().length;j++) {
			System.out.println(Fenotyyp.valjasta(karnäu.getFenotahel(),j));	
		}
		
		
		
	
		//demo millised meetodid on kasutatavad ja millised mitte (võin ämber teha kui vaja on):
		//selle abil siis loemegi edaspidi "geneetilist koodi"
		/*
		System.out.println(mia.getAhel1().toString()); //ei tääta, annab viida mitte andmed
		System.out.println(mia.ahel1.toString()); //ei tääta, annab viida mitte andmed
		System.out.println(mia.ahel1); //ei tääta, annab viida mitte andmed
		
		System.out.println(mia.toString()); //täätab, aga mitte eriti kasulik
		System.out.println(mia.ahel1[0]+""+mia.ahel1[1]+mia.ahel1[2]); //siin on siis äige access meetod x3
		System.out.println(mia.ahel1[4]); //äige x1
		System.out.println("Viienda lookuse väärtus 1. ahelas on: " +mia.ahel1[8]);
		System.out.println("Viienda lookuse väärtus 2. ahelas on: "+mia.ahel2[8]);
		*/
		for (int i = 0; i < karnäu.fenotahel.length; i++) {
			System.out.println(karnäu.fenotahel[i]);
		}

	}
	

}
