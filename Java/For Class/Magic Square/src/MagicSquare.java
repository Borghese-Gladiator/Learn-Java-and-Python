import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MagicSquare 
{
	//Holds data of input table
	private int magicSquare[][];
	private int magicSquare2[][];
	//Holds size of input table
	private int dimension;
	//Holds the magic square constant and is first found
	//with the sum of the first row before being compared to 
	//other rows, columns, and diagonals.
	private int totalSum;
	//Initializes the square with a given dimension
	//@param length of square
	public MagicSquare(int d)
	{
		dimension = d;
		magicSquare = new int[dimension][dimension];
		magicSquare2 = new int[dimension][dimension];
	}
	public boolean setMagicSquare(DefaultTableModel array)
	{
		boolean result = false;
		for (int i = 0; i < dimension; i++)
		{
			for (int j = 0; j < dimension; j++)
			{
				if (array.getValueAt(i,j) == null)
				{
					magicSquare[i][j] = 0;
					result = true;
				}
				else
				{
					magicSquare[i][j] = Integer.parseInt(array.getValueAt(i, j).toString());
				}
			}
		}
		return result;
	}
	public int convertToInteger(Object x)
	{
		if (x == null)
		{
			return 0;
		}
		else
		{
			return Integer.valueOf(x.toString());
		}
	}
	//Checks that the input table only has positive integers
	//@return valid or invalid
	public boolean checkMagicSquare()
	{
		for (int i = 0; i < dimension; i++)
		{
			for (int j = 0; j < dimension; j++)
			{
				if (magicSquare[i][j] < 0)
				{
					return true;
				}
			}
		}
		return false;
	}
	//Determines if input table is a magic square
	//@return result which is an error or the magic square constant
	public String ifSquare()
	{
		if (checkRowSums() == true && checkColumnSums() == true
				&& checkDiagonalSums() == true)
		{
			return "The square is a magic square with "
					+ "a magic square constant of " + totalSum + '\n';
		}
		else
		{
			return "Not a magic square" + '\n';
		}
	}
	//Sets the totalSum to the sum of the first row and checks if 
	//all row sums are equal
	//@return false if not all row sums are equal or true if all equal
	private boolean checkRowSums()
	{
		int sum = 0, firstRowSum = findFirstRowSum();
		for (int i = 1; i < dimension; i++)
		{
			for (int j = 0; j < dimension; j++)
			{
				sum += magicSquare[i][j];
			}
			if (sum != firstRowSum)
			{
				return false;
			}
			sum = 0;
		}
		totalSum = firstRowSum;
		return true;
	}
	//Finds the sum of the first row
	//@return sum of first row
	private int findFirstRowSum()
	{
		int result = 0;
		for (int i = 0; i < dimension; i++)
		{
			result += magicSquare[0][i];	
		}
		return result;
	}
	//checks if all column sums are equal to magic square constant
	//@return false if not all column sums are equal or true if all equal
	private boolean checkColumnSums()
	{
		int sum = 0;
		for (int i = 0; i < dimension; i++)
		{
			for (int j = 0; j < dimension; j++)
			{
				sum += magicSquare[j][i];
			}
			if (sum != totalSum)
			{
				return false;
			}
			sum = 0;
		}
		return true;
	}
	//Checks if both diagonals are equal to magic square constant
	//@return false if not both diagonals are equal or true if both equal
	private boolean checkDiagonalSums()
	{
		int sum = 0, sum2 = 0;
		for (int i = 0; i < dimension; i++)
		{
			sum += magicSquare[i][i];
		}
		for (int i = dimension - 1; i >= 0; i--)
		{
			sum2 += magicSquare[i][i];
		}
		if (sum == totalSum && sum2 == totalSum)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}