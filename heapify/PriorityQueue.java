class PriorityQueue {
	// min Heap
	int[] queue;
	int pqSize;
	public PriorityQueue() {
		this.queue = new int[100];
	}

    // add number
	public booleam offer(int num) {
		queue[pqSize] = num;
		shiftup(pqSize);
		pqSize++;
		return true;
	}
    
    // get and remove the minimal number from pq
	public int poll() {
		int value = queue[0];
        queue[0] = queue[pqSize - 1];
        pqSize--;
        if (pqSize > 0) {
        	shiftdown(0);
        }
        return value;
	}

	// get the minimal number from pq
	public int peek() {
		if (pqSize == 0) {
			return -1;
		}
		return queue[0];
	}

    // heapify
    // after exchange first and last, then shift down
	private void shiftdown(int nodeIndex) {
		int smallest = nodeIndex;
		int left = 2 * nodeIndex + 1;
		int right = 2 * nodeIndex + 2;
		if (left < pqSize && queue[left] < queue[smallest]) {
			smallest = left;
		}
		if (right < pqSize && queue[right] < queue[smallest]) {
			smallest = right;
		}

		if (smallest == nodeIndex) {
			break;
		}
		swap(nodeIndex, smallest);
		shiftdown(smallest);
	}
    
    // add a num to the last then shift up
	private void shiftup(int nodeIndex) {
		if (nodeIndex > 0) {
			int parentIndex = (nodeIndex - 1) / 2;
			if (queue[parentIndex] > queue[nodeIndex]) {
				swap(parentIndex, nodeIndex);
			}
			shiftup(parentIndex);
		}
	}

	private void swap(int i, int j) {
		int tmp = queue[i];
		queue[i] = queue[j];
		queue[j] = tmp;
	}
}