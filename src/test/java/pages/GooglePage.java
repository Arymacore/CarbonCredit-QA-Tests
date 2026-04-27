package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePage {

    private final WebDriver driver;

    // Locators
    private final By searchBox = By.name("q");
    private final By acceptCookiesBtn = By.id("L2AGLb");

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    // Open Google
    public void open() {
        driver.get("https://www.google.com");
    }

    // Handle cookie popup (safe if not present)
    public void acceptCookiesIfPresent() {
        try {
            driver.findElement(acceptCookiesBtn).click();
        } catch (Exception ignored) {
            // popup not shown in some regions/browsers
        }
    }

    // Perform search
    public void search(String text) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(text);
        driver.findElement(searchBox).submit();
    }
}