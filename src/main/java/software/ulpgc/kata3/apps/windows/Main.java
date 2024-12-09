package software.ulpgc.kata3.apps.windows;

import software.ulpgc.kata3.architecture.control.SelectStatisticCommand;
import software.ulpgc.kata3.architecture.io.TsvBarchartLoader;
import software.ulpgc.kata3.architecture.control.ToggleStatisticCommand;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        TsvBarchartLoader loader = new TsvBarchartLoader();
        mainFrame.put("toggle", new ToggleStatisticCommand(loader, mainFrame.barchartDisplay()));
        mainFrame.put("select", new SelectStatisticCommand(mainFrame.selectStatisticDialog(), loader, mainFrame.barchartDisplay()));
        mainFrame.barchartDisplay().show(loader.load(0));
        mainFrame.setVisible(true);
    }

}
