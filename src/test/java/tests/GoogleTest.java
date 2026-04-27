package tests;

import base.BaseTest;
import pages.GooglePage;
import utils.WaitUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GoogleTest extends BaseTest {

    @Test
    public void googleSearchTest() {

        GooglePage page = new GooglePage(driver);
        WaitUtils wait = new WaitUtils(driver);

        page.open();
        page.search("carbon credit QA automation");

        // stable wait (DO NOT use titleContains here)
        wait.visible(By.name("q"));

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        Assertions.assertTrue(
                title.toLowerCase().contains("carbon"),
                "Unexpected title: " + title
        );
    }
}