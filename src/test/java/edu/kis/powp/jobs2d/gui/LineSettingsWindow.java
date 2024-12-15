package edu.kis.powp.jobs2d.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;

import edu.kis.powp.jobs2d.helpers.CustomizableLine;
import edu.kis.powp.jobs2d.helpers.LineSettings;
import edu.kis.powp.jobs2d.helpers.LineType;

public class LineSettingsWindow extends JFrame {
    private JPanel customConfigPanel;

    public LineSettingsWindow(LineSettings lineSettings) {
        super("Line Settings");
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());

        this.add(getRadioPanel(lineSettings), BorderLayout.NORTH);
        customConfigPanel = getCustomConfigPanel(lineSettings);
        this.add(customConfigPanel, BorderLayout.CENTER);
        setCustomConfigEnabled(false);
    }

    private void setCustomConfigEnabled(boolean enabled) {
        customConfigPanel.setVisible(enabled);
    }

    private JPanel getRadioPanel(LineSettings lineSettings) {
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        JRadioButton basicLineRadio = new JRadioButton("Basic Line");
        JRadioButton dottedLineRadio = new JRadioButton("Dotted Line");
        JRadioButton specialLineRadio = new JRadioButton("Special Line");
        JRadioButton customLineRadio = new JRadioButton("Custom Line");
        basicLineRadio.setSelected(true);

        basicLineRadio.addActionListener(e -> {
            lineSettings.setLineType(LineType.BASIC);
            setCustomConfigEnabled(false);
        });
        dottedLineRadio.addActionListener(e -> {
            lineSettings.setLineType(LineType.DOTTED);
            setCustomConfigEnabled(false);
        });
        specialLineRadio.addActionListener(e -> {
            lineSettings.setLineType(LineType.SPECIAL);
            setCustomConfigEnabled(false);
        });
        customLineRadio.addActionListener(e -> {
            lineSettings.setLineType(LineType.CUSTOM);
            setCustomConfigEnabled(true);
        });

        ButtonGroup lineTypeGroup = new ButtonGroup();
        lineTypeGroup.add(basicLineRadio);
        lineTypeGroup.add(dottedLineRadio);
        lineTypeGroup.add(specialLineRadio);
        lineTypeGroup.add(customLineRadio);

        radioPanel.add(basicLineRadio);
        radioPanel.add(Box.createVerticalStrut(5));
        radioPanel.add(dottedLineRadio);
        radioPanel.add(Box.createVerticalStrut(5));
        radioPanel.add(specialLineRadio);
        radioPanel.add(Box.createVerticalStrut(5));
        radioPanel.add(customLineRadio);

        return radioPanel;
    }

    private JPanel getCustomConfigPanel(LineSettings lineSettings) {
        JPanel customConfigPanel = new JPanel();
        customConfigPanel.setLayout(new GridLayout(2, 1));
        CustomizableLine line = lineSettings.getCustomizableLine();

        customConfigPanel.add(getColorChooser(line));
        customConfigPanel.add(getThicknessDottedPanel(line));

        return customConfigPanel;
    }

    private JColorChooser getColorChooser(CustomizableLine line) {
        JColorChooser colorChooser = new JColorChooser(line.getColor());
        colorChooser.setPreviewPanel(new JPanel());
        colorChooser.setChooserPanels(new AbstractColorChooserPanel[] {
                colorChooser.getChooserPanels()[0]
        });
        colorChooser.getSelectionModel().addChangeListener(e -> {
            Color selectedColor = colorChooser.getColor();
            line.setColor(selectedColor);
        });
        return colorChooser;
    }

    private JPanel getThicknessDottedPanel(CustomizableLine line) {
        JPanel thicknessDottedPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        thicknessDottedPanel.add(new JLabel("Thickness:"));

        JSpinner thicknessSpinner = new JSpinner(new SpinnerNumberModel(line.getThickness(), 0.1, 10.0, 0.1));
        thicknessSpinner.addChangeListener(e -> {
            float thickness = (float) (double) thicknessSpinner.getValue();
            line.setThickness(thickness);
        });
        thicknessDottedPanel.add(thicknessSpinner);

        JCheckBox dottedCheckBox = new JCheckBox("Dotted Line", line.isDotted());
        dottedCheckBox.addActionListener(e -> {
            boolean isDotted = dottedCheckBox.isSelected();
            line.setDotted(isDotted);
        });
        thicknessDottedPanel.add(dottedCheckBox);
        return thicknessDottedPanel;
    }
}
