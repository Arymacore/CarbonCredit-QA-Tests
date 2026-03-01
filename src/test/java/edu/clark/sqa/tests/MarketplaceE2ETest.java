package edu.clark.sqa.tests;

import edu.clark.sqa.pages.CheckoutPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MarketplaceE2ETest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        File htmlFile = new File("src/test/resources/mock-marketplace.html");
        String localUrl = "file:///" + htmlFile.getAbsolutePath();
        driver.get(localUrl);
    }

    @Test
    public void testUserRegistration() {
        driver.findElement(By.id("reg-email")).sendKeys("corp@example.com");
        driver.findElement(By.id("reg-password")).sendKeys("SecureQA2026!");
        driver.findElement(By.id("submit-reg")).click();
        assertTrue(driver.getPageSource().contains("Account Created Successfully"));
    }

    @Test
    public void testProductSearch() {
        driver.findElement(By.id("search-bar")).sendKeys("Wind Farm Credits");
        driver.findElement(By.id("filter-certified")).click();
        driver.findElement(By.id("search-btn")).click();
        assertNotNull(driver.findElement(By.className("search-results")));
    }

    @Test
    public void testCheckoutWithPOM() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.purchaseCredits("500");
        boolean isConfirmed = checkoutPage.isTransactionConfirmed();
        assertTrue(isConfirmed, "Blockchain transaction failed or timed out.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}