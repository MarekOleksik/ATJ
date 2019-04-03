package atj;

import java.time.Duration;
import java.time.Instant;

public class TestSort {
		
	private ISort method;
	private double[] array;

	public long test(double[] array) {
		Instant start = Instant.now();
		method.sort(array);
		return Duration.between(start, Instant.now()).toNanos();
		}

	public void setMethod(BubbleSort bubbleSort) {
		// TODO Auto-generated method stub
		bubbleSort = BubbleSort.bubbleSort(array);
	}

	

}
