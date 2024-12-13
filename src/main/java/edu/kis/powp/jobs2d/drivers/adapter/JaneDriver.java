package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.Job2dDriver;

public class JaneDriver extends AbstractDriver {
    private Job2dDriver jobDriver;

    public JaneDriver(Job2dDriver currentDriver) {
        super(0, 0);
        jobDriver = currentDriver;
    }

    @Override
    public void operateTo(int x, int y) {
        jobDriver.operateTo(x, y);
    }

    @Override
    public String toString() {
        return "Jane Driver";
    }
}
