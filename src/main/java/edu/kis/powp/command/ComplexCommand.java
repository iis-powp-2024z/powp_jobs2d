package edu.kis.powp.command;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand {
    public List<DriverCommand> commands = new ArrayList<DriverCommand>();

    @Override
    public void execute() {
        for (DriverCommand command : this.commands) {
            command.execute();
        }
    }

    public void add(DriverCommand command) {
        this.commands.add(command);
    }
}
