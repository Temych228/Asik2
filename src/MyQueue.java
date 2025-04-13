public class MyQueue<T> {
    private MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    // Adds an element to the end of the queue
    public void enqueue(T element) {
        list.add(element);
    }

    // Removes and returns the front element
    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        T element = list.get(0);
        list.remove(0);
        return element;
    }

    // Returns the front element without removing
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return list.get(0);
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // Returns number of elements in the queue
    public int size() {
        return list.size();
    }
}
