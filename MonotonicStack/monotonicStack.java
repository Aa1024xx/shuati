// input: nums = {2, 1, 2, 4, 3}
// monotonic stack increasing
// output: {4, 2, 4, -1, -1}
// 比第一个2后面大的数是4； 比1后面大的数是2；
// 比第二个2后面大的数是4； 比4后面大的数没有;
// 比3后面大的数没有.

private static int[] nextGreaterElement(int[] nums) {
	int[] res = new int[nums.length];
	Stack<Integer> stack = new Stack<>();
	for (int i = nums.length - 1; i >= 0; i--) {
		while (!stack.isEmpty() && nums[i] >= stack.peek()) {
			stack.pop();
		}
		res[i] = stack.isEmpty() ? -1 : stack.peek();
		stack.push(nums[i]); // stack: [4, 2, 1]
	}
	return res;
}