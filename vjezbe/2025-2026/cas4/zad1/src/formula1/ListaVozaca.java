package formula1;

import java.util.Comparator;
import java.util.LinkedList;

public class ListaVozaca {
	LinkedList<Vozac> vozaci;
	
	public ListaVozaca() {
		this.vozaci = new LinkedList<Vozac>();
	}
	
	public void dodaj(Vozac v) {
		vozaci.add(v);
		vozaci.sort(new Comparator<Vozac>() {

			@Override
			public int compare(Vozac o1, Vozac o2) {
				return -o1.compareTo(o2);
			}
			
		});
	}
	
	public void brisi(String ime) {
		int i=0;
		for(Vozac v:vozaci) {
			if(ime.compareTo(v.ime) == 0) {
				vozaci.remove(i);
				return;
			}
			i++;
		}
	}
	
	public void stampaj() {
		int i=1;
		for(Vozac v:vozaci) {
			System.out.println(i++ +". "+v.ime+" "+v.brPrvihPozicija());
		}
	}
}
