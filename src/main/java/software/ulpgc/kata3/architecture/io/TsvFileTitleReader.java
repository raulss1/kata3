package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.apps.windows.Title;
import software.ulpgc.kata3.architecture.model.TsvTitleDeserializer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TsvFileTitleReader implements TitleReader {
    private final File file;

    public TsvFileTitleReader(File file) {
        this.file = file;
    }

    @Override
    public List<Title> read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine();
            return readWith(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Title> readWith(BufferedReader reader) throws IOException {
        TsvTitleDeserializer deserializer = new TsvTitleDeserializer();
        List<Title> result = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            Title title = deserializer.deserialize(line);
            result.add(title);
        }
        return result;
    }

}
