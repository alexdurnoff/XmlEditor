package ui;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Element со списком elementList
 */
public class ElementWithElementsList {
    private final Element element;

    public ElementWithElementsList(Element element) {
        this.element = element;
    }

    public List<Element> elementList(){
        List<Element> elementList = new ArrayList<>();
        NodeList childNodes = this.element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++){
            Node node = childNodes.item(i);
            if (node instanceof Element) elementList.add((Element) node);
        }
        return elementList;
    }
}
