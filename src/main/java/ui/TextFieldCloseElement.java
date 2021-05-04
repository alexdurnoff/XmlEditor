package ui;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import org.w3c.dom.Element;

public class TextFieldCloseElement extends TextField {
    public TextFieldCloseElement(Element element) {
        this.setText("</" + element.getNodeName() + ">");
    }
}
