package Main;

import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Scanner;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

//import Songs.Album;
import Structures.*;

public class Home {

	public static Songs[] songValues() {

		Songs[] songData = new Songs[8];

		Songs s1 = new Songs("Perfect", "xyz", LocalDate.of(2017, 1, 13));
		Songs s2 = new Songs("Shape Of You", "pqr", LocalDate.of(2017, 1, 13));
		Songs s3 = new Songs("Love Story", "abc", LocalDate.of(2017, 1, 13));
		Songs s4 = new Songs("You Belong With Me", "def", LocalDate.of(2017, 1, 13));
		Songs s5 = new Songs("Channa Mereya", "Ae Dil Hai mushkil", LocalDate.of(2017, 1, 13));
		Songs s6 = new Songs("Tujhe Kitna Chahane Lage ham", "kabir Singh", LocalDate.of(2017, 1, 13));
		Songs s7 = new Songs("Numb", "ghi", LocalDate.of(2017, 1, 13));
		Songs s8 = new Songs("In the end", "jkl", LocalDate.of(2017, 1, 13));

		songData[0] = s1;
		songData[1] = s2;
		songData[2] = s3;
		songData[3] = s4;
		songData[4] = s5;
		songData[5] = s6;
		songData[6] = s7;
		songData[7] = s8;

		return songData;
	}

	public static void showAllLibraries(ArrayList<Library> library) {
			
		for(int i=0;i<2;i++)
		System.out.println((library.get(i)).getLibrary());
	}
////
//	static void showAllAlbums(ArrayList<Library> libList) {
//		for(int i = 0; i < 3; i++) {
//				libList.get(i).displayAlbums();
//		}
//	}
////
//	public static void showAllSongs(ArrayList<Library> library) {
//
//	}
//
//	public static void showLibrary(ArrayList<Object> library) {
//
//	}
//
//	public static void showAlbum(ArrayList<Object> album) {
//
//	}
//
//	public static void showSong(ArrayList<Object> songs) {
//
//	}

	public static ArrayList<Library> createData() {

		Songs songData[] = songValues();
		ArrayList<Library> libraryList = libraryValues(albumValues(songData));
		return libraryList;

	}

	public static ArrayList<Album> albumValues(Songs[] songData) {
		ArrayList<Album> result = new ArrayList<>();
		// TODO Auto-generated method stub
		for (int i = 0; i < 8; i++) {
			Album a1 = new Album("Album" + (i + 1));
			a1.songs.add(songData[i]);
			i += 1;
			a1.songs.add(songData[i]);
			result.add(a1);
		}

		return result;
	}

	public static ArrayList<Library> libraryValues(ArrayList<Album> albums) {
		ArrayList<Library> result = new ArrayList<>();
		// TODO Auto-generated method stub
		for (int i = 0; i < 4; i++) {
			Library l = new Library("Library" + (i + 1));
			l.albums.add(albums.get(i));
			i++;
			l.albums.add(albums.get(i));
			result.add(l);
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("00:All Libraries\n01:Library 1\n02:Library 2\nEnter your choice::");

		ArrayList<Library> library = createData();

		Scanner sc = new Scanner(System.in); // creating and initializing the Scanner class for getting user data

		String choice = sc.nextLine(); // taking user choice

		switch (choice) {
		case "00":
			showAllLibraries(library);
			break;
		case "01":
			System.out.println(library.get(0));
			break;
		case "02":
			System.out.println(library.get(1));
			break;
		
		default:
			System.out.println("Invalid Choice,try again");
			break;
		}

	}
}
