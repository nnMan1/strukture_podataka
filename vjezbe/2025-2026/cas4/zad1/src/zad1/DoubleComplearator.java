package zad1;

import java.util.Comparator;

public class DoubleComplearator implements Comparator<Double> {

	@Override
	public int compare(Double o1, Double o2) {
		return o1.compareTo(o2);
	}

}
