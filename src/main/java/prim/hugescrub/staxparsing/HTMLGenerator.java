package prim.hugescrub.staxparsing;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class HTMLGenerator {
    public Writer generateHTML(Users users) throws XMLStreamException, IOException, IllegalAccessException, InvocationTargetException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        try (Writer output = new StringWriter()) {
            XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(output);

            writer.writeDTD("<!DOCTYPE html>");
            writer.writeStartElement("html");
            writer.writeAttribute("lang", "en");
            writer.writeStartElement("head");
            writer.writeDTD("<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            writer.writeDTD("<link rel=\"stylesheet\" href=\"style.css\">");
            writer.writeStartElement("title");
            writer.writeCharacters("All chat users");
            writer.writeEndElement();
            writer.writeEndElement();

            writer.writeStartElement("table");

            writer.writeStartElement("tr");

            writer.writeStartElement("th");
            writer.writeCharacters("Id");
            writer.writeEndElement();

            writer.writeStartElement("th");
            writer.writeCharacters("fullname");
            writer.writeEndElement();

            writer.writeStartElement("th");
            writer.writeCharacters("email");
            writer.writeEndElement();

            writer.writeStartElement("th");
            writer.writeCharacters("country");
            writer.writeEndElement();

            writer.writeStartElement("th");
            writer.writeCharacters("town");
            writer.writeEndElement();

            writer.writeStartElement("th");
            writer.writeCharacters("registered");
            writer.writeEndElement();

            writer.writeEndElement();

            for (User user : users.getUsers()) {

                writer.writeStartElement("tr");

                writer.writeStartElement("td");
                writer.writeCharacters(String.valueOf(user.getId()));
                writer.writeEndElement();

                writer.writeStartElement("td");
                writer.writeCharacters(user.getFullname());
                writer.writeEndElement();

                writer.writeStartElement("td");
                writer.writeCharacters(String.valueOf(user.getEmail()));
                writer.writeEndElement();

                writer.writeStartElement("td");
                writer.writeCharacters(user.getCountry());
                writer.writeEndElement();

                writer.writeStartElement("td");
                writer.writeCharacters(user.getTown());
                writer.writeEndElement();

                writer.writeStartElement("td");
                writer.writeCharacters(user.getRegistered().toString());
                writer.writeEndElement();

                writer.writeStartElement("td");
                writer.writeCharacters(user.getAddress());
                writer.writeEndElement();

                writer.writeEndElement();
            }

            writer.writeStartElement("td");
            writer.writeCharacters("User Count: ");
            writer.writeEndElement();

            writer.writeStartElement("td");
            writer.writeAttribute("colspan", "5");
            writer.writeCharacters(String.valueOf(users.getUsers().size()));
            writer.writeEndElement();


            writer.writeStartElement("table");

            writer.writeStartElement("ru");
            writer.writeCharacters("Users from Russia: ");
            writer.writeEndElement();

            writer.writeStartElement("ru");
            writer.writeCharacters(String.valueOf(users.getByCountry("Russia").size()));
            writer.writeEndElement();

            writer.writeStartElement("table");

            writer.writeStartElement("de");
            writer.writeCharacters("Users from Germany: ");
            writer.writeEndElement();

            writer.writeStartElement("de");
            writer.writeCharacters(String.valueOf(users.getByCountry("Germany").size()));
            writer.writeEndElement();

            writer.writeStartElement("table");

            writer.writeStartElement("us");
            writer.writeCharacters("Users from United States: ");
            writer.writeEndElement();

            writer.writeStartElement("us");
            writer.writeCharacters(String.valueOf(users.getByCountry("United States").size()));
            writer.writeEndElement();

            writer.writeStartElement("table");

            writer.writeStartElement("au");
            writer.writeCharacters("Users from Austria: ");
            writer.writeEndElement();

            writer.writeStartElement("au");
            writer.writeCharacters(String.valueOf(users.getByCountry("Austria").size()));
            writer.writeEndElement();

            writer.writeStartElement("table");

            writer.writeStartElement("pl");
            writer.writeCharacters("Users from Poland: ");
            writer.writeEndElement();

            writer.writeStartElement("pl");
            writer.writeCharacters(String.valueOf(users.getByCountry("Poland").size()));
            writer.writeEndElement();

            writer.writeEndElement();
            return output;
        }
    }

    public void createHTML(Writer output) throws IOException {
        File fileHTML = new File(".\\src\\main\\resources\\users.html");
        fileHTML.createNewFile();
        FileOutputStream oFile = new FileOutputStream(fileHTML, false);
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(oFile)); //
            writer.write(output.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {/*ignore*/}
        }
    }
}
