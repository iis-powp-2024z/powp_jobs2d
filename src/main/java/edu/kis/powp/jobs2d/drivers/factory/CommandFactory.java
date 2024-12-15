package edu.kis.powp.jobs2d.drivers.factory;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.command.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.command.DriverCommand;
import edu.kis.powp.jobs2d.drivers.command.OperateToCommand;
import edu.kis.powp.jobs2d.drivers.command.SetPositionCommand;

public class CommandFactory {

    public static DriverCommand createRectangle(Job2dDriver driver, int x, int y, int width, int height) {
        ComplexCommand complexCommand = new ComplexCommand();
        complexCommand.addCommand(new SetPositionCommand(x, y, driver));
        complexCommand.addCommand(new OperateToCommand(x, y + height, driver));
        complexCommand.addCommand(new OperateToCommand(x + width, y + height, driver));
        complexCommand.addCommand(new OperateToCommand(x + width, y, driver));
        complexCommand.addCommand(new OperateToCommand(x, y, driver));
        return complexCommand;
    }

    public static DriverCommand createTriangle(Job2dDriver driver, int x, int y, int base, int height) {
        ComplexCommand complexCommand = new ComplexCommand();
        complexCommand.addCommand(new SetPositionCommand(x, y, driver));
        complexCommand.addCommand(new OperateToCommand(x + base, y, driver));
        complexCommand.addCommand(new OperateToCommand(x + (base / 2), y + height, driver));
        complexCommand.addCommand(new OperateToCommand(x, y, driver));
        return complexCommand;
    }
}