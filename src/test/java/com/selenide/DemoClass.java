package com.selenide;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

public class DemoClass {




    @Test
    public static void Setup() throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\login\\Tools\\geckodriver\\geckodriver.exe");
        System.setProperty("selenide.browser", "Firefox");
        Thread.sleep(2000);
        open("http://parabank.parasoft.com/parabank/index.htm");
        if ($(By.xpath("//a[contains(text(),'ParaBank')]")).isDisplayed())
        {
            System.out.println("Home Page Loaded");
            if ($(By.xpath("//*[contains(text(),'Customer Login')]")).isDisplayed())
            {
                $(By.xpath("//*[contains(@name,'username')]")).val("test");
                $(By.xpath("//*[contains(@name,'password')]")).val("test");
                $(By.xpath("//*[contains(@value,'Log In')]")).click();
                Thread.sleep(2000);
                if ($(By.xpath("//*[contains(text(),'Log Out')]")).isDisplayed())
                {
                    System.out.println("User Login Successfull");
                }
                else
                {
                    System.out.println("User Login NOT Successfull");
                }
            }
        }
        else
        {
            System.out.println("Home Page Not Loaded");
        }




    }
}
