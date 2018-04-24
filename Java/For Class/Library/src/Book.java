public class Book extends Item
{
	//Holds author of this book
	private String author;
	//Error check author
	//@param title, author
	public static void errorCheckBook(String aTitle, String aAuthor)
	{
		errorCheckItem(aTitle);
		if (aAuthor == null || aAuthor.isEmpty())
		{
			throw new IllegalArgumentException("Author cannot be blank");
		}
	}
	//Initializes Book object
	//@param title, author
	public Book(String aTitle, String aAuthor)
	{
		super(aTitle);
		author = aAuthor;
	}
	//Assembles book information
	//@return book information
	public String print()
	{
		String result = "Title: " + getTitle() + '\n';
		result += "Author: " + author + '\n';
		return result;
	}
	//Compares this book with inputted book
	//@param inputted book
	//@return position of inputted book compared to this book(alphabetical order)
	@Override
	public int compareTo(Object x)
	{
		if (!(x instanceof Book))
		{
			throw new IllegalArgumentException(getTitle() + " is not of the same type");
		}
		return author.compareTo(((Book)x).getAuthor());
	}
	//Accessor method
	//@return author
	public String getAuthor() {
		return author;
	}
	//Mutator method
	//@param author
	public void setAuthor(String author) {
		this.author = author;
	}
}
