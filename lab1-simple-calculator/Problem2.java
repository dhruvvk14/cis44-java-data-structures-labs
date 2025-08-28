import java.util.Scanner;
public class Problem2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.print("First Input (type exit if quit): ");
            String first = scan.next();
            if (first.equals("exit")) break;
            System.out.print("Operation: ");
            String operation = scan.next();
            System.out.print("Second Input: ");
            String second = scan.next();
            if (operation.equals("+")) {
                System.out.println(first + operation + second + " is " + (Double.parseDouble(first) + Double.parseDouble(second)));
            }
            else if (operation.equals("-")) {
                System.out.println(first + operation + second + " is " + (Double.parseDouble(first) - Double.parseDouble(second)));
            }
            else if (operation.equals("*")) {
                System.out.println(first + operation + second + " is " + (Double.parseDouble(first) * Double.parseDouble(second)));
            }
            else if (operation.equals("/")) {
                System.out.println(first + operation + second + " is " + (Double.parseDouble(first) / Double.parseDouble(second)));
            }
            else if (operation.equals("=")) {
                System.out.println(first + operation + second + " is " + (Double.parseDouble(first) == Double.parseDouble(second)));
            }
            else System.out.println("error");
            
        }

		
	}
}
