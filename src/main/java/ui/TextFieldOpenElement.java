package ui;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/**
 * открывающий тэг для элемента xml-документа.
 */
public class TextFieldOpenElement extends TextField {
    private final Element element;

    public TextFieldOpenElement(Element element) {
        this.element = element;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('<').append(element.getNodeName());
        NamedNodeMap attributes = element.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++){
            stringBuilder
                    .append(' ')
                    .append(attributes.item(i).getNodeName())
                    .append('=')
                    .append(attributes.item(i).getTextContent());
        }
        stringBuilder.append('>');
        this.setText(stringBuilder.toString());
    }
}
