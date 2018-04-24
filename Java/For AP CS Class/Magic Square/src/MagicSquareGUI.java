/* Timothy Shee
 * 29 September 2017
 * Prompt: Magic square is a square array of positive integers where the sum of all rows, columsn,
 * and diagonals are the same value. Write a program that includes a GUI and can let users input the size
 * of the square, input numbers into the square, and output if the square is a magic square. If it is,
 * output the magic square constant. Furthermore, this program should have easy number input, so the user is
 * able to input into the table without excessive trouble.
 * Purpose: This program lets the user enter the size, creates the table, and then lets the user
 * enter their data into that table. Afterwards, it outputs the magic square constant.
 */
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import BreezySwing.GBFrame;
import BreezySwing.IntegerField;

public class MagicSquareGUI extends GBFrame
{
	//Creates input table with the given size
	private JButton inputSize = addButton("Input size", 3, 1, 1, 1);
	//Inputs user data inside input table to find if it is a magic square
	private JButton inputSquare = addButton("Calculate if magic square", 5, 1, 1, 1);
	//Labels to indicate where the user should input which information
	private JLabel sizeLabel = addLabel("Input size here", 1, 1, 1, 1);
	//Holds user input for the size of the square
	private IntegerField sizeField = addIntegerField(0, 2, 1, 1, 1);
	//Declare new magic square when program run
	private MagicSquare magicSquare;
	//Holds output for user to see magic square constant
	private JTextArea output = addTextArea("",6, 1, 1, 1);
	
	//Extra Credit
	//Inputs given size and number to create magic square
	private JButton createSquare = addButton ("Create square", 5, 3, 1, 1);
	private JLabel createSizeLabel = addLabel("Input odd size", 3, 3, 1, 1);
	private JLabel createNumberLabel = addLabel("Input number", 3, 5, 1, 1);
	private IntegerField oddSize = addIntegerField(0, 4, 3, 1, 1);
	private IntegerField number = addIntegerField(0, 4, 5, 1, 1);
	
	//The three widgets below hold the table in a separate window for user to input data
	private static JFrame frame = new JFrame(); //actual window
	private JTable inputTable = new JTable(); //table
    private JScrollPane scrollPane = new JScrollPane(inputTable);//holds table
    //Holds actual data of table
	private DefaultTableModel tableData = new DefaultTableModel();
	//Determine which button was clicked by user and corresponding action
	//@param button clicked
	public void buttonClicked(JButton button)
	{
		if (button == inputSize)
		{
			if (errorCheckSize() == false)
			{
				magicSquare = new MagicSquare(sizeField.getNumber());
				tableData.setColumnCount(sizeField.getNumber());
				tableData.setRowCount(sizeField.getNumber());
				inputTable.setModel(tableData);
				inputTable.setEnabled(true);
				sizeField.setEnabled(false);
				inputSquare.setEnabled(true);
			}
		}
		if (button == inputSquare)
		{
			inputTable.getSelectionModel().clearSelection();
			if (magicSquare.setMagicSquare(tableData) == false)
			{
				if (magicSquare.checkMagicSquare() == false)
				{
					output.append(magicSquare.ifSquare());
					tableData.setRowCount(0);
					sizeField.setEnabled(true);
					inputSquare.setEnabled(false);
					inputTable.setEnabled(false);
				}
				else
				{
					messageBox("Error: There are negative values");
				}
			}
			else
			{
				messageBox("Error: There is a blank value");
			}
		}
		if (button == createSquare)
		{
			MagicSquareCreation create = 
					new MagicSquareCreation(number.getNumber(), oddSize.getNumber());
			if (create.errorCheck() == false)
			{
				output.append(create.create());
			}
			else
			{
				messageBox("The size must be odd");
			}
		}
	}
	//Checks if data is valid 
	//@return valid or invalid
	private boolean errorCheckSize() 
	{	//Check for decimal and letters
		if (sizeField.isValidNumber() == false)
		{
			messageBox("Error: Not a valid integer");
			return true;
		}
		//Check for valid square size
		if (sizeField.getNumber() < 2 || sizeField.getNumber() > 8)
		{
			messageBox("Error: Input is not greater than or equal to 2 nor "
					+ "less than or equal to 8");
			return true;
		}
		return false;
	}
	//Initializes GUI and disables all buttons except input size and
	//Sets up input table
	public MagicSquareGUI()
	{
		sizeField.setEnabled(true);
		inputSquare.setEnabled(false);
		frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
		inputTable.setFillsViewportHeight(true);
		inputTable.setEnabled(false);
	}
	public static void main(String[] args) 
	{
		MagicSquareGUI GUI = new MagicSquareGUI();
		frame.setTitle("Input table here");
		frame.setSize(550, 300);
	    frame.setVisible(true);
		GUI.setTitle("Create a Magic Square");
		GUI.setSize(700, 400);
		GUI.setVisible(true);
	}
}