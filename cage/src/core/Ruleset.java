package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class imports, interprets and manages rulesets
 *
 */
public class Ruleset {
	Gene[] listOfGenes;

	public Ruleset() {
		
	}
	
	public void ReadFile(String filename) {
		try {
			String line = "";
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while (line != null) {
				line = reader.readLine();
				//checking that the line is longer than 1 character and not empty
				if (line != null && line.length()>1) {
					ParseLine(line);
				}
			}
			reader.close();
		} catch (IOException e) {
			// TODO Error Standardisation
		}
	}
	
	/*
	 * Gets a line and splits it into individual instructions
	 */
	public void ParseLine(String line) {
		if (line.charAt(0)=='/'&& line.charAt(1)=='/') {
			//if the line is a comment, it gets ignored.
		}
		else {
			Gene created_gene = new Gene();
			int elem_index = 0;
			int index_start = 0;
			int index_end = line.indexOf(';');
			while (index_end != -1) {
				ParseInstruction(new StringBuilder(line.substring(index_start, index_end)), created_gene, elem_index);
				index_start = index_end;
				index_end = line.indexOf(';', index_end+1);
				elem_index ++;
			}
		}

	}
	
	/*
	 * Takes individual instructions and puts them into a ruleset.
	 */
	public void ParseInstruction(StringBuilder instruction, Gene gene_in_works, int index) {
		//remove semicolon
		if(instruction.indexOf(";")!=-1) {
			instruction.deleteCharAt(instruction.indexOf(";"));
			ParseInstruction(instruction, gene_in_works, index);
		}
		//remove spaces
		else if(instruction.indexOf(" ")!=-1) {
			instruction.deleteCharAt(instruction.indexOf(" "));
			ParseInstruction(instruction, gene_in_works, index);
		}
		//parse the symbol of the gene
		else if(index==0) {
			gene_in_works.setSymbol(instruction.toString());
			System.out.print("symbol: ");
			System.out.println(instruction);
		}
		//parse the alleles of the gene
		else if(index==1) {
			gene_in_works.setAlleles(instruction.toString().split(","));
			System.out.print("alleles: ");
			System.out.println((instruction.toString().split(",")).length);
		}
		//parse the instruction/rules of the gene
		else {
			gene_in_works.addInteractions(instruction.toString());
			System.out.print("instructions: ");
			System.out.println(instruction);
		}
	}

}
