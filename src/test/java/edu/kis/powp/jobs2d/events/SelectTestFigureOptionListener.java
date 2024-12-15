package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.ComplexFactory;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoeDecorator;

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

			case "command":
				FiguresJoeDecorator.CommandSquareCrossed(driverManager.getCurrentDriver());
				break;

			case "command complex":
				FiguresJoeDecorator.ComplexCommandSquareCrossed(driverManager.getCurrentDriver());
				break;

			case "command complex factory square":
				ComplexFactory.Square(driverManager.getCurrentDriver()).execute();
				break;

			case "command complex factory triangle":
				ComplexFactory.Triangle(driverManager.getCurrentDriver()).execute();
				break;
		}
	}
}
