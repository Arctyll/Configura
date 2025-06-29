package org.arctyll.configura.utils;

public class PlatformUtils {
    public static boolean isAndroid() {
        String osName = System.getProperty("os.name").toLowerCase();
        return osName.contains("android");
    }
}
