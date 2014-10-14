package kassid_rt13oop_tg_kal;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class KassiRaamiListikuular implements ListSelectionListener {

	@SuppressWarnings("rawtypes")
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {
			// vaatab mitu kassi JListist on valitud
			int s = ((JList) e.getSource()).getSelectedValuesList().size();
			// Kuva omadusi, Kuva geene, Eemalda, Rista
			switch (s) {
			// kui kassi valitud ei ole siis uurimise all olevad neli käsku ei
			// ole kasutatavad
			case 0:
				Kassiraam.n1.setEnabled(false); //Kuva omadusi
				Kassiraam.n2.setEnabled(false); //Kuva geene
				Kassiraam.n3.setEnabled(false); //Kuva pilt
				// n4 on alati enabled
				// n5 on alati enabled
				Kassiraam.n6.setEnabled(false); //Rista
				Kassiraam.n7.setEnabled(false); //Muuda nime
				Kassiraam.n8.setEnabled(false); //Eemalda
				break;
			case 1:
				Kassiraam.n1.setEnabled(true);
				Kassiraam.n2.setEnabled(true);
				Kassiraam.n3.setEnabled(true);
				Kassiraam.n6.setEnabled(false);
				Kassiraam.n7.setEnabled(true); 
				Kassiraam.n8.setEnabled(true);
				break;
			// paarita n[6] on võimalik ainult siis kui on valitud kaks eri
			// soost kassi
			case 2:
				Kassiraam.n1.setEnabled(true);
				Kassiraam.n2.setEnabled(true);
				Kassiraam.n3.setEnabled(true);
				Kassiraam.n6.setEnabled(((Kass) ((JList) e.getSource()).getSelectedValuesList()
						.get(0)).getFenotahel()[9]
						+ ((Kass) ((JList) e.getSource())
								.getSelectedValuesList().get(1)).getFenotahel()[9] == 1);
				Kassiraam.n7.setEnabled(true); 
				Kassiraam.n8.setEnabled(true);
				break;
			default:
				Kassiraam.n1.setEnabled(true);
				Kassiraam.n2.setEnabled(true);
				Kassiraam.n3.setEnabled(true);
				Kassiraam.n6.setEnabled(false);
				Kassiraam.n7.setEnabled(true); 
				Kassiraam.n8.setEnabled(true);
				break;
			}
		}
	}
}
