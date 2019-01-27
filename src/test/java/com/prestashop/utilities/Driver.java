package com.prestashop.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    private static WebDriver driver;
    private static String OS = System.getProperty("os.name").toLowerCase();

    private Driver(){}

    public static WebDriver getDriver(){

        if (driver == null){

            try {
                switch (ConfigReader.getProperty("browser")){
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    case "ie":
                        if (OS.contains("mac")) throw new WebDriverException();
                        WebDriverManager.iedriver().setup();
                        driver = new InternetExplorerDriver();
                        break;
                    case "edge":
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        break;
                    case "safari":
                        if (OS.contains("win")) throw new WebDriverException();
                        System.setProperty("webdriver.safari.noinstall", "true");
                        driver = new SafariDriver();
                        break;
                }

            }catch (WebDriverException ex ){
                System.out.println("Your "+ OS + " doesn't support " + ConfigReader.getProperty("browser") + " browser" );
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
