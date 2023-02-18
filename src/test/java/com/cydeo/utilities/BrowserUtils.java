package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    public static void sleep(int second){
        second *= 1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }
    public static void switchBetweenWindowsAndVerify( String expectedURL, String expectedTitle){
        //Return and store all windows handles in a Set
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();


        for ( String each: allWindowHandles){
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL: "+Driver.getDriver().getCurrentUrl());
            if (Driver.getDriver().getCurrentUrl().contains(expectedURL)){
                break;
            }
        }

        String actualTitle =Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));




    }

    public static void verifyTitle (String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);
    }

    public static void verifyTitleContains (String expectedTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }

    public static List<String> dropdownOptionsAsString(WebElement dropdownElement) {
        Select month = new Select(dropdownElement);
        //storing all the ACTUAL options into a list of WebElement
        List<WebElement> actualMonth_as_WebElement = month.getOptions();

//creating an EMPTY list of String to store ACTUAL <option> as String
        List<String> actualMonth_as_String = new ArrayList<>();


//looping through the List <WebElement>, getting all options' text and storing them into List <String>
        for (WebElement each : actualMonth_as_WebElement) {
            actualMonth_as_String.add(each.getText());

        }
        return actualMonth_as_String;
    }

}
