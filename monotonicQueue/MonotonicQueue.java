public int[] MonotonicQueue(int[] nums, int k) {
	int n = nums.length;
	Deque<Integer> q = new ArrayDeque<>();
	int[] res = new int[n - k + 1];
	for (int i = 0; i < n; i++) {
		while (!q.isEmpty() && i - q.peekFirst() >= k) {
			q.pollFirst(); // left out q, make sure window size is k-1
		}
		while (!q,isEmpty() && nums[q.peekLast()] <= nums[i]) {
			q.pollLast(); // right in q, make sure monotonic
		}
		q.offerLast(i); // en q, q.size() = k
		q.peekFirst(); // q left peek - largest 
	}
}