package gui.creationframe;

import gui.CAGEFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import core.Kass;


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
		if (CreationFrameOfConfirmation.getCatName().equals(
				CreationFrameOfConfirmation.getDeftext())) {
			uuskass = new Kass(kassiahel1, kassiahel2);
		} else {
			uuskass = new Kass(kassiahel1, kassiahel2,
					CreationFrameOfConfirmation.getCatName());
		}
		CAGEFrame.addKass(uuskass);
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		if (CreationFrameOfConfirmation.getCatName().equals(
				CreationFrameOfConfirmation.getDeftext())) {
			CreationFrameOfConfirmation.setCatName("");
		}
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		if (CreationFrameOfConfirmation.getCatName().equals("")) {
			CreationFrameOfConfirmation.setCatName(CreationFrameOfConfirmation.getDeftext());
		}

	}

}
