package prim.hugescrub.staxparsing;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stax.StAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SchemaValidator {

    public static boolean schemaValidator(String schemaFile, String xmlFile){
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(schemaFile));

            Validator validator = schema.newValidator();
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(Files.newInputStream(Paths.get(xmlFile)));

            validator.validate(new StAXSource(reader));

            System.out.println("XML is valid");
            return true;
        } catch (Exception e) {
            String message = e.getMessage();
            System.out.println("XML is not valid: " + message);
            return false;
        }
    }
}
