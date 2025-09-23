

public class MyArrayList <E> {
    private static final int INITIAL_CAPACITY = 2;
    private E[] data;
    private int size = 0;

    public MyArrayList() {
        data = (E[]) new Object[INITIAL_CAPACITY];
    }

    public void add(E element) {
        if (size == data.length) {
            resize();
        }
        data[size] = element;
        size++;
    }

    public E get(int index) {
        // First, check if the index is valid (less than size).
        // Then, return the element.
        if (index < size) return data[index];
        throw new IndexOutOfBoundsException("Invalid index");
    }
    public int size() {return size;}
    public void add(int index, E element) {
        if (size == data.length) {
            resize();
        }

        for (int i = size; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = element;
        size++;
    }
    // ... other methods ...
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        for (int i = index; i < size; i++) data[i] = data[i+1];
        data[size-1] = null;
        size--;        
    }
    private void resize() {
        int newCapacity = data.length * 2;
        E[] newData = (E[]) new Object[newCapacity];
        // Loop to copy elements from 'data' to 'newData'
        // Finally, update the 'data' reference.

        for (int i = 0; i < size; i++) newData[i] = data[i];

        System.out.println("Resized from " + data.length + " to " + newCapacity);
        this.data = newData;
    }

    public String toString() {
        String ret = "";
        for (int i = 0; i < size; i++) ret = ret + data[i] + " ";

        return ret;
    }

    public static void main(String[] args) {
        MyArrayList<Integer> lst = new MyArrayList<Integer>();

        for (int i = 1; i <= 12; i++) {
            lst.add(i);
            System.out.println("Current List: " + lst);
        }


        lst.remove(10);
        System.out.println("After removing 10th index: " + lst);

        lst.add(2, 10023424);

        System.out.println("Adding big number to 2nd index: " + lst);
    }
}

