class ShellSort {
	static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
		System.out.println();
	}

	int sort(int arr[]) {
		int n = arr.length;
		// start with a big gap, then reduce the gap
		for (int gap = n/2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i++) {
				int tmp = arr[i];
				for (int j = i; j > gap && arr[j - gap] > tmp; j -= gap) {
					arr[j] = arr[j - gap];
				}
			}
		}

		return 0;
	}

	public static void main(String arg[]) {
		int arr[] = { 12, 34, 54, 2, 3 };
		System.out.println("Array before sorting");
		printArray(arr);

		ShellSort ob = new ShellSort();
		ob.sort(arr);

		System.out.println("Array after sorting");
		printArray(arr);
	}

}