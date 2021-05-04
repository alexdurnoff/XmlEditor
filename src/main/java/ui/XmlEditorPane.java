package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;


public class XmlEditorPane extends BorderPane {
    private final FilesChooserPane filesChooserPane;


    public XmlEditorPane() {
        XmlEditorMenuBar menuBar = new XmlEditorMenuBar(this.open(), this.saveContent());
        this.setTop(menuBar);
        this.filesChooserPane = new FilesChooserPane(this.edit());
        this.setBottom(filesChooserPane);
    }

    private EventHandler<ActionEvent> saveContent() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Node center = getCenter();
                if (center != null){
                    ContentScrollPane contentScrollPane = (ContentScrollPane) center;
                    try {
                        contentScrollPane.saveToFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    private EventHandler<ActionEvent> edit() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    setCenter(new ContentBox(filesChooserPane.editedFilePath()));
                } catch (IllegalStateException | IOException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
                    alert.showAndWait();
                }
            }
        };
    }

    private EventHandler<ActionEvent> open() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("xml-files", "xml"));
                File file = fileChooser.showOpenDialog(getScene().getWindow());
                setCenter(new ContentScrollPane(new ContentBox(file.toPath())));
            }
        };
    }


}
