import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class testHashTable 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		HashTable table = new HashTable();
		table.insert(0, 5);
		table.insert(0, 8);
		System.out.println("This is key 1: " + table.getValue("Key 1"));
		System.out.println(table.print());
		try
        {
			JAXBContext context = JAXBContext.newInstance(HashTable.class);
		    Marshaller m = context.createMarshaller();
		    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        	File XMLfile = new File("C:\\DATIMMY\\Table.xml");
        	//Writing to XML File
        	m.marshal(table, XMLfile);
        	//Writing to console
        	m.marshal(table, System.out);
        }
        catch (JAXBException e) 
        {
            // some exception occured
            e.printStackTrace();
        }
    }
}