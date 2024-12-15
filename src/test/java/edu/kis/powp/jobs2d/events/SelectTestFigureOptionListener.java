package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.AbstractDriverAdapter;
public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private Consumer<AbstractDriver> testFigureScript;

	public SelectTestFigureOptionListener(DriverManager driverManager, Consumer<AbstractDriver> testFigureScript) {
		this.driverManager = driverManager;
		this.testFigureScript = testFigureScript;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		testFigureScript.accept(new AbstractDriverAdapter(driverManager.getCurrentDriver()));
	}
}
