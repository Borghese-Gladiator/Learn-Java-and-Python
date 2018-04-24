import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
//If you want you can define the order in which the fields are written
//Optional
@XmlType(propOrder = {"values", "keys"})
public class HashTable 
{	@XmlElementWrapper(name = "keysfff")
	private ArrayList<String> keys;
	@XmlElementWrapper(name = "values")
	private ArrayList<Integer> values;
	public HashTable()
	{
		keys = new ArrayList<String>();
		values = new ArrayList<Integer>();
	}
	public void insert(int index, int element)
	{
		keys.add(index, "Key " + keys.size());
		values.add(index, element);
	}
	public int getValue(String aKey)
	{
		return values.get(keys.indexOf(aKey));
	}
	public static String fixedLengthString(String string, int length) {
	    return String.format("%1$-"+length+ "s", string);
	}
	public String print()
	{
		String keyResult = "";
		String valueResult = "";
		for (int i = 0; i < values.size(); i++)
		{
			keyResult += fixedLengthString(keys.get(i), 8);
			valueResult += fixedLengthString(String.valueOf(values.get(i)), 8);	
		}
		return keyResult + '\n' + valueResult;
	}
}
