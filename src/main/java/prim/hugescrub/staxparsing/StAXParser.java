package prim.hugescrub.staxparsing;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

public class StAXParser extends AbstractParser {

    public StAXParser(String filename) {
        super(filename);
    }

    @Override
    public List<User> getAllUsers() {
        try {
            List<User> userList = null;
            User current = null;
            String tagContent = null;

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);

            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(
                    ClassLoader.getSystemResourceAsStream(getFilename()));

            // парсим все элементы файла
            while (reader.hasNext()) {
                int event = reader.next();

                // получаем элемент и смотрим аттрибуты
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        // читаем внешний элемент users и создаем список
                        String localName = reader.getLocalName();
                        if ("users".equals(localName)) {
                            userList = new ArrayList<User>();
                        } else if ("user".equals(localName)) {
                            current = new User();
                            //получаем атрибут id элемента user
                            current.setId(reader.getAttributeValue(0));
                        }
                        break;

                        //получаем содержимое элемента
                    case XMLStreamConstants.CHARACTERS:
                        tagContent = reader.getText().trim();
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        localName = reader.getLocalName();
                        if ("user".equals(localName)) {
                            // добавляем user в список после закрывающего тега user
                            userList.add(current);
                        } else if ("fullname".equals(localName)) {
                            current.setFullname(tagContent);
                        } else if ("email".equals(localName)) {
                            current.setEmail(tagContent);
                        } else if ("country".equals(localName)) {
                            current.setCountry(tagContent);
                        } else if ("town".equals(localName)) {
                            current.setTown(tagContent);
                        } else if ("registered".equals(localName)) {
                            current.setRegistered(formatter.parse(tagContent));
                        } else if ("address".equals(localName)) {
                            current.setAddress(tagContent);
                        }
                        break;
                }

            }
            return userList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
