package kassid_rt13oop_tg_kal;


public class Test {

	//this is where i try out random shit so it wouldnt bug in main code
	
	
	public static void main(String[] args) {
		int hulk = 5;
		char[] kassiAhel1=new char[hulk];
		//char[] kassiAhel2=new char[5];
		
		for (char elem:kassiAhel1) {
			if (Math.random()<0.5) elem='l';
			System.out.println(elem);
		}
		int x=(int)(Math.round(Math.random()*1000)/10
				);
		String nimi=Integer.toString(x);
		System.out.println(nimi);

	}

}
