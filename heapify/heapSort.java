public class HeapSort {
	public void sort(int arr[]) {
		int n = arr.length;

		// build heap (rearrange array) 
		for (int i = n/2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		// one by one extract an element from heap
		for (int i = n - 1; i > 0; i--) {
			// move current root to end
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	// to heapify a subtree rooted with node i which is 
	// an index in arr[], n is size of heap
	private void heapify(int arr[], int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && arr[l] > arr[largest]) {
			largest = l;
		}
		if (r < n && arr[r] > arr[largest]) {
			largest = r;
		}

		if (largest == i) {
			break;
		}

		int tmp = arr[largest];
		arr[largest] = arr[i];
		arr[i] = tmp;

		heapify(arr, n, largest); 
	}
}