package kassid_rt13oop_tg_kal;
import java.util.Scanner;

public class kaivitaMind {


	private static Scanner kuul;

	public static void main(String[] args) {
		kuul = new Scanner(System.in);
		System.out.println("Oled meie kasside geneetika mudeli alpha �nnelik omanik");
		System.out.println("Tasuta versioonis saad genereerida 1 (�he) kassi");
		System.out.println("Sisest oma kassi genot��p 20 numbrit �kshaaval kahes ahelas");
		int len=10;
		
		//kassi esimene ahel
		int[] ahel1=new int[len];
		System.out.println("Sisesta esimese ahela numbreid");
		for (int i=0;i<len;i++) {
			System.out.print("Sisesta j�rgmine number ");
			switch (i) {
			case 1: System.out.println("(0 v�i 1 v�i 3): "); break;
			case 2: System.out.println("(0 v�i 1 v�i 3 v�i 7): "); break;
			default: System.out.println("(0 v�i 1): "); break;
			}
			ahel1[i]=kuul.nextInt();
		}
		
		//kassi teine ahel
		int[] ahel2=new int[len];
		System.out.println("Sisesta teise ahela numbreid");
		for (int i=0;i<len;i++) {
			System.out.println("Sisesta j�rgmine number ");
			switch (i) {
			case 1: System.out.print("(0 v�i 1 v�i 3)"); break;
			case 2: System.out.print("(0 v�i 1 v�i 3 v�i 7)"); break;
			default: System.out.print("(0 v�i 1)"); break;
			}
			ahel2[i]=kuul.nextInt();
		}
		
		Kass m�u = new Kass(ahel1,ahel2); //kasside m�u, n�u, meow ja nya genereerimine
		
		System.out.println("m�u: \n"+m�u); //Kuvab meow genot��pi ja fenot��pi
		for (int j=0; j<len;j++) { //Kuvab m�u fenot��bi kirjelduse
			System.out.println(Fenotyyp.valjasta(m�u.getFenotahel(),j));
		}
	}

}