package ui;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Класс достает текст из элемента без дочерних элементов.
 */
public class ElementWithText {
    private final Element element;

    public ElementWithText(Element element) {
        this.element = element;
    }

    public void addToContentBox(VBox vBox){
        NodeList childNodes = element.getChildNodes();
        if (childNodes.getLength() == 1){
            Node node = childNodes.item(0);
            if (node.getNodeName().equals("#text")) vBox.getChildren().add(new TextField(node.getTextContent()));
        }
    }
}
