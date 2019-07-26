package Structures;

import java.util.ArrayList;

public class Library implements Comparable{
	
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

	public ArrayList<Album> albums = new ArrayList<Album>();

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
