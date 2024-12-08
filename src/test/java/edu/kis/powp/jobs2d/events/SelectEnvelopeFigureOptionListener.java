package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.AbstractDriverAdapter;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;

public class SelectEnvelopeFigureOptionListener implements ActionListener {

    private DriverManager driverManager;

    public SelectEnvelopeFigureOptionListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractDriver driver = new AbstractDriverAdapter(driverManager.getCurrentDriver());
        FiguresJane.figureScript(driver);
    }
}
