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
	private JButton deleteValue = addButton("Delete number with given index", 6, 2, 1, 1);
	private JButton reset = addButton("Reset", 5, 1, 1, 1);
	private JButton exit = addButton("Exit", 7, 1, 1, 1);
	//Show the user what they have inputted so far
	private JTextArea outputArea= addTextArea("", 6, 1, 1, 1);
	//Input each number into the sequence individually
	private IntegerField inputNumber = addIntegerField(0, 2, 1, 1, 1);
	//Input the index of the number user wishes to delete
	private IntegerField inputIndex = addIntegerField(0, 6, 2, 1, 1);
	private JLabel indexLabel = addLabel("Enter index to delete numbers below", 5, 2, 1, 1);
	private JLabel inputLabel = addLabel("Enter numbers below", 1, 1, 1, 1);
	
	private SequenceArray array= new SequenceArray();
	public void buttonClicked(JButton button)
	{
		if (button == input)
		{
			if (array.getCount() == 0)
			{
				outputLong.setEnabled(true);
				outputShort.setEnabled(true);
				outputLongDec.setEnabled(true);
				outputShortDec.setEnabled(true);
				reset.setEnabled(true);
				deleteValue.setEnabled(true);
			}
			if (inputNumber.isValid() == true)
			{
				int x = inputNumber.getNumber();
				array.inputNumber(x);
			}
			else
				messageBox("Your input is invalid");
			inputNumber.requestFocus();
			inputNumber.selectAll();
		}
		if (button == outputLong)
		{
			outputArea.setText("Longest non-decreasing: " + array.output());
		}
		if (button == outputShort)
		{
		}
		if (button == outputLongDec)
		{
		}
		if (button == outputShortDec)
		{
		}
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
		if (button == exit)
		{
			messageBox("The program will now end.");
			System.exit(0);
		}
	}
	public SequenceGUI()
	{
		outputLong.setEnabled(false);
		outputShort.setEnabled(false);
		outputLongDec.setEnabled(false);
		outputShortDec.setEnabled(false);
		reset.setEnabled(false);
		deleteValue.setEnabled(false);
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