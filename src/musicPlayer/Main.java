package musicPlayer;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("HALF GEMINI","916frosty");

        album.addSong("mr. valentine",3.40);
        album.addSong("to the west!",5.01);
        album.addSong("a night in brooklyn",3.21);
        album.addSong("half gemini",3.17);
        album.addSong("forever",3.21);
        album.addSong("soldiercomehome.wav - bonus track",2.17);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();
        
        albums.get(0).addToPlayList("mr. valentine",playList_1);
        albums.get(0).addToPlayList("to the west!",playList_1);
        albums.get(0).addToPlayList("a night in brooklyn",playList_1);
        albums.get(0).addToPlayList("half gemini",playList_1);
        albums.get(0).addToPlayList("forever",playList_1);
        albums.get(0).addToPlayList("soldiercomehome.wav - bonus track",playList_1);
       
       

        play(playList_1);

    }

    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("This playlist has no songs");
        }else {
            System.out.println("\nNow playing " + listIterator.next().toString()+"\n");
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
                        System.out.println("no song availble, reached to the end of  playlist");
                        forward = false;
                    }
                    System.out.println();
                    printMenu();
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
                        System.out.println("You cannot play previous song, you are currently listening to first song of playlist");
                        forward = false;
                    }
                    System.out.println();
                    printMenu();
                    break;

                case 3:
                    printList(playList);
                    System.out.println();
                    printMenu();
                    break;
              
                case 4:
                    if (playList.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                        	System.out.println("song deleted from playlist");
                            System.out.println("now playing "+listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious())
                            System.out.println("no songs left to delete");
                        }
                    }
                    System.out.println();
                    printMenu();
            }
        }
    }

    public static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - list of all songs \n"+
                "4 - delete current song");
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