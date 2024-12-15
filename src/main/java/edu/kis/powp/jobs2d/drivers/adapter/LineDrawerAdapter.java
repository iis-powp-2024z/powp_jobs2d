package edu.kis.powp.jobs2d.drivers.adapter;

import java.util.function.Supplier;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;

/**
 * LineDrawerAdapter is an adapter for Job2dDriver that draws provided line when operating.
 */
public class LineDrawerAdapter implements Job2dDriver {
	private int x = 0, y = 0;
	private DrawPanelController drawerController;
	private Supplier<ILine> lineSupplier;
	
	public LineDrawerAdapter(DrawPanelController drawerController, Supplier<ILine> lineSupplier) {
		this.drawerController = drawerController;
        this.lineSupplier = lineSupplier;
    }
	
	@Override
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void operateTo(int x, int y) {
		ILine line = lineSupplier.get();
		line.setStartCoordinates(this.x, this.y);
		line.setEndCoordinates(x, y);
		setPosition(x, y);
		
		drawerController.drawLine(line);
	}

	@Override
	public String toString() {
		return "Line Drawer Driver";
	}
}
