package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuBar;


public class XmlEditorMenuBar extends MenuBar {
    private final XmlMenu openMenu;
    private final XmlMenu saveMenu;


    public XmlEditorMenuBar(EventHandler<ActionEvent> openHandler, EventHandler<ActionEvent> saveHandler) {
        this.openMenu = new XmlMenu("open", openHandler);
        this.saveMenu = new XmlMenu("save", saveHandler);
        this.getMenus().addAll(openMenu, saveMenu);
    }

}
