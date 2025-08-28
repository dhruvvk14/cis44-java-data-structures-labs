import java.util.Random;
public class Problem1
{
	public static void main(String[] args) {
		int n = 5;
		int a[] = new int[n];
		int b[] = new int[n];
		long c[] = new long[n];
		int mx = Integer.MAX_VALUE;
		Random r = new Random();
		for (int i = 0; i < n; i++) {
		    //let a and b filled with integers that can be from (-INTEGER.MAX_VALUE, INTEGER.MAX_VALUE
		    a[i] = r.nextInt(mx);
		    int sign = r.nextInt(2);
		    if (sign == 1) { //this is negative
                a[i] *= -1;		        
		    }
		}
		
		
		for (int i = 0; i < n; i++) {
		    //let a and b filled with integers that can be from (-INTEGER.MAX_VALUE, INTEGER.MAX_VALUE
		    b[i] = r.nextInt(mx);
		    int sign = r.nextInt(2);
		    if (sign == 1) { //this is negative
                b[i] *= -1;		        
		    }
		    c[i] = (long)a[i] * (long)b[i];
		}
		System.out.println("array a: ");
		for (int i: a) System.out.print(i + " ");
		System.out.println("\narray b: ");
		for (int i: b) System.out.print(i + " ");
		System.out.println("\narray c: ");
		for (long i: c) System.out.print(i + " ");
		
	}
}
