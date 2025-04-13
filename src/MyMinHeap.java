public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    // Adds a new element and maintains heap property
    public void add(T element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    // Removes and returns the minimum (root)
    public T removeMin() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        T min = heap.get(0);
        T last = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return min;
    }

    // Heapify upwards to restore heap property
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) < 0) {
                swap(index, parent);
                index = parent;
            } else break;
        }
    }

    // Heapify downwards
    private void heapifyDown(int index) {
        int left, right, smallest;
        while (index < heap.size()) {
            left = 2 * index + 1;
            right = 2 * index + 2;
            smallest = index;

            if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0)
                smallest = left;
            if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0)
                smallest = right;

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else break;
        }
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int size() {
        return heap.size();
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }
}
