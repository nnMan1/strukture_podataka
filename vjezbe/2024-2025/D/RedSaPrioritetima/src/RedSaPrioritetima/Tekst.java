package RedSaPrioritetima;

public class Tekst implements Comparable<Tekst> {
    String tekst;

    public Tekst(String tekst) {
        this.tekst = tekst;
    }

    int brVelikihSlova() {
        int br = 0;
        for(int i=0;i<tekst.length();i++) {
            if(Character.isUpperCase(tekst.charAt(i)))
            br++;
        }
        return br;
    }

    @Override
    public String toString() {
        return tekst;
    }

    @Override
    public int compareTo(Tekst o) {
        if(this.brVelikihSlova() < o.brVelikihSlova()) return 1;
        if(this.brVelikihSlova() == o.brVelikihSlova()) return 0;
        return -1;
    }
}
