package com.github.shirahata777.chapter10;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesTest2 {

    public static void main(String[] args) throws Exception {
        // ResourceBundleでもpropertyを読み込める
        File dicDir = Paths.get(".").toFile();
        URLClassLoader urlLoader;
        urlLoader = new URLClassLoader(new URL[]{dicDir.toURI().toURL()});
        ResourceBundle resource = ResourceBundle.getBundle("test_props", Locale.JAPAN, urlLoader);
        System.out.println(resource.getString("key2"));

        // propertiesファイルが存在しない場合はMissingResoureceExceptionが発生
        ResourceBundle resourceNotFind = ResourceBundle.getBundle("test_props2", Locale.JAPAN, urlLoader);
        System.out.println(resourceNotFind.getString("key2"));
    }
    
}
