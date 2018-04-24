public class Database 
{
	//Array max size is 10
	private static final int MAX_SIZE = 10;
	//Hold entered people
	private Person[] people;
	//Hold Number of people in database
	private int count;
	//Initialize database to have a max of 10 people
	public Database()
	{
		people = new Person[MAX_SIZE];
		count = 0;
	}
	//Add given person to database
	//@param any Person object (includes Student, Undergraduate, and Graduate)
	public void addPerson(Person person)
	{	
		if (count == people.length)
			increasePeopleLength();
		people[count] = person;
		count++;
	}
	//Assemble information of every person in database
	//@return information of every person in database
	public String assemblePeople()
	{
		String result = "People" + '\n'+ '\n';
		for (int i = 0; i < count; i++)
		{
			result += people[i].print() + '\n';
		}
		return result;
	}
	//Assemble information of every Student in database
	//@return information of every Student in database
	public String assembleStudents()
	{
		String result = "Students" + '\n'+ '\n';
		for (int i = 0; i < count; i++)
		{
			if (people[i] instanceof Student)
			{
				result += people[i].print() + '\n';
			}
		}
		return result;
	}
	//Assemble information of every Undergraduate in database
	//@return information of every Undergraduate in database
	public String assembleUndergraduates()
	{
		String result = "Undergraduates" + '\n'+ '\n';
		for (int i = 0; i < count; i++)
		{
			if (people[i] instanceof Undergraduate)
			{
				result += people[i].print() + '\n';
			}
		}
		return result;
	}
	//Assemble information of every Graduate in database
	//@return information of every Graduate in database
	public String assembleGraduates()
	{
		String result = "Graduates" + '\n'+ '\n';
		for (int i = 0; i < count; i++)
		{
			if (people[i] instanceof Graduate)
			{
				result += people[i].print() + '\n';
			}
		}
		return result;
	}
	//Assemble information of multiple equivalence comparisons between inputted person
	// and every person in database
	//@param inputted person, which group they are in (grad = "major" undergrad = "grade")
	//@return equivalence comparisons of inputted person with every person in database
	public String findCollegeStudent(Person person, String group)
	{
		String result = "Found who is in the same " + group + " as " + person.getName() +'\n' + '\n';
		for (int i = 0; i < count; i++)
		{
			result += person.findUndergradOrGrad(people[i]);
		}
		return result;
	}
	//Increases the length of the array by 10
	private void increasePeopleLength()
	{
		Person[] newArray = new Person[people.length + MAX_SIZE];
		for (int i = 0; i < count; i++)
		{
			newArray[i] = people[i];
		}
		people = newArray;
	}
	//Resets database
	public void reset()
	{
		count = 0;
	}
}