// MyArrayList is a custom implementation of a dynamic array list
public class MyArrayList<T> implements MyList<T> {

    // Internal array to store elements
    private Object[] elements;

    // Tracks the number of elements currently in the list
    private int size;

    // Default constructor initializing the array with a default capacity
    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    // Adds an element to the end of the list
    @Override
    public void add(T element) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = element;
    }

    // Doubles the capacity of the internal array when needed
    private void increaseCapacity() {
        Object[] newElements = new Object[elements.length * 2]; // create a larger array
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    // Retrieves the element at the given index
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    // Removes the element at the specified index and shifts remaining elements
    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }

    // Replaces the element at the specified index with a new element
    public void set(int index, T element) {
        checkIndex(index);
        elements[index] = element;
    }

    // Helper method to check if index is within bounds
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " is invalid.");
        }
    }

    // Returns the number of elements currently in the list
    @Override
    public int size() {
        return size;
    }

    // Optional: Returns a string representation of the list for easy printing
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
