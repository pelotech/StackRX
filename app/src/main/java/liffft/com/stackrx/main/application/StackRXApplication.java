package liffft.com.stackrx.main.application;

import android.app.Application;

import roboguice.RoboGuice;

/**
 * Created by graemeharnish on 4/7/15.
 */
public class StackRXApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        RoboGuice.setUseAnnotationDatabases(false);

    }
}
