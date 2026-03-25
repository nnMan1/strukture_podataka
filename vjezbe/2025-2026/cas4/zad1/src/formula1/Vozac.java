package formula1;

import java.util.Arrays;

public class Vozac implements Comparable<Vozac> {
	String ime;
	int[] pobjede;
	int[] trening;
	
	public Vozac(String ime, int[] pobjede, int[] trening) {
		this.ime = ime;
		this.pobjede = Arrays.copyOf(pobjede, pobjede.length);
		this.trening = Arrays.copyOf(trening, trening.length);
	}
	
	public void setTrening(int i, int poz) {
		this.trening[i] = poz;
	}
	
	
	public void setPobjeda(int i, int br) {
		this.pobjede[i] = br;
	}
	
	public int brBodova() {
		int sum = 0;
		
		for(int br: pobjede)
			sum += br;
		
		return sum;
	}
	
	public int brPrvihPozicija() {
		int cnt = 0;
		
		for(int poz: trening) 
			if(poz == 1)
				cnt ++;
		
		return cnt;
	}
	
	@Override
	public int compareTo(Vozac o) {
		if(this.brBodova() < o.brBodova()) 
			return -1;
		if(this.brBodova() > o.brBodova())
			return 1;
		
		if(this.brPrvihPozicija() < o.brPrvihPozicija())
			return -1;
		if(this.brPrvihPozicija() > o.brPrvihPozicija())
			return 1;
		
		return this.ime.compareTo(o.ime);
	}
}
