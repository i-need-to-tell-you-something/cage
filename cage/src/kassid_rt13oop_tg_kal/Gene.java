package kassid_rt13oop_tg_kal;

import java.util.LinkedList;

/**
 * The Gene class serves to contain information about the properties of each possible gene
 *
 */

public class Gene {
	String symbol;
	String[] alleles;
	LinkedList<String> interactions = new LinkedList<String>();
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setAlleles(String[] alleles) {
		this.alleles = alleles;
	}

	public void addInteractions(String interactions) {
		this.interactions.add(interactions);
	}

	public Gene() {
	}

}
