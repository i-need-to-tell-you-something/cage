package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author k
 *  
 * Unimplemented. This class will handle keyboard input to the main frame
 */
public class CAGEFrameKeyListener implements KeyListener {
	// TODO UNIMPLEMENTED
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyChar());
		System.out.println("brb");

	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("brbr");

	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println(e.getKeyChar());
		System.out.println("brb2");

	}

}
