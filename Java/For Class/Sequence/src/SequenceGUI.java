import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import BreezySwing.GBFrame;
import BreezySwing.IntegerField;

public class SequenceGUI extends GBFrame
{
	private JButton input = addButton("Input", 3, 1, 1, 1);
	private JButton outputLong = addButton("Find longest non-decreasing", 1, 2, 1, 1);
	private JButton outputShort = addButton("Find shortest non-decreasing", 2, 2, 1 ,1);
	private JButton outputLongDec = addButton("Find longest decreasing", 3, 2, 1, 1);
	private JButton outputShortDec = addButton("Find shortest decreasing", 4, 2, 1, 1);
	/*
	private JButton deleteValue = addButton("Delete number with given index", 6, 2, 1, 1);
	*/
	private JButton reset = addButton("Reset", 5, 1, 1, 1);
	private JButton exit = addButton("Exit", 7, 1, 1, 1);
	private JTextArea outputArea= addTextArea("", 6, 1, 1, 1);
	//Input each number into the sequence individually
	private IntegerField inputNumber = addIntegerField(0, 2, 1, 1, 1);
	/*
	//Input the index of the number user wishes to delete
	private IntegerField inputIndex = addIntegerField(0, 6, 2, 1, 1);
	private JLabel indexLabel = addLabel("Enter index to delete numbers below", 5, 2, 1, 1);
	*/
	private JLabel inputLabel = addLabel("Enter numbers below", 1, 1, 1, 1);
	//Hold the inputted sequence and return sequences in order
	private SequenceArray array= new SequenceArray();
	public void buttonClicked(JButton button)
	{
		//Enters one number into the sequence of numbers and enable buttons that interact with arrays
		if (button == input)
		{
			if (array.getCount() == 0)
			{
				outputLong.setEnabled(true);
				outputShort.setEnabled(true);
				outputLongDec.setEnabled(true);
				outputShortDec.setEnabled(true);
				reset.setEnabled(true);
				/*
				deleteValue.setEnabled(true);
				*/
			}
			if (inputNumber.isValid() == true)
			{
				array.inputNumber(inputNumber.getNumber());
			}
			else
				messageBox("Your input is invalid");
		}
		//Longest continuously increasing sequence
		if (button == outputLong)
		{
			//Longest non-decreasing sequence, true means to output longest sequence
			outputArea.setText("Longest non-decreasing: " + array.output(true));
		}
		//Shortest continuously increasing sequence
		if (button == outputShort)
		{
			//Shortest non=decreasing sequence, false means to output shortest sequence
			outputArea.setText("Shortest non-decreasing: " + array.output(false));
		}
		//Longest continuously decreasing sequence
		if (button == outputLongDec)
		{
		}
		//Shortest continuously decreasing sequence
		if (button == outputShortDec)
		{
		}
		/*
		//Delete value from array with given index
		if (button == deleteValue)
		{
			messageBox(array.deleteValue(inputIndex.getNumber()));
		}
		*/
		//Remove all values entered earlier and disable buttons interacting with arrays
		if (button == reset)
		{
			outputArea.setText("");
			messageBox(array.reset());
			outputLong.setEnabled(false);
			outputShort.setEnabled(false);
			outputLongDec.setEnabled(false);
			outputShortDec.setEnabled(false);
			reset.setEnabled(false);
		}
		//Alternative to close button in top right
		if (button == exit)
		{
			messageBox("The program will now end.");
			System.exit(0);
		}
		//Make user friendly, run after any button click to enter inputs more easily
		inputNumber.requestFocus();
		inputNumber.selectAll();
	}
	//Initialize GUI and disable buttons that interact with array
	public SequenceGUI()
	{
		outputLong.setEnabled(false);
		outputShort.setEnabled(false);
		outputLongDec.setEnabled(false);
		outputShortDec.setEnabled(false);
		reset.setEnabled(false);
		/*
		deleteValue.setEnabled(false);
		*/
		input.setEnabled(true);
		exit.setEnabled(true);
	}
	public static void main(String[] args)
	{
		SequenceGUI GUI = new SequenceGUI();
		GUI.setTitle("Sequence Finder");
		GUI.setSize(1100, 500);
		GUI.setVisible(true);
	}
}