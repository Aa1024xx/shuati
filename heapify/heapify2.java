public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    // O(n)
    public void heapify(int[] A) {
        for (int i = A.length / 2; i >= 0; i--) {
            shiftdown(A, i);
        }
    }

    private void shiftdown(int[] A, int k) {
        while (k < A.length) {
            int smallest = k;
            if(2 * k + 1 < A.length && A[k * 2 + 1] < A[smallest]) {
                smallest = 2 * k + 1;
            }
            if (2 * k + 2 < A.length && A[2 * k + 2] < A[smallest]) {
                smallest = 2 * k + 2;
            }

            if (smallest == k) {
                break;
            }

            int tmp = A[smallest];
            A[smallest] = A[k];
            A[k] = tmp;

            k = smallest;
        }
    }
}