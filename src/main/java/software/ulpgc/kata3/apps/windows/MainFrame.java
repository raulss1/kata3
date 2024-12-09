package software.ulpgc.kata3.apps.windows;

import software.ulpgc.kata3.architecture.view.BarchartDisplay;
import software.ulpgc.kata3.architecture.control.Command;
import software.ulpgc.kata3.architecture.view.SelectStatisticDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands;
    private final JFreeBarchartDisplay barchartDisplay;
    private SelectStatisticDialog selectStatisticDialog;

    public MainFrame() throws HeadlessException {
        this.setTitle("Kata 3");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, toolbar());
        this.add(barchartDisplay = statisticPanel());
        this.commands = new HashMap<>();
    }

    public void put(String name, Command command) {
        commands.put(name, command);
    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.add(toggle());
        panel.add(selector());
        return panel;
    }

    private Component selector() {
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("StartYear");
        comboBox.addItem("TitleType");
        comboBox.addItemListener(e -> {
            if (e.getStateChange() != ItemEvent.SELECTED) return;
            commands.get("select").execute();
        });
        selectStatisticDialog = comboBox::getSelectedIndex;
        return comboBox;
    }

    private JButton toggle() {

        JButton button = new JButton("toggle");
        button.addActionListener(e -> commands.get("toggle").execute());
        return button;
    }

    private JFreeBarchartDisplay statisticPanel() {
        return new JFreeBarchartDisplay();
    }


    public BarchartDisplay barchartDisplay() {
        return barchartDisplay;
    }

    public SelectStatisticDialog selectStatisticDialog() {
        return selectStatisticDialog;
    }
}
