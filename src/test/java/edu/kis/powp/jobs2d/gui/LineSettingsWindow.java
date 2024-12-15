package edu.kis.powp.jobs2d.gui;

import java.awt.BorderLayout;

import javax.swing.*;

import edu.kis.powp.jobs2d.helpers.LineSettings;
import edu.kis.powp.jobs2d.helpers.LineType;

public class LineSettingsWindow extends JFrame {

    public LineSettingsWindow(LineSettings lineSettings) {
        super("Line Settings");
        this.setSize(500, 300);
        this.setLayout(new BorderLayout());

        this.add(getRadioPanel(lineSettings), BorderLayout.NORTH);
    }

    private JPanel getRadioPanel(LineSettings lineSettings) {
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        JRadioButton basicLineRadio = new JRadioButton("Basic Line");
        JRadioButton dottedLineRadio = new JRadioButton("Dotted Line");
        JRadioButton specialLineRadio = new JRadioButton("Special Line");
        basicLineRadio.setSelected(true);

        basicLineRadio.addActionListener(e -> {
            lineSettings.setLineType(LineType.BASIC);
        });
        dottedLineRadio.addActionListener(e -> {
            lineSettings.setLineType(LineType.DOTTED);
        });
        specialLineRadio.addActionListener(e -> {
            lineSettings.setLineType(LineType.SPECIAL);
        });

        ButtonGroup lineTypeGroup = new ButtonGroup();
        lineTypeGroup.add(basicLineRadio);
        lineTypeGroup.add(dottedLineRadio);
        lineTypeGroup.add(specialLineRadio);

        radioPanel.add(basicLineRadio);
        radioPanel.add(Box.createVerticalStrut(5));
        radioPanel.add(dottedLineRadio);
        radioPanel.add(Box.createVerticalStrut(5));
        radioPanel.add(specialLineRadio);

        this.add(radioPanel, BorderLayout.NORTH);
        basicLineRadio.setSelected(true);
        basicLineRadio.addActionListener(e -> {
            lineSettings.setLineType(LineType.BASIC);
        });
        dottedLineRadio.addActionListener(e -> {
            lineSettings.setLineType(LineType.DOTTED);
        });
        specialLineRadio.addActionListener(e -> {
            lineSettings.setLineType(LineType.SPECIAL);
        });

        return radioPanel;
    }
}
