public class TextEditor {
    private static class Node {
        public String textState;
        public Node prev;
        public Node next;
        // Node constructor...
        public Node(String textState, Node prev, Node next) {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node currentNode;

    public TextEditor() {
        // Start with an initial empty string state.
        Node initialNode = new Node("", null, null);
        this.currentNode = initialNode;
    }

    public void add(String newText) {
        Node newNode = new Node(currentNode.textState + newText, currentNode, null);
        currentNode.next = newNode;
        currentNode = newNode;
        // Create a new node with the updated text.
        // Set its 'prev' to the current node.
        // Set the current node's 'next' to this new node.
        // Finally, update currentNode to point to the new node.
    }

    public String undo() {
        if (currentNode.prev == null) return "Error, can't be done";
        currentNode = currentNode.prev;
        return currentNode.textState;
        // Check if currentNode.prev is not null.
        // If it is, move currentNode back and return the text.
        // Otherwise, you can't undo.
    }
    
    public String redo() {
        if (currentNode.next == null) return "Error, can't be done";
        currentNode = currentNode.next;
        return currentNode.textState;
        // Check if currentNode.next is not null.
        // If it is, move currentNode forward and return the text.
    }
    
    public void printCurrent() {
        System.out.println(currentNode.textState);
    }

    public static void main(String[] args) {
        TextEditor t = new TextEditor();
        System.out.println("Adding initial data");
        t.add("Hello");
        t.add(" World");
        t.printCurrent();
        System.out.println("Testing Undo");
        t.undo();
        t.printCurrent();
        
        
        t.add("Check");
        t.printCurrent();

        t.redo();
        System.out.println("Checking the redo should do nothing");
        t.printCurrent();

        System.out.println("More extensive testing");
        t.add("I love this class :)");
        t.printCurrent();


    }
}