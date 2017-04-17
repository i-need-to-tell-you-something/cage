package gui;

import java.text.MessageFormat;
import java.util.ArrayList;

import gui.menubar.Locales;

public class FenotypeToStrings {
	
	/**
	 * Matches loci/gene integers to their corresponding letters. Each internal integer is the index of each letter.
	 */
	//TODO: Should move this to a more intuitive and shared place:
	static String locusLabelLetters[] = {"A","B","C","D","L","O","S","T","W","X"};

	
	/**
	 * Returns a line of text describing the fenotype result of a specified locus/gene in the context of the full genome
	 * @param genome The genome of the cat to be described
	 * @param locus The locus the effects (or lack thereof) of which we will describe 
	 * @return
	 */
	public static String giveText(int [] genome, int locus) {
		switch (locus) {

		case 0: {//A locus
			//Masking check:
			ArrayList<Integer> maskingLoci = new ArrayList<Integer>();
			if (genome[2]!=1 && genome[2]!=2 && genome[2]!=4 && genome[2]!=8) {
				maskingLoci.add(2);
			}
			if (genome[5]==2) {
				maskingLoci.add(5);
			}
			if (genome[8]!=0) {
				maskingLoci.add(8);
			}
			if (maskingLoci.isEmpty()) {
				//Actual locus evaluation (only takes place if preceding things succeeded):
				switch (genome[locus]) {
				case 0: return(Locales.characteristicsBundle.getString("aa"));
				case 1: case 2: return(Locales.characteristicsBundle.getString("AA/Aa"));
				default: return(returnError(locus));
				}
			}
			else {
				return(returnMasked(locus, maskingLoci));
			}
		}

		case 1: {//B locus
			//Masking check:
			ArrayList<Integer> maskingLoci = new ArrayList<Integer>();
			if (genome[0]!=0) {
				maskingLoci.add(0);
			}
			if (genome[2]!=1 && genome[2]!=2 && genome[2]!=4 && genome[2]!=8) {
				maskingLoci.add(2);
			}
			if (genome[5]==2) {
				maskingLoci.add(5);
			}
			if (genome[8]!=0) {
				maskingLoci.add(8);
			}
			if (maskingLoci.isEmpty()) {
				//Actual locus evaluation (only takes place if preceding things succeeded):
				switch (genome[locus]) {
				case 6: return(Locales.characteristicsBundle.getString("blbl")); 
				case 0: case 3: return(Locales.characteristicsBundle.getString("bbl/bb"));
				case 1: case 2: case 4: return(Locales.characteristicsBundle.getString("BB/Bbl/Bb"));
				default: return(returnError(locus));
				}
			}
			else {
				return(returnMasked(locus, maskingLoci));
			}
		}

		case 2: {//C locus
			//C locus doesn't need masking check, because it is masked by nothing.
			switch (genome[locus]) {
			case 0: return(Locales.characteristicsBundle.getString("cc"));

			case 1: case 2: case 4: case 8: return(Locales.characteristicsBundle.getString("CC/Ccb/Ccs/Cc"));            	

			case 6: return(Locales.characteristicsBundle.getString("cbcb")); 
			case 3: return(Locales.characteristicsBundle.getString("cbc"));

			case 14: return(Locales.characteristicsBundle.getString("cscs"));
			case 7: return(Locales.characteristicsBundle.getString("csc"));

			case 10: return(Locales.characteristicsBundle.getString("cbcs")); 

			default: return(returnError(locus));

			}
		}

		case 3: {//D locus
			//Masking check:
			ArrayList<Integer> maskingLoci = new ArrayList<Integer>();
			if (genome[0]!=0 && genome[5]==0) {
				maskingLoci.add(0);
			}
			if (genome[2]!=1 && genome[2]!=2 && genome[2]!=4 && genome[2]!=8) {
				maskingLoci.add(2);
			}
			if (genome[8]!=0) {
				maskingLoci.add(8);
			}
			if (maskingLoci.isEmpty()) {
				//Actual locus evaluation (only takes place if preceding things succeeded):
				switch (genome[locus]) {
				case 1: case 2: return(Locales.characteristicsBundle.getString("DD/Dd"));

				case 0: {
					switch (genome[5]) {
					case 2: return(Locales.characteristicsBundle.getString("ddXOXO/ddXOY"));
					case 1: return(Locales.characteristicsBundle.getString("ddXOXo"));
					case 0: {
						switch (genome[1]) {
						case 6: return(Locales.characteristicsBundle.getString("aablblddXoXo/aablblddXoY"));                   
						case 0: case 3: return(Locales.characteristicsBundle.getString("aabbddXoXo/aabbddXoY/aabblddXoXo/aabblddXoY"));                           
						case 1: case 2: case 4: return(Locales.characteristicsBundle.getString("aaBBddXoXo/aaBBddXoY/aaBbddXoXo/aaBbddXoY/aaBblddXoXo/aaBblddXoY"));
						}
					}
					}
				}
				default: return(returnError(locus));
				}
			}
			else {
				return(returnMasked(locus, maskingLoci));
			}
		}

		case 4: {//L locus
			//L locus doesn't need masking check, because it is masked by nothing.
			switch (genome[locus]) {
			case 0: return(Locales.characteristicsBundle.getString("ll"));
			case 1: case 2: return(Locales.characteristicsBundle.getString("LL/Ll"));
			default: return(returnError(locus));
			}
		}

		case 5: {//O locus
			//Masking check:
			ArrayList<Integer> maskingLoci = new ArrayList<Integer>();
			if (genome[2]!=1 && genome[2]!=2 && genome[2]!=4 && genome[2]!=8) {
				maskingLoci.add(2);
			}
			if (genome[8]!=0) {
				maskingLoci.add(8);
			}
			if (maskingLoci.isEmpty()) {
				//Actual locus evaluation (only takes place if preceding things succeeded):
				switch (genome[locus]) {
				case 0: return(Locales.characteristicsBundle.getString("XoXo/XoY"));
				case 1: return(Locales.characteristicsBundle.getString("XOXo"));
				case 2: return(Locales.characteristicsBundle.getString("XOXO/XOY"));
				default: return(returnError(locus));
				}
			}
			else {
				return(returnMasked(locus, maskingLoci));
			}
		}

		case 6: {//S locus
			//Masking check:
			ArrayList<Integer> maskingLoci = new ArrayList<Integer>();
			if (genome[2]!=1 && genome[2]!=2 && genome[2]!=4 && genome[2]!=8) {
				maskingLoci.add(2);
			}
			if (genome[8]!=0) {
				maskingLoci.add(8);
			}
			if (maskingLoci.isEmpty()) {
				//Actual locus evaluation (only takes place if preceding things succeeded):
				switch (genome[locus]) {
				case 0: return(Locales.characteristicsBundle.getString("ss"));
				case 1: return(Locales.characteristicsBundle.getString("Ss"));
				case 2: return(Locales.characteristicsBundle.getString("SS"));
				default: return(returnError(locus));
				}
			}
			else {
				return(returnMasked(locus, maskingLoci));
			}
		}

		case 7: {//T locus
			//Masking check:
			ArrayList<Integer> maskingLoci = new ArrayList<Integer>();
			if (genome[0]==0 && genome[5]==0) {
				maskingLoci.add(0);
				maskingLoci.add(5);
			}
			if (genome[2]!=1 && genome[2]!=2 && genome[2]!=4 && genome[2]!=8) {
				maskingLoci.add(2);
			}
			if (genome[8]!=0) {
				maskingLoci.add(8);
			}
			if (maskingLoci.isEmpty()) {
				//Actual locus evaluation (only takes place if preceding things succeeded):
				switch (genome[locus]) { // Ta-Abyssinian;T-Mackerel;tb-Classic
				case 6: return(Locales.characteristicsBundle.getString("tbtb")); //tbtb
				case 2: case 4: return(Locales.characteristicsBundle.getString("TT/Ttb")); //TT;Ttb
				case 0: return(Locales.characteristicsBundle.getString("TaTa")); //TaTa
				case 1: case 3: return(Locales.characteristicsBundle.getString("TaT/Tatb")); //TaT;Tatb
				default: return(returnError(locus));
				}
			}
			else {
				return(returnMasked(locus, maskingLoci));
			}
		}

		case 8: {//W locus
			//Masking check:
			ArrayList<Integer> maskingLoci = new ArrayList<Integer>();
			if (genome[2]!=1 && genome[2]!=2 && genome[2]!=4 && genome[2]!=8) {
				maskingLoci.add(2);
			}
			if (maskingLoci.isEmpty()) {
				//Actual locus evaluation (only takes place if preceding things succeeded):
				switch (genome[locus]) {
				case 0: return(Locales.characteristicsBundle.getString("ww"));
				case 1: case 2: return(Locales.characteristicsBundle.getString("WW/Ww"));
				default: return(returnError(locus));
				}
			}
			else {
				return(returnMasked(locus, maskingLoci));
			}
		}

		case 9: {//Sex locus
			// Sex locus doesn't need masking check, because it is masked by nothing.
			switch (genome[locus]) {
			case 0: return(Locales.characteristicsBundle.getString("XX"));
			case 1: return(Locales.characteristicsBundle.getString("XY"));
			default: return(returnError(locus));
			}
		}

		//If locus cannot be identified
		default: return(Locales.characteristicsBundle.getString("NA")); 
		}
	}


	/** 
	 * Generate error message
	 * @param locus The locus which can't be displayed
	 * @return The error message
	 */
	private static String returnError(int locus) {
		MessageFormat formatter = new MessageFormat(Locales.characteristicsBundle.getString("errors"));
		Object[] messageArguments = { locusLabelLetters[locus] };
		return(formatter.format(messageArguments));
	}

	/** 
	 * Generate masking message
	 * @param originLocus The locus being masked
	 * @param maskingLoci The loci masking it
	 * @return The masking message
	 */
	private static String returnMasked(int originLocus, ArrayList<Integer> maskingLoci) {
		int length = maskingLoci.size();
		MessageFormat formatter = new MessageFormat(Locales.characteristicsBundle.getString("masking"));
		StringBuilder maskingLociLetters= new StringBuilder();
		for (int i = 0; i < length; i++) {
			if (i>0) {
				maskingLociLetters.append(", ");
			}
			maskingLociLetters.append(locusLabelLetters[maskingLoci.get(i)]);
		}
		Object[] messageArguments = { locusLabelLetters[originLocus], maskingLociLetters};
		return(formatter.format(messageArguments));
	}

}
