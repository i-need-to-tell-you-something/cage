package kassid_rt13oop_tg_kal;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.text.MessageFormat;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * @author K tegemist on meetodiga, mis kuvab kas genotüübi või fenotüübi ilusas
 *         aknakeses kui Kassiraam vastavate andmetega selle esile kutsub
 */
@SuppressWarnings("serial")
public class FGKonteiner extends JFrame {
	// konstandid
	static final int FENOTYPE = 0;
	static final int GENOTYPE = 1;

	public FGKonteiner(JTextField[] fenotekst, String kassinimi, int tyyp) {
		// selle akna omadused
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//lokaaditundlik tiitlisättimine
		MessageFormat formatter = new MessageFormat("");
	    formatter.setLocale(Main.currentLocale);
	    Object [] messageArguments = {kassinimi};
	    if (tyyp==FENOTYPE) {
	    	formatter.applyPattern(Main.mainbundle.getString("title6"));
	    }
	    else {
	    	formatter.applyPattern(Main.mainbundle.getString("title5"));
	    }
		this.setTitle(formatter.format(messageArguments));
		// põhikonteiner
		Container fenojumal = getContentPane();
		fenojumal.setLayout(new BorderLayout());

		// väike sildike
		// JLabel silt = new JLabel("Kassi " + kassinimi +
		// (tüüp==FENOTYPE?" fenotüüp":" genotüüp") + " on:");
		// fenojumal.add(silt, BorderLayout.NORTH);

		// loome ilusa kasti, kus fenotüübi ridu näidata
		Container fenotekstikast = new Container();
		fenojumal.add(fenotekstikast, BorderLayout.CENTER);
		fenotekstikast.setLayout(new GridLayout(10, 1));

		// fenotüübi tekstid saavad lisatud fenotüübi kastile
		for (int i = 0; i < fenotekst.length; i++) {
			fenotekstikast.add(fenotekst[i], i);
		}
	}

	// Getterid ja setterid
	public static int getFenotype() {
		return FENOTYPE;
	}

	public static int getGenotype() {
		return GENOTYPE;
	}
}
