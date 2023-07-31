package page_classes;

import org.openqa.selenium.By;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import util_classes.TestDataUtils;

public class UnsubscribePage extends Form {
	
	public UnsubscribePage() {
		super (By.xpath("//h3[contains(text(), 'Newsletter unsubscription')]"), "Unsubscribe Page Unique Element");
	}
	
	public void inputEmail() {
		ITextBox emailBox = getElementFactory().getTextBox(By.id("email"), "Email Box");
		emailBox.clearAndType(TestDataUtils.getTestEmail());
	}
	
	public void clickConfirmUnsubscribe() {
		IButton confirmUnsubscribeButton = getElementFactory().getButton(
				By.xpath("//button[@type='submit']"), "Confirm Unsubscribe button");
		confirmUnsubscribeButton.clickAndWait();
	}
	
	public boolean isSubscriptionCanceled() {
		return getElementFactory().getTextBox(By.className("text-danger"), "Unsubscribe Successful").state().isDisplayed();
	}
}