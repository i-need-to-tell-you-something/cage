package kassid_rt13oop_tg_kal;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class d2Listikuular implements ListSelectionListener {

	@SuppressWarnings("rawtypes")
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {
			// vaatab mitu kassi JListist on valitud
			int s = ((JList) e.getSource()).getSelectedValuesList().size();
			// muutuja demo2nuppude on vajutatavuse hoidmiseks
			// Kuva omadusi, Kuva geene, Kuva pilt, Rista, Eemalda
			boolean[] n = new boolean[5];
			switch (s) {

			// 	kui kassi valitud ei ole siis uurimise all olevad viis käsku ei
			// 	ole kasutatavad
			case 0: {
				n[0] = false;
				n[1] = false;
				n[2] = false;
				n[3] = false;
				n[4] = false;
				break;
			}
			case 1: {
				n[0] = true;
				n[1] = true;
				n[2] = true;
				n[3] = false;
				n[4] = true;
				break;
			}
			// paarita n[3] on võimalik ainult siis kui on valitud kaks eri
			// soost kassi
			case 2: {
				n[0] = true;
				n[1] = true;
				n[2] = false;
				n[3] = (((Kass) ((JList) e.getSource()).getSelectedValuesList()
						.get(0)).getFenotahel()[9]
								+ ((Kass) ((JList) e.getSource())
										.getSelectedValuesList().get(1)).getFenotahel()[9] == 1);
				n[4] = true;
				break;
			}
			default: {
				n[0] = true;
				n[1] = true;
				n[2] = false;
				n[3] = false;
				n[4] = true;
				break;
			}
			}
			demo2.regnuppe(n);
		}

	}

}
