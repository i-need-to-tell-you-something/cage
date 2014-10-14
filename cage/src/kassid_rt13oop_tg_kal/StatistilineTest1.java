package kassid_rt13oop_tg_kal;
class StatistilineTest1 {

	//uurib randomit sisaldavat avaldist Kass.java konstruktoris Kass.genereeri.
	
	public static void main(String[] args) {
		for (int i=0;i<10;i++) { //k�ime l�bi loodava kassi ahela lookused
	    	  int n=Andmed.Tabel()[i][0]; //loen tabelist, mis on max v��rtus
	    	  System.out.println();
	    	  for (int j=0;j<n;j++) { //ja siis k�in iga v��rtuse l�bi
	    		  if (Math.random()*100<=100/(n-j)*(Andmed.Tabel()[i][2]/10)) {System.out.print(Kass.jada[j]+"-"+(100/(n-j)*(Andmed.Tabel()[i][2]/10))+"%  "); break;} //suvaline number 0-100 v�rreldakse parema poolega, kui parem pool on suurem siis pannakse j
	    		  //if (Math.random()*100<=100/(n-j)+Andmed.Tabel()[i][2]*10) {System.out.print((100/(n-j)+Andmed.Tabel()[i][2]*10)+"%  "); break;}
	    	  }
		}
		
		
//		int ite=(int) 1E+6;
//		int kahek�mnendik = ite/20; //for loadingbar
//		System.out.println("0%              100%"); //loadingbar
		
//		for (int i=0; i<10;i++) {
//			int n=Andmed.Tabel()[i][0];
//			for (int j=0;j<n;j++) {
//				if Math.random()*100<=100/(n-j+1)+Andmed.Tabel()[i][2]*10
//			}
//		}
//		for (int i=0;i<10;i++) { //k�ime l�bi loodava kassi ahela lookused
//	    	  int n=Andmed.Tabel()[i][0]; //loen tabelist, mis on max v��rtus
//	    	  System.out.println();
//	    	  for (int j=0;j<n;j++) { //ja siis k�in iga v��rtuse l�bi
//	    		  System.out.print((100/(n-j)+Andmed.Tabel()[i][2]*10)+"%  ");
//	    		  //System.out.println(100/(n-j+1)+Andmed.Tabel()[i][2]*10);
//	    	  }
//	      }
//		System.out.println();
	}

}
