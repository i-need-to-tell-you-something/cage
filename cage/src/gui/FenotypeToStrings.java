package gui;

import java.text.MessageFormat;

import gui.menubar.Locales;

public class FenotypeToStrings {
	int[] fenotype;
	//TODO: Should move this to a more intuitive and shared place:
	static String geneReference[] = {"A","B","C","D","L","O","S","T","W","X"};

	//ABCDLOSTWX
	//0123456789
	public static String giveText(int [] dnaStrand, int locus) {
		String x=""; //$NON-NLS-1$

		switch (locus) {

		case 0: {//A lookus. Akuutsus dominantne. Dominantne epistaas B lookus üle. Retsessiivne epistaas T lookuse üle
			switch (dnaStrand[locus]) {
			case 0: x=Locales.characteristicsBundle.getString("aa"); break; //$NON-NLS-1$
			case 1: case 2: x=Locales.characteristicsBundle.getString("AA/Aa"); break; //$NON-NLS-1$
			default: returnError(0); break;
			}break;
		}

		case 1: {//B lookus.
			//Moved this exception up here from the exception section
			if (dnaStrand[0]!=0) {x=Locales.characteristicsBundle.getString("Bneedsaa"); break;} //TODO Restructure_1
			switch (dnaStrand[locus]) {
			case 6: x=Locales.characteristicsBundle.getString("blbl"); break;   	 //$NON-NLS-1$
			case 0: case 3: x=Locales.characteristicsBundle.getString("bbl/bb"); break; //$NON-NLS-1$
			case 1: case 2: case 4: x=Locales.characteristicsBundle.getString("BB/Bbl/Bb"); break; //$NON-NLS-1$
			default: returnError(1); break;
			}break;
		}

		case 2: {//C lookus
			switch (dnaStrand[locus]) {
			case 0: x=Locales.characteristicsBundle.getString("cc"); break; //$NON-NLS-1$

			case 1: case 2: case 4: case 8: x=Locales.characteristicsBundle.getString("CC/Ccb/Ccs/Cc"); break;            	 //$NON-NLS-1$

			case 6: x=Locales.characteristicsBundle.getString("cbcb"); break; //soojemates kohtades heledate laikudega (kõht, lõuaalune) //$NON-NLS-1$
			case 3: x=Locales.characteristicsBundle.getString("cbc"); break; //$NON-NLS-1$

			case 14: x=Locales.characteristicsBundle.getString("cscs"); break; //kere on hele, kõrvad, nägu, saba, käpad tumedad. Silmad intensiivsinised. //$NON-NLS-1$
			case 7: x=Locales.characteristicsBundle.getString("csc"); break; //$NON-NLS-1$

			case 10: x=Locales.characteristicsBundle.getString("cbcs"); break;  //$NON-NLS-1$

			default: returnError(2); break;

			}break;
		}

		case 3: {//D lookus
			switch (dnaStrand[locus]) {
			case 1: case 2: x=Locales.characteristicsBundle.getString("DD/Dd"); break; //$NON-NLS-1$

			case 0: {
				if (dnaStrand[5]==2){
					x=Locales.characteristicsBundle.getString("ddXOXO/ddXOY"); break; //$NON-NLS-1$
				}
				else if (dnaStrand[5]==1){
					x=Locales.characteristicsBundle.getString("ddXOXo"); break; //$NON-NLS-1$
				}
				else if (dnaStrand[5]==0)  { //norm värvi, mitte oranž, lahjendunud, pole akuuti
					if (dnaStrand[0]==0) {
						switch (dnaStrand[1]) {
						case 6: x=Locales.characteristicsBundle.getString("aablblddXoXo/aablblddXoY"); break;                    //$NON-NLS-1$
						case 0: case 3: x=Locales.characteristicsBundle.getString("aabbddXoXo/aabbddXoY/aabblddXoXo/aabblddXoY"); break;                            //$NON-NLS-1$
						case 1: case 2: case 4: x=Locales.characteristicsBundle.getString("aaBBddXoXo/aaBBddXoY/aaBbddXoXo/aaBbddXoY/aaBblddXoXo/aaBblddXoY"); break; //$NON-NLS-1$
						}
					}
					else {
						x="lookus ei AVALDU (A)"; break; //TODO localize
					}
				}
			}
			default: returnError(3); break;
			}break;
		}

		case 4: {//L lookus
			switch (dnaStrand[locus]) {
			case 0: x=Locales.characteristicsBundle.getString("ll"); break; //$NON-NLS-1$
			case 1: case 2: x=Locales.characteristicsBundle.getString("LL/Ll"); break; //$NON-NLS-1$
			default: returnError(4); break;
			}break;
		}

		case 5: {//O lookus. suguliiteline (hiljem vaatab kas kuidas muudab)
			switch (dnaStrand[locus]) {
			case 0: x=Locales.characteristicsBundle.getString("XoXo/XoY"); break; //$NON-NLS-1$
			case 1: x=Locales.characteristicsBundle.getString("XOXo"); break; //$NON-NLS-1$
			case 2: x=Locales.characteristicsBundle.getString("XOXO/XOY"); break; //$NON-NLS-1$
			default: returnError(5); break;
			}break;
		}

		case 6: {//S lookus. Laigud dominantsed. Semidominantsus
			switch (dnaStrand[locus]) {
			case 0: x=Locales.characteristicsBundle.getString("ss"); break; //$NON-NLS-1$
			case 1: x=Locales.characteristicsBundle.getString("Ss"); break; //$NON-NLS-1$
			case 2: x=Locales.characteristicsBundle.getString("SS");break; //$NON-NLS-1$
			default: returnError(6); break;
			}break;
		}

		case 7: {//T lookus
			switch (dnaStrand[locus]) { // Ta-Abyssinian;T-Mackerel;tb-Classic
			case 6: x=Locales.characteristicsBundle.getString("tbtb"); break; //tbtb //$NON-NLS-1$
			case 2: case 4: x=Locales.characteristicsBundle.getString("TT/Ttb"); break; //TT;Ttb //$NON-NLS-1$
			case 0: x=Locales.characteristicsBundle.getString("TaTa"); break; //TaTa //$NON-NLS-1$
			case 1: case 3: x=Locales.characteristicsBundle.getString("TaT/Tatb"); break; //TaT;Tatb //$NON-NLS-1$
			default: returnError(7); break;
			}break;
		}

		case 8: {//W lookus. Valge dominantne. Dominantsus. Dominantne epistaas A,B,D,O,S,T üle
			switch (dnaStrand[locus]) {
			case 0: x=Locales.characteristicsBundle.getString("ww"); break; //$NON-NLS-1$
			case 1: case 2: x=Locales.characteristicsBundle.getString("WW/Ww"); break; //$NON-NLS-1$
			default: returnError(8); break;
			}break;
		}

		case 9: {//sugukromosoomid
			switch (dnaStrand[locus]) {
			case 0: x=Locales.characteristicsBundle.getString("XX"); break; //$NON-NLS-1$
			case 1: x=Locales.characteristicsBundle.getString("XY"); break; //$NON-NLS-1$
			default: returnError(9); break;
			}break;
		}


		default: x=Locales.characteristicsBundle.getString("NA");  //$NON-NLS-1$
		}


		
		
		
		
		
		
		
		
		
		
		
		
		
		//FOLLOWING:
		//TODO Restructure_1
		//IF these were moved into their respective "case n:"s then could use "return x;" right away. 
		
		
		//The description of the locus has it's initial value
		//Now we will check if some gene is epistatic over the one we are examining (when one gene suppresses another)

		//Took this exception to the main switch element up 
		//if (ahel[0]!=0 && lookus==1) x="B lookus ei avaldu(A)"; //Kontrollib kas kass on hoopis akuutvärvi

		if ((dnaStrand[0]==0 && dnaStrand[5]==0) && locus==7) x=Locales.characteristicsBundle.getString("TneedsOA"); //$NON-NLS-1$

		

		if (dnaStrand[5]==2) {//Kontrollib kas kass on oranž
			switch (locus) {
			case 1: x=Locales.characteristicsBundle.getString("Bneeds!O");break; //$NON-NLS-1$
			case 0: x=Locales.characteristicsBundle.getString("Aneeds!O");break; //$NON-NLS-1$
			}
		}

		if (dnaStrand[8]!=0) { //Kontrollib kas kass on hoopis valge
			switch (locus) {
			case 0: x=Locales.characteristicsBundle.getString("Aneeds!W"); break; //$NON-NLS-1$
			case 1: x=Locales.characteristicsBundle.getString("Bneeds!W"); break; //$NON-NLS-1$
			case 3: x=Locales.characteristicsBundle.getString("Dneeds!W"); break; //$NON-NLS-1$
			case 5: x=Locales.characteristicsBundle.getString("Oneeds!W"); break; //$NON-NLS-1$
			case 6: x=Locales.characteristicsBundle.getString("Sneeds!W"); break; //$NON-NLS-1$
			case 7: x=Locales.characteristicsBundle.getString("Tneeds!W"); break; //$NON-NLS-1$
			}
		}

		if ((dnaStrand[2]!=1 && dnaStrand[2]!=2 && dnaStrand[2]!=4 && dnaStrand[2]!=8)) { //Kontrollib kas kass on üldse värvunud
			switch (locus) {
			case 0: x=Locales.characteristicsBundle.getString("Aneeds!cc"); break; //$NON-NLS-1$
			case 1: x=Locales.characteristicsBundle.getString("Bneeds!cc"); break; //$NON-NLS-1$
			case 3: x=Locales.characteristicsBundle.getString("Dneeds!cc"); break; //$NON-NLS-1$
			case 5: x=Locales.characteristicsBundle.getString("Oneeds!cc"); break; //$NON-NLS-1$
			case 6: x=Locales.characteristicsBundle.getString("Sneeds!cc"); break; //$NON-NLS-1$
			case 7: x=Locales.characteristicsBundle.getString("Tneeds!cc"); break; //$NON-NLS-1$
			case 8: x=Locales.characteristicsBundle.getString("Wneeds!cc"); break; //$NON-NLS-1$

			}
		}

		return x;
	}
	
	private static String returnError(int locus) {
		MessageFormat formatter = new MessageFormat("");
		formatter.setLocale(Locales.currentLocale);
		Object[] messageArguments = { geneReference[locus] };
		formatter.applyPattern(Locales.characteristicsBundle.getString("errors"));
		return(formatter.format(messageArguments));
	}

}
