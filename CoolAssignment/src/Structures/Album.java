package Structures;

import java.util.ArrayList;

public class Album implements Comparable{

	public ArrayList<Songs> songs = new ArrayList<Songs>();
	
	
	private String albumName;
	
	public Album(String albumName) {
		this.albumName = albumName;
	}
	
	public String getAlbumName() {
		return albumName;
	}

	@Override
	public String toString() {
		return "Album [songs=" + songs + ", albumName=" + albumName + "]";
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	@Override
	public int compareTo(Object album) {
		// TODO Auto-generated method stub
		return 0;
	}

}
