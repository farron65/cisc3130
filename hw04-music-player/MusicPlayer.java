
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class Node {
    Song song;
    Node next;
    Node prev;

    public Node(Song song) {
        this.song = song;
        this.next = null;
        this.prev = null;
    }
}

public class MusicPlayer {
    Node head;
    Node tail;

    HashMap<String, Node> library;

    public MusicPlayer() {
        this.head = null;
        this.tail = null;
        this.library = new HashMap<>();
    }

    public boolean addSong(String id, String title, String artist) {
        if (this.library.containsKey(id)) {return false;}

        Node newNode = new Node(new Song(id, title, artist));
        if (this.head == null) {
            this.head = newNode;
            this.tail = this.head;
            
        } else {
            Node currentNode = this.tail;
            this.tail = newNode;
            this.tail.prev = currentNode;
            currentNode.next = this.tail;
            this.tail.next = null;
        }

        this.library.put(id, newNode);
        return true;
    }

    public Song findSong(String id) {
        Node node = this.library.get(id);
        if (node == null) {
            return null;
        }
        return node.song;
    }

    public List<String> showPlaylist() {
        List<String> songs = new ArrayList<String>();
        Node start = this.head;

        while (start != null) {
            songs.add(start.song.title);
            start = start.next;
        }

        return songs;
    }
}
