package edu.kis.powp.jobs2d.features;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.events.SelectTestFigureOptionListener;

import java.util.function.Consumer;

public class FigureFeature {
    private static Application app;

    public static void setupTestsPlugin(Application application) {
        app = application;
    }
    public static void addTest(String name, Consumer<Job2dDriver> figureScript) {
        SelectTestFigureOptionListener selectFigure = new SelectTestFigureOptionListener(
                DriverFeature.getDriverManager(), figureScript);

        app.addTest(name, selectFigure);
    }
}
