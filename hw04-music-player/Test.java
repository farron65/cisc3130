public class Test {
    static String t(Song s) {
        return s == null ? "null" : s.title;
    }

    public static void main(String[] args) {
        MusicPlayer p = new MusicPlayer();

        System.out.println("--- 1. Build the playlist ---");
        System.out.println(p.addSong("s1", "Night Drive", "A"));
        System.out.println(p.addSong("s2", "Slow Tide", "B"));
        System.out.println(p.addSong("s3", "Copper Sky", "C"));
        System.out.println(p.addSong("s4", "Static Bloom", "D"));
        System.out.println(p.addSong("s5", "Low Orbit", "E"));
        System.out.println(p.addSong("s6", "Glass Rivers", "F"));
        System.out.println("duplicate s3: " + p.addSong("s3", "Dup", "X"));
        System.out.println("playlist: " + p.showPlaylist());

        System.out.println("--- 2. Look up songs ---");
        System.out.println("find s4: " + t(p.findSong("s4")));
        System.out.println("find s9: " + t(p.findSong("s9")));

        System.out.println("--- 3. Play and move forward ---");
        System.out.println("play s1: " + t(p.play("s1")));
        System.out.println("play s9: " + t(p.play("s9")));
        System.out.println("next: " + t(p.next()));
        System.out.println("next: " + t(p.next()));
        System.out.println("history: " + p.showHistory());

        System.out.println("--- 4. Up next ---");
        System.out.println(p.queueLater("s5"));
        System.out.println(p.queueLater("s6"));
        System.out.println(p.queueNext("s1"));
        System.out.println("queue s9: " + p.queueLater("s9"));
        System.out.println("up next: " + p.showUpNext());
        System.out.println("next: " + t(p.next()));
        System.out.println("now playing: " + t(p.nowPlaying()));
        System.out.println("history: " + p.showHistory());

        System.out.println("--- 5. Back button ---");
        System.out.println("back: " + t(p.back()));
        System.out.println("up next: " + p.showUpNext());
        System.out.println("history: " + p.showHistory());

        System.out.println("--- 6. Remove songs ---");
        System.out.println("remove s5: " + p.removeSong("s5"));
        System.out.println("remove current (s3): " + p.removeSong("s3"));
        System.out.println("remove s9: " + p.removeSong("s9"));
        System.out.println("playlist: " + p.showPlaylist());
        System.out.println("up next: " + p.showUpNext());

        System.out.println("--- 7. Removed songs are skipped ---");
        System.out.println("next: " + t(p.next()));
        System.out.println("next: " + t(p.next()));
        System.out.println("next at end: " + t(p.next()));
        System.out.println("now playing: " + t(p.nowPlaying()));
        System.out.println("back: " + t(p.back()));
        System.out.println("up next: " + p.showUpNext());

        System.out.println("--- 8. Play counts ---");
        System.out.println("s1: " + p.playCount("s1"));
        System.out.println("s3: " + p.playCount("s3"));
        System.out.println("s6: " + p.playCount("s6"));
        System.out.println("s5 (removed): " + p.playCount("s5"));

        System.out.println("--- 9. Empty player ---");
        MusicPlayer e = new MusicPlayer();
        System.out.println("next: " + t(e.next()));
        System.out.println("back: " + t(e.back()));
        System.out.println("now playing: " + t(e.nowPlaying()));
        System.out.println("playlist: " + e.showPlaylist());
    }
}