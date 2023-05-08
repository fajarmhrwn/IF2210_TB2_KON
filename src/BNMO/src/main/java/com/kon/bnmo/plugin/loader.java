package com.kon.bnmo.plugin;

import com.kon.bnmo.datastore.DataStore;
import javafx.scene.control.Tab;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class loader extends Tab {
    DataStore dataStore;

    public loader(Tab tab ,DataStore dataStore,String str){
        String jarFilePath = "/Users/fajarherawan/Documents/IF2210_TB2_KON/src/BNMO/plugin1.jar"; // Specify the path to the JAR file
        try{
            System.out.println(str.substring(str.length()-11));
            if(str.substring(str.length()-11).equals("plugin1.jar")){
                URLClassLoader classLoader = new URLClassLoader(new URL[]{new File(jarFilePath).toURI().toURL()});


                Class<?> chartPage = classLoader.loadClass("com.example.demo3.ChartPage");
                Constructor<?> constructor = chartPage.getConstructor(Tab.class, DataStore.class);

                Object chartResult = constructor.newInstance(tab,dataStore);

            }
            else if(str.substring(str.length()-11).equals("plugin2.jar")) {
                URLClassLoader classLoader = new URLClassLoader(new URL[]{new File(jarFilePath).toURI().toURL()});


                Class<?> chartPage = classLoader.loadClass("com.example.demo3.ChartPage");
                Constructor<?> constructor = chartPage.getConstructor(Tab.class, DataStore.class);

                Object chartResult = constructor.newInstance(tab, dataStore);
            }
            else if(str.substring(str.length()-11).equals("plugin3.jar")) {
                URLClassLoader classLoader = new URLClassLoader(new URL[]{new File(jarFilePath).toURI().toURL()});
                Class<?> chartPage = classLoader.loadClass("com.example.demo3.kursPage");
                Constructor<?> constructor = chartPage.getConstructor(Tab.class, DataStore.class);
                Object chartResult = constructor.newInstance(tab, dataStore);
            } else if (str.substring(str.length()-11).equals("plugin4.jar")) {
                URLClassLoader classLoader = new URLClassLoader(new URL[]{new File(jarFilePath).toURI().toURL()});
                Class<?> chartPage = classLoader.loadClass("com.example.demo3.discountPage");
                Constructor<?> constructor = chartPage.getConstructor(Tab.class, DataStore.class);
                Object chartResult = constructor.newInstance(tab, dataStore);
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
