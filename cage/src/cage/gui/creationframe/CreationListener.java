package cage.gui.creationframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import cage.core.Kass;
import cage.gui.CAGEFrame;

/**
 * Firstly deals with creating a cat with or without a name and secondly writes
 * or deletes deftext according to needs
 * 
 */
public class CreationListener implements ActionListener, FocusListener {
	public CreationListener() {
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int[] kassiahel1 = CreationFrameOfSelection
				.genoString2int(CreationFrameOfSelection.ahela1geno());
		int[] kassiahel2 = CreationFrameOfSelection
				.genoString2int(CreationFrameOfSelection.ahela2geno());
		Kass uuskass;
		if (CreationFrameOfConfirmation.kassinimi.getText().equals(
				CreationFrameOfConfirmation.deftext)) {
			uuskass = new Kass(kassiahel1, kassiahel2);
		} else {
			uuskass = new Kass(kassiahel1, kassiahel2,
					CreationFrameOfConfirmation.kassinimi.getText());
		}
		CAGEFrame.addKass(uuskass);
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		if (CreationFrameOfConfirmation.kassinimi.getText().equals(
				CreationFrameOfConfirmation.deftext)) {
			CreationFrameOfConfirmation.kassinimi.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		if (CreationFrameOfConfirmation.kassinimi.getText().equals("")) {
			CreationFrameOfConfirmation.kassinimi
					.setText(CreationFrameOfConfirmation.deftext);
		}

	}

}
