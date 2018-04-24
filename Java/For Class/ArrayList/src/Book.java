import BreezySwing.Format;

public class Book implements Comparable
{
	//Holds Title
	private String title;
	//Holds author
	private String author;
	//if borroweed
	private boolean isBorrowed;
	//name of borrower
	private String borrower;
	//date borrowed
	private Date date;
	//Initializes Book object
	//@param title, author
	public Book(String title, String author)
	{
		this.title = title;
		this.author = author;
		isBorrowed = false;
		borrower = null;
		date = null;
	}
	//Initializes Book Object
	//@param title, author, borrower name, date
	public Book(String title, String author, String name, Date date)
	{
		isBorrowed = true;
		this.title = title;
		this.author = author;
		this.borrower = name;
		this.date = date;
	}
	//Compares book object to another book
	//@return difference between titles
	@Override
	public int compareTo(Object book)
	{
		return getTitle().compareTo(((Book)book).getTitle());
	}
	//Finds if a book has the same title as another
	//@return same title or not
	@Override
	public boolean equals(Object book)
	{
		return getTitle().equals(((Book)book).getTitle());
	}
	//Finds if book is late
	//@return late or not
	public boolean isLate(Date date)
	{
		return this.date.twoWeeksLate(date);
	}
	//Returns book to library
	public void returnBook()
	{
		borrower = null;
		date = null;
	}
	//Output's book information
	//@return book information
	public String output()
	{
		return Format.justify('l', title, 25) + "| " + author;
	}
	//@return is borrowed
	public boolean isBorrowed() {
		return isBorrowed;
	}
	//@return title
	public String getTitle() {
		return title;
	}
	//@return author
	public String getAuthor() {
		return author;
	}
}
