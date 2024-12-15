package edu.kis.powp.jobs2d.helpers;

import edu.kis.legacy.drawer.shape.ILine;

public class LineSettings {
    private LineType lineType = LineType.BASIC;
    private final static CustomizableLine customizableLine = new CustomizableLine();

	public void setLineType(LineType lineType) {
		this.lineType = lineType;
	}

    public ILine getLine() {
        if (lineType == LineType.CUSTOM) {
            return customizableLine;
        }
        return lineType.getLine();
    }

    public CustomizableLine getCustomizableLine() {
        return customizableLine;
    }
}
