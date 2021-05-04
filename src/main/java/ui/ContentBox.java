package ui;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Класс для отображения контента xml-файла.
 * Сохраняет данные на диск.
 */
public class ContentBox extends VBox {
    private final Path contentFilePath;

    public ContentBox(Path contentFilePath) {
        this.contentFilePath = contentFilePath;
        new DocumentContent(contentFilePath).addToContentBox(this);
    }

    public void saveToFile() throws IOException {
        BufferedWriter bufferedWriter = Files.newBufferedWriter(this.contentFilePath);
        ObservableList<Node> children = this.getChildren();
        children.forEach(node -> {
            TextField textField = (TextField) node;
            try {
                bufferedWriter.write(textField.getText());
                bufferedWriter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
