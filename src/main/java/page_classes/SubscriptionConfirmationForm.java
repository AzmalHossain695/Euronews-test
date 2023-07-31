package page_classes;

import org.openqa.selenium.By;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;

public class SubscriptionConfirmationForm extends Form {
	
	public 	SubscriptionConfirmationForm() {
		super (By.className("h2"), "Subscription Confirmation Form");
	}
	
	public void closeSubscriptionForm() {
		IButton closeButton = AqualityServices.getElementFactory().getButton(By.xpath("//a[@class='close-modal ']"), "Close Button");
	        closeButton.clickAndWait();	    
	}
}