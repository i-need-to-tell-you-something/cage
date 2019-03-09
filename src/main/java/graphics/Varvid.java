package graphics;

import core.FilePaths;

public class Varvid {
	public static void koigivarvidevaartustamine(){
		ceedevaartustamine();
		triibuvaartustamine();
		varvivaartustamine();
		laiguvaartustamine();
//		return 1;
	}
	
	static int a=13;//kassvärvide arv
	
	static float[] hue=new float[a];
	static float[] saturation=new float[a];
	static float[] lumbon=new float[a];
	static String[] kassivarv=new String[a];
	static String[] failinimi=new String[a];
	
	static int t=5;//Triipude tüüpide arv(puudulikkus kaasa arvatud)
	static String[] triibud=new String[t];
	
	static int c=8;
	static String[] ceefail=new String[c];
	static String[] ceenimi=new String[c];
	
	static String[] laigunimi=new String[3];
	
	//Kassivärvide Väärtustamine
	public static void varvivaartustamine() {
	//Hue määrab tooni
	//Saturation määrab värvi erksuse
	//Lumbon määrab lisatava heleduse. Kui taustapilti(hall.png) muuta, 
		//siis tuleb tõenäoliselt uued lumbon värtused lisada
		
	hue[0]=13/360f;
	saturation[0]=35/100f;
	lumbon[0]=-0.1f;
	kassivarv[0]="Puudulik kass";
	
	hue[1]=30/360f;//korras loodetavasti
	saturation[1]=60/100f;
	lumbon[1]=0.2f;
	kassivarv[1]="Oranž";
	
	hue[2]=23/360f;//seems right
	saturation[2]=20/100f;
	lumbon[2]=0.1f;
	kassivarv[2]="Sirelililla";
	
	hue[3]=25/360f;//yup
	saturation[3]=0/100f;
	lumbon[3]=-0.f;
	kassivarv[3]="Hall";
	
	hue[4]=30/360f;
	saturation[4]=60/100f;
	lumbon[4]=0.45f;
	kassivarv[4]="HeleOranž";
	
	hue[5]=42/360f;//check
	saturation[5]=30/100f;
	lumbon[5]=-0.f;
	kassivarv[5]="Akuut";
	
	hue[6]=40/360f;//maybe
	saturation[6]=45/100f;
	lumbon[6]=-0.f;
	kassivarv[6]="Roostepruun";		
	
	hue[7]=28/360f;
	saturation[7]=0/100f;
	lumbon[7]=-0.45f;//enne -0,5. 
	kassivarv[7]="Must";
	
	hue[8]=28/360f;
	saturation[8]=30/100f;
	lumbon[8]=0.2f;
	kassivarv[8]="Lahj. akuut";	//Pole kindel kas eksisteerib
	
	hue[9]=28/360f;
	saturation[9]=80/100f;
	lumbon[9]=0.2f;
	kassivarv[9]="LahjRoostepruun";	
	
	hue[10]=20/360f;
	saturation[10]=25/100f;//chenk
	lumbon[10]=-0.3f;
	kassivarv[10]="šokolaad";
	
	hue[11]=28/360f;
	saturation[11]=70/100f;
	lumbon[11]=-0.f;
	kassivarv[11]="Roostepruun";	
	
	hue[12]=1/360f;
	saturation[12]=0/100f;
	lumbon[12]=0.45f;//enne 0,6
	kassivarv[12]="Valge";	
	
}
	//Triipude failinimede määramine 
	//.png tuleb hiljem lõppu panna, sest tiigrimuster peab arvestama nt TT1 ja TT2 triipe
	public static void triibuvaartustamine(){
		triibud[0]=FilePaths.gfx+"/Blank";
		triibud[1]=FilePaths.gfx+"/T";//Tiigrimuster
		triibud[2]=FilePaths.gfx+"/tbtb";
		triibud[3]=FilePaths.gfx+"/TaTa";
		triibud[4]=FilePaths.gfx+"/TaT";
	}
	
	public static void ceedevaartustamine(){
		ceefail[0]=FilePaths.gfx+"/Blank.png";
		ceefail[1]=FilePaths.gfx+"/Blank.png";//Normaalne karvavärvumine C
		ceefail[2]=FilePaths.gfx+"/Siiam.png";//cscs
		ceefail[3]=FilePaths.gfx+"/Birma.png";//cbcb
		ceefail[4]=FilePaths.gfx+"/Birma-Siiam.png";//cscb
		ceefail[5]=FilePaths.gfx+"/Siiamhele.png";//ccs
		ceefail[6]=FilePaths.gfx+"/Birmahele.png";//ccb
		ceefail[7]=FilePaths.gfx+"/Albiino.png";//cc
		ceenimi[0]=FilePaths.gfx+"/blank.png";
		ceenimi[1]=FilePaths.gfx+"/C.png";//Normaale karvavärvumine C
		ceenimi[2]=FilePaths.gfx+"/cscs.png";//cscs
		ceenimi[3]=FilePaths.gfx+"/cbcb.png";//cbcb
		ceenimi[4]=FilePaths.gfx+"/cscb.png";//cscb
		ceenimi[5]=FilePaths.gfx+"/ccs.png";//ccs
		ceenimi[6]=FilePaths.gfx+"/ccb.png";//ccb
		ceenimi[7]=FilePaths.gfx+"/cc.png";//cc
	}
	
	public static void laiguvaartustamine(){
		laigunimi[0]=FilePaths.gfx+"/Blank.png";
		laigunimi[1]=FilePaths.gfx+"/S.png";//alla 50 protsendi valgeid laike
		laigunimi[2]=FilePaths.gfx+"/SS.png";//üle 50 protsendi valgeid laike
	}
	
	
		

}
