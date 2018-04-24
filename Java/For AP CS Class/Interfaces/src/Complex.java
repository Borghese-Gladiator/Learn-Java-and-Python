public class Complex implements Number
{
	//Holds real part of complex number (a + bi)
	private double a;
	//Holds imaginary part of complex number
	private double b;
	//Initializes Complex number object
	//@param real, imaginary
	public Complex(double aA, double aB)
	{
		a = aA;
		b = aB;
	}
	//Adds this complex number to passed in complex number 
	//(a + c) + (b + d)i
	//@param a complex number
	//@return a third complex number equal to the sum of the two
	public Number add(Number number)
	{
		checkIfComplex(number);
		double realValue = a + ((Complex)number).a;
		double imaginary = b + ((Complex)number).b;
		Complex result = new Complex(realValue, imaginary);
		return result;
	}
	//Subtracts the passed in complex number from this complex number
	//@param a complex number
	//@return a third complex number equal to the difference of the two
	public Number subtract(Number number)
	{
		((Complex)number).a *= -1;
		((Complex)number).b *= -1;
		return add(number);
	}
	//Multiplies this complex number by the passed in complex number
	//@param a complex number
	//@return a third complex number equal to the product of the two
	public Number multiply(Number number)
	{
		checkIfComplex(number);
		//when (a + bi)(c + di)
		//real = (ac - bd)
		double realValue = (a * ((Complex)number).a) - (b * ((Complex)number).b);
		//imaginary = (bc + ad)
		double imaginary = (b * ((Complex)number).a) + (a * ((Complex)number).b);
		Complex result = new Complex(realValue, imaginary);
		return result;
	}
	//Divides this complex number by the passed in complex number
	//@param a complex number
	//@return a third complex number equal to the quotient of the two
	public Number divide(Number number)
	{
		checkIfComplex(number);
		//when (a + bi)(c + di)
		//real = (ac + bd) / (c^2 + d^2)
		double realValue = (a * ((Complex)number).a) + (b * ((Complex)number).b);
		realValue /= (Math.pow(((Complex)number).a, 2) + Math.pow(((Complex)number).b, 2));
		//imaginary = (bc - ad) / (c^2 + d^2)
		double imaginary = (b * ((Complex)number).a) - (a * ((Complex)number).b);
		imaginary /= (Math.pow(((Complex)number).a, 2) + Math.pow(((Complex)number).b, 2));
		Complex result = new Complex(realValue, imaginary);
		return result;
	}
	//Error check passed in value is a complex number
	//@param a "number" (could be a fraction or a complex number)
	private void checkIfComplex(Number num)
	{
		if (!(num instanceof Complex))
		{
			throw new IllegalArgumentException("Not a complex");
		}
	}
	//Assembles this complex number's information
	//@return complex number information
	public String toString()
	{
		String result = "";
		if (b == 0)
		{
			result += a;
		}
		else if (a == 0)
		{
			result += b + "i";
		}
		else
		{
			result += a + " + " + b + "i";
		}
		return result;
	}
}
