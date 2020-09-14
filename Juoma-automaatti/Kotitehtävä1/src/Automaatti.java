import java.util.Scanner;

public class Automaatti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Kopio objektista 
		JuomaAutomaatti a = new JuomaAutomaatti();
		
		Scanner lukija = new Scanner(System.in);
		
		int valinta = 0;
		
		while (valinta != 4) {
			
		boolean rohkea = a.onnistuuko();	
			
		System.out.println("****************************");
		System.out.println("*  Juoma-Automaatti        *");
		System.out.println("*                          *");
		System.out.println("* 1. Kahvi                 *");
		System.out.println("* 2. Tee                   *");
		System.out.println("* 3. Kaakao                *");
		System.out.println("* 4. Lopeta                *");
		System.out.println("*                          *");
		System.out.println("****************************");
		
		System.out.println("Mitä haluat tehdä?");
		valinta = lukija.nextInt();
		
		if (rohkea == false) {
		switch(valinta) {
		 case 1:
			 a.valmistaKahvi();
			 break;
		 case 2:
			 a.valmistaTee();
			 break;
		 case 3:
			 a.valmistaKaakao();
			 break;
		 case 4:
			 System.out.println("Kiitos käynnistä ja tervetuloa uudestaan!");
			 break;
		default:
			System.out.println("Virheellinen valinta.");
			break;
		}
		}
		else {
			System.out.println("Ei onnistu. Kiitos kuitenkin maksustasi.");
		}
		}
	}

}
