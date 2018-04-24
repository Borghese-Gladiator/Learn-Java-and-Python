import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import BreezySwing.GBFrame;
public class ParserGUI extends GBFrame
{
	//Input sentence
	JLabel inputLabel = addLabel("Input sentence below", 1, 1, 1, 1);
	private JTextField input = addTextField("", 2, 1, 1,1);
	//Output result
	private JButton calculate = addButton("Calculate", 3, 1, 1, 1);
	private JTextArea output = addTextArea("", 4, 1, 1, 1);
	public void buttonClicked(JButton button)
	{
		try
		{
			Parser wordCounter = new Parser(input.getText());
			if (button == calculate)
			{
				//Output calculated values
				output.setText(wordCounter.convertWord() + '\n');
			}
		}
		catch (Exception e)
		{
			messageBox(e.getMessage());
		}
	}
	public static void main(String[] args) 
	{
		ParserGUI GUI = new ParserGUI();
		GUI.setTitle("Parse Strings");
		GUI.setSize(500, 500);
		GUI.setVisible(true);
	}
}
