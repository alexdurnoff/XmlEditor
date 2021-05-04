package ui;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



/**
 * Класс инкапсулирует Node и запихивает его контент в VBox;
 */
public class NodeContent {
    private final Element element;

    public NodeContent(Element element) {
        this.element = element;
    }

    public void addToContentVbox(VBox contentBox) {
        contentBox.getChildren().add(new TextFieldOpenElement((element)));
        new ElementWithText(element).addToContentBox(contentBox);
        new ElementWithElementsList(element).elementList().forEach(element1 -> {
            new NodeContent(element1).addToContentVbox(contentBox);
        });
        contentBox.getChildren().add(new TextFieldCloseElement(element));
    }
}
