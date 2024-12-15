package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.Job2dDriver;

/**
 * AbstractDriverAdapter is an adapter for AbstractDriver delegating calls to
 * the current Job2dDriver.
 */
public class AbstractDriverAdapter extends AbstractDriver {
    private Job2dDriver currentDriver;

    public AbstractDriverAdapter(Job2dDriver currentDriver) {
        super(0, 0);
        this.currentDriver = currentDriver;
    }

    @Override
    public void operateTo(int x, int y) {
        currentDriver.setPosition(this.getX(), this.getY());
        currentDriver.operateTo(x, y);
        super.setPosition(x, y);
    }
}