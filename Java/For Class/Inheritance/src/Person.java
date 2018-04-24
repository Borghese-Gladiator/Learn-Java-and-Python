public class Person 
{
	//Holds name of this person
	private String name;
	//Error check name
	//@param name of person
	public static void errorCheckName(String aName)
	{
		if (aName == null || aName.isEmpty())
		{
			throw new IllegalArgumentException("No name entered");
		}
	}
	//Initializes Person object
	//@param name of Person
	public Person(String aName)
	{
		name = aName;
	}
	//Assemble person information
	//@return person information
	public String print()
	{
		String result = "Name: " + name + '\n';
		return result;
	}
	//Assemble equivalence information between inputted person and this person
	//Inheritance allows for this person to be an undergraduate or graduate
	//@param inputted person
	public String findUndergradOrGrad(Person person)
	{
		String result = "";
		try
		{
			if (this.equals(person))
			{
				result += person.getName() + " is equal to " + getName() + '\n';
			}
			else
			{
				result += person.getName() + " is not equal to " + getName() + '\n';
			}
		}
		catch (Exception e)
		{
			result += e.getMessage() + '\n';
		}
		return result;
	}
	//Accessor method
	//@return name
	public String getName() {
		return name;
	}
}