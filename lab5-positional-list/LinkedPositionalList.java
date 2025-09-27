import java.util.Iterator;

// You'll need a Position interface
interface Position <E> { E getElement(); }

public class LinkedPositionalList <E> implements Iterable<E> {
    // --- Nested Node Class (implements Position) ---
    private static class Node <E> implements Position {
        // ... element, prev, next pointers and methods ...
        public E element;
        public Node <E> prev, next;
        public Node() {
            prev = null; next = null; element = null;
        }
        public Node(E element, Node <E> prev, Node <E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
        public E getElement() {
            return this.element;
        }

    }
    
    private Node <E> header;
    private Node <E> trailer;
    private int size = 0;

    public LinkedPositionalList() {
        header = new Node<E>();
        trailer = new Node<E>();
        size = 0;
        header.next = trailer;
        trailer.prev = header;
    }

    public Node <E> ensure(Position <E> p) {
        if (!(p instanceof Node)) {
            throw new IllegalAccessError();
        }
        Node <E> nodeP = (Node<E>) p;

        if(nodeP.next == null) throw new IllegalAccessError();
        return nodeP;
    }

    public Position <E> addFirst(E element) {
        Node <E> add = new Node<>(element, header, header.next);
        add.next.prev = add;
        header.next = add;
        size++;
        return add;
    }
    public Position <E> addLast(E element) {
        Node <E> add = new Node<>(element, trailer.prev, trailer);
        (trailer.prev).next = add;
        trailer.prev = add;
        size++;
        return add;
    }

    public Position <E> addBefore (Position <E> pos, E element) throws IllegalArgumentException{
        Node <E> posNode = ensure(pos);
        Node <E> add = new Node(element, posNode.prev, posNode);

        (posNode.prev).next = add;
        posNode.prev = add;
        size++;

        return add;
    }

    public Position <E> addAfter(Position <E> pos, E element) throws IllegalArgumentException{
        Node<E> posNode = ensure(pos);
        Node<E> add = new Node<>(element, posNode, posNode.next);

        (posNode.next).prev = add;
        posNode.next = add;
        size++;

        return add;

    }
    public E set(Position <E> pos, E element) throws IllegalArgumentException{
        Node <E> node = ensure(pos);
        E ans = node.element;
        node.element = element;
        return ans;
    }
    public E remove(Position<E> pos) {
    Node<E> node = ensure(pos);
    Node<E> pre  = node.prev;
    Node<E> post = node.next;
    pre.next = post;
    post.prev = pre;
    size--;
    E element = node.element;
    node.element = null;
    node.prev = null;
    node.next = null;

    return element;
}

    public String toString() {
        Node <E> start = header.next;
        String lst = "";
        while (start != trailer) {
            lst += start.element + " ";
            start = start.next;
        }
        return lst;
    }
    // ... Implement all the Positional List methods ...

    // --- Nested Iterator Class ---
    private class ElementIterator implements Iterator {
        Position cursor = header.next; // Start at the first element
        
        public boolean hasNext() {
            //stop when trailer is reached.
            return cursor != trailer;
        }
        
        public E next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }

            Node<E> node = (Node<E>) cursor;
            E result = node.element;
            // advance cursor to the next node
            cursor = node.next;
            return result;
        }
    }
    
    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    public static void main(String[] args) {
        LinkedPositionalList <String> lst = new LinkedPositionalList<>();
        System.out.println("Printing: " + lst);
        Position <String> p1 = lst.addFirst("Paris");
        System.out.println("Printing: " + lst);
        Position <String> p2 = lst.addFirst("France");
        System.out.println("Printing: " + lst);
        Position <String> p3 = lst.addAfter(p1, "Africa");
        System.out.println("Printing: " + lst);

        Position <String> p4 = lst.addLast("Ghana");
        System.out.println("Printing: " + lst);

        Position <String> p5 = lst.addBefore(p4, "India");
        System.out.println("Printing: " + lst);

        lst.set(p4, "Ghana2.0");
        System.out.println("Printing: " + lst);

        lst.remove(p1);
        System.out.println("Printing: " + lst);
        for (String s: lst) {
            System.out.println("Test Iterator: " + s);
        }
    }
}