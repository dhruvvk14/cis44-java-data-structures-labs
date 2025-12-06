public class Main {
    public static void unsortedTest() {
        UnsortedListMap<Integer, Character> map = new UnsortedListMap<>();
        // map.size();
        System.out.println(map.put(5, 'A'));
        System.out.println(map.put(7, 'B'));
        System.out.println(map.put(2, 'C'));
        System.out.println(map.put(2, 'E'));
        System.out.println(map.get(7));
        System.out.println(map.remove(5));
    }
    public static void seperateTest() {
        SeparateChainingMap <Integer, Character> map = new SeparateChainingMap<>();
        System.out.println(map.put(5, 'A'));
        System.out.println(map.put(7, 'B'));
        System.out.println(map.put(2, 'C'));
        System.out.println(map.put(2, 'E'));
        System.out.println(map.get(7));
        System.out.println(map.remove(5));

        System.out.println(map.put(15, 'B'));
        System.out.println(map.put(15, 'A'));
        System.out.println(map.put(15, 'D'));
        System.out.println(map.put(15, 'F'));
        System.out.println(map.put(12, 'L'));
    }
    public static void main(String[] args) {
        
        seperateTest();

        // System.out.println("HERE");
    }
}