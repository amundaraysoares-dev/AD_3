import javax.xml.stream.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class XML {
    public static void main(String[] args) {
        XML xml = new XML();
        try {
            XMLOutputFactory archivo = XMLOutputFactory.newInstance();
            XMLStreamWriter escribir = archivo.createXMLStreamWriter(new FileOutputStream("autores.xml"), "UTF-8");

            escribir.writeStartDocument("1.0");
            escribir.writeStartElement("autores");
            escribir.writeStartElement("autor");
            escribir.writeAttribute("codigo", "a1");

            escribir.writeStartElement("nome");
            escribir.writeCharacters("Alexandre Dumas ");
            escribir.writeEndElement();

            escribir.writeStartElement("titulo");
            escribir.writeCharacters(" El conde de montecristo");
            escribir.writeEndElement();

            escribir.writeStartElement("titulo");
            escribir.writeCharacters(" Los miserables ");
            escribir.writeEndElement();

            escribir.writeEndElement(); // Cierra autor a1

            escribir.writeStartElement("autor");
            escribir.writeAttribute("codigo", "a2");

            escribir.writeStartElement("nome");
            escribir.writeCharacters("Fiodor Dostoyevski");
            escribir.writeEndElement();

            escribir.writeStartElement("titulo");
            escribir.writeCharacters(" El idiota");
            escribir.writeEndElement();

            escribir.writeStartElement("titulo");
            escribir.writeCharacters(" Noches blancas ");
            escribir.writeEndElement();

            escribir.writeEndElement();

            escribir.writeEndElement();
            escribir.writeEndDocument();

            escribir.flush();
            escribir.close();
        }
        catch (XMLStreamException | IOException e) {
            System.out.println("No se puede crear el documento");

        }

    }
}