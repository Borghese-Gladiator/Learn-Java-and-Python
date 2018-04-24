import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class testLibrary {

	@Test
	public void testSearch() 
	{
		Library library = new Library();
		addToLibrary(library);
		library.setLibrary(SortSearch.inSort(library.getLibrary()));
		assertEquals(3, SortSearch.binarySearch(library.getLibrary(), "Zed", 0));
	}
	@Test
	public void testSort()
	{
		Library library = new Library();
		addToLibrary(library);
		library.setLibrary(SortSearch.inSort(library.getLibrary()));
		assertEquals("Abc", library.getBook(0).getTitle());
	}
	@Test
	public void testSort2()
	{
		Library library = new Library();
		addToLibrary(library);
		library.setLibrary(SortSearch.inSort(library.getLibrary()));
		Library library2 = new Library();
		addToLibrary(library2);
		Collections.sort(library2.getLibrary());
		assertEquals(library2, library);
	}
	private void addToLibrary(Library library) {
		library.addBook(new Book("Zed", "Person"));
		library.addBook(new Book("Abc", "Person"));
		library.addBook(new Book("B", "La"));
		library.addBook(new Book("Cat", "45"));
	}
	@Test
	public void testLoan()
	{
		Library library = new Library();
		addToLibrary(library);
		Date date = new Date(1, 1, 1);
		library.loan("Zed", "person", date);
		assertEquals(true, library.getBook(3).isBorrowed());
	}
	@Test
	public void testLoanError()
	{
		try
		{
			Library library = new Library();
			addToLibrary(library);
			if (library.inLibrary("Great"))
			{
				Date date = new Date(1, 1, 1);
				library.loan("Great", "Me", date);	
			}
		}
		catch(Exception e)
		{
			assertEquals("Great" + " is not added to the library", e.getMessage());
		}
	}
	@Test
	public void testLoanTwice()
	{
		try
		{
			Library library = new Library();
			addToLibrary(library);
			if (library.inLibrary("Zed"))
			{
				Date date = new Date(1, 1, 1);
				library.loan("Zed", "A Borrower", date);	
				library.loan("Zed", "A Borrower", date);
			}
		}
		catch(Exception e)
		{
			assertEquals("Zed" + " is out", e.getMessage());
		}
	}
	@Test
	public void testReturn()
	{
		Library library = new Library();
		addToLibrary(library);
		Date date = new Date(1, 1, 1);
		library.loan("Zed", "person", date);
		library.returnBook("Zed");
		assertEquals(false, library.getBook(1).isBorrowed());
	}
	@Test
	public void testReturnError()
	{
		try
		{
			Library library = new Library();
			addToLibrary(library);
			library.returnBook("Zed");
		}
		catch(Exception e)
		{
			assertEquals("Zed" + " is not out", e.getMessage());
		}
	}
	@Test
	public void testLeapYear()
	{
		Library library = new Library();
		addToLibrary(library);
		Date date = new Date(2016, 2, 29);
		library.loan("Zed", "A Guy", date);
	}
	@Test
	public void testLeapYearError()
	{
		try
		{
			Library library = new Library();
			addToLibrary(library);
			Date date = new Date(2017, 2, 29);
			library.loan("Zed", "A Guy", date);
		}
		catch (Exception e)
		{
			assertEquals("Enter a valid day", e.getMessage());
		}
	}
}