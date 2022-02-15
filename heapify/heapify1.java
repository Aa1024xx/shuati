public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    // time complexity: O(nlogn)  
    public void heapify(int[] A) {
        for (int i = 0; i < A.length; i++) {
            siftup(A, i);
        }
    }

    private void siftup(int[] A, int k) {
        while (k != 0) {
            int father = (k - 1) /2;
            if (A[k] > A[father]) {
                break;
            }
            int tmp = A[k];
            A[k] = A[father];
            A[father] = tmp;

            k = father;
        }
    }
}