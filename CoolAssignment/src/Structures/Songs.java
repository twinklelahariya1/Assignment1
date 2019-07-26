package Structures;

import java.time.LocalDate;

public class Songs implements Comparable{

	private String author;
	private String movieName;
	private LocalDate date;
	
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	
	public Songs(String author, String movieName, LocalDate date) {
	
		this.author = author;
		this.movieName = movieName;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Songs [author=" + author + ", movieName=" + movieName + ", date=" + date + "]";
	}
	@Override
	public int compareTo(Object songs) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
