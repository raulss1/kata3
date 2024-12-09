package software.ulpgc.kata3.architecture.model;

import software.ulpgc.kata3.apps.windows.Title;

public interface TitleDeserializer {
    Title deserialize(String data);
}
