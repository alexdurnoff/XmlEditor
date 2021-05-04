package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class XmlMenu extends Menu {

    public XmlMenu(String name, EventHandler<ActionEvent> eventHandler){
        super(name);
        MenuItem menuItem = new MenuItem(name);
        menuItem.setOnAction(eventHandler);
        this.getItems().add(menuItem);
    }
}
