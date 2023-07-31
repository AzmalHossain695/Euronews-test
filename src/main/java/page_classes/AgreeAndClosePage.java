package page_classes;

import org.openqa.selenium.By;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;

public class AgreeAndClosePage extends Form {	
	
	private IButton agreeAndCloseButton;
	
	public AgreeAndClosePage() {
		super(getAgreeAndCloseButtonLocator(), "Agree and close button");
		agreeAndCloseButton = getElementFactory().getButton(getAgreeAndCloseButtonLocator(), "Agree and close button");
	}
	
	public void click() {
		agreeAndCloseButton.clickAndWait();
	}
	
	private static By getAgreeAndCloseButtonLocator() {
		return By.xpath("//span[contains(normalize-space(translate(text(), ' ', '')), 'Agreeandclose')]");
	}
}