package edu.kis.powp.jobs2d.magicpresets;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

public class FiguresJoeDecorator extends FiguresJoe {
    public static void CommandSquareCrossed(Job2dDriver driver) {
        new SetPositionCommand(-120, -120,driver).execute();
        new OperateToCommand(120, -120, driver).execute();
        new OperateToCommand(120, 120, driver).execute();
        new OperateToCommand(-120, 120, driver).execute();
        new OperateToCommand(-120, -120,driver).execute();
        new OperateToCommand(120, 120, driver).execute();
        new SetPositionCommand(120, -120, driver).execute();
        new OperateToCommand(-120, 120, driver).execute();
    }

    public static void ComplexCommandSquareCrossed(Job2dDriver driver) {
        ComplexCommand complexCommand = new ComplexCommand();

        complexCommand.add(new SetPositionCommand(-120, -120, driver));
        complexCommand.add(new OperateToCommand(120, -120, driver));
        complexCommand.add(new OperateToCommand(120, 120, driver));
        complexCommand.add(new OperateToCommand(-120, 120, driver));
        complexCommand.add(new OperateToCommand(-120, -120, driver));
        complexCommand.add(new OperateToCommand(120, 120, driver));
        complexCommand.add(new SetPositionCommand(120, -120, driver));
        complexCommand.add(new OperateToCommand(-120, 120, driver));

        complexCommand.execute();
    }
}
