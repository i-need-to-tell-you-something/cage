package kassid_rt13oop_tg_kal;

public class KassiNupud {

	public static void kutse() {
		
		// JFrame raami loomine
		KassiNupuKonteiner raam = new KassiNupuKonteiner();
		raam.setTitle("Kassi loomine");
//		raam.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		raam.setSize(500, 320);
		raam.setLocation(0, 100);
		raam.setVisible(true);
		
		//JFrame raami loomine fenotüübi näitamiseks ja loomiseks
		LoomisKonteiner fenoraam = new LoomisKonteiner();		
		fenoraam.setSize(400, 250);
		fenoraam.setLocation(500, 100);
		fenoraam.setVisible(true);
		fenoraam.setTitle("Loodava kassi fenotüüp");
//		fenoraam.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

	static Kass tagastus(Kass kass) {
		System.out.println("Kassinupud üritab lisada: " + kass);
		return kass;
	}
	
}
