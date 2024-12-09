package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.apps.windows.Title;
import software.ulpgc.kata3.architecture.model.Barchart;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class TsvBarchartLoader   implements BarchartLoader {
    @Override
    public Barchart load(int id) {
        return switch (id) {
            case 0 -> barchart0();
            case 1 -> barchart1();
            default -> null;
        };
    }

    private Barchart barchart0() {
        Barchart barchart = new Barchart("StartYear", "x", "y");
        File file = new File("title.basics.tsv");
        List<Title> titles = new TsvFileTitleReader(file).read();
        HashMap<Integer, Integer> histogram = new HashMap<>();
        for (Title title : titles) {
            if (title.getStartyear() > 2010 && title.getStartyear() < 2025)
                histogram.put(title.getStartyear(), histogram.getOrDefault(title.getStartyear(), 0) + 1);
        }

        for (Integer integer : histogram.keySet()) {
            barchart.put(Integer.toString(integer), histogram.get(integer));
        }
        return barchart;
    }

    private Barchart barchart1() {
        Barchart barchart = new Barchart("TitleType", "x", "y");
        File file = new File("title.basics.tsv");
        List<Title> titles = new TsvFileTitleReader(file).read();
        HashMap<Title.TitleType, Integer> histogram = new HashMap<>();
        for (Title title : titles) {
            histogram.put(title.getTitleType(), histogram.getOrDefault(title.getTitleType(),0) + 1);
        }
        for (Title.TitleType titleType : histogram.keySet()) {
            barchart.put(String.valueOf(titleType), histogram.get(titleType));
        }
        return barchart;
    }
}
