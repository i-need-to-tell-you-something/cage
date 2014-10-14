package kassid_rt13oop_tg_kal;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NimetamisKuular implements ActionListener {

	private Kass kass;

	public NimetamisKuular(Kass k) {
		this.kass = k;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//nimetamiskonteiner tüüpi aken kus event toimus
		NimetamisKonteiner aken = (NimetamisKonteiner)((Component)e.getSource()).getParent().getParent().getParent().getParent();

		//muudame nime ära selleks mis on kastis
		kass.setNimi(aken.lahter.getText());
		Kassiraam.kassilist.repaint();
		aken.dispose();
	}
}
