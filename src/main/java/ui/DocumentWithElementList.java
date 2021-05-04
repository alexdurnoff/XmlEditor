package ui;

import org.w3c.dom.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс инкапсулирует Document и отдает список всех его элементов.
 * В данном с лучае в жопу декоратор. Триста строк методов переопределять!
 */
public class DocumentWithElementList {
    private final Document document;


    public DocumentWithElementList(Document document) {
        this.document = document;
    }

    public List<Element> elementList() {
        List<Element> elementList = new ArrayList<>();
        NodeList childNodes = document.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++){
            Node node = childNodes.item(i);
            if (node instanceof Element){
                elementList.add((Element) node);
            }
        }
        return elementList;
    }
}
