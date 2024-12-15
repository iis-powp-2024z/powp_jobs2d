package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.ComplexFactory;
import edu.kis.powp.command.OperateToCommand;
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

			case "command":
				new SetPositionCommand(-120, -120, driverManager.getCurrentDriver()).execute();
				new OperateToCommand(120, -120, driverManager.getCurrentDriver()).execute();
				new OperateToCommand(120, 120, driverManager.getCurrentDriver()).execute();
				new OperateToCommand(-120, 120, driverManager.getCurrentDriver()).execute();
				new OperateToCommand(-120, -120, driverManager.getCurrentDriver()).execute();
				new OperateToCommand(120, 120, driverManager.getCurrentDriver()).execute();
				new SetPositionCommand(120, -120, driverManager.getCurrentDriver()).execute();
				new OperateToCommand(-120, 120, driverManager.getCurrentDriver()).execute();
				break;

			case "command complex":
				ComplexCommand complexCommand = new ComplexCommand();
				complexCommand.add(new SetPositionCommand(-120, -120, driverManager.getCurrentDriver()));
				complexCommand.add(new OperateToCommand(120, -120, driverManager.getCurrentDriver()));
				complexCommand.add(new OperateToCommand(120, 120, driverManager.getCurrentDriver()));
				complexCommand.add(new OperateToCommand(-120, 120, driverManager.getCurrentDriver()));
				complexCommand.add(new OperateToCommand(-120, -120, driverManager.getCurrentDriver()));
				complexCommand.add(new OperateToCommand(120, 120, driverManager.getCurrentDriver()));
				complexCommand.add(new SetPositionCommand(120, -120, driverManager.getCurrentDriver()));
				complexCommand.add(new OperateToCommand(-120, 120, driverManager.getCurrentDriver()));
				complexCommand.execute();
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
