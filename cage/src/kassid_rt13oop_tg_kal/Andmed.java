package kassid_rt13oop_tg_kal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Andmed {

	@SuppressWarnings("finally")
	static int[][] loeboonust(String failinimi) throws IOException {
		BufferedReader reader = null;
		int[][] tabel = new int[10][];
		try {
			reader = new BufferedReader(new FileReader(failinimi));
			int reaarv = 0;
			String line = "";// while tsükli tegemiseks panen line'le väärtuse
			while (line != "STOP" && line != null) {
				line = reader.readLine();

				// System.out.println(line); //Kontroll, et mida failist loeb

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

				} finally {
				}
				;

				// Lisan loodud järjendi tabelisse
				tabel[reaarv] = reaintjarjend;
				for (int i = 0; i < boonusvaljapikkus; i++) {
					tabel[reaarv][i] = reaintjarjend[i];
				}
				reaarv++;
			}

		} catch (IOException e) {
			System.out.println("boonuse io feil");
		} finally {
			reader.close();
			return tabel;
		}
	}

	@SuppressWarnings("finally")
	public static int[][] boonustabel() {
		int[][] boonustabel = null;
		try {
			boonustabel = loeboonust("data/lookusboonus.txt");
		} catch (IOException ex) {
			System.out.println("jou. IO is a ... in boonustabel");
		} finally {
			return boonustabel;
		}
	}

	public static int[][] tabel = boonustabel();

	// Kassinimede failis lugemise meetod
	@SuppressWarnings("finally")
	// selle rea pidi panema et hüüumärki poleks kollasel taustal
	static String[] loe(String failinimi) throws IOException {
		// See blokk loeb failis ridade arvu
		BufferedReader reader = null;
		int ridadearv = 0;
		try {
			reader = new BufferedReader(new FileReader(failinimi));
			while (true) {
				String line = reader.readLine();
				if (line != null) {
					ridadearv++;
				} else {
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("IO exception");
		} finally {
			reader.close();
		}
		reader = null;
		// Ridade arvu järgi loob sõnede järjendi kassinimedele
		String[] kassinimed = new String[ridadearv];
		// Täidan kassinimede järjendi kassinimedega failist
		try {
			reader = new BufferedReader(new FileReader(failinimi));
			for (int i = 0; i < ridadearv; i++) {
				String line = reader.readLine();
				if (line != null) {
					kassinimed[i] = line;
				} else {
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("IO exception");
		} finally {
			reader.close();
			return kassinimed;
		}
	}

	// Meetod mis kasutab failist lugemise meetodi ja väljutab kassinimede
	// järjendi
	@SuppressWarnings("finally")
	public static String[] kassinimed() {
		String[] kassinimed = null;
		try {
			kassinimed = loe("data/nimed.txt");
		} catch (IOException ex) {
			System.out.println("jou. IO is a ...");
		} finally {
			return kassinimed;
		}
	}

	// Kassinimede väli kasutades eelnevat meetodit
	public static String[] kassinimed = kassinimed();

	// // väli kasside nimede jaoks
	// // eelmise välja väärtuste hulga loenduri andmed
	public static int[] nimedehulk = new int[kassinimed.length];

	// Getterid ja setterid
	public static int getNimehulk(int indeks) {
		return nimedehulk[indeks];
	}

	public static void growNimehulk(int indeks) {
		nimedehulk[indeks]++;
	}

	public static int[][] getTabel() {
		return tabel;
	}

	public static void setTabel(int[][] tabel) {
		Andmed.tabel = tabel;
	}

	public static String[] getKassinimed() {
		return kassinimed;
	}

	public static void setKassinimed(String[] kassinimed) {
		Andmed.kassinimed = kassinimed;
	}

	public static int[] getNimedehulk() {
		return nimedehulk;
	}

	public static void setNimedehulk(int[] nimedehulk) {
		Andmed.nimedehulk = nimedehulk;
	}

}
