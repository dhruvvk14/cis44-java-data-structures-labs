import java.util.Random;
import java.lang.Override;
public class Matrix{
    private int[][] data;
    public int n, m;
    private Random rand;
    public Matrix(int rows, int cols) {
        n = rows;
        m = cols;
        data = new int[n][m];
        rand = new Random();
    }
    public Matrix(int [][] data) {
        n = data.length;
        m = data[0].length;
        this.data = data;
    }
    public int get(int row, int col) {
        if (!(0 <= row && row < n && 0 <= col && col < m)) throw new IndexOutOfBoundsException();
        return data[row][col];
    }
    public void populateRandom() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = rand.nextInt(10) + 1;
            }
        }

    }
    public Matrix add(Matrix other) {
        if (this.n != other.n && this.m != other.m) {
            throw new IllegalArgumentException();
        }
        int retData[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) retData[i][j] = other.get(i, j) + this.get(i, j);
        }
        return new Matrix(retData);
    }
    public Matrix multiply(Matrix other) {
        if (this.m != other.n) throw new IllegalArgumentException();
        int retData[][] = new int[n][other.m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < other.n; k++) {
                    retData[i][j] += this.get(i, k) * other.get(k, j);
                }
            }
        }
        return new Matrix(retData);
    }
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {s += Integer.toString(this.get(i, j)) + " ";}
            s += "\n";
        }
        return s;
    }
}