import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Library {

	public static void main(String[] args) {
		
		ArrayList<Book> books = new ArrayList<Book>();
		
		boolean done = false;
		boolean yesNo;
				
		String yesOrNo = "";
		Scanner keyboard = new Scanner(System.in);
		
		String title = "";
		String author = "";
		int copy;
		
		int count = 0;
		
		HashMap<String, Integer> titleCopies = new HashMap<String, Integer>();
		
		while (done == false) { 
			yesNo = false;
			copy = 1;
			
			System.out.println("Would you like to enter a new book? (yes or no)");
			yesOrNo = keyboard.nextLine().toLowerCase();		
				
			if (yesOrNo.equals("yes") || yesOrNo.equals("no")) {
				yesNo = true;
				if (yesOrNo.equals("no")) {
					done = true;
				}
			}
		
			while (yesNo == false) {
				System.out.println("Error. Please enter yes or no:");
				yesOrNo = keyboard.nextLine();
				
				if (yesOrNo.equals("yes") || yesOrNo.equals("no")) {
					yesNo = true;
					if (yesOrNo.equals("no")) {
						done = true;
					}
				}
			}
			
			if (yesOrNo.equals("yes")) {			
				
				count += 1;
				
				System.out.println("Enter the title of the book: ");
				title = keyboard.nextLine();
				
				System.out.println("Enter the author of the book: ");
				author = keyboard.nextLine();
				
				for (Book b : books) {
					if (b.getTitle().equals(title)) {
						copy = b.getCopies() + 1;
					}
				}
				
				titleCopies.put(title, copy);
				
				Book newBook = new Book(title, author, copy);
				
				books.add(newBook);
				
			}
				
		}
		
		System.out.println("\nHere are the books in the library: ");
		
		for (Book b : books) {
			System.out.println(books.toString());
		}

	}

}
