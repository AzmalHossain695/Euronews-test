package page_classes;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import java.time.Duration;
import org.openqa.selenium.By;

public class PreviewPage extends Form {
	
    private final ITextBox previewForm = AqualityServices.getElementFactory().getTextBox(By.cssSelector(".jquery-modal.blocker.current"), "Preview Form");
	
	public PreviewPage() {
		super(By.cssSelector(".jquery-modal.blocker.current"), "Preview Page Unique Locator");
	}
	
	public void gotoUnsubscribe() throws InterruptedException {
		IElement iframe = previewForm.findChildElement(By.className("iframe-preview"), ElementType.TEXTBOX);
	    AqualityServices.getBrowser().getDriver().switchTo().frame(iframe.getElement());
		IButton unsubscribeButton = getElementFactory().getButton
				(By.xpath("//a[contains(text(), 'clicking here')]"), "Unsubscribe link element");
        unsubscribeButton.getJsActions().scrollIntoView();
		String unsubscribeLink = unsubscribeButton.getAttribute("href");
		AqualityServices.getBrowser().goTo(unsubscribeLink);
		AqualityServices.getBrowser().setPageLoadTimeout(Duration.ofSeconds(20));
	}
	
	public void gotoAllNewsletters() {
		IElement iframe = previewForm.findChildElement(By.className("iframe-preview"), ElementType.TEXTBOX);
	    AqualityServices.getBrowser().getDriver().switchTo().frame(iframe.getElement());
		IButton allNewsletterButton = getElementFactory().getButton
				(By.xpath("//a[contains(text(), 'See all our newsletters')]"), "See all newsletter link element");
		allNewsletterButton.getJsActions().scrollIntoView();
		String allNewsletterLink = allNewsletterButton.getAttribute("href");
		AqualityServices.getBrowser().goTo(allNewsletterLink);
		AqualityServices.getBrowser().setPageLoadTimeout(Duration.ofSeconds(20));		
	}
}