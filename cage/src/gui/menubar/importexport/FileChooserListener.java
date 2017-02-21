package gui.menubar.importexport;

import gui.CAGEFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JDialog;
import javax.swing.JFileChooser;

import core.Kass;


public class FileChooserListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		//kõige välisem JDialog - see, mille lõpuks sulgeda tahame
		JDialog jd = ((JDialog)((JFileChooser)e.getSource()).getParent().getParent().getParent().getParent());
		//kui vajutad "impordi"
	    if (e.getActionCommand()=="ApproveSelection") {
	    	//võtame kõik JFileChooseris valitud failid
	    	File[] imporditavad = ((JFileChooser)e.getSource()).getSelectedFiles();
	    	//ja teeme neist igaühega:
	    	for (File elem : imporditavad) {
	    		//loeme nad sisse ja paneme DefaultListModelisse "kassid"
	    		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(elem)) ) {
	    			CAGEFrame.addKass((Kass)ois.readObject());
	    			//TODO error standardization
	    		} catch (IOException e1) {
					System.out.println("S/V erind: " + e1);
				} catch (ClassNotFoundException e1) {
					System.out.println("KlassiEiLeita erind: " + e1);
				}
	    		//sulgeme kõik
	    		finally {
	    			jd.dispose();
	    		}
	    	}
	    	
	    }
	    //kui vajutad "cancel"
	    if (e.getActionCommand()=="CancelSelection") {
	    	//sulgeme kõik
	    	jd.dispose();
	    }
	}

}
