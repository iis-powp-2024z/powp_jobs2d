package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public interface DriverCommand {
    Job2dDriver driver = null;
    void execute();
}
