package Visuaal;

public class Varvid {
	static int a=13;//kassvärvide arv
	
	static float[] hue=new float[a];
	static float[] saturation=new float[a];
	static float[] lumbon=new float[a];
	static String[] kassivarv=new String[a];
	static String[] failinimi=new String[a];
	
	static int t=4;//Triipude tüüpide arv(puudulikkus kaasa arvatud)
	static String[] triibud=new String[t];
	
	static int c=6;
	static String[] ceefail=new String[c];
	static String[] ceenimi=new String[c];
	
	static String[] laigunimi=new String[3];
	
	//Kassivärvide Väärtustamine
	public static void varvivaartustamine() {
		
	hue[0]=13/360f;
	saturation[0]=35/100f;
	lumbon[0]=-0.1f;
	kassivarv[0]="Puudulik kass";
	
	hue[1]=25/360f;
	saturation[1]=70/100f;
	lumbon[1]=-0.f;
	kassivarv[1]="Oranž";
	
	hue[2]=23/360f;
	saturation[2]=20/100f;
	lumbon[2]=0.1f;
	kassivarv[2]="Sirelililla";
	
	hue[3]=25/360f;
	saturation[3]=0/100f;
	lumbon[3]=-0.f;
	kassivarv[3]="Hall";
	
	hue[4]=30/360f;
	saturation[4]=23/100f;
	lumbon[4]=0.45f;
	kassivarv[4]="HeleOranž";
	
	hue[5]=42/360f;
	saturation[5]=41/100f;
	lumbon[5]=-0.f;
	kassivarv[5]="Akuut";
	
	hue[6]=28/360f;
	saturation[6]=70/100f;
	lumbon[6]=-0.f;
	kassivarv[6]="Roostepruun";		
	
	hue[7]=28/360f;
	saturation[7]=0/100f;
	lumbon[7]=-0.2f;
	kassivarv[7]="Must";
	
	hue[8]=28/360f;
	saturation[8]=70/100f;
	lumbon[8]=-0.f;
	kassivarv[8]="Roostepruun";	
	
	hue[9]=28/360f;
	saturation[9]=70/100f;
	lumbon[9]=-0.f;
	kassivarv[9]="LahjRoostepruun";	
	
	hue[10]=13/360f;
	saturation[10]=35/100f;
	lumbon[10]=-0.1f;
	kassivarv[10]="šokolaad";
	
	hue[11]=28/360f;
	saturation[11]=70/100f;
	lumbon[11]=-0.f;
	kassivarv[11]="Rooshllhkepruun";	
	
	hue[12]=1/360f;
	saturation[12]=0/100f;
	lumbon[12]=0.1f;
	kassivarv[12]="Valge";	
	
}
	//Triipude määramine
	public static void triibuvaartustamine(){
		triibud[0]="blank.png";
		triibud[1]="TT.png";//Triigrimuster
		triibud[2]="tbtb.png";
		triibud[3]="Tatb.png";
	}
	
	public static void ceedevaartustamine(){
		ceefail[0]="blank.png";
		ceefail[1]="C.png";//Normaale karvavärvumine C
		ceefail[2]="cscs.png";//cscs
		ceefail[3]="cbcb.png";//cbcb
		ceefail[4]="cscb.png";//cscb
		ceefail[5]="ccs.png";//ccs
		ceefail[6]="ccb.png";//ccb
		ceefail[7]="cc.png";//cc
		ceenimi[0]="blank.png";
		ceenimi[1]="C.png";//Normaale karvavärvumine C
		ceenimi[2]="cscs.png";//cscs
		ceenimi[3]="cbcb.png";//cbcb
		ceenimi[4]="cscb.png";//cscb
		ceenimi[5]="ccs.png";//ccs
		ceenimi[6]="ccb.png";//ccb
		ceenimi[7]="cc.png";//cc
	}
	
	public static void laiguvaartustamine(){
		laigunimi[0]="blank.png";
		laigunimi[1]="S.png";//alla 50 protsendi valgeid laike
		laigunimi[2]="SS.png";//üle 50 protsendi valgeid laike		
	}
	
	public static void varvid(){
		ceedevaartustamine();
		triibuvaartustamine();
		varvivaartustamine();
		laiguvaartustamine();
	}
		

}
