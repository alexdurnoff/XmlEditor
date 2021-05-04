package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Панель выбора файла данных и редактируемого файла.
 * Из файла данных часть данных будут переноситься в редактируемый файл.
 */
public class FilesChooserPane extends VBox {
    private final HBoxWithButtonAndTextField sourceHBox;
    private final HBoxWithButtonAndTextField editedHBox;
    private final Button editButton;


    public FilesChooserPane(EventHandler<ActionEvent> eventHandler){
        this.sourceHBox = new HBoxWithButtonAndTextField("Выбрать файл для импорта данных");
        this.editedHBox = new HBoxWithButtonAndTextField("Выбрать редактируемый файл");
        this.editButton = new Button("Редактировать");
        this.editButton.setOnAction(eventHandler);
        this.getChildren().addAll(sourceHBox, editedHBox, editButton);
    }

    public Path editedFilePath() throws IOException {
        Path sourcePath = Paths.get("");
        Path editedPath = Paths.get("");
        try {
            sourcePath = this.sourceHBox.path();
        } catch (IllegalStateException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Не выбран файл для импорта данных");
            alert.showAndWait();
        }

        try {
            editedPath = this.editedHBox.path();
        } catch (IllegalStateException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Не выбран редактируемый файл");
            alert.showAndWait();
        }

        return new XmlFileWithImportedData(sourcePath, editedPath).getPath();
    }


}
