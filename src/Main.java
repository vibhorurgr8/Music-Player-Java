import java.sql.SQLOutput;
import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Album1","AC/DC");

        album.addSong("TNT",4.5);
        album.addSong("Highway to hell",3.5);
        album.addSong("ThunderStruck",5.0);
        albums.add(album);

        album = new Album("Album2","Eminem");

        album.addSong("Rap god",4.5);
        album.addSong("Not Afraid",3.5);
        album.addSong("Lose yourself",4.5);

        albums.add(album);

        album = new Album("Udaan","Amit Trivedi");

        album.addSong("Kahaani",3.27);
        album.addSong("Geet me dhalte lafzon mein",4.55);
        album.addSong("Aazadiyaan",5.38);
        album.addSong("Udaan",4.24);
        album.addSong("Naav",4.12);

        albums.add(album);

        LinkedList<Song> EDM = new LinkedList<>();

        albums.get(0).addToPlayList("TNT",EDM);
        albums.get(0).addToPlayList("Highway to hell",EDM);
        albums.get(1).addToPlayList("Rap god",EDM);
        albums.get(1).addToPlayList("Lose yourself",EDM);

        LinkedList<Song> Fav = new LinkedList<>();
        albums.get(2).addToPlayList("Kahaani",Fav);
        albums.get(2).addToPlayList("Geet me dhalte lafzon mein",Fav);
        albums.get(2).addToPlayList("Aazadiyaan",Fav);
        albums.get(2).addToPlayList("Udaan",Fav);

        double dur=0;

        System.out.println("Choose the playlist to be played.\nPress the serial number of the playlist to play.");
        System.out.println("Playlists:\n1. EDM\n2. Fav");
        Scanner sc = new Scanner(System.in);
        int action = sc.nextInt();
        switch (action){
            case 1:
                for(Song s: EDM){
                    dur+=s.getDuration();
                }
                System.out.println("Playlist name: EDM");
                System.out.printf("Playlist duration: %.2f min\n", dur);
                play(EDM);
                break;
            case 2:
                for(Song s: Fav){
                    dur+=s.getDuration();
                }
                System.out.println("Playlist name: Fav");
                System.out.printf("Playlist duration: %.2f min", dur);
                play(Fav);
                break;
            default:
                System.out.println("Enter a valid number");
        }

    }


    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();


        if(playList.size() == 0){
            System.out.println("This playlist have no song");
        }else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){

                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }else {
                        System.out.println("no song availble, reached to the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }else {
                        System.out.println("This is the first song");
                        forward = false;
                    }
                    break;

                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("we are at the start of the playlist");
                        }
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("we have reached to the end of playlist");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious()) {
                                System.out.println("now playing "+listIterator.previous().toString());
                            }
                        }
                    }
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs \n"+
                "5 - print all available options\n"+
                "6 - delete current song");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("-----------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("-----------------");
    }

}
