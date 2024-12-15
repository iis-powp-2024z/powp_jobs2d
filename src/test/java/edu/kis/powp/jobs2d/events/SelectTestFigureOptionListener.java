package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.command.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.command.OperateToCommand;
import edu.kis.powp.jobs2d.drivers.command.SetPositionCommand;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

    private DriverManager driverManager;

    public SelectTestFigureOptionListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "Figure Joe 1":
                FiguresJoe.figureScript1(driverManager.getCurrentDriver());
                break;
            case "Figure Joe 2":
                FiguresJoe.figureScript2(driverManager.getCurrentDriver());
                break;

            case "Rectangle":
                ComplexCommand complexCommand = new ComplexCommand();
                complexCommand.addCommand(new SetPositionCommand(0, 0, driverManager.getCurrentDriver()));
                complexCommand.addCommand(new OperateToCommand(0, 100, driverManager.getCurrentDriver()));
                complexCommand.addCommand(new OperateToCommand(100, 100, driverManager.getCurrentDriver()));
                complexCommand.addCommand(new OperateToCommand(100, 0, driverManager.getCurrentDriver()));
                complexCommand.addCommand(new OperateToCommand(0, 0, driverManager.getCurrentDriver()));
                complexCommand.execute();
                break;

            default:
                System.out.println("Undefined action command: " + actionCommand);
                break;
        }
    }
}
