public class WordCounter 
{
	//Holds the input sentence
	private String input;
	//Holds the number of characters
	private int numCharacters;
	//Holds the number of words
	private int numWords;
	//Holds all the unique words and number of iterations of each in list format
	private String uniqueWords;
	//Initializes WordCounter object
	//@param a sentence
	public WordCounter(String aSentence)
	{
		//Check for no input
		if (aSentence == null || aSentence.isEmpty())
		{
			throw new IllegalArgumentException("No input");
		}
		input = aSentence;
	}
	//Assigns values to each instance variable
	private void count()
	{
		//Remove trailing and leading spaces
		setInput(input.trim());
		numCharacters = characterCount();
		String allWords[] = split();
		numWords = allWords.length;
		uniqueWords = findUniqueWords(allWords);
	}
	//Assembles information of instance variables
	//@return word counts of a sentence
	@Override
	public String toString()
	{
		count();
		String result = numCharacters + " characters" + '\n';
		result += numWords + "  words" + '\n' + uniqueWords;
		return result;
	}
	//Counts the number of characters
	//@return number of characters
	private int characterCount()
	{
		int characterCount = 0;
		for (int i = 0; i < input.length(); i++)
		{
			if (!(input.charAt(i) == ' '|| input.charAt(i) == '\t'))
			{
				characterCount++;
			}
		}
		return characterCount;
	}
	//Finds and removes punctuation if it is attached to the end of a word
	//@param a word
	//@return word without punctuation
	private String removePunctuation(String word) 
	{
		char lastCharacter = word.charAt(word.length() - 1);
		if (lastCharacter == '.' || lastCharacter == '!' || lastCharacter == '?' 
				|| lastCharacter == ',' || lastCharacter == ':' || lastCharacter == ';')
		{
			word = word.substring(0, word.length() - 1);
		}
		return word;
	}
	//Splits the sentence into an array containing only the words
	//@return all words including repeats
	public String[] split()
	{
		String[] result = new String[input.length()/2];
		int beginIndex = 0;
		int counter = 0;
		final char space = ' ';
		for (int i = 0; i < result.length; i++)
			input = input.replace("  ", " ");
		for (int i = 0; i < input.length(); i++)
		{
			if (input.charAt(i) == space || i == input.length() - 1)
			{
				result[counter] = input.substring(beginIndex, i);
				beginIndex = i + 1;
				counter++;
			}
		}
		return resizeArray(result, counter);
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
	//Finds all unique words
	//@param an array of words without trailing null values
	//@return all unique words and iterations of each in a list format
	private String findUniqueWords(String[] allWords)
	{
		String result = "";
		//Holds the number of items in the array of unique words
		int repeatArrLength = 0;
		//Creates an array holding only unique words (functions similar to a set)
		String[] repeats = new String[allWords.length];
		//Loop through whole array
		for (int i = 0; i < allWords.length; i++)
		{
			allWords[i] = removePunctuation(allWords[i]);
			if (noRepeats(repeats, allWords[i], repeatArrLength))
			{	
				result += allWords[i] + "   " + numOfRepeats(allWords, allWords[i], i);
				//EXTRA CREDIT: outputs if there is a pallindrome
				if (findIfPalindrome(allWords[i]))
				{
					result += "   This word is a pallindrome";
				}
				result += '\n';
				repeats[repeatArrLength] = allWords[i];
				repeatArrLength++;
			}
		}
		return result;
	}
	//Checks if a word is in the array (meaning it has been searched before and is a repeat)
	//@param array of unique words, a word, number of items in array
	//@return false if the word is a repeat or true if the word is not a repeat
	private boolean noRepeats(String[] repeats, String word, int repeatLength) {
		for (int j = 0; j < repeatLength; j++)
		{
			if (repeats[j].equalsIgnoreCase(word))
			{
				//This word has already been searched before
				return false;
			}
		}
		return true;
	}
	//Finds the number of times a word appears in the array
	//@param array of all words, a given word in the array, index of the given word
	//@return number of times the word appears in the array
	private int numOfRepeats(String[] repeats, String word, int i) 
	{
		//1 since the word occurs at least once
		int numberOfRepeats = 1;
		for (int j = i + 1; j < repeats.length; j++)
		{
			if (repeats[j].equalsIgnoreCase(word))
			{
				numberOfRepeats++;
			}
		}
		return numberOfRepeats;
	}
	//Determines if given is a palindrome
	//@param a word
	//@return true if the word is a palindrome and false if not
	private boolean findIfPalindrome(String word)
	{
		word = word.toUpperCase();
		for (int i = 0; i < word.length( )/ 2; i++)
		{
			if (word.charAt(i) != word.charAt(word.length() - 1 - i))
			{
				return false;
			}
		}
		return true;
	}
	public void setInput(String sentence) {
		this.input = sentence;
	}
}