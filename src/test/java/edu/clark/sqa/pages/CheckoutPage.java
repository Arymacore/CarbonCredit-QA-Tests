package edu.clark.sqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By creditInput = By.id("credit-amount");
    private By buyButton = By.id("buy-btn");
    private By successMessage = By.id("tx-success");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void purchaseCredits(String amount) {
        driver.findElement(creditInput).sendKeys(amount);
        driver.findElement(buyButton).click();
    }

    public boolean isTransactionConfirmed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}