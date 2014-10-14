package kassid_rt13oop_tg_kal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class d2Nupukuular implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String prikas = e.getActionCommand();
		switch (prikas) {
		case "Eemalda": demo2.Eemalda(); break;
		case "Lisa uus": demo2.Lisa(); break;
		case "Lisa uus geenidega": demo2.LisaG(); break;
		case "Rista": demo2.Rista(); break;
		case "Kuva omadusi": demo2.KuvaF(); break;
		case "Kuva geene": demo2.KuvaG(); break;
		//error:
		default: System.out.println("tundmatu käsk: " + e.getActionCommand()); break;
		}

	}

}