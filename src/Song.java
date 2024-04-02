public class Song {
    private String title;
    private double duration;
    private String artist;
    private String albumName;

    public Song(String title, String artist, double duration,String albumName) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.albumName = albumName;
    }
    public Song(){

    }

    public String getTitle() {return title;}

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", artist='" + artist + '\'' +
                ", albumName='" + albumName + '\'' +
                '}';
    }
}
