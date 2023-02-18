package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //1 - Create the properties object
    //make it private so it's not accessible from outside the class
    //static - to make sure it's created and loaded the first in the class, and also it belongs to the class
    private static Properties properties = new Properties();


    static {

        try {

            //2 - Open file using FileInputStream(open file)
            FileInputStream file = new FileInputStream("configuration.properties");

            //3 - Load the "properties" object with "file"
            properties.load(file);

            //close the file in the memory
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found with given path");
        }
    }

    //4 - Use "properties" object to read from the file(read properties)
    //create a utility method to use the object to read
    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);

    }
}
