package page_classes;

import org.openqa.selenium.By;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;

public class MainPage extends Form {	
	
	private final IButton newsletterButton;
	
	public MainPage() {
		super(By.xpath("//a[normalize-space(translate(@aria-label, ' ', ''))='EuronewsLogo']"), "Main Page Unique Button");
		newsletterButton = getElementFactory().getButton(
				By.xpath("//span[@data-event='newsletter-link-header' and contains(text(), 'Newsletters')]"),
				"Newsletter Click Button");
	}
	
	public void clickNewsletterLink() {
		newsletterButton.clickAndWait();
	}
}