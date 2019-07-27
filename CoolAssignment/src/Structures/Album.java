package Structures;

import java.util.ArrayList;

public class Album implements Comparable {

	public ArrayList<Songs> songs = new ArrayList<Songs>();

	private String albumName;

	public Album(String albumName) {
		this.albumName = albumName;
	}

	public String getAlbumName() {
		return albumName;
	}
	
	
	/*
	 * showing all albums
	 */

	public static void showAllAlbums(ArrayList<Album> albums) {

		for (int i = 0; i < 4; i++)
			System.out.println((albums.get(i)).toString());

	}

	/*
	 * showing songs of a specific album
	 */
	public static void showAlbums(ArrayList<Album> albums, int choice) {

		System.out.println((albums.get(choice - 1).toString()));
	}

	@Override
	public String toString() {
		return "Album [albumName=" + albumName + ", song = " + songs + "]";
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
