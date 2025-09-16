public class Main {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(2, 2);
        m1.populateRandom();
        Matrix m2 = new Matrix(2, 2);
        m2.populateRandom();
        System.out.println(m1.toString());
        System.out.println(m2.toString());
        System.out.println("Adding m1 & m2");
        System.out.println(m1.add(m2).toString());
        System.out.println("Multiplying m1 & m2");
        System.out.println(m1.multiply(m2).toString());

        int preloaded[][] = {{1, 10, 15}, {1, 2, 3}};
        Matrix m3 = new Matrix(preloaded);
        System.out.println("Matrix 3 contents: ");
        System.out.println(m3);

        System.out.println(m3.add(m2));
    }
}