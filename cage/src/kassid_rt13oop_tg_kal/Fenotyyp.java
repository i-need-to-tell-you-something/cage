package kassid_rt13oop_tg_kal;


public class Fenotyyp {
    int[] fenotype;
   
    public static int[] genereeri(int[] ahel1, int [] ahel2){
        int x=ahel1.length;
        int[] fenotype= new int[x];
        for (int i=0;i<x;i++){
            fenotype[i]=(ahel1[i]+ahel2[i]);
            }
        return fenotype;
    }
    
    //ABCDLOSTWX
    //0123456789
    public static String valjasta(int [] ahel, int lookus) {
        String x="";
        
        switch (lookus) {
        
        case 0: {//A lookus. Akuutsus dominantne. Dominantne epistaas B lookus üle. Retsessiivne epistaas T lookuse üle
        	switch (ahel[lookus]) {
        	case 0: x="Akuutvärv puudub"; break;
        	case 1: case 2: x="Akuutvärvi triibuline"; break;
        	default: x="viga A lookuses"; break;
        	}break;
        }
        
        case 1: {//B lookus.
        	switch (ahel[lookus]) {
        	case 6: x="Roostepruun"; break;        	
        	
        	case 0: case 3: x="Shokolaadipruun"; break;
        	        	
        	case 1: case 2: case 4: x="Must"; break;
        	
        	
        	default: x="viga B lookuses"; break;
        	}break;
        }
        
        case 2: {//C lookus
        	switch (ahel[lookus]) {
        	case 0: x="Albiino"; break;
        	
        	case 1: case 2: case 4: case 8: x="Normaalne karva värvumine"; break;            	
        	
        	case 6: x="Birma  kass"; break; //soojemates kohtades heledate laikudega (kõht, lõuaalune)
        	case 3: x="Heledama tooniga Birma kass"; break;
        	
        	case 14: x="Siiami kass"; break; //kere on hele, kõrvad, nägu, saba, käpad tumedad. Silmad intensiivsinised.
        	case 7: x="Heledama tooniga Siiami kass"; break;
        	
        	case 10: x="Siiami ja Birma kassi vahepealne kass"; break; 
        	        	
        	default: x="viga"; break;
        	
        	}break;
        	}
        
        case 3: {//D lookus
            switch (ahel[lookus]) {
            case 1: case 2: x="Lahjenemata, normaalselt värvunud"; break;
            case 0: x="Kreemjas (lahjendunud oranž) kass"; break;
//            {            
//                switch (ahel [5]) {
//                case 1: case 2: x="kreemjas (lahjendunud oranž) kass";break;
//                case 0 : {          
//                        switch (ahel[1]) {
//                        case 6: x="Kollakaspruun kass"; break;                   
//                        case 0: case 3: x="Sirelililla kass"; break;                           
//                        case 1: case 2: case 4: x="Sinakashall kass"; break;
//                        }
//                }break;
//                }
//            }
            default: x="viga"; break;    
            }break;
        }
        
        case 4: {//L lookus
        	switch (ahel[lookus]) {
        	case 0: x="Pikakarvaline"; break;
        	case 1: case 2: x="Lühikarvaline"; break;
        	default: x="viga"; break;
        	}break;
        }
        
        case 5: {//O lookus. suguliiteline (hiljem vaatab kas kuidas muudab)
        	switch (ahel[lookus]) {
        	case 0: x="Pole oranž"; break;
        	case 1: x="Kilpkonnamustriga"; break;
        	case 2: x="Oranž kass"; break;
        	default: x="viga"; break;
        	}break;
        }
        
        case 6: {//S lookus. Laigud dominantsed. Semidominantsus
        	switch (ahel[lookus]) {
        	case 0: x="Pole valgeid laike"; break;
        	case 1: x="Alla 50% kehast valgelaiguline"; break;
        	case 2: x="üle 50% kehast valgelaiguline";break;
        	default: x="viga"; break;
        	}break;
        }
        
        case 7: {//T lookus
        	switch (ahel[lookus]) {
        	case 6: x="Laienenud vöödid"; break;
        	case 2: case 4: x="Tiigertüüpi vöödid"; break; //TT;Ttb
        	case 0: x="Ainult näos ja käppadel on peened triibud"; break; //TaTa
        	case 1: case 3: x="Vööte on käppadel, sabal ja näos. Osa keha pinnast on ka triibuline"; break; //TaT;Tatb
        	default: x="viga"; break;
        	}break;
        }
        
        case 8: {//W lookus. Valge dominantne. Dominantsus. Dominantne epistaas A,B,D,O,S,T üle
        	switch (ahel[lookus]) {
        	case 0: x="Normaalset värvunud (pole valge)"; break;
        	case 1: case 2: x="üleni valge kass (mittealbiino)"; break;
        	default: x="viga"; break;
        	}break;
        }
        
        case 9: {//sugukromosoomid
        	switch (ahel[lookus]) {
        	case 0: x="Emane"; break;
        	case 1: x="Isane"; break;
        	default: x="viga"; break;
        	}break;
        }
        
        
        default: x="tundmatu lookus";	
        }
        
        
        
        //lookuste esialge väärtustamine lõppenud,
        //nüüd hakkab erijuhtude kontroll:
        
        if (ahel[0]!=0 && lookus==1) x="B lookus ei avaldu(A)"; //Kontrollib kas kass on hoopis akuutvärvi

        if ((ahel[0]==0 && ahel[5]==0) && lookus==7) x="T lookus ei avaldu(puudub O ja A)";
        
        if (lookus==3 && ahel[5]==0 )  {          
        	switch (ahel[1]) {
        	case 6: x="Kollakaspruun kass"; break;                   
        	case 0: case 3: x="Sirelililla kass"; break;                           
        	case 1: case 2: case 4: x="Sinakashall kass"; break;
        	}
        }
        
        if (ahel[5]==2) {//Kontrollib kas kass on oranž
        	switch (lookus) {
        	case 1: x="B lookus ei avaldu(O)";break;
        	case 0: x="A lookus ei avaldu(O)";break;
        	}
        }
           
        if (ahel[8]!=0) { //Kontrollib kas kass on hoopis valge
        	switch (lookus) {
        	case 0: x="A lookus ei avaldu(W)"; break;
        	case 1: x="B lookus ei avaldu(W)"; break;
        	case 3: x="D lookus ei avaldu(W)"; break;
        	case 5: x="O lookus ei avaldu(W)"; break;
        	case 6: x="S lookus ei avaldu(W)"; break;
        	case 7: x="T lookus ei avaldu(W)"; break;
        	}
        }
        
        if ((ahel[2]!=1 && ahel[2]!=2 && ahel[2]!=4 && ahel[2]!=8)) { //Kontrollib kas kass on üldse värvunud
        	switch (lookus) {
        	case 0: x="A lookus ei avaldu(C)"; break;
        	case 1: x="B lookus ei avaldu(C)"; break;
        	case 3: x="D lookus ei avaldu(C)"; break;
        	case 5: x="O lookus ei avaldu(C)"; break;
        	case 6: x="S lookus ei avaldu(C)"; break;
        	case 7: x="T lookus ei avaldu(C)"; break;
        	case 8: x="W lookus ei avaldu(C)"; break;
        	
        	}
        }
        
        return x;
        }

    }