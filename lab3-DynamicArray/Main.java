public class Main {
    public static void main(String[] args) {
        DynamicArray <Integer> a = new DynamicArray();
        for(int i = 1; i <= 15; i++) {
            a.add(i);
            System.out.print("Printing: ");
            a.print();
        }
        for (int i = 14; i >= 0; i--) {
            a.remove(i);
            System.out.print("Printing: ");
            a.print();
        }
        
        a.print();
        // for (int i = 0; i < 3; i++) 
    }
}