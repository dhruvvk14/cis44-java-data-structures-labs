import java.util.Arrays;
public class DynamicArray<T> {
    private T[] data;
    private static final int INITIAL_CAPACITY = 2;
    private int size;
    private int curInd = 0;
    public void print() {
        for (int i = 0; i < curInd; i++) System.out.print(data[i] + " ");
        System.out.println();
    }
    public DynamicArray() {
        data = (T[])new Object[INITIAL_CAPACITY];
        size = INITIAL_CAPACITY;
    }
    public T get(int index) {
        if (index < 0 || index > curInd)throw new IndexOutOfBoundsException("getting an invalid index");
        return data[index];
    }
    private void resize() {
        size *= 2;
        data = Arrays.copyOf(data, 2 * size);
    }
    public void add(T element) {
        if (curInd == size) {
            resize();
        }
        data[curInd] = element;
        curInd++;
    }
    public T remove(int index) {
        if (index < 0 || index > curInd) {
            throw new IndexOutOfBoundsException("removing at invalid index");
        }
        T type = data[index];
        data[index] = null;
        for (int i = index; i < curInd; i++) {
            data[i] = data[i+1];
        }
        curInd--;
        return type;
    }
}