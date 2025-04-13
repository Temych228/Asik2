public class Main {
    public static void main(String[] args) {
        System.out.println("=== Testing MyArrayList ===");
        MyList<Integer> arrayList = new MyArrayList<>();

        for (int i = 1; i <= 6; i++) {
            arrayList.add(i);
        }
        System.out.println("Original array list: " + arrayList);

        arrayList.remove(2);
        System.out.println("After removing index 2: " + arrayList);

        System.out.println("Element at index 1: " + arrayList.get(1));
        System.out.println("Size: " + arrayList.size());

        System.out.println("\n=== Testing MyLinkedList ===");
        MyList<Integer> linkedList = new MyLinkedList<>();

        for (int i = 1; i <= 6; i++) {
            linkedList.add(i);
        }
        System.out.println("Original linked list: " + linkedList);

        linkedList.remove(2);
        System.out.println("After removing index 2: " + linkedList);

        System.out.println("Element at index 1: " + linkedList.get(1));
        System.out.println("Size: " + linkedList.size());
    }
}
