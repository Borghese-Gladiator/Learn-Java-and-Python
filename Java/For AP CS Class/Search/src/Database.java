public class Database 
{
	//Holds array of people
	private People[] people;
	//Holds logical size of people
	private int counter;
	//Initializes student database to 10 people
	public Database()
	{
		people = new People[20];
		counter = 0;
	}
	//Returns an individual at a given index
	public People getPerson(int index)
	{
		return people[index];
	}
	//Adds student to database
	//@param a person
	public void addPerson(People person)
	{
		//Error if more than 10 people
		if (counter > 10)
		{
			throw new IllegalArgumentException("There can only be 10 students");
		}
		//Error if same name has been entered
		/*if (search(person.getName(), 0, counter - 1) != -1)
		{
			throw new IllegalArgumentException("Duplicate name");
		}*/
		people[counter] = person;
		counter++;
	}
	//Outputs all people currently in database sorted by name
	//@return string containing people and their information
	public String print()
	{
		sort();
		String result = "";
		for (int i = 0; i < counter; i ++)
		{
			result += people[i].print() + '\n' + '\n';
		}
		return result;
	}
	//Deletes an individual from the array
	//@param index of person to be deleted
	public void delete(int index)
	{
		if (index < 0 || index > counter)
		{
			throw new IllegalArgumentException("Person not found");
		}
		//Moves individuals to fill gap
		for (int i = index; i < counter; i++)
		{
			people[i] = people[i + 1];
		}
		people[counter] = null;
		counter--;
	}
	//Searches database for person
	//@param name of person
	//@return index of person or error if person is not found
	public int findPerson(String name)
	{
		sort();
		int index = search(name, 0, counter);
		if (index == -1)
		{
			throw new IllegalArgumentException("404 Error: " + name + " not found");
		}
		return index;
	}
	public int findPerson2(String name)
	{
		int index = binarySearch(name);
		if (index == -1)
		{
			throw new IllegalArgumentException("404 Error: " + name + " not found");
		}
		return index;
	}
	public int findPerson3(String name)
	{
		int index = sequentialSearch(name);
		if (index == -1)
		{
			throw new IllegalArgumentException("404 Error: " + name + " not found");
		}
		return index;
	}
	//Searches person
	//@param name of person, begin of unsearched area, end of unsearched area
	//@return index of person
	private int search (String name, int begin, int end)
	{
		if (end >= begin)
		{
			int mid = (begin + (end - 1)) / 2;
			if (people[mid].getName().equals(name))
			{
				return mid;
			}
			else if (people[mid].getName().compareTo(name) < 0)
			{
				return search(name, mid + 1, end);
			}
			else
			{
				return search(name, begin, mid - 1);
			}
		}
		return -1;
	}
	private int binarySearch(String name)
	{
		int end = counter;
		int begin = 0;
		int mid;
		while (end >= begin)
		{
			mid =  begin + (end - 1) / 2;
			if (people[mid].getName().equals(name))
			{
				return mid;
			}
			else if (people[mid].getName().compareTo(name) < 0)
			{
				begin = mid + 1;
			}
			else
			{
				end = mid - 1;
			}
		}
		return -1;
	}
	//Searches person 
	//@param name of person
	//@return index of person
	private int sequentialSearch(String name)
	{
		for (int i = 0; i < counter; i++)
		{
			if (people[i].getName().equals(name))
			{
				return i;
			}
		}
		return -1;
	}
	//Sorts the array by either name or average
	//@param true = grade sort, false = name sort
	private void sort()
	{
		for (int i = 0; i < counter; i++)
		{
			int minIndex;
			minIndex = sortByName(i);
			if (minIndex != i)
			{
				swap(i, minIndex);
			}
		}
	}
	//Finds next person with a name later in the alphabet
	//@param the index of the previously switched person
	//@return index of person with name later in alphabet to switch with
	private int sortByName(int first)
	{
		int minIndex = first;
		for (int i = first + 1; i < counter; i++)
		{
			if ((people[i].getName()).compareTo((people[minIndex]).getName()) < 0)
			{
				minIndex = i;
			}
		}
		return minIndex;
	}
	//Swaps the positions of two people
	//@param index 1, index 2
	private void swap(int x, int y)
	{
		People temp = people[x];
		people[x] = people[y];
		people[y] = temp;
	}
}
