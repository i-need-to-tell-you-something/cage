package kassid_rt13oop_tg_kal;

public class Andmed {
	//väli kasside nimede jaoks
	public static String[] NIMED = {"Näu","Nurr","Miisu","Kitty"};
	//eelmise välja väärtuste hulga loenduri andmed
	public static int[] nimedehulk = new int[NIMED.length];
	//kõige ilusam väli, mis kätkeb endas andmeid lookuste omapärade kohta
	public static int[][] Tabel = {
		/* [n] erinevate omaduste hulk 
		 * [k] kromosoom

		 * [e] esimese omaduse boonus - deprecated
		 * [2] teise omaduse boonus - deprecated
		 * [3] kolmanda omaduse boonus - deprecated
		 * [4] neljanda omaduse boonus - deprecated
		 * lookus         {n,k};//lookuse tähis
		 */
			 new int[]{2,8}//A
			,new int[]{3,6}//B
			,new int[]{4,7}//C
			,new int[]{2,4}//D
			,new int[]{2,1}//L
			,new int[]{2,0}//O
			,new int[]{2,2}//S
			,new int[]{3,3}//T
			,new int[]{2,5}//W
			,new int[]{2,0}//X	
	};
	
	public static int getNimehulk(int indeks) {
		return nimedehulk[indeks];
	}

	public static void growNimehulk(int indeks) {
		nimedehulk[indeks]++;
	}
}
