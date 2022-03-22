import java.util.Random;

public class Solution {
	public Random rand;

	public void sortIntegers(int[] A) {
		rand = new Random();

		quickSort(A, 0, A.length - 1);
	}

	private void quickSort(int[] A, int start, int end) {
		if (start >= end) {
			return;
		}

		int index = rand.nextInt(end - start + 1) + start;
		int pivot = A[index];
		int left = start;
		int right = end;

		while (left <= right) {
			while (left <= right && A[left] < pivot) {
				left++;
			}
			while (left <= right && A[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int tmp = A[left];
				A[left] = A[right];
				A[right] = tmp;
				left++;
				right--;
			}
		}

		quickSort(A, start, right);
		quickSort(A, left, end);
	}
}