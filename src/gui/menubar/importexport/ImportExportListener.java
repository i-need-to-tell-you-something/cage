package gui.menubar.importexport;

import gui.CAGEFrame;
import gui.menubar.LocaleChangeListener;
import gui.menubar.Locales;
import gui.menubar.MenuLanguageListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import core.FilePaths;
import core.Kass;


/**
 * Managing exporting and importing cats for this program
 * 
 * @author K
 *
 */
public class ImportExportListener implements ActionListener,
		LocaleChangeListener {

	FileChooser importer;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Export")) {
			// We'll take all the currently selected cats
			for (Kass kiisu : CAGEFrame.getKassiList().getSelectedValuesList()) {
				try (ObjectOutputStream oos = new ObjectOutputStream(
						new FileOutputStream(new File(FilePaths.savePath+ kiisu.getNimi()
								+ ".cage")))) {
					// And save each of them to a homonymous file
					oos.writeObject(kiisu);
				} catch (IOException e1) {
					// TODO error_standardization
					System.out.println("kiisu salvestamiserind: "
							+ e1.getMessage());
				}
			}
		} else if (e.getActionCommand().equals("Import")) {
			importer = new FileChooser(FilePaths.savePath);
			importer.setFileFilter(new ImportExportFilter());

			// Listing that this component needs to fire whenever there's a
			// locale change
			MenuLanguageListener.addToDeclaredComponents(this);

			onLocaleChange();
			importer.setMultiSelectionEnabled(true);
			importer.setApproveButtonMnemonic(KeyEvent.VK_I);
			importer.addActionListener(new FileChooserListener());

			// A dialog window to put the importer into
			JDialog impaken = new JDialog();

			// Setting the default button of the Dialog window
			JPanel nupukas = (JPanel) ((JPanel) (JPanel) importer
					.getComponent(3)).getComponent(3);
			impaken.getRootPane().setDefaultButton(
					(JButton) nupukas.getComponent(0));

			impaken.add(importer);
			impaken.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			impaken.pack();
			impaken.setVisible(true);
		} else {
			// TODO Error standardisation
			System.out
					.println("This_shouldnt_happen_error: Not import nor Export");
		}
	}

	@Override
	public void onLocaleChange() {
		importer.setApproveButtonText(Locales.mainBundle.getString("button10"));
		importer.setApproveButtonToolTipText(Locales.tipBundle.getString("tt11"));
	}
}
