import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import BreezySwing.GBFrame;
public class CharactersGUI extends GBFrame
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
			WordCounter wordCounter = new WordCounter(input.getText());
			if (button == calculate)
			{
				//Output calculated values
				output.setText(wordCounter.toString() + '\n');
			}
		}
		catch (Exception e)
		{
			messageBox(e.getMessage());
		}
	}
	public static void main(String[] args) 
	{
		CharactersGUI GUI = new CharactersGUI();
		GUI.setTitle("Characters");
		GUI.setSize(1000, 1000);
		GUI.setVisible(true);
	}
}