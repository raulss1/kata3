package software.ulpgc.kata3.architecture.model;

import software.ulpgc.kata3.apps.windows.Title;

public class TsvTitleDeserializer implements TitleDeserializer {
    @Override
    public Title deserialize(String data) {
        return deserialize(data.split("\t"));
    }

    private Title deserialize(String[] fields) {
        return new Title(
                fields[0],
                toTitleType(fields[1]),
                toInteger(fields[5]));
    }


    private int toInteger(String field) {
        if (field.equals("\\N")) return 0;
        return Integer.parseInt(field);
    }

    private Title.TitleType toTitleType(String field) {
        return Title.TitleType.valueOf(normalize(field));
    }

    private String normalize(String field) {
        String upperCase = field.toUpperCase();
        String temp =  field.replace("-","");
        return upperCase.toCharArray()[0] + temp.substring(1);
    }


}
