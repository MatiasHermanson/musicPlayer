package musicPlayer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

	private String name;
	private String artist;
	private ArrayList<Song> songs;
	
	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}
	
	public Album() {
		
	}
	
	public Song findSong(String name) {
		for(Song checkedSong : songs) {
			if(checkedSong.getName(). equals(name)) return checkedSong;
		}
		return null;
	}
	
	public boolean addSong(String name, double duration) {
		if(findSong(name) == null) {
			songs.add(new Song(name,duration));
			System.out.println(name + " succesfully added song to playlist");
			return true;
		}
		else {
			System.out.println("Song " + name + " already exist in list");
			return false;
		}
	}
	
	public boolean addToPlayList(int trackNumber, LinkedList<Song> PlayList) {
		int index = trackNumber -1;
		if(index > 0 && index <= this.songs.size()) {
			PlayList.add(this.songs.get(index));
			return true;
		}
		System.out.println("This album does not have song with track number " + trackNumber);
		return false;
	}
	
	public boolean addToPlayList(String name, LinkedList<Song>PlayList) {
		for(Song checkedSong : this.songs) {
			if(checkedSong.getName().equals(name)) {
				PlayList.add(checkedSong);
				return true;
			}
		}
		System.out.println(name + " there is no such song in the album");
		return false;
	}
}
