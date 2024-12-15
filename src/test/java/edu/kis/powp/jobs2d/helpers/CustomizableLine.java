package edu.kis.powp.jobs2d.helpers;

import java.awt.Color;

import edu.kis.legacy.drawer.shape.line.AbstractLine;

public class CustomizableLine extends AbstractLine {
	public void setColor(Color color) {
		this.color = color;
	}

	public void setThickness(float thickness) {
		this.thickness = thickness;
	}
	
	public void setDotted(boolean dotted) {
		this.dotted = dotted;
	}
}
