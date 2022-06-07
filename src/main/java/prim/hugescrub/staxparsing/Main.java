package prim.hugescrub.staxparsing;

import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws XMLStreamException, IOException, InvocationTargetException, IllegalAccessException {
        String fileName = "xml/chat.xml";
        String schemaPath = ".\\src\\main\\resources\\xml\\chat.xsd";
        String xmlPath = ".\\src\\main\\resources\\xml\\chat.xml";
        Map<String, XmlParser> parsers = new HashMap<>();

        SchemaValidator.schemaValidator(schemaPath, xmlPath);

        parsers.put("StAXParser", new StAXParser(fileName));

        for (Map.Entry<String, XmlParser> entry : parsers.entrySet()) {
            System.out.println("Parsing " + fileName.substring(4) + " using " + entry.getKey() + ":");
            List<User> result = entry.getValue().getAllUsers();
            for (User user : result) {
                System.out.println(user);
            }

            Users users = new Users(result);
            HTMLGenerator generator = new HTMLGenerator();
            Writer output = generator.generateHTML(users);
            generator.createHTML(output);
            System.out.println(output);
        }
    }
}
