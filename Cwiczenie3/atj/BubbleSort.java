package atj;

import java.util.Arrays;

public class BubbleSort implements ISort {

	public static void bubbleSort(double[] array) {
		for (int j = 0; j < array.length - 1; j++) {
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					double temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
		}
	}

	@Override
	public void sort(double[] array) {
		// TODO Auto-generated method stub
		BubbleSort.bubbleSort(array);
	}
}
