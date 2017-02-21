package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads 2 files and uses the obtained data 
 *
 */
public class DataReader {

	/**
	 * This method checks that the line isn't null and doesn't start with double slash (comment)  
	 * @param line The line to be checked
	 *
	 */
	public static boolean isValidLine(String line) {
		if (line == null) {
			return false;
		}
		else if (line.charAt(0)=='/'&& line.charAt(1)=='/') {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	/* This method reads information about:
	the number of alleles in a locus
	the likelihood of each allele being in a cat
	which alleles get carried on together
	*/
	@SuppressWarnings("finally")
	static int[][] readBonus(String fileName) throws IOException {
		BufferedReader reader = null;
		int[][] table = new int[10][];
		try {
			reader = new BufferedReader(new FileReader(fileName));
			int reaarv = 0;
			String line = "";// while tsükli tegemiseks panen line'le väärtuse
			while (isValidLine(line)) {
				line = reader.readLine();

				// Võtan reast vaid selle osa, mis meid huvitav ( {} märkide
				// vahelise osa)
				int algus = line.indexOf("{") + 1;
				int lopp = line.indexOf("}") - 1;
				String rida = "";
				for (int i = 0; i < lopp - algus; i++) {
					rida = rida + line.charAt(i + algus);
				}

				// Vaatab kui pika boonusväljaga antud lookus(rida) on
				int boonusvaljapikkus = 0;
				for (int i = 0; i < rida.length(); i++) {
					if (rida.charAt(i) == (',')) {
						boonusvaljapikkus++;
					}

				}
				// Kuna komasid on üks vähem kui neid ümbritsevad välju, siis
				// tuleb üks juurde lisada bonusväljade summale
				boonusvaljapikkus++;

				// Muudan rea järjendiks
				String[] reajarjend = rida.split(",");
				// Puhastan tühikutest
				for (int i = 0; i < reajarjend.length; i++) {
					reajarjend[i] = reajarjend[i].trim();
				}

				// Stringi järjendist int järjendi tegemine
				int[] reaintjarjend = new int[reajarjend.length];
				try {
					for (int i = 0; i < reajarjend.length; i++) {
						reaintjarjend[i] = Integer.parseInt(reajarjend[i]);
					}
				} catch (NumberFormatException nfe) {
					//TODO error_standardization

				} finally {
				}
				;

				// Lisan loodud järjendi tabelisse
				table[reaarv] = reaintjarjend;
				for (int i = 0; i < boonusvaljapikkus; i++) {
					table[reaarv][i] = reaintjarjend[i];
				}
				reaarv++;
			}

		} catch (IOException e) {
			//TODO error_standardization
			System.out.println("boonuse io feil");
		} finally {
			reader.close();
			return table;
		}
	}

	@SuppressWarnings("finally")
	private static int[][] initializeLocusBonusTable() {
		int[][] boonustabel = null;
		try {
			boonustabel = readBonus("data/locusbonus.txt");
		} catch (IOException ex) {
			//TODO error_standardization
			System.out.println("jou. IO is a ... in boonustabel");
		} finally {
			return boonustabel;
		}
	}


	// This method reads lines in a file into a String array
	// Added this suppression so that the yellow triangle would disappear in Eclipse
	@SuppressWarnings("finally")
	private static String[] readLinesToStringArray(String fileName) throws IOException {
		// Need to count the amount of lines for initializing String array
		BufferedReader reader = null;
		int numberOfLines = 0;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			while (true) {
				String line = reader.readLine();
				if (line != null) {
					numberOfLines++;
				} else {
					break;
				}
			}
		} catch (IOException e) {
			//TODO error_standardization
			System.out.println("IO exception");
		} finally {
			reader.close();
		}
		reader = null;
		// Initializing array
		String[] stringArray = new String[numberOfLines];
		// Filling array with lines
		try {
			reader = new BufferedReader(new FileReader(fileName));
			for (int i = 0; i < numberOfLines; i++) {
				String line = reader.readLine();
				if (line != null) {
					stringArray[i] = line;
				} else {
					break;
				}
			}
		} catch (IOException e) {
			//TODO error_standardization
			System.out.println("IO exception");
		} finally {
			reader.close();
			return stringArray;
		}
	}

	// Method to initialize String array of cat names
	@SuppressWarnings("finally")
	private static String[] initializeCatNames() {
		String[] catNames = null;
		try {
			catNames = readLinesToStringArray("data/names.txt");
		} catch (IOException ex) {
			//TODO error_standardization
			System.out.println("jou. IO is a ...");
		} finally {
			return catNames;
		}
	}

	// Cat name field using the preceding method
	private static String[] catNames = initializeCatNames();

	// Field for locus bonus table
	private static int[][] locusBonusTable = initializeLocusBonusTable();
	
	// Field for tracking how many cats there are with a specific name
	private static int[] amountOfNames = new int[catNames.length];

	// Getters and setters
	public static int getAmountOfNames(int index) {
		return amountOfNames[index];
	}

	public static void growAmountOfNames(int index) {
		amountOfNames[index]++;
	}

	public static int[][] getLocusBonusTable() {
		return locusBonusTable;
	}

	public static String[] getCatNames() {
		return catNames;
	}

}
