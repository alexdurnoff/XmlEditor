package ui;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.w3c.dom.Element;
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
        NodeList childNodes = element.getChildNodes();
        contentBox.getChildren().add(new TextFieldOpenElement((element)));
        if (childNodes.getLength() > 0){
            for (int i = 0; i < childNodes.getLength(); i++){
                Node node = childNodes.item(i);
                if (node instanceof Element){
                    Element element1 = (Element) node;
                    new NodeContent(element1).addToContentVbox(contentBox);
                }
            }
        }
        contentBox.getChildren().add(new TextField(element.getTextContent()));
        contentBox.getChildren().add(new TextFieldCloseElement(element));
    }
}
