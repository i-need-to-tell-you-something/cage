package core;
import gui.menubar.Locales;
import gui.menubar.Menu;

import java.io.Serializable;
import java.util.Arrays;


public class Kass implements Serializable{

	
	//andmeväljad:
	String ema;
	String isa;
	int[] ahel1; //esimene genotüübiahel
	int[] ahel2; //teine genotüübiahel
	int[] fenotahel; //fenotüüp, genereeritakse kahe genotüübiahela põhjal
	String nimi; //kiisu nimi
	// List of numbers that form unique pairs - id est no sum of any pair of these numbers is same as the sum of any other pair. http://oeis.org/A025582 
	public static final int[] jada={0, 1, 3, 7, 12, 20, 30, 44, 65, 80, 96, 122, 147, 181, 203, 251, 289, 360, 400, 474, 564, 592, 661, 774, 821, 915, 969, 1015, 1158, 1311, 1394, 1522, 1571, 1820, 1895, 2028, 2253, 2378, 2509, 2779, 2924, 3154, 3353, 3590, 3796, 3997, 4296, 4432, 4778, 4850};
	// Some error or warning asked for this:
	private static final long serialVersionUID = 1L;



	//konstruktor, mille abil saame luua uue kassi etteantud genotüübiahelatega ja genereeritakse fenotüübiahel
	public Kass(int[] kassiahel1, int[] kassiahel2) {
		this.ahel1=kassiahel1;
		this.ahel2=kassiahel2;
		this.fenotahel=Kass.genotypeToFenotype(kassiahel1,kassiahel2);
		try {
			this.nimi=randnimifailist();
		}
		catch (java.lang.NoClassDefFoundError e) {
			//TODO error_standardization
			System.out.println("randnime ei saa luua vea tõttu: " + e.getMessage());
		}
	}

	public Kass(int[] kassiahel1, int[] kassiahel2, String ema, String isa) {
		this.ema=ema;
		this.isa=isa;
		this.ahel1=kassiahel1;
		this.ahel2=kassiahel2;
		this.fenotahel=Kass.genotypeToFenotype(kassiahel1,kassiahel2);
		try {
			this.nimi=randnimifailist();
		}
		catch (java.lang.NoClassDefFoundError e) {
			//TODO error_standardization
			System.out.println("randnime ei saa luua vea tõttu: " + e.getMessage());
		}
	}

	//konstruktor etteantud nimega (ja ahelatega) kassi loomiseks
	public Kass(int[] kassiahel1, int[] kassiahel2, String kassinimi) {
		this.ahel1=kassiahel1;
		this.ahel2=kassiahel2;
		this.fenotahel=Kass.genotypeToFenotype(kassiahel1,kassiahel2);
		this.nimi=kassinimi;
	}

	//konstruktor ilma argumentideta; endine Kass.genereeri(hulk)
	public Kass (){
		//TODO support >10 loci
		int hulk=10; //oli compatibility jaoks kui on rohkem kromosoome; enam ei ole vaja
		int[] kassiahel1=new int[hulk]; //teeme esimese ahela
		int[] kassiahel2=new int[hulk]; //teeme teise ahela

		for (int i=0;i<hulk;i++) { //käime läbi loodava kassi ahela elemendid (lookused)
			try {
				int n=DataReader.getLocusBonusTable()[i][0]; //loen tabelist, mitu erinevat väärtust antud lookuses võib olla
				double vahemik []= new double [n+1]; //loon jada randominumbri vahemike (millise puhul milline väärtus tuleb) salvestamiseks 

				int sumboonus=0;
				for (int k=0;k<DataReader.getLocusBonusTable()[i].length-2;k++){
					sumboonus= sumboonus+DataReader.getLocusBonusTable()[i][k+2];//Määrab antud lookuses alleelide boonuste summa
				}

				for (int j=0;j<n;j++) { //ja siis käin läbi väärtuste hulga...
					vahemik[j+1] = (double)DataReader.getLocusBonusTable()[i][j+2]/sumboonus+vahemik[j]; //...ja määran nende vahemiku lõpu (uue vahemiku alguse)

				}        
				double ran=Math.random(); //võtame suvalise arvu. järgnev tsükkel ei ole eelmisega ühendatud seepärast, et kasutatakse väärtusi, mis eelmise tsükli lõpuks alles omistatud saavad
				for (int j=0;j<n;j++) { //käin läbi kõik väärtused esimese ahela jaoks... 
					if (ran>=vahemik[j] && ran<vahemik[j+1]) {kassiahel1[i]=jada[j];break;} //...ja kontrollin, kas random sattus nende vahemikku     
				}
				ran=Math.random(); //uus random ja uus tsükkel. viimane neist seepärast, et "break;"
				for (int j=0;j<n;j++) { //käin läbi kõik väärtused teise ahela jaoks...
					if (ran>=vahemik[j] && ran<vahemik[j+1]) {kassiahel2[i]=jada[j]; break;} //...ja kontrollin, kas random sattus nende vahemikku
				} 
			}
			catch (ExceptionInInitializerError e) {
				//TODO error_standardization
				System.out.println("ReadSomeData.tabel[i][0] = n in Kass.java: " + e.getMessage());
			}
			catch (java.lang.NoClassDefFoundError e) {
				//TODO error_standardization
				System.out.println("ReadSomeData.tabel[i][0] = n in Kass.java: " + e.getMessage());
			}

		}
		if (kassiahel1[9]==1 && kassiahel2[9]==1) { //hardcodisin sisse, et kui YY, siis XX
			kassiahel2[9]=0;
			kassiahel1[9]=0;
		}
		this.ahel1=kassiahel1;
		this.ahel2=kassiahel2;
		this.fenotahel=Kass.genotypeToFenotype(kassiahel1,kassiahel2); 
		try {
			this.nimi=randnimifailist();
		}
		catch (java.lang.NoClassDefFoundError e) {
			//TODO error_standardization
			System.out.println("randnime ei saa luua vea tõttu: " + e.getMessage());
		}
	}

	String randnimifailist() throws java.lang.NoClassDefFoundError {
		int index = (int)Math.round(Math.random()*(DataReader.getCatNames().length)-0.5);
		DataReader.growAmountOfNames(index);
		if (DataReader.getAmountOfNames(index)==1){ //Juhul kui kass on esimene sellist nime omama, siis ei lisandu indeksit
			return (DataReader.getCatNames()[index]);
		}
		else{	
			return (DataReader.getCatNames()[index] + DataReader.getAmountOfNames(index));//Kui nimekaim kass on olemas, siis lisandub indeks
		}
	}

	//meetod, mis loob uue suguraku kassil (kasutatakse sigimisel)
	int[] suguR() {
		int[] suguRahel = new int[this.getAhel1().length]; //sugurakus samapalju lookuseid kui ühes genotüübiahelas
		try {
			for (int j=0;j<DataReader.getLocusBonusTable().length;j++) { //käin andmetabeli läbi
				if (Math.random()>0.5) {
					suguRahel[j]=this.getAhel1()[j]; //...siis valin randomi alusel ahel1...
					if (j==9) suguRahel[5]=this.getAhel1()[5]; //(o lookus saab olema samast ahelast kui sugulookuski) 
				}
				else {
					suguRahel[j]=this.getAhel2()[j]; //...või ahel2
					if (j==9) suguRahel[5]=this.getAhel2()[5]; //(o lookus saab olema samast ahelast kui sugulookuski)
				}
			}
		}
		catch (java.lang.NoClassDefFoundError e) {
			//TODO error_standardization
			System.out.println("Sugurakku ei saa moodustada: " + e.getMessage());
		}
		return suguRahel;
	}


	//meetod, mis loob uue kassi etteantud vanematega - viljastumine
	public static Kass viljastumine (Kass x, Kass y){
		//	(x.getFenotahel()[9]==0)? : ;
		if (x.getFenotahel()[9]==1) {
			Kass z; //temp muutuja swapi jaoks
			z=x;
			x=y;
			y=z;
		}
		int[] isaSuguR = y.suguR(); 
		int[] emaSuguR = x.suguR();
		if (isaSuguR[9]==1) isaSuguR[5]=emaSuguR[5]; //isalt Y kromosoomi saamise korral ei saa järglane isalt O lookust,
		//seega kaotan info ära duubeldades ema O lookust
		return new Kass(isaSuguR,emaSuguR,x.getNimi(),y.getNimi()); //viljastumine ehk sugurakkude liitumine
	}

	public String toString() {
		StringBuilder kujutus = new StringBuilder();
		String sugu = "";
		switch (this.getFenotahel()[9]) {
		case 0: sugu = " " + Locales.mainBundle.getString("female"); break;
		case 1: sugu = " " + Locales.mainBundle.getString("male"); break;
		case 2: sugu = " " + Locales.mainBundle.getString("doubleY"); break;
		//TODO error_standardization
		default: sugu = " viga"; break;
		}
		kujutus.append(this.getNimi() + sugu);
		if (Menu.isOptionVanemad()) {
			kujutus.append(" (");
			if (this.ema==null) {
				kujutus.append(Locales.mainBundle.getString("invitro"));
			}
			else {
				kujutus.append(this.ema + " " + Locales.mainBundle.getString("female") +"; " + this.isa + " " + Locales.mainBundle.getString("male"));
			}
			kujutus.append(")");
		}
		return kujutus.toString();
	}

	public String toString2() {
		return "Kass [ahel1=" + Arrays.toString(ahel1) + ", ahel2="
				+ Arrays.toString(ahel2) + ", fenotahel="
				+ Arrays.toString(fenotahel) + ", nimi=" + nimi + "]";
	}

	//Getterid ja setterid
	public String getNimi() {return nimi;}

	public void setName(String nimi) {this.nimi = nimi;}

	public int[] getAhel1() {return ahel1;}

	public void setAhel1(int[] ahel1) {this.ahel1 = ahel1;}

	public int[] getAhel2() {return ahel2;}

	public void setAhel2(int[] ahel2) {this.ahel2 = ahel2;}

	public int[] getFenotahel() {return fenotahel;}

	public static int[] getJada() {
		return jada;
	}

	public void setFenotahel(int[] fenotahel) {
		this.fenotahel = fenotahel;
	}

	public static int[] genotypeToFenotype(int[] ahel1, int [] ahel2){
		int x=ahel1.length;
		int[] fenotype= new int[x];
		for (int i=0;i<x;i++){
			fenotype[i]=(ahel1[i]+ahel2[i]);
		}
		return fenotype;
	}

}


