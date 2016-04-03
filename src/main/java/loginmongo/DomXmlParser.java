package loginmongo;

/**
 * Created by hsenid on 3/16/16.
 */

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class DomXmlParser {

	

	public String readResponse(InputStream input) throws Exception {


		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(input);
		


		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		NodeList nList = doc.getElementsByTagName("text");

		System.out.println("----------------------------");
		// ArrayList<String> listValues = new ArrayList<String>();

		// String
		// passValue=String.valueOf(listValues.add(nList.item(0).getAttributes().getNamedItem("text").getNodeValue()));
		String passValue = nList.item(0).getTextContent();

		System.out.println(passValue);
		return passValue;

	}
}
