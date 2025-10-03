// You will need a functioning Queue implementation (like LinkedQueue) for this to work.
interface Queue<E> {
    public E pop();
    public void push(E e);
    public int size();

}
class LinkedQueue<E> implements Queue<E> {
    //singly linked list should be enough...
    class Node{
        private E data;
        public Node next;
        public Node(E data, Node next) {
            this.data = data; this.next = next;
        }
        public E getData(){return data;}
    }
    private Node head = null, tail = null;
    private int size = 0;
    public LinkedQueue() {
        head = null; tail = null; size = 0;
    }
    
    public int size() {return size;}
    public void push(E e){
        if (size == 0) {
            Node add = new Node(e, null);
            head = add;
            tail = add;
            size++;
            return;
        }
        Node add = new Node(e, null);
        tail.next = add;
        tail = add;
        size++;
    }
    public E pop() throws IndexOutOfBoundsException{
        if (size == 0) throw new IndexOutOfBoundsException();
        E thisData = head.data;
        head = head.next;
        size--;
        return thisData;
    }
}

/**
 * Represents a single document to be printed.
 */
class PrintJob {
    private String documentName;
    private int pageCount;
    // TODO: Implement the constructor
    public PrintJob(String documentName, int pageCount) {
        // Your code here
        this.documentName = documentName;
        this.pageCount = pageCount;
    }

    // TODO: Implement the toString method to return a descriptive string
    // e.g., "PrintJob[Document: report.docx, Pages: 15]"
    @Override
    public String toString() {
        return "Document Name: " + this.documentName + ", Pages: " + Integer.toString(this.pageCount); // Placeholder
    }
}
/**
 * Simulates a printer that manages a queue of print jobs.
 */
public class Printer {
    private Queue <PrintJob> jobQueue;

    public Printer() {
        // TODO: Initialize the jobQueue with a LinkedQueue
        jobQueue = new LinkedQueue <PrintJob>(); // Placeholder
    }

    /**
     * Adds a new print job to the rear of the queue.
     * @param job The print job to add.
     */
    public void addJob(PrintJob job) {
        System.out.println("Adding to queue: " + job);
        // TODO: Enqueue the job
        jobQueue.push(job);
    }

    /**
     * Processes the job at the front of the queue.
     */
    public void processNextJob() {
        if (jobQueue.size() == 0) System.out.println("The queue is empty, can't process.");
        else {
            System.out.print("Processing... ");
            System.out.println(jobQueue.pop());
        }
        // TODO: Check if the queue is empty. If so, print a message.
        // If not empty, dequeue the job and print a "Processing..." message.
    }

    public static void main(String[] args) {
        Printer officePrinter = new Printer();

        officePrinter.addJob(new PrintJob("Annual_Report.pdf", 25));
        officePrinter.addJob(new PrintJob("Meeting_Agenda.docx", 2));
        officePrinter.addJob(new PrintJob("Presentation_Slides.pptx", 30));

        System.out.println("\n--- Starting to Print ---");
        officePrinter.processNextJob(); // Should print Annual_Report.pdf
        officePrinter.processNextJob(); // Should print Meeting_Agenda.docx

        System.out.println("\nNew high-priority job arrives...");
        officePrinter.addJob(new PrintJob("Urgent_Memo.pdf", 1));

        officePrinter.processNextJob(); // Should print Presentation_Slides.pptx
        officePrinter.processNextJob(); // Should print Urgent_Memo.pdf
        officePrinter.processNextJob(); // Should say the queue is empty
    }
}
