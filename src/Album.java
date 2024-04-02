import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private int numOfSongs;
    private double totalDuration;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public Song findSong(String title){

        for(Song checkedSong : songs){
            if(checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }

    public void addSong(String title, double duration){
        if(findSong(title) == null){
            songs.add(new Song(title,artist,duration, name));
//            System.out.println(title + "successfully added to the list");
        }
        else {
//            System.out.println("Song with name "+ title+ " already exist in the list");
        }
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> PlayList){
        int index = trackNumber - 1;
        if(index > 0 && index <= this.songs.size()){
            PlayList.add(this.songs.get(index));
            return true;
        }
//        System.out.println("this album does not have song with trackNumber "+trackNumber);
        return false;
    }

    public void addToPlayList(String title, LinkedList<Song> PlayList){
        for(Song checkedSong : this.songs){
            if (checkedSong.getTitle().equals(title)){
                PlayList.add(checkedSong);
                return;
            }
        }
//        System.out.println(title + "there is no such song in album");
    }
    public double getTotalDuration(){
        double res = 0;
        for(Song s: songs){
            res+=s.getDuration();
        }
        return res;
    }
    public int getNumOfSongs(){
        int numOfSongs=0;
        for(Song s: songs){
            numOfSongs+=1;
        }
        return numOfSongs;
    }
}
