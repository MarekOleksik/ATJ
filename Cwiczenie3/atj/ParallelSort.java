package atj;

import java.util.Arrays;

public class ParallelSort implements ISort{

	@Override
	public void sort(double[] array) {
		// TODO Auto-generated method stub
		Arrays.parallelSort(array);
	}

}
