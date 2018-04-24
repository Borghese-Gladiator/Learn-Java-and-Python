import java.util.ArrayList;

public class InformationAssembler 
{
	//Outputs all information in library
	//@param a library
	//@return all information in library
	public String outputAll(Library library)
	{
		String result = "All books\nTitle                    | Author\n\n";
		library.setLibrary(SortSearch.inSort(library.getLibrary()));
		for (int i = 0; i < library.getLibrary().size(); i++)
		{
			result += library.getBook(i).output() + '\n';
		}
		return result;
	}
	//Outputs all books borrowed in library
	//@param a library
	//@return all books borrowed in library
	public String outputBorrowed(Library library)
	{
		String result = "Borrowed Books\nTitle\n\n";
		library.setLibrary(SortSearch.inSort(library.getLibrary()));
		for (int i = 0; i < library.getLibrary().size(); i++)
		{
			if (library.getBook(i).isBorrowed())
			{
				result += library.getBook(i).getTitle() + '\n';
			}
		}
		if (result.equals("Borrowed Books\nTitle\n\n"))
		{
			result = "No borrowed books";
		}
		return result;
	}
	//Outputs all late books out of library
	//@param a library
	//@return all late books out of library
	public String outputLate(Library library, Date date)
	{
		String result = "Late Books\nTitle\n\n";
		library.setLibrary(SortSearch.inSort(library.getLibrary()));
		for (int i = 0; i < library.getLibrary().size(); i++)
		{
			if (library.getBook(i).isLate(date))
			{
				result += library.getBook(i).getTitle() + '\n';
			}
		}
		if (result.equals("Late Books\nTitle\n\n"))
		{
			result = "No late books";
		}
		return result;
	}
	
}
