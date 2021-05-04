package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * HBox с кнопкой и текстовым полем для выбора файла.
 * Возвращает путь к файлу.
 */
public class HBoxWithButtonAndTextField extends HBox {
    private final TextField textField;
    private final Button button;

    public HBoxWithButtonAndTextField(String buttonName){
        this.textField = new TextField();
        this.button = new Button(buttonName);
        this.button.setOnAction(ae -> {
            String path = new FileChooser().showSaveDialog(getScene().getWindow()).getPath();
            this.textField.setText(path);
        });
        this.getChildren().addAll(textField, button);
    }

    public Path path(){
        if (textField.getText() == null) throw new IllegalStateException("Не выбран файл");
        return Paths.get(this.textField.getText());
    }

}
