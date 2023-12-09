package org.marinb.automation.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("env"));
    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
    public static String getEnv() {
        return System.getProperty("env");
    }
}
