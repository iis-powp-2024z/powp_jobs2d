package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.ComplexFactory;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.enums.TestNames;
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
		switch(e.getActionCommand()) {
			case TestNames.FigureJoe1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;

			case TestNames.FigureJoe2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;

			case TestNames.Command:
				FiguresJoeDecorator.CommandSquareCrossed(driverManager.getCurrentDriver());
				break;

			case TestNames.CommandComplex:
				FiguresJoeDecorator.ComplexCommandSquareCrossed(driverManager.getCurrentDriver());
				break;

			case TestNames.CommandComplexFactorySquare:
				ComplexFactory.Square(driverManager.getCurrentDriver()).execute();
				break;

			case TestNames.CommandComplexFactoryTriangle:
				ComplexFactory.Triangle(driverManager.getCurrentDriver()).execute();
				break;
		}
	}
}
