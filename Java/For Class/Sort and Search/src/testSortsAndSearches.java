import static org.junit.Assert.*;

import org.junit.Test;

public class testSortsAndSearches {

	@Test
	public void testInSort()
	{
		Database items = new Database();
		Comparable item1 = new Employee("Town, Mary", 33);
		items.add(item1);
		Comparable emp1 = new Employee("Jerry, Fuck you", 42);
		items.add(emp1);
		Comparable emp2 = new Employee("Jerry2, Fuck you2", 11);
		items.add(emp2);
		Comparable item2 = new Widget("309", 33);
		items.add(item2);
		Comparable item3 = new Student("Bill", 3.1);
		items.add(item3);
		assertEquals("", items.output(true, "Employee"));
	}
	/*
	 
	@Test
	public void testSeSort() 
	{
		Database items = new Database();
		Comparable item1 = new Employee("Town, Mary", 33);
		items.add(item1);
		Comparable item2 = new Widget(309, 33);
		items.add(item2);
		Comparable item3 = new Student("Bill", 3.1);
		items.add(item3);
		assertEquals("", items.output(false));
	}
	@Test
	public void testInSort()
	{
		Database items = new Database();
		Comparable item1 = new Employee("Town, Mary", 33);
		items.add(item1);
		Comparable item2 = new Widget(309, 33);
		items.add(item2);
		Comparable item3 = new Student("Bill", 3.1);
		items.add(item3);
		assertEquals("", items.output(true));
	}
	@Test
	public void testBiSearch()
	{
		try
		{
			Database items = new Database();
			Comparable item1 = new Employee("Town, Mary", 33);
			items.add(item1);
			Comparable item2 = new Widget(309, 33);
			items.add(item2);
			Comparable item3 = new Student("Bill", 3.1);
			items.add(item3);
			Comparable target = new Employee("A person", 33);//Not names
			assertEquals("", items.search(true, target));
		}
		catch(Exception e)
		{
		}
	}
	@Test
	public void testBiSearchFail()
	{
		try
		{
			Database items = new Database();
			Comparable item1 = new Employee("Town, Mary", 33);
			items.add(item1);
			Comparable item2 = new Widget(309, 33);
			items.add(item2);
			Comparable item3 = new Student("Bill", 3.1);
			items.add(item3);
			Comparable target = new Employee("A person", 31); //Checks ages
			String result = items.search(true, target);//Should pass an error
			fail();
		}
		catch(Exception e)
		{
			assertEquals("404 Error", e.getMessage());
		}
	}
	@Test
	public void testBiSearchMulIndice()
	{
		Database items = new Database();
		Comparable item1 = new Employee("Town, Mary", 33);
		items.add(item1);
		Comparable item2 = new Widget(309, 33);
		items.add(item2);
		Comparable item3 = new Student("Bill", 3.1);
		items.add(item3);
		Comparable item4 = new Employee("Another guy", 33);
		items.add(item4);
		Comparable target = new Employee("What", 33);
		assertEquals("", items.search(true, target));
	}
	@Test
	public void testSeSearch()
	{
		Database items = new Database();
		Comparable item1 = new Employee("Town, Mary", 33);
		items.add(item1);
		Comparable item2 = new Widget(309, 33);
		items.add(item2);
		Comparable item3 = new Student("Bill", 3.1);
		items.add(item3);
		Comparable target = new Employee("What", 33);
		assertEquals("", items.search(false, target));
	}
	@Test
	public void testSeSearchFail()
	{
		try
		{
			Database items = new Database();
			Comparable item1 = new Employee("Town, Mary", 33);
			items.add(item1);
			Comparable item2 = new Widget(309, 33);
			items.add(item2);
			Comparable item3 = new Student("Bill", 3.1);
			items.add(item3);
			Comparable target = new Employee("What", 31); //Checks ages
			String result = items.search(false, target);
			fail();
		}
		catch(Exception e)
		{
			assertEquals("404 Error", e.getMessage());
		}
	}
	@Test
	public void testSeSearchMulIndice()
	{
		Database items = new Database();
		Comparable item1 = new Employee("Town, Mary", 33);
		items.add(item1);
		Comparable item2 = new Widget(309, 33);
		items.add(item2);
		Comparable item3 = new Student("Bill", 3.1);
		items.add(item3);
		Comparable item4 = new Employee("Another guy", 33);
		items.add(item4);
		Comparable target = new Employee("What", 33);
		assertEquals("", items.search(false, target));
	}
	* 
	 */
}