package edu.kis.powp.jobs2d.lines;

import edu.kis.legacy.drawer.shape.line.BasicLine;

import java.awt.*;

public class CustomLine extends BasicLine {
    public CustomLine(Color color, float thickness, boolean dotted) {
        this.color = color;
        this.thickness = thickness;
        this.dotted = dotted;
    }
}
