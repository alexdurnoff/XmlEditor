package ui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class XmlFileWithImportedData {
    private final Path sourceFile;
    private final Path editedFile;

    public XmlFileWithImportedData(Path sourceFile, Path editedFile) {
        this.sourceFile = sourceFile;
        this.editedFile = editedFile;
    }

    /**
     * Импортирует данные из одного файла в другой.
     */
    private void importData() throws IOException {
        Files.copy(sourceFile, editedFile);

    }

    public Path getPath() throws IOException {
        importData();
        return editedFile;
    }
}
