package RedSaPrioritetima;

import java.util.Comparator;

public class PoredjenjeFilmova implements Comparator<Interval> {

    @Override
    public int compare(Interval o1, Interval o2) {
        if(o1.r < o2.r) return -1;
        if(o1.r == o2.r) return 0;
        return 1;
    }
    
}
