package atj;

import java.util.Arrays;

public class Main {

	private static long bubbleTime = 0;
	private static long parallelTime = 0;
	private static long listTime = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSort ts = new TestSort();

		for (int i = 0; i < 1000; ++i) {
			double[] array = randomArray();

			ts.setMethod(new BubbleSort());
			bubbleTime += ts.test(Arrays.copyOf(array, array.length));
			
			ts.setMethod(new ParallelSort());
			parallelTime += ts.test(Arrays.copyOf(array, array.length));
			
			ts.setMethod(new ListSort());
			listTime += ts.test(Arrays.copyOf(array, array.length));
		}
		
		final double DIV = Math.pow(10, 6);
		System.out.println("Bubble sort time [ms]: " + bubbleTime / DIV);
		System.out.println("Parallel sort time [ms]: " + +parallelTime / DIV);
		System.out.println("List sort time [ms]: " + listTime / DIV);

	}

	static double[] randomArray() {
		// TODO Auto-generated method stub
		double[] array = new double[1000];
		for (int i = 0; i < 1000; ++i) { array[i] = Math.random() * 100; }
		return array;
	}
}

