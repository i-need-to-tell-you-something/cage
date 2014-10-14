package kassid_rt13oop_tg_kal;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestPilt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame raam=new JFrame();
//		JPanel paneel=new JPanel();
		raam.setVisible(true);
		raam.setSize(400, 400);
	
		ImageIcon image = new ImageIcon("data/gfx/image.JPG");
		JLabel imageLabel = new JLabel(image);
		raam.add(imageLabel);
		
		ImageIcon oun = new ImageIcon("data/gfx/oun.png");
		raam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel ounLabel = new JLabel(oun);
		raam.add(ounLabel);
//		Image image2 = new Image("image.JPG");
		
//		JFrame.setIconImage(image);
		// TODO Auto-generated method stub

	}

}
