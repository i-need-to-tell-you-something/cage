package gui;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import core.Kass;


/**
 * This class determines which buttons are available based on the number of cats
 * selected (int s)
 * 
 * @author K
 */
public class CAGEFrameListListener implements ListSelectionListener {

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
				CAGEFrame.n1.setEnabled(false); // Kuva omadusi
				CAGEFrame.n2.setEnabled(false); // Kuva geene
				CAGEFrame.n3.setEnabled(false); // Kuva pilt
				// n4 on alati enabled
				// n5 on alati enabled
				CAGEFrame.n6.setEnabled(false); // Rista
				CAGEFrame.n7.setEnabled(false); // Muuda nime
				CAGEFrame.n8.setEnabled(false); // Eemalda
				break;
			case 1:
				CAGEFrame.n1.setEnabled(true);
				CAGEFrame.n2.setEnabled(true);
				CAGEFrame.n3.setEnabled(true);
				CAGEFrame.n6.setEnabled(false);
				CAGEFrame.n7.setEnabled(true);
				CAGEFrame.n8.setEnabled(true);
				break;
			// paarita n[6] on võimalik ainult siis kui on valitud kaks eri
			// soost kassi
			case 2:
				CAGEFrame.n1.setEnabled(true);
				CAGEFrame.n2.setEnabled(true);
				CAGEFrame.n3.setEnabled(true);
				CAGEFrame.n6
						.setEnabled(((Kass) ((JList) e.getSource())
								.getSelectedValuesList().get(0)).getFenotahel()[9]
								+ ((Kass) ((JList) e.getSource())
										.getSelectedValuesList().get(1))
										.getFenotahel()[9] == 1);
				CAGEFrame.n7.setEnabled(true);
				CAGEFrame.n8.setEnabled(true);
				break;
			default:
				CAGEFrame.n1.setEnabled(true);
				CAGEFrame.n2.setEnabled(true);
				CAGEFrame.n3.setEnabled(true);
				CAGEFrame.n6.setEnabled(false);
				CAGEFrame.n7.setEnabled(true);
				CAGEFrame.n8.setEnabled(true);
				break;
			}
		}
	}
}
