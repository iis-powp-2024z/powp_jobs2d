package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.Job2dDriver;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private Consumer<Job2dDriver> testFigureScript;

	public SelectTestFigureOptionListener(DriverManager driverManager, Consumer<Job2dDriver> testFigureScript) {
		this.driverManager = driverManager;
		this.testFigureScript = testFigureScript;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		testFigureScript.accept(driverManager.getCurrentDriver());
	}
}
