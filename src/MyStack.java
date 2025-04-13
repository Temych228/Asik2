public class MyStack<T> {
    private MyArrayList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    // Pushes an element to the top of the stack
    public void push(T element) {
        list.add(element);
    }

    // Removes and returns the top element
    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        T element = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return element;
    }

    // Returns the top element without removing it
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.get(list.size() - 1);
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // Returns number of elements in the stack
    public int size() {
        return list.size();
    }
}
