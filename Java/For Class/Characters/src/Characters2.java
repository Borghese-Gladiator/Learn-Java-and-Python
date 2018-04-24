public class Characters2 
{
	private String sentence;
	public Characters2(String aSentence)
	{
		if (aSentence.isEmpty())
		{
			throw new IllegalArgumentException("No input");
		}
		char x = aSentence.charAt(aSentence.length() - 1);
		if (x != '.' && x != '!' && x != '?')
		{
			throw new IllegalArgumentException("No punctuation at end.");
		}
		sentence = aSentence;
	}
	@Override
	public String toString()
	{
		String result = ""; 
		setSentence(sentence.trim()); //Remove trailing and leading spaces
		result += characterCount() + " characters" + '\n' + numOfWords() + "  words" + '\n';
		removePunctuation();
		String temp[] = new String[sentence.length()/2];
		temp = sentence.split(" ");
		return result + findWords(temp);
	}
	private int characterCount()
	{
		int characterCount = 0;
		for (int i = 0; i < sentence.length(); i++)
		{
			if (!(sentence.charAt(i) == ' '|| sentence.charAt(i) == '\t'))
			{
				characterCount++;
			}
		}
		return characterCount;
	}
	private int numOfWords(){
		int result = 1;
		result += sentence.length() - characterCount();
		return result;
	}
	private void removePunctuation() 
	{
		setSentence(sentence.substring(0, sentence.length() - 1));
	}
	private String findWords(String[] x)
	{
		String result = "";
		int repeatArrLength = 0;
		String[] repeats = new String[x.length];
		//Loop through whole array
		for (int i = 0; i < x.length; i++)
		{
			if (noRepeats(repeats, x[i], repeatArrLength))
			{	
				result += x[i] + "   " + numOfRepeats(x, x[i], i) + '\n';
				repeats[repeatArrLength] = x[i];
				repeatArrLength++;
			}
		}
		return result;
	}
	private int numOfRepeats(String[] x, String word, int i) 
	{
		int numberOfRepeats = 1;
		for (int j = i + 1; j < x.length; j++)
		{
			if (x[j].equalsIgnoreCase(word))
			{
				numberOfRepeats++;
			}
		}
		return numberOfRepeats;
	}
	private boolean noRepeats(String[] x, String word, int counter) {
		for (int j = 0; j < counter; j++)
		{
			if (x[j].equalsIgnoreCase(word))
			{
				//This word has already been searched before
				return false;
			}
		}
		return true;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
}