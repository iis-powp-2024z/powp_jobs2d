package edu.kis.powp.commands;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand{
    private Job2dDriver job2dDriver;
    private int x;
    private int y;

    public OperateToCommand(Job2dDriver job2dDriver, int x, int y) {
        this.job2dDriver = job2dDriver;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        job2dDriver.operateTo(x, y);
    }
}
