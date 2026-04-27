package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePage {

    WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchBox = By.name("q");

    public void open() {
        driver.get("https://www.google.com");
    }

    public void search(String text) {
        driver.findElement(searchBox).sendKeys(text);
        driver.findElement(searchBox).submit();
    }
}