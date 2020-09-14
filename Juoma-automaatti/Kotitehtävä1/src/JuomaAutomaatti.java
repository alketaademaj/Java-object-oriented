public class JuomaAutomaatti {
	private int tee;
	private int kahvi;
	private int kaakao;
	
	//Konstruktori
	public JuomaAutomaatti(int tee, int kahvi, int kaakao) {
		super();
		this.tee = tee;
		this.kahvi = kahvi;
		this.kaakao = kaakao;
	}
	
	//Konstruktori
	public JuomaAutomaatti() {
		super();
		this.tee = 50;
		this.kahvi = 50;
		this.kaakao = 50;
	}
	
	public void valmistaTee() {
		if (getTee() < 10) {
		System.out.println("Tee loppu.");
		}
		else {
			this.tee -=10;
			System.out.println("Odota hetki, teesi valmistuu! Teetä jäljellä " + getTee() + " yksikköä.");
		}
	}

	public void valmistaKahvi() {
		if (getKahvi() < 10) {
		System.out.println("Kahvi loppu.");
	}
		else {
			this.kahvi -=10;
			System.out.println("Odota hetki, kahvisi valmistuu! Kahvia jäljellä " + getKahvi() + " yksikköä.");
		}
	}
		
	public void valmistaKaakao() {
		if (getKaakao() < 10) {
		System.out.println("Kaakao loppu.");
		}
		else {
			this.kaakao -=10;
			System.out.println("Oodota hetki, kaakaosi valmistuu! Kaakaota jäljellä " + getKaakao() + " yksikköä.");
		}
	}
	
	public int getTee() {
		return tee;
	}
	public void setTee(int tee) {
		this.tee = tee;
	}
	public int getKahvi() {
		return kahvi;
	}
	public void setKahvi(int kahvi) {
		this.kahvi = kahvi;
	}
	public int getKaakao() {
		return kaakao;
	}
	public void setKaakao(int kaakao) {
		this.kaakao = kaakao;
	}
	
	public boolean onnistuuko() {
		int toimivuus = (int)(Math.random() * 100+1);
		
		if (toimivuus <25) {
			return true;
		}
		
		else {
			return false;
		}	
	}
	
	@Override
	public String toString() {
		return "JuomaAutomaatti [tee=" + tee + ", kahvi=" + kahvi + ", kaakao=" + kaakao + "]";
	}
}
