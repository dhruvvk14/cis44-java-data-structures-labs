import java.util.ArrayList;
// You will need a functioning Stack implementation (like ArrayStack) for this to work.
interface Stack <E> {
    public void push(E element);
    public int size();
    public E pop();
}
class ArrayStack <E> implements Stack <E> {
    private ArrayList <E> stck;
    public ArrayStack() {
        stck = new ArrayList<E>();
    }
    public void push(E element) {
        stck.add(element);
    }
    public E pop() throws IndexOutOfBoundsException{
        if(stck.isEmpty()) throw new IndexOutOfBoundsException();

        E ret = stck.get(stck.size()-1);
        stck.remove(stck.size()-1);
        return ret;
    }
    public int size() {
        return stck.size();
    }
}

public class SyntaxChecker {

    /**
     * Uses a stack to check if a line of code has balanced symbols.
     * @param line The string of code to check.
     * @return true if symbols are balanced, false otherwise.
     */
    public static boolean isBalanced(String line) {
        // TODO: Implement this method using a Stack.
        Stack <Character> stck = new ArrayStack<Character>();

        int n = line.length();

        for (int i = 0; i < n; i++) {
            char c = line.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stck.push(c);
                continue;
            }
            else if (c == ')') {
                if (stck.size() == 0) return false;
                if (stck.pop() != '(') return false;
            }
            else if (c == '}') {
                if (stck.size() == 0) return false;
                if (stck.pop() != '{') return false;
            }
            else if (c == ']') {
                if (stck.size() == 0) return false;
                if (stck.pop() != '[') return false;
            }
        }
        
        // Your implementation here...
        
        return stck.size()==0; // Placeholder
    }

    public static void main(String[] args) {
        String line1 = "public static void main(String[] args) { ... }"; // Should be true
        String line2 = "int x = (5 + [a * 2]);"; // Should be true
        String line3 = "System.out.println('Hello');)"; // Should be false (extra closing parenthesis)
        String line4 = "List list = new ArrayList<{String>();"; // Should be false (mismatched)
        String line5 = "if (x > 0) {"; // Should be false (unmatched opening brace)

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
    }
}
