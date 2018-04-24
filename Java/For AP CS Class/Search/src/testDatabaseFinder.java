import static org.junit.Assert.*;

import org.junit.Test;

public class testDatabaseFinder {

	@Test
	public void testSearch() 
	{
		try
		{
			Database people = new Database();
			People person = new People("Charlie", 10);
			people.addPerson(person);
			int index = people.findPerson("Buck");
		}
		catch (Exception e)
		{
			assertEquals("404 Error: Buck not found", e.getMessage());
		}
	}
	@Test
	public void testSearchLarger() 
	{
		try
		{
			Database people = new Database();
			People person = new People("Charlie", 10);
			people.addPerson(person);
			People person2 = new People("Charlie2", 11);
			people.addPerson(person2);
			People person3 = new People("Charlie3", 12);
			people.addPerson(person3);
			int index = people.findPerson("Buck");
		}
		catch (Exception e)
		{
			assertEquals("404 Error: Buck not found", e.getMessage());
		}
	}
	@Test
	public void testPersonSuccess()
	{
		Database people = new Database();
		People person = new People("Incursio", 11);
		people.addPerson(person);
		int index = people.findPerson("Incursio");
		assertEquals(11, people.getPerson(index).getAge());
	}
	@Test
	public void testPersonSuccessLarger()
	{
		Database people = new Database();
		People person = new People("Incursio", 11);
		people.addPerson(person);
		People person1 = new People("Charlie", 10);
		people.addPerson(person1);
		People person2 = new People("Charlie2", 11);
		people.addPerson(person2);
		People person3 = new People("Charlie3", 12);
		people.addPerson(person3);
		int index = people.findPerson("Incursio");
		assertEquals(11, people.getPerson(index).getAge());
	}
	@Test
	public void testDeletePerson()
	{
		Database people = new Database();
		People person = new People("Charlie", 10);
		people.addPerson(person);
		People person2 = new People("Charlie2", 11);
		people.addPerson(person2);
		People person3 = new People("Charlie3", 12);
		people.addPerson(person3);
		int index = people.findPerson("Charlie");
		people.delete(index);
		assertEquals("Name: Charlie2" + '\n' + "Age: 11" + '\n' + '\n'+ "Name: Charlie3" + '\n' + "Age: 12" + '\n' + '\n', people.print());
	}
	@Test
	public void testDeleteMultiple()
	{
		Database people = new Database();
		People person = new People("Charlie", 10);
		people.addPerson(person);
		People person2 = new People("Charlie2", 11);
		people.addPerson(person2);
		People person3 = new People("Charlie3", 12);
		people.addPerson(person3);
		int index = people.findPerson("Charlie");
		people.delete(index);
		int index2 = people.findPerson("Charlie2");
		people.delete(index2);
		assertEquals("Name: Charlie3" + '\n' + "Age: 12" + '\n' + '\n', people.print());

	}
	@Test
	public void testStowe()
	{
		Database people = new Database();
		People person = new People("Jones, Jim", 28);
		people.addPerson(person);
		People person2 = new People("Abott, Sam", 31);
		people.addPerson(person2);
		People person3 = new People("Smith, Sue", 42);
		people.addPerson(person3);
		People person4 = new People("Duffy, Martin", 33);
		people.addPerson(person4);
		People person5 = new People("Town, Mary", 22);
		people.addPerson(person5);
		People person6 = new People("Adams, John", 300);
		people.addPerson(person6);
		People person7 = new People("Clinton, Hillary", 65);
		people.addPerson(person7);
		People person8 = new People("Rayburn, Sam", 55);
		people.addPerson(person8);
		People person9 = new People("Jones, Joe", 18);
		people.addPerson(person9);
		People person10 = new People("Adams, Abigail", 299);
		people.addPerson(person10);
		int index = people.findPerson("Adams, Abigail");
		people.delete(index);
		int index2 = people.findPerson("Town, Mary");
		people.delete(index2);
		assertEquals("Name: Charlie3" + '\n' + "Age: 12" + '\n' + '\n', people.print());

	}
}