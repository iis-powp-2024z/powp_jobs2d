package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;

/**
 * DrawerDriverAdapter is an adapter for Job2dDriver that draws lines when operating.
 */
public class DrawerDriverAdapter implements Job2dDriver {
	private int x = 0, y = 0;
	private DrawPanelController drawerController;

	public DrawerDriverAdapter(DrawPanelController drawerController) {
		this.drawerController = drawerController;
	}

	@Override
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void operateTo(int x, int y) {
		ILine line = LineFactory.getBasicLine();
		line.setStartCoordinates(this.x, this.y);
		line.setEndCoordinates(x, y);
		setPosition(x, y);

		drawerController.drawLine(line);
	}

	@Override
	public String toString() {
		return "Drawer driver";
	}
}
