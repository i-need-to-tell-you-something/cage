package gui.menubar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class is used to read text files line by line into a String format (for
 * example in the classes {@link ConspectListener1} and
 * {@link HelpAboutListener})
 *
 */
public class FileToString {
	public static String process(String failinimi) throws IOException,
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
