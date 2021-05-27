package com.example.bank.model;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestDriver {
    private String driverUrl = "D:\\bank\\SQA-bank-app-backend\\SQA-bank-app-backend\\browserDriver\\chromedriver.exe";

    public TestDriver(){}
    public ChromeDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", driverUrl);
        return new  ChromeDriver();
    }
}
