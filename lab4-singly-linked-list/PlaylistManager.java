class Song {
    public String title;
    public String artist;
    public Song (String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
    public String toString() {
        return "Title: " + title + ", Artist: " + artist;
    }
    // Constructor and getters...
}

class Playlist {
    private static class Node {
        Song song;
        Node next;
        // Node constructor...
        public Node(Song song, Node next) {
            this.song = song;
            this.next = next;
        }
    }

    private Node head = null;
    private Node tail = null;
    private Node currentNode = null;
    private int size;

    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentNode = null;
        this.size = 0;
    }

    public void addSong(Song song) {
        // Your implementation here...
        if (size == 0) {
            Node newSong = new Node(song, null);
            head = newSong;
            tail = newSong;
            size++;
            return;
        }
        
        tail.next = new Node(song, null);
        tail = tail.next;
        size++;
    }

    public void removeSong(String title) {
        // let us assume that each song has a unique title...
        Node current = head;
        Node pre = null;
        int curSong = 1;
        while (current != null && !current.song.title.equals(title)) {
            pre = current;
            current = current.next;
            curSong++;
        }
        // System.out.println(current.song);
        if (curSong == 1) {
            // System.out.println("HERE");
            //this is our head...
            this.head = head.next;
            size--;
            return;
        }
        if (curSong == size) {
            tail = pre;
            pre.next = null;
            size--;
        }
        else {pre.next = current.next; size--;}
        
        // Handle two cases: removing the head and removing from elsewhere.
        // Don't forget to update the tail if the last song is removed.
    }

    public void playNext() {
        if (currentNode == null) {
            currentNode = head;
            System.out.println(currentNode.song);
            return;
        }
        currentNode = currentNode.next;
        if (currentNode == null) currentNode = head;
        System.out.println(currentNode.song);
        // System.out.println(currentNode.);
        // If currentNode is null, start from the head.
        // Otherwise, advance to the next node.
        // If you reach the end, loop back to the head.
    }
    
    public void displayPlaylist() {
        Node current = head;
        while (current != null) {
            System.out.println(current.song);
            current = current.next;
        }
        // Traverse from the head and print each song.
    }
}

public class PlaylistManager{
    public static void main (String[] args) {
        Playlist playlist = new Playlist();

        Song s1 = new Song("Am I Dreaming", "Metro Booming");
        Song s2 = new Song("What did I Miss", "Drake");
        playlist.addSong(s1);
        playlist.addSong(s2);
        playlist.addSong(new Song("Umberlla", "Rihanna"));
        System.out.println("Displaying playlist first time: ");
        playlist.displayPlaylist();

        playlist.removeSong("What did I Miss");
        playlist.addSong(new Song("Graduation", "Kanye West"));
        System.out.println("Removing & adding song, then displaying playlist");
        playlist.displayPlaylist();

        playlist.displayPlaylist();


        // System.out.println();
        System.out.println("playNext() functionality");
        playlist.playNext();
        playlist.playNext();
        playlist.playNext();
        playlist.playNext();
    }
}