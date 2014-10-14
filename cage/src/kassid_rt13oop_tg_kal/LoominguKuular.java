package kassid_rt13oop_tg_kal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class LoominguKuular implements ActionListener, FocusListener {
	public LoominguKuular() {
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int[] kassiahel1 = KassiNupuKonteiner.genoString2int(KassiNupuKonteiner
				.ahela1geno());
		int[] kassiahel2 = KassiNupuKonteiner.genoString2int(KassiNupuKonteiner
				.ahela2geno());
		Kass uuskass;
		if (LoomisKonteiner.kassinimi.getText().equals(LoomisKonteiner.deftekst)) {
			uuskass = new Kass(kassiahel1, kassiahel2);
		} else {
			uuskass = new Kass(kassiahel1, kassiahel2, LoomisKonteiner.kassinimi.getText());
		}
		Kassiraam.kassid.addElement(uuskass);
//		System.out.println("LoominguKuulari katse lisada kassi: " + uuskass);
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		if (LoomisKonteiner.kassinimi.getText()
				.equals(LoomisKonteiner.deftekst)) {
			LoomisKonteiner.kassinimi.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		if (LoomisKonteiner.kassinimi.getText().equals("")) {
			LoomisKonteiner.kassinimi.setText(LoomisKonteiner.deftekst);
		}

	}

}
