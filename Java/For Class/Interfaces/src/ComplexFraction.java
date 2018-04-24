
public class ComplexFraction implements Number 
{
	private Fraction real;
	private Fraction imaginary;
	public ComplexFraction(Fraction fraction1, Fraction fraction2)
	{
		real = fraction1;
		imaginary = fraction2;
	}
	public ComplexFraction(Number aNumber,Number aNumber2)
	{
		real = (Fraction)aNumber;
		imaginary = (Fraction)aNumber2;
	}
	@Override
	public Number add(Number number) 
	{
		checkIfComplexFraction(number);
		checkIfRealAndImaginaryAreFractions();
		// getLeft and getRIght
		// check both left and right are Fractions
		// if not, throw exception
		Fraction realValue = (Fraction)real.add(((ComplexFraction)number).real);
		Fraction imaginaryValue = (Fraction)imaginary.add(((ComplexFraction)number).imaginary);
		ComplexFraction result = new ComplexFraction(realValue, imaginaryValue);
		return result;
	}
	@Override
	public Number subtract(Number number) 
	{
		((ComplexFraction)number).real.num *= -1;
		((ComplexFraction)number).imaginary.num *= -1;
		return add(number);
	}
	@Override
	public Number multiply(Number number) 
	{
		checkIfComplexFraction(number);
		checkIfRealAndImaginaryAreFractions();
		//when (a + bi)(c + di)
		//real = (ac - bd)
		Number temp = real.multiply(((ComplexFraction)number).real);
		Number temp2 = imaginary.multiply(((ComplexFraction)number).imaginary);
		Number realValue =((Fraction)temp).subtract(((Fraction)temp2));
		//imaginary = (bc + ad)
		Number temp3 = imaginary.multiply(((ComplexFraction)number).real);
		Number temp4 = real.multiply(((ComplexFraction)number).imaginary);
		Number imaginaryValue = ((Fraction)temp3).add((Fraction)temp4);
		ComplexFraction result = new ComplexFraction(realValue, imaginaryValue);
		return result;
	}
	@Override
	public Number divide(Number number) 
	{
		checkIfComplexFraction(number);
		checkIfRealAndImaginaryAreFractions();
		//when (a + bi)(c + di)
		//real = (ac + bd) / (c^2 + d^2)
		Number temp = real.multiply(((ComplexFraction)number).real);
		Number temp2 = imaginary.multiply(((ComplexFraction)number).imaginary);
		Number temp3 = ((ComplexFraction)number).real.square();
		Number temp4 = ((ComplexFraction)number).imaginary.square();
		Number temp5 = temp3.add(temp4);
		Number realValue = ((Fraction)temp).add(((Fraction)temp2));
		realValue = realValue.divide(temp5);
		//imaginary = (bc - ad) / (c^2 + d^2)
		Number temp6 = imaginary.multiply(((ComplexFraction)number).real);
		Number temp7 = real.multiply(((ComplexFraction)number).imaginary);
		Number imaginaryValue =(temp6.subtract(temp7)).divide(temp5);
		ComplexFraction result = new ComplexFraction(realValue, imaginaryValue);
		return result;
	}
	public String toString()
	{
		String result = "";
		if (((Fraction)imaginary).num == 0)
		{
			result += real.toString();
		}
		else if (((Fraction)real).num == 0)
		{
			result += imaginary.toString() + " * i";
		}
		else
		{
			result += real.toString() + " + " + imaginary.toString() + " * i";
		}
		return result;
	}
	private void checkIfRealAndImaginaryAreFractions()
	{
		if (!(real instanceof Fraction))
		{
			throw new IllegalArgumentException("The real value is not a fraction");
		}
		if (!(imaginary instanceof Fraction))
		{
			throw new IllegalArgumentException("The imaginary value is not a fraction");
		}
	}
	public void checkIfComplexFraction(Number number)
	{
		if (!(number instanceof ComplexFraction))
		{
			throw new IllegalArgumentException("Not a Complex Fraction");
		}
	}
}