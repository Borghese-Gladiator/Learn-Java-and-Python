import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class ParserUnitTester 
{

	@Test
	public void testAddition()
	{
		Parser tester = new Parser("=42+42");
		assertEquals("84.0", tester.convertWord());
	}
	@Test
	public void testMultipleTerms()
	{
		Parser tester = new Parser("=1+2+3");
		assertEquals("6.0", tester.convertWord());
	}
	@Test
	public void testSpaceValid()
	{
		Parser tester = new Parser("=   5+   7");
		assertEquals("12.0", tester.convertWord());
	}
	@Test
	public void testSpaceInvalid()
	{
		try
		{
			Parser tester = new Parser("=5+- 2");
			tester.convertWord();
		}
		catch (Exception e)
		{
			assertEquals("Error: Cannot convert", e.getMessage());
		}
	}
	@Test
	public void testSpaceInvalid2()
	{
		try
		{
			Parser tester = new Parser("=5 6+72");
			tester.convertWord();
		}
		catch (Exception e)
		{
			assertEquals("Error: Cannot convert", e.getMessage());
		}
	}
	@Test
	public void testNegatives()
	{
		Parser tester = new Parser("=-42+42");
		assertEquals("0.0", tester.convertWord());
	}
	@Test
	public void testDecimals()
	{
		Parser tester = new Parser("=56+2.5");
		assertEquals("58.5", tester.convertWord());
	}
	@Test
	public void testOOP()
	{
		Parser tester = new Parser("=1*1+1*1+1*1");
		assertEquals("3.0", tester.convertWord());
	}
	@Test
	public void testMultiplication()
	{
		Parser tester = new Parser("=3*2");
		assertEquals("6.0", tester.convertWord());
	}
	@Test
	public void testMultiplication2()
	{
		Parser tester = new Parser("=33*2");
		assertEquals("66.0", tester.convertWord());
	}
	@Test
	public void testOOP2()
	{
		Parser tester = new Parser("=3 * 3 + 2 * 2");
		assertEquals("13.0", tester.convertWord());
	}
	@Test
	public void testError()
	{
		try
		{
			Parser tester = new Parser("=3 ** 3");
			tester.convertWord();
		}
		catch(Exception e)
		{
			assertEquals(e.getMessage(), "Error: Cannot convert");
		}
	}
	@Test
	public void testError2()
	{
		try
		{
			Parser tester = new Parser("=3**3");
			tester.convertWord();
		}
		catch(Exception e)
		{
			assertEquals(e.getMessage(), "Error: Cannot convert");
		}
	}
	@Test
	public void testDecimals3()
	{
		Parser tester = new Parser("=1.555+1.555");
		assertEquals("3.11", tester.convertWord());
	}
	@Test
	public void testStowe1()
	{
		Parser tester = new Parser("=27.2-45.15");
		assertEquals("-17.95", tester.convertWord());
	} 
	@Test
	public void testStowe2()
	{
		Parser tester = new Parser("=76*-7.1");
		assertEquals("-539.6", tester.convertWord());
	}
	@Test
	public void testStowe3()
	{
		Parser tester = new Parser("=-678.2--89.764");
		assertEquals("-588.436", tester.convertWord());
	}
}
