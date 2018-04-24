public class People 
{
	//Holds name of individual
	private String name;
	//Holds age of individual
	private int age;
	//Initializes individual with name and age
	//@param name, age
	public People(String aName, int aAge)
	{
		if (aName.isEmpty())
		{
			throw new IllegalArgumentException("Name cannot be blank");
		}
		if (aAge < 0)
		{
			throw new IllegalArgumentException("Age must be positive");
		}
		name = aName;
		age = aAge;
	}
	//Outputs individual's information
	//@return individual's information
	public String print()
	{
		return "Name: " + name + '\n' + "Age: " + age;
	}
	//@return name
	public String getName() {
		return name;
	}
	//@return age
	public int getAge() {
		return age;
	}
	//@param name
	public void setName(String name) {
		this.name = name;
	}
	//@param age
	public void setAge(int age) {
		this.age = age;
	}
}
