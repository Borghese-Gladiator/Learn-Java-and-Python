import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import BreezySwing.DoubleField;
import BreezySwing.GBFrame;
import BreezySwing.IntegerField;
public class InterfacesGUI extends GBFrame 
{
	//Operations
	private JRadioButton add = addRadioButton("+", 1, 5, 1, 1);
	private JRadioButton subtract = addRadioButton("-", 2, 5, 1, 1);
	private JRadioButton multiply = addRadioButton("*", 4, 5, 1, 1);
	private JRadioButton divide = addRadioButton("/", 5, 5, 1, 1);
	//Fraction
	private JButton fraction = addButton("Fraction" , 0, 1, 1, 1);
	private IntegerField numerator1 = addIntegerField(0, 1, 2, 1, 2);
	private IntegerField denominator1 = addIntegerField(0, 2, 2, 1, 2);
	private IntegerField numerator2 = addIntegerField(0, 1, 3, 1, 2);
	private IntegerField denominator2 = addIntegerField(0, 2, 3, 1, 2);
	private JButton inputFraction = addButton("=", 1, 6, 1, 1);
	//Complex
	private JButton complex = addButton("Complex number", 4, 1, 1, 1);
	private DoubleField real1 = addDoubleField(0, 4, 2, 1, 1);
	private DoubleField imaginary1 = addDoubleField(0, 5, 2, 1, 1);
	private DoubleField real2 = addDoubleField(0, 4, 3, 1, 1);
	private DoubleField imaginary2 = addDoubleField(0, 5, 3, 1, 1);
	private JButton inputComplex = addButton("=", 4, 6, 1, 1);
	//Output
	private JTextArea output = addTextArea("", 1, 8, 1, 8);
	//Extra credit
	private JButton complexFraction = addButton("Complex fraction", 6, 1, 1, 1);
	private JButton equalComplexFraction = addButton("=", 6, 6, 1, 1);
	private IntegerField nume1 = addIntegerField(0, 6, 2, 1, 1);
	private IntegerField deno1 = addIntegerField(0, 7, 2, 1, 1);
	private IntegerField nume2 = addIntegerField(0, 6, 3, 1, 1);
	private IntegerField deno2 = addIntegerField(0, 7, 3, 1, 1);
	private IntegerField nume3 = addIntegerField(0 ,6, 4, 1, 1);
	private IntegerField deno3 = addIntegerField(0, 7, 4, 1, 1);
	private IntegerField nume4 = addIntegerField(0, 6, 5, 1, 1);
	private IntegerField deno4 = addIntegerField(0, 7, 5, 1, 1);
	public InterfacesGUI()
	{
		ButtonGroup group = new ButtonGroup();
		group.add(add);
		group.add(subtract);
		group.add(multiply);
		group.add(divide);
		enableFraction();
	}
	public void buttonClicked(JButton button)
	{
		if (button == inputFraction)
		{
			try
			{
				Number num1 = new Fraction(numerator1.getNumber(), denominator1.getNumber());
				Number num2 = new Fraction(numerator2.getNumber(), denominator2.getNumber());
				Number result = new Fraction(1, 1);
				result = findOperation(num1, num2);
				output.setText(result.toString());
			}
			catch (Exception e)
			{
				messageBox(e.getMessage());
			}
			
		}
		if (button == inputComplex)
		{
			try
			{
				Number num1 = new Complex(real1.getNumber(), imaginary1.getNumber());
				Number num2 = new Complex(real2.getNumber(), imaginary2.getNumber());
				Number result = new Complex(0, 0);
				result = findOperation(num1, num2);
				findOperation(num1, num2);
				output.setText(result.toString());
			}
			catch (Exception e)
			{
				messageBox(e.getMessage());
			}
		}
		if (button == equalComplexFraction)
		{
			try
			{
				Fraction fraction1 = new Fraction(nume1.getNumber(), deno1.getNumber());
				Fraction fraction2 = new Fraction(nume2.getNumber(), deno2.getNumber());
				Number complex1 = new ComplexFraction(fraction1, fraction2);
				Fraction fraction3 = new Fraction(nume3.getNumber(), deno3.getNumber());
				Fraction fraction4 = new Fraction(nume4.getNumber(), deno4.getNumber());
				Number complex2 = new ComplexFraction(fraction3, fraction4);
				Number result = findOperation(complex1, complex2);
				output.setText(result.toString());
			}
			catch(Exception e)
			{
				messageBox(e.getMessage());
			}
		}
		if (button == fraction)
		{
			enableFraction();
		}
		if (button == complex)
		{
			enableComplex();
		}
		if (button == complexFraction)
		{
			enableComplexFraction();
		}
	}
	private Number findOperation(Number num1, Number num2)
	{
		if (add.isSelected())
		{
			return num1.add(num2);
		}
		else if (subtract.isSelected())
		{
			return num1.subtract(num2);
		}
		else if (multiply.isSelected())
		{
			return num1.multiply(num2);
		}
		else if (divide.isSelected())
		{
			return num1.divide(num2);
		}
		else
		{
			messageBox("Please select an operation");
			return null;
		}
	}
	private void enableFraction()
	{
		inputFraction.setEnabled(true);
		inputComplex.setEnabled(false);
		equalComplexFraction.setEnabled(false);
	}
	private void enableComplex()
	{
		inputFraction.setEnabled(false);
		inputComplex.setEnabled(true);
		equalComplexFraction.setEnabled(false);
	}
	private void enableComplexFraction()
	{
		inputFraction.setEnabled(false);
		inputComplex.setEnabled(false);
		equalComplexFraction.setEnabled(true);
	}
	public static void main(String[] args) 
	{
		InterfacesGUI GUI = new InterfacesGUI();
		GUI.setTitle("Fraction and Complex Calculator");
		GUI.setSize(10000, 1000);
		GUI.setVisible(true);
	}
}