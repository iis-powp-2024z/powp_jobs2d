package edu.kis.powp.jobs2d.helpers;

import edu.kis.legacy.drawer.shape.ILine;

public class LineSettings {
    private LineType lineType = LineType.BASIC;

	public void setLineType(LineType lineType) {
		this.lineType = lineType;
	}

    public ILine getLine() {
        return lineType.getLine();
    }
    }
