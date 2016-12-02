package dev.android.remixerdemo;

import android.app.Application;

import com.google.android.libraries.remixer.Remixer;
import com.google.android.libraries.remixer.ui.RemixerInitialization;

/**
 * Created by ronaldvelasquez on 2/12/16.
 */

public class RemixerApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RemixerInitialization.initRemixer(Remixer.getInstance(), this);
    }
}
