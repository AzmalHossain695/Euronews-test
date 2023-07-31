package test_classes;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import util_classes.ConfigDataUtills;

public class BaseTest {
	private Browser browser;

    @BeforeMethod
    public void setUp() {
        browser = AqualityServices.getBrowser();
        browser.getDriver().manage().window().maximize();
        browser.getDriver().get(ConfigDataUtills.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        if (browser != null) {
            browser.quit();
        }
    }
}