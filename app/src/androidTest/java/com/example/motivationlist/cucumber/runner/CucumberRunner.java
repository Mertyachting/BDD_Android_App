package com.example.motivationlist.cucumber.runner;

import android.os.Bundle;

import java.io.File;

import cucumber.api.CucumberOptions;
import cucumber.api.android.CucumberAndroidJUnitRunner;

public class CucumberRunner extends CucumberAndroidJUnitRunner{
    @Override
    public void onCreate(final Bundle bundle) {
        bundle.putString("plugin", getPluginConfigurationString()); // we programmatically create the plugin configuration
        super.onCreate(bundle);
    }

    /**
     * Since we want to checkout the external storage directory programmatically, we create the plugin configuration
     * here, instead of the {@link CucumberOptions} annotation.
     *
     * @return the plugin string for the configuration, which contains XML, HTML and JSON paths
     */
    private String getPluginConfigurationString() {
        String cucumber = "cucumber";
        String separator = "--";
        return "junit:" + getAbsoluteFilesPath() + "/" + cucumber + ".xml" + separator +
                "html:" + getAbsoluteFilesPath() + "/" + cucumber + ".html" + separator +
                "json:" + getAbsoluteFilesPath() + "/" + cucumber + ".json";
    }

    /**
     * The path which is used for the report files.
     *
     * @return the absolute path for the report files
     */
    private String getAbsoluteFilesPath() {

        //sdcard/Android/data/cucumber.cukeulator
        File directory = getTargetContext().getExternalFilesDir(null);
        return new File(directory,"reports").getAbsolutePath();
    }
}
