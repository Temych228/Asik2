// MyLinkedList is a custom implementation of a doubly linked list.
// It supports dynamic addition, removal, and access of elements.
public class MyLinkedList<T> implements MyList<T> {

    // Inner class representing a node in the linked list
    private class MyNode<T> {
        T data;
        MyNode<T> next;
        MyNode<T> prev;

        public MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Adds a new element at the end of the list
    @Override
    public void add(T element) {
        MyNode<T> newNode = new MyNode<>(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Returns the element at a specific index
    @Override
    public T get(int index) {
        checkIndex(index);
        MyNode<T> current = head;

        // Traverse the list from head to index
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    // Removes the element at the specified index
    @Override
    public void remove(int index) {
        checkIndex(index);

        MyNode<T> current = head;

        // Traverse to the target node
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }

        size--;
    }

    // Checks whether the given index is within list bounds
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds.");
        }
    }

    // Returns the number of elements in the list
    @Override
    public int size() {
        return size;
    }

    // Returns a string representation of the list
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        MyNode<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
