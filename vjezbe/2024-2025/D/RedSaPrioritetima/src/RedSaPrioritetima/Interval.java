package RedSaPrioritetima;

public class Interval implements Comparable<Interval> {
    int l;
    int r;

    public Interval(int l, int r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public String toString() {
        return "["+l +","+r+"]";
    }

    @Override
    public int compareTo(Interval o) {
        if(l < o.l) return -1;
        if(l == o.l) return 0;
        return 1;
    }
}