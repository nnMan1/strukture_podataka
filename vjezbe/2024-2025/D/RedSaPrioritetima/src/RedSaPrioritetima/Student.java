package RedSaPrioritetima;

public class Student implements Comparable<Student> {
	String ime;
	int brojIndeksa;
	int godinaUpisa;
	double prosjek;
	
	public Student(String ime, int brojIndeksa, int godinaUpisa, double prosjek) {
		this.ime = ime;
		this.brojIndeksa = brojIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.prosjek = prosjek;
	}

	public String toString() {
		String ret = String.format(
			"""
			Student{
				ime: %s
				brojIndeksa: %d
				godinaUpisa: %d
				prosjek: %f
			}				
			""", ime, brojIndeksa, godinaUpisa, prosjek);

		return ret;
	}

	@Override
	public int compareTo(Student o) {
		if(Math.abs(prosjek - o.prosjek) < 0.01)
			return 0;

		if(prosjek < o.prosjek) return -1;
		
		return 1;
	}
}
