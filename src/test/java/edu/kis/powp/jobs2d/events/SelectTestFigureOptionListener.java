package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private static int counter = 0;
	private DriverManager driverManager;

	public SelectTestFigureOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (counter % 2) {
			case 0:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
		
			case 1:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
		}

		counter++;
	}

	public static int getCounter() {
		return counter;
	}
}
