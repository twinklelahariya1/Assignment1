package Structures;

import java.util.ArrayList;
import java.util.Scanner;

public class Library implements Comparable {

	private String libraryName;

	public Library(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getLibrary() {
		return libraryName;
	}

	public void setLibrary(String libraryName) {
		this.libraryName = libraryName;
	}

	public static ArrayList<Album> albums = new ArrayList<Album>();

	/*
	 * showing all libraries
	 */
	public static void showAllLibraries(ArrayList<Library> library) {

		for (int i = 0; i < 2; i++)
			System.out.println((library.get(i)).toString());

	}
	/*
	 * showing specific library and shifting control to album class
	 */
	public static void showLibraries(ArrayList<Library> library, int choice) {

		System.out.println((library.get(choice - 1).toString()));

		System.out.println("00:All Albums\n01:Album 1\n02:Album 2\nEnter your choice::");
		Scanner sc = new Scanner(System.in); // creating and initializing the Scanner class for getting user data

		int choice1 = sc.nextInt(); // taking user choice

		if (choice1 == 0) {
			Album.showAllAlbums(albums);
		} else if (choice1 == 1 || choice1 == 2) {
			Album.showAlbums(albums, choice1);
		}

	}

	@Override
	public int compareTo(Object Library) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Library [libraryName=" + libraryName + ", albums=" + albums + "]";
	}

}
