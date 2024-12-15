package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class ComplexFactory {
    public static DriverCommand Square(Job2dDriver driver) {
        ComplexCommand complexCommand = new ComplexCommand();

        complexCommand.add(new SetPositionCommand(-120, -120, driver));
        complexCommand.add(new OperateToCommand(120, -120, driver));
        complexCommand.add(new OperateToCommand(120, 120, driver));
        complexCommand.add(new OperateToCommand(-120, 120, driver));
        complexCommand.add(new OperateToCommand(-120, -120, driver));

        return complexCommand;
    }
}
