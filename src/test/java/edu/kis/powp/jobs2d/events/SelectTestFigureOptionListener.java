package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.command.*;
import edu.kis.powp.jobs2d.drivers.factory.CommandFactory;
import edu.kis.powp.jobs2d.enums.TestFigure;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

    private DriverManager driverManager;

    public SelectTestFigureOptionListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        TestFigure figure = TestFigure.valueOf(actionCommand);

        switch (figure) {
            case FIGURE_JOE_1:
                FiguresJoe.figureScript1(driverManager.getCurrentDriver());
                break;
            case FIGURE_JOE_2:
                FiguresJoe.figureScript2(driverManager.getCurrentDriver());
                break;

            case RECTANGLE:
                DriverCommand rectangleCommand =
                        CommandFactory.createRectangle(driverManager.getCurrentDriver(), 0, 0, 100, 100);
                rectangleCommand.execute();
                break;

            case TRIANGLE:
                DriverCommand triangleCommand =
                        CommandFactory.createTriangle(driverManager.getCurrentDriver(), 0, 0, 100, 100);
                triangleCommand.execute();
                break;

            default:
                System.out.println("Undefined action command: " + actionCommand);
                break;
        }
    }
}
