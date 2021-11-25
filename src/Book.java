import java.io.*;

public class Book implements Serializable {
	private String title;
	private String author;
	private int copies;

	public String getTitle() {
		return title;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int c) {
		copies = c;
	}

	public Book(String t, String a, int c) {
		title = t;
		author = a;
		copies = c;
	}

	public String toString() {
		return title + " " + author + " " + copies;
	}
}
