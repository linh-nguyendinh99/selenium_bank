package com.example.bank;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	public void  demo(){
        System.setProperty("webdriver.chrome.driver","D:\\bank\\SQA-bank-app-backend\\SQA-bank-app-backend\\browserDriver\\chromedriver.exe");
        WebDriver obj = new ChromeDriver();
        obj.get("http://192.168.5.185:8080/interest-calculation");

	}
}
