
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


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

    Song currentSong;
    Map<String, Integer> playsCount;

    Stack<Song> history;

    Deque<Song> upNext;

    public MusicPlayer() {
        this.head = null;
        this.tail = null;

        this.library = new HashMap<>();

        this.currentSong = null;

        this.playsCount = new HashMap<>();
        this.history = null;

        this.upNext = new ArrayDeque<>();
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

    private void startSong(Song song) {
        this.playsCount.put(song.id, this.playsCount.getOrDefault(song.id, 0) + 1);
        this.currentSong = song;
    }

    public Song play(String id) {
        if (!this.library.containsKey(id)) {return null;}
        Node song = this.library.get(id);

        if (this.currentSong != null) {
            this.history.push(this.currentSong);
        }
       
        startSong(song.song);
        return this.currentSong;
    }

    public int playCount(String id) {
        return (this.playsCount.get(id) != null) ? this.playsCount.get(id) : 0;
    }

    public boolean queueLater(String id) {
        Node song = this.library.get(id);
        if (song == null) {return false;}

        upNext.addLast(song.song);
        return true;
    }

    public boolean queueNext(String id) {
        Node song = this.library.get(id);
        if (song == null) {return false;}

        upNext.addFirst(song.song);
        return true;
    }

    public List<String> showUpNext() {
        List<String> listOfTitles = new ArrayList<>();
        for (Song song: upNext) {
            listOfTitles.add(song.title);
        }
        return listOfTitles;
    }
}
