// MyList defines the common interface for list data structures.
public interface MyList<T> {
    void add(T element);
    T get(int index);
    void remove(int index);
    int size();
}
