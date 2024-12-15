package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;

	public SelectTestFigureOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand().toLowerCase()) {
			case "figure joe 1":
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;

			case "figure joe 2":
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;

			case "jane":
				new SetPositionCommand(10, 10, driverManager.getCurrentDriver()).execute();
				break;
		}
	}
}
