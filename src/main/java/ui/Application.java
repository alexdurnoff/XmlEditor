package ui;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        XmlEditorPane xmlEditorPane = new XmlEditorPane();
        Scene scene = new Scene(xmlEditorPane, 1300, 700);
        primaryStage.setTitle("XmlEditor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
