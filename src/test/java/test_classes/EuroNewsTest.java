package test_classes;

import org.testng.Assert;
import org.testng.annotations.Test;
import aquality.selenium.browser.AqualityServices;
import page_classes.MainPage;
import page_classes.NewsLetterPage;
import page_classes.AgreeAndClosePage;
import java.time.Duration;
import page_classes.EmailForm;
import page_classes.SubscriptionConfirmationForm;
import page_classes.PreviewPage;
import page_classes.UnsubscribePage;
import util_classes.ExpectedDataUtils;

public class EuroNewsTest extends BaseTest {
    MainPage mainPage = new MainPage();
    NewsLetterPage newsletterPage = new NewsLetterPage();
    AgreeAndClosePage agreeAndClose = new AgreeAndClosePage();
    EmailForm emailForm = new EmailForm();
    SubscriptionConfirmationForm subscriptionForm = new SubscriptionConfirmationForm();
    PreviewPage previewPage = new PreviewPage();
    UnsubscribePage unsubscribePage = new UnsubscribePage();

    @Test
    public void TestCase1() throws InterruptedException {
        AqualityServices.getBrowser().setPageLoadTimeout(Duration.ofMinutes(20));
        AqualityServices.getLogger().info("Checking if Main Page is open");
        Assert.assertTrue(mainPage.state().isDisplayed(), "Main Page is not opened");
        if (agreeAndClose.state().isDisplayed()) {
            agreeAndClose.click();
        }
        mainPage.clickNewsletterLink();
        AqualityServices.getLogger().info("Checking if Newletter page is open");
        Assert.assertTrue(newsletterPage.state().isDisplayed(), "Newsletter Page is not opened");
        newsletterPage.clickRandomNewsletter();
        AqualityServices.getLogger().info("Checking if Button to choose newsletter has changed");
        Assert.assertTrue(newsletterPage.isNewsletterChosen(), "Button to choose newsletter has not changed");
        AqualityServices.getLogger().info("Checking if Email Form has appeared");
        Assert.assertTrue(emailForm.state().isDisplayed(), "Email Form has not appeared");
        emailForm.enterEmail();
        emailForm.clickSubmitButton();
        AqualityServices.getLogger().info("Checking if pop-up form with message about subscription confirmation email has appeared");
        Assert.assertTrue(subscriptionForm.state().isDisplayed(),
                "Pop-up form with message about subscription confirmation email has not appeared");
        subscriptionForm.closeSubscriptionForm();
        newsletterPage.ClickOnPreviewOfTheSameNewsletter();
        AqualityServices.getLogger().info("Checking if a preview of the required plan is opened");
        Assert.assertTrue(previewPage.state().isDisplayed(), "A preview of the required plan is not opened");
        previewPage.gotoUnsubscribe();
        AqualityServices.getLogger().info("Checking if unsubscribe page is opened");
        Assert.assertTrue(unsubscribePage.state().isDisplayed(), "Unsubscribe page is not opened");
        unsubscribePage.inputEmail();
        unsubscribePage.clickConfirmUnsubscribe();
        AqualityServices.getLogger().info("Checking if a message that the subscription was canceled successfully appears");
        Assert.assertTrue(unsubscribePage.isSubscriptionCanceled(),
                "A message that the subscription was canceled doesn't successfully appear");
    }
    
    @Test
    public void Test2() throws InterruptedException {
        AqualityServices.getBrowser().setPageLoadTimeout(Duration.ofMinutes(20));
        AqualityServices.getLogger().info("Main Page is opening");
        Assert.assertTrue(mainPage.state().isDisplayed(), "Main Page is not opened");
        if (agreeAndClose.state().isDisplayed()) {
            agreeAndClose.click();
        }
        mainPage.clickNewsletterLink();
        AqualityServices.getLogger().info("Newletter page is opening");
        Assert.assertTrue(newsletterPage.state().isDisplayed(), "Newsletter Page is not opened");
        AqualityServices.getLogger().info("Checking if all mentioned newsletters are present on the page and their data is matching");
        Assert.assertTrue(newsletterPage.getActualNewsletterData().containsAll(ExpectedDataUtils.getAllExpectedData()),
                "All mentioned newsletters are not present on the page and their data is not matching");
        newsletterPage.ClickOnPreviewOfTheSameNewsletter();
        AqualityServices.getLogger().info("Checking if a preview of required plan is open");
        Assert.assertTrue(previewPage.state().isDisplayed(), "A preview of the required plan is not opened");
        previewPage.gotoAllNewsletters();
        AqualityServices.getLogger().info("Checking if Newletter page is open");
        Assert.assertTrue(newsletterPage.state().isDisplayed(), "Newsletter Page is not opened");
    }
}