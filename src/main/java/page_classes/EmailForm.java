package page_classes;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import util_classes.TestDataUtils;
import org.openqa.selenium.By;

public class EmailForm extends Form {
	
	public EmailForm() {
		super (By.xpath("//div[contains(@class, 'container') and contains(@class, 'lg:flex') and contains(@class, 'justify-between')]"), 
				"Email Form Unique Locator");
	}
	
	public void enterEmail() {
		ITextBox emailInputBox = getElementFactory().getTextBox(By.xpath("//input[@type='email']"), "Email Input Box");
		emailInputBox.clearAndType(TestDataUtils.getTestEmail());
	}
	
	public void clickSubmitButton() {
		IButton submitButton = getElementFactory().getButton(By.xpath("//input[@data-event='NL_submit']"), "Submit Button");
		submitButton.clickAndWait();
	}
}