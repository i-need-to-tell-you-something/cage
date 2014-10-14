package kassid_rt13oop_tg_kal;
public class demo {

	
	//algus, duh
	public static void main(String[] args) {
		
		//loome kassi hulga "suurus" lookusega
		int suurus = 10;
		Kass k1= new Kass();
		System.out.println(k1.toString());
		//System.out.println(k2.toString());
		//System.out.println(k3.toString());
		//System.out.println(k4.toString());
		for (int i=0;i<suurus;i++) {
			System.out.println(Fenotyyp.valjasta(k1.getFenotahel(), i));
		}
		/*Kass k5= new Kass().viljastumine(k3, k4);
		System.out.println(k5.toString());
		Kass k6= new Kass().viljastumine(k2, k1);
		System.out.println(k6.toString());
		Kass k7= new Kass().viljastumine(k5, k6);
		System.out.println(k7.toString());
		
		
		//demo millised meetodid on kasutatavad ja millised mitte (v�in �mber teha kui vaja on):
		//selle abil siis loemegi edaspidi "geneetilist koodi"
		
		/*System.out.println(mia.toString()); //t��tab, aga mitte eriti kasulik
		for (int i=0;i<mia.getAhel1().length;i++) System.out.print(mia.getAhel1()[i]);
		System.out.println();
		for (int i=0;i<mia.getAhel1().length;i++) System.out.print(mia.getAhel2()[i]);
		System.out.println();
		for (int i=0;i<mia.getAhel1().length;i++) System.out.print(mia.getFenotahel()[i]);
		System.out.println();
		*/
	}

}
