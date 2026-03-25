package zad1;

import java.util.Comparator;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int = > Ineteger
//		double => Double
//		boolean => Boolean
		LinkedList<Double> list = new LinkedList<>();
		list.add(5.3);
		list.add(2.4);
		list.addFirst(0.12);
		list.add(1, 1.0);
		
		for(Double val: list) {
			System.out.print(val + " ");
		}
		System.out.println();
		
//		list.remove(3);
//		list.removeLast();
//		list.removeFirst(); 
//		list.sort(new DoubleComplearator());

		list.sort(new Comparator<Double>() {
			@Override
			public int compare(Double o1, Double o2) {
				return o1.compareTo(o2);
			}
		});
		
		for(Double val: list) {
			System.out.print(val + " ");
		}
	}

}
