import java.util.ArrayList;

public class Library
{
	//Holds all books
	private ArrayList<Book> library;
	//Initializes library object
	public Library()
	{
		library = new ArrayList<Book>();
	}
	//Adds book to library
	//@param a book
	public void addBook(Book book)
	{
		library.add(book);
	}
	//Checks if given book is in the library
	//@return if in library
	public boolean inLibrary(String title)
	{
		int beginIndex = 0;
		library = SortSearch.inSort(library);
		while (beginIndex != -1)
		{
			beginIndex = SortSearch.binarySearch(library, title, beginIndex);
			if (beginIndex != -1)
			{
				return true;
			}
		}
		return false;
	}
	//Changes a book's status to out, if in the library
	//@param title, borrower name, date borrowed
	public void loan(String title, String name, Date date)
	{
		int beginIndex = 0;
		library = SortSearch.inSort(library);
		while (beginIndex != -1)
		{
			beginIndex = SortSearch.binarySearch(library, title, beginIndex);
			if (beginIndex != -1)
			{
				if (!(library.get(beginIndex).isBorrowed()))
				{
					library.set(beginIndex, new Book(title, library.get(beginIndex).getAuthor(), name, date));
				}
				else
				{
					throw new IllegalArgumentException(title + " is out");
				}
				beginIndex++;
			}
		}
	}
	//Changes a book's status to in, if it was out of the library
	//@param title
	public void returnBook(String title)
	{
		int beginIndex = 0;
		library = SortSearch.inSort(library);
		while (beginIndex != -1)
		{
			beginIndex = SortSearch.binarySearch(library, title, beginIndex);
			if (beginIndex != -1)
			{
				if (library.get(beginIndex).isBorrowed())
				{
					library.set(beginIndex, new Book(title, library.get(beginIndex).getAuthor()));
				}
				else
				{
					throw new IllegalArgumentException(title + " is not out");
				}
				beginIndex++;
			}
		}
	}
	//Checks if one library object is equal to another
	//@return equal or not
	@Override
	public boolean equals(Object another)
	{
		boolean result = true;;
		for (int i = 0; i < library.size(); i++)
		{
			if (!(getBook(i).equals(((Library)another).getBook(i))))
			{
				result = false;
				break;
			}
		}
		return result;
	}
	//@returns book at given index
	public Book getBook(int index)
	{
		return library.get(index);
	}
	//Sets the library ArrayList in a Library object
	//@param new library ArrayList
	public void setLibrary(ArrayList<Book> library) {
		this.library = library;
	}
	//@return library ArrayList
	public ArrayList<Book> getLibrary() {
		return library;
	}
}