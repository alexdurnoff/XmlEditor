package ui;

import javafx.scene.layout.VBox;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Класс будет брать контент из xml-документа и запихивать его в VBox.
 */
public class DocumentContent {
    private final Path filePath;

    public DocumentContent(Path filePath) {
        this.filePath = filePath;
    }

    public void addToContentBox(VBox contentBox) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = factory.newDocumentBuilder();
            DocumentWithElementList document =new DocumentWithElementList(documentBuilder.parse(filePath.toFile()));
            document.elementList().forEach(element -> {
                new NodeContent(element).addToContentVbox(contentBox);
            });
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

    }
}
