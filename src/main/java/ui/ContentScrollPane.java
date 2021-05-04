package ui;

import javafx.scene.control.ScrollPane;

import java.io.IOException;

/**
 * Заворачивает ContentBox в ScrollPane
 */
public class ContentScrollPane extends ScrollPane{
    private final ContentBox contentBox;

    public ContentScrollPane(ContentBox contentBox){
        super(contentBox);
        this.contentBox = contentBox;
    }

    public void saveToFile() throws IOException {
        this.contentBox.saveToFile();
    }
}

