package kassid_rt13oop_tg_kal;
class StatistilineTest0 {

	//uurib Math.randomi v��rtust. l�pus kokkuv�te
	//HALB VALE PAHA
	
	
	public static void main(String[] args) {
		double start = System.currentTimeMillis(); //for timer
		int ite=(int) 1E+6; //iteratsioonide hulk
		int kahek�mnendik = ite/20; //for loadingbar
		System.out.println("0%              100%"); //loadingbar
		
		int[] summaahel= new int[10];
		for (int i=0;i<ite;i++) {
			if (i%kahek�mnendik==0) System.out.print("|"); //minu esimene loadingbar
			Kass k1= new Kass();
			for (int j=0;j<10;j++) {
				summaahel[j]+=k1.getAhel1()[j]+k1.getAhel2()[j];
			}
		}
		System.out.println(" " + (System.currentTimeMillis()-start)/1000 + "sekundit"); //timer.out.println
		
		System.out.println("summa - keskmine");
		for (int i=0;i<10;i++) {
//			System.out.print((Andmed.Tabel()[i][0]-1)/2.0);
//			System.out.print(" - ");
			System.out.print(summaahel[i]);
			System.out.print(" - ");
			System.out.println(summaahel[i]/(2.0*ite));
		}

	}

}
