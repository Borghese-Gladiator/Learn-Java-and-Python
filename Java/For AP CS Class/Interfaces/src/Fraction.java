public class Fraction implements Number
{
	//This is public to help the extra credit work more easily without excessive method calls
	//(originally private prior to extra credit)
	//Holds numerator of Fraction
	public int num;
	//Holds denominator of Fraction
	private int den;
	//Initializes Fraction object
	//@param numerator, denominator
	public Fraction(int aNum, int aDen)
	{
		//Error check denominator
		if (aDen == 0)
		{
			throw new IllegalArgumentException("A denominator is 0");
		}
		num = aNum;
		den = aDen;
	}
	//Adds this fraction to passed in fraction
	//@param fraction2
	//@return a third fraction equal to the sum of the two fractions
	public Number add(Number number)
	{
		checkIfFraction(number);
		int numerator = num * ((Fraction)number).den + den * ((Fraction)number).num;
		int denominator = den * ((Fraction)number).den;
		Fraction result = new Fraction(numerator, denominator);
		return result;
	}
	//Subtracts passed in fraction from this fraction
	//@param fraction2
	//@return a third fraction equal to the difference of the two fractions
	public Number subtract(Number number)
	{
		((Fraction)number).num *= -1;
		return add(number);
	}
	//Multiplies this fraction by passed in fraction
	//@param fraction2
	//@return a third fraction equal to the product of the two fractions
	public Number multiply(Number number)
	{
		checkIfFraction(number);
		int numerator = num * ((Fraction)number).num;
		int denominator = den * ((Fraction)number).den;
		Fraction result = new Fraction(numerator, denominator);
		return result;
	}
	//Divides this fraction by passed in fraction
	//@param fraction2
	//@return a third fraction equal to the quotient of the two fractions
	public Number divide(Number number)
	{
		number = reciprocal(number);
		return multiply(number);
	}
	//Finds the reciprocal of a passed in fraction
	//@param passed in fraction
	//@return reciprocal
	private Number reciprocal(Number number)
	{
		int temp = ((Fraction)number).num;
		((Fraction)number).num = ((Fraction)number).den;
		((Fraction)number).den = temp;
		if (temp == 0)
		{
			throw new IllegalArgumentException("Invalid division. Numerator is 0");
		}
		return number;
	}
	//Squares this fraction
	//@return the squared version of this fraction
	public Number square() 
	{
		num *= num;
		den *= den;
		return new Fraction(num, den);
	}
	//Error check passed in value is a fraction
	//@param given "number" (can be fraction or complex number)
	private void checkIfFraction(Number number)
	{
		if (!(number instanceof Fraction))
		{
			throw new IllegalArgumentException("Not a Fraction");
		}
	}
	//Simplifies this fraction and then assembles fraction information
	//@return fraction information
	@Override
	public String toString()
	{
		if (num != 0)
			reduce();
		String result = "";
		if (den == 1)
		{
			result += num;
		}
		else if (num == 0)
		{
			result += 0;
		}
		else
		{
			result += num + "  /  " + den;
		}
		return result;
	}
	//Simplifies this fraction
	private void reduce()
	{
		int GCF = findGCF();
		num /= GCF;
		den /= GCF;
	}
	//Finds greatest common factor
	//@return GCF
	private int findGCF()
	{
		int GCF = findSmaller();
		for (int i = GCF; i > 1; i--)
		{
			if (num % i == 0 && den % i == 0)
			{
				GCF = i;
				break;
			}
		}
		return GCF;
	}
	//Determines if numerator or denominator is smaller
	//@return numerator or denominator (whichever is smaller)
	private int findSmaller()
	{
		if (num > den)
		{
			return den;
		}
		else
		{
			return num;
		}
	}
}