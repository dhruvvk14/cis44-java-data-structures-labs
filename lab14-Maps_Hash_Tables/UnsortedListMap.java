import java.util.ArrayList;

// --- 1. Entry ADT ---
class Entry<K, V> {
    private final K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() { return key; }
    public V getValue() { return value; }
    public V setValue(V value) { 
        V old = this.value;
        this.value = value;
        return old;
    }
}

// --- 2. Common Map Interface ---
interface MapADT<K, V> {
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    int size();
    boolean isEmpty();
}

// --- 3. Implementation: Unsorted List Map ---
class UnsortedListMap<K, V> implements MapADT<K, V> {
    private ArrayList<Entry<K, V>> list = new ArrayList<>();
    private int findEntryIndex(K key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public int size() { return list.size(); }
    public boolean isEmpty() { return list.isEmpty(); }
    
    public V get(K key) {
        int i = findEntryIndex(key);
        return (i != -1) ? list.get(i).getValue() : null;
    }
    
    public V remove(K key) {
        int i = findEntryIndex(key);
        if (i != -1) {
            V oldValue = list.get(i).getValue();
            list.remove(i); 
            return oldValue;
        }
        return null;
    }
    
    // TODO: Complete this method (O(n))
    public V put(K key, V value) {
        // 1. Search for existing key.
        int n = list.size();
         for (int i = 0; i < n; i++) {
            if (list.get(i).getKey().equals(key)) {
                V prev = list.get(i).getValue();
                list.get(i).setValue(value);
                return prev;
            }
         }
         list.add(new Entry(key, value));
        return null;
    }
}