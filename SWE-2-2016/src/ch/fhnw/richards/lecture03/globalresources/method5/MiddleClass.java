package ch.fhnw.richards.lecture03.globalresources.method5;

import java.util.Locale;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class MiddleClass {
    // Display an instance of LastClass, which
    // also needs access to our shared resource
    public void go() {
        // LastClass lc = Guice.createInjector(new
        // GuiceModule()).getInstance(LastClass.class);

        // GuiceModule guice = new GuiceModule();
        // MainClass.injector = Guice.createInjector(MainClass.guice);

        LastClass lc = MainClass.injector.getInstance(LastClass.class);

    }

}
