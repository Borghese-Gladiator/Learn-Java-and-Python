import java.math.BigDecimal;

public class Parser 
{
	//holds a phrase
	private String word;
	//initialize parser object
	//@param given word
	public Parser (String input)
	{
		word = input;
	}
	//Operates on word if there is an equals sign, otherwise returns word
	//@return result of operations or word
	public String convertWord()
	{
		if (word.charAt(0) == '=')
		{
			//Remove equals sign
			word = word.substring(1);
			String[] terms = isolateTerms();
			double result = processTerms(terms);
			return Double.toString(result);
		}
		else
		{
			return word;
		}
	}
	//Isolates every number and operation in an array
	//@return array holding each number and operation
	private String[] isolateTerms()
	{
		boolean termsNotIsolated = true; 
		String[] allTerms = new String[word.length()];
		//Remove "null" from all places to help negatives work properly
		for (int i = 0; i < allTerms.length; i++)
		{
			allTerms[i] = "";
		}
		int counter = 0;
		int beginIndex = 0;
		String theWord = word;
		while(termsNotIsolated)
		{
			char operation = findOperation(theWord);
			beginIndex = theWord.indexOf(operation);
			//Split up next section
			String[] arr = splitInput(theWord, operation);
			//0th term is null if there is a negative
			if (arr[0].isEmpty())
			{
				//Put negative sign prior to number
				allTerms[counter] = "-";
			}
			else
			{
				//Add new isolated values to array
				allTerms[counter] += arr[0];
				counter++;
				allTerms[counter] = Character.toString(operation);
				counter++;
			}
			if (isOnlyANumber(arr[2]))
			{
				allTerms[counter] += arr[2];
				termsNotIsolated = false;
				counter++;
			}
			theWord = theWord.substring(beginIndex + 1);
		}
		if (allTerms.length != counter)
		{
			allTerms = resizeArray(allTerms, counter);
		}
		return allTerms;
	}
	//Takes various strings and performs operations
	//@param all isolated terms
	//@return evaluated solution with OOP
	private double processTerms(String[] terms)
	{
		double result = 0;
		//Holds numbers after multiplication and division
		String[] noMulDiv = new String[terms.length];
		int counter = 0;
		//Prioritize * and /
		for (int i = 0; i < terms.length; i++)
		{
			char operation = terms[i].charAt(0);
			if (operation == '-' && terms[i].length() > 1)
			{
				noMulDiv[counter] = terms[i];
				counter++;
			}
			else if (operation == '+' || operation == '-' || operation == '*' || operation == '/')
			{
				switch(operation)
				{
				case '*':
				case '/':
					counter--;
					BigDecimal x = operate(parse(terms[i - 1]), parse(terms[i + 1]), operation);
					noMulDiv[counter] = Double.toString(x.doubleValue());
					counter++;
					i++;
					break;
				case '+':
				case '-':
					noMulDiv[counter] = terms[i];
					counter++;
					break;
				}
			}
			else
			{
				noMulDiv[counter] = terms[i];
				counter++;
			}
		}
		if (counter != noMulDiv.length)
			noMulDiv = resizeArray(noMulDiv, counter);
		result = parse(noMulDiv[0]);
		//Complete + and -
		for (int i = 1; i < noMulDiv.length; i++)
		{
			if (i % 2 == 1)
			{
				char operation = noMulDiv[i].charAt(0);
				switch (operation)
				{
				case '+':
				case '-':
				case '*':
				case '/':
					BigDecimal x = operate(result, parse(noMulDiv[i + 1]), operation);
					result = x.doubleValue();
				}
			}
		}
		return result;
	}
	//Finds the first operation in a given word
	//@param a word
	//@return the operation
	private char findOperation(String word)
	{
		//Operation cannot be at end
		for (int i = 0; i < word.length() - 1; i++)
		{
			char character = word.charAt(i);
			switch(character)
			{
			case '+':
			case '-':
			case '*':
			case '/':
				return character;
			}
		}
		//Return if no operation was found
		return 'N';
	}
	//Separates input into value, operation, and to be processed
	//@param word, operation
	//@return array with isolated left value, operation, and to be processed right
	private String[] splitInput(String word, char operation)
	{	
		String cOperation = Character.toString(operation);
		//Make split function look for +, -, *, / without error
		cOperation = "\\" + cOperation;
		//Hold the operator in addition to the 2 terms
		String result[] = new String[3];
		result[1] = cOperation;
		//Split with a limit of 2
		String splitResult[] = word.split(cOperation, 2);
		//Add values from split function into array holding operation
		result[0] = splitResult[0];
		result[2] = splitResult[1];
		//Remove excess spaces
		result[0] = result[0].trim();
		result[2] = result[2].trim();
		return result;
	}
	//Changes given strings into numbers (including negatives)
	//@param a word
	//@return numeric value of word
	private double parse(String word)
	{
		double result = 0; boolean isNegative = false;
		if (word.charAt(0) == '-')
		{
			word = word.substring(1);
			isNegative = true;
		}
		int decimalPoint = word.indexOf(".");
		//No decimal point
		if (decimalPoint == -1)
		{
			result = parseInt(word);
		}
		else
		{
			//Divide into two parts with decimal section
			result = parseInt(word.substring(0, decimalPoint));
			result += parseFloat(word.substring(decimalPoint + 1));
		}
		if (isNegative)
		{
			result *= -1;
		}
		return result;
	}
	//Changes given word into its whole number value
	//@param a word
	//@return integer value of word
	private double parseInt(String word)
	{
		double result = 0;
		for (int i = 0; i < word.length(); i++)
		{
			result *= 10;
			char character = word.charAt(i);
			//Decimal point already searched before
			if (!Character.isDigit(character))
			{
				throw new IllegalArgumentException("Error: Cannot convert");
			}
			result += Character.getNumericValue(character);
		}
		return result;
	}
	//Changes given word into its decimal value
	//@param a word
	//@return decimal value of word
	private double parseFloat(String word)
	{
		double result = parseInt(word);
		while (result >= 1)
			result /= 10;
		return result;
	}
	//Combines two numbers with a given operation
	//@param first number, second number, operation
	//@return sum, difference, product, or quotient
	private BigDecimal operate(double num1, double num2, char operation)
	{
		//Using BigDecimal since returns 0.88799999 instead of 0.888
		BigDecimal theNum1 = new BigDecimal(num1);
		BigDecimal theNum2 = new BigDecimal(num2);
		switch(operation)
		{
		case '+': 
			return theNum1.add(theNum2);
		case '-':
			return theNum1.subtract(theNum2);
		case '*':
			return theNum1.multiply(theNum2);
		case '/':
			return theNum1.divide(theNum2);
		default:
			throw new IllegalArgumentException("Invalid operation");
		}
	}
	//Determines if there are no more operations (meaning it is last term)
	//@param a word
	//@return if there are no more operations left
	private boolean isOnlyANumber(String word)
	{
		if (findOperation(word) == 'N')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//Removes the null values from an array of strings
	//@param an array of words, number of words in array
	//@return array of strings without trailing null values
	private String[] resizeArray(String[] result, int counter) 
	{
		String[] resizeResult = new String[counter];
		for (int i = 0; i < counter; i++)
		{
			resizeResult[i] = result[i];
		} 	
		return resizeResult;
	}
}