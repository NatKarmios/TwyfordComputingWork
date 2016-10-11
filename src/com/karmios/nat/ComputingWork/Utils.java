package com.karmios.nat.ComputingWork;

import java.nio.file.FileSystems;

public class Utils {
    public static String getDir(Class cls) {
        String sep = FileSystems.getDefault().getSeparator();
        return System.getProperty("user.dir") + sep + "src" + sep + cls.getPackage().getName().replace(".", sep) + sep;
    }
}
