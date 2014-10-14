package kassid_rt13oop_tg_kal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

public class MigratsiooniKuular implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// ekspordi osa
		if (((JMenuItem) e.getSource()).getText() == "Ekspordi kasse") {
			// valime kõik parajasti valitud kassid
			for (Kass kiisu : Kassiraam.kassilist.getSelectedValuesList()) {
				try (ObjectOutputStream oos = new ObjectOutputStream(
						new FileOutputStream(new File("save/" + kiisu.getNimi() + ".cage")))) {
					// ja salvestame igaühe neist omanimelisse faili
					oos.writeObject(kiisu);
				} catch (IOException e1) {
					System.out.println("kiisu salvestamiserind: "
							+ e1.getMessage());
				}
			}
			// impordi osa
		} else {
			JFileChooser imp = new JFileChooser("save/");

			// CODECEPTION - kood koodi sees. defineerime faili valimise filtri
			imp.setFileFilter(new FileFilter() {
				// faili valiku lingvistiline kirjeldus
				@Override
				public String getDescription() {
					return "CAGE save files";
				}

				// faili valiku loogiline kirjeldus
				@Override
				public boolean accept(File fail) {
					String s6ne = fail.getName();
					int indeks = s6ne.lastIndexOf('.');
					//peab olema kas .cage lõpuga v kaust
					if (indeks > 0
							&& indeks < s6ne.length() - 1
							&& s6ne.substring(indeks).toLowerCase()
									.equals(".cage") || fail.isDirectory()) {
						return true;
					} else {
						return false;
					}
				}
			});

			//impordi aknakese conf
			imp.setMultiSelectionEnabled(true);
			imp.setApproveButtonText("Impordi");
			imp.setApproveButtonToolTipText("Impordi valitud kassid kassilisti");
			imp.setApproveButtonMnemonic(KeyEvent.VK_I);
			
			//impaknakese raamike
			JDialog impaken = new JDialog();
			impaken.add(imp);
			//nupupaneeli salvestame ära
			JPanel nupukas = (JPanel) ( (JPanel)  (JPanel)imp.getComponent(3) ).getComponent(3);
			
			impaken.getRootPane().setDefaultButton((JButton)nupukas.getComponent(0));
			//kuular JFileChooserile
			imp.addActionListener(new FailiValijaKuular());
			
			impaken.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			impaken.pack();
			impaken.setVisible(true);
		}
	}

}
