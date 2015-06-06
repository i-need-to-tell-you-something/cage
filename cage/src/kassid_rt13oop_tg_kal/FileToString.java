package kassid_rt13oop_tg_kal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileToString {
	static String loe(String failinimi) throws IOException,
			NullPointerException {
		BufferedReader reader = null;
		String tekst = "";

		try {
			String line = " ";
			reader = new BufferedReader(new FileReader(failinimi));
			while (line != null) {
				line = reader.readLine();
				if (line != null) {
					tekst += line + "\n";
				}
			}
			return tekst;

		} finally {
			reader.close();

		}
	}

}
