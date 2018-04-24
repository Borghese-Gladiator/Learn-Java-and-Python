public class MagicSquareCreation 
{
	private int number;
	private int size;
	public MagicSquareCreation(int nm, int s)
	{
		number = nm;
		size = s;
	}
	public boolean errorCheck()
	{
		if (size % 2 == 0)
		{
			return true;
		}
		return false;
	}
	public String create()
	{
		String result = "";
		int [][] magicSquare = new int[size][size];
		int i = size/2;
		int j = 0;
		// One by one put all values in magic square
	    for (int x=1; x <= size*size;x++ )
	    {
	    	magicSquare[i][j] = number;
	    	i = (i + 1)% 2;
	    	j = (j + 1)% 2;
	    	if (magicSquare[i][j] != 0)
	    	{
	    		j = (j + size - 2)/size;
	    		i = (i + size - 2)/size;
	    	}
	    	for(int i=size-1;i>=0;i--)
			{
			    for(int j=0;j<size;j++)
			    {
			        System.out.print(magicSquare[i][j]+",");
			    }
			    System.out.println();
			}
		return result;
	}
}