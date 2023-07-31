package page_classes;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import org.openqa.selenium.By;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.forms.Form;
import model_classes.NewsletterModel;

public class NewsLetterPage extends Form {

	private static int randomIndex;
	private final IButton chosenButton;

	public NewsLetterPage() {
		super(By.xpath("//span[contains(translate(@class, ' ', ''), 'h1text-secondary')]"), "Newsletter Page Unique Element");
		chosenButton = getElementFactory().getButton(
		    By.xpath("//label[contains(normalize-space(translate(., ' ', '')), 'Chosen')]/i[contains(concat(' ', normalize-space(@class), ' '), 'far') and contains(concat(' ', normalize-space(@class), ' '), 'fa-check') and contains(concat(' ', normalize-space(@class), ' '), 'text-white')]/.."),
		    "Chosen Button");
	}

	public void clickRandomNewsletter() throws InterruptedException {
		List<IElement> newsletterLabels = getElementFactory().findElements(
				By.xpath("//label[contains(normalize-space(translate(text(), ' ', '')), 'Choosethisnewsletter')]"), ElementType.BUTTON);
		Random random = new Random();
		randomIndex = random.nextInt(newsletterLabels.size() - 1);
		newsletterLabels.get(randomIndex).click();
	}

	public void ClickOnPreviewOfTheSameNewsletter() throws InterruptedException {
	    List<IElement> p8Divs = getElementFactory().findElements(By.className("p-8"), ElementType.COMBOBOX);
	    if (randomIndex >= 0 && randomIndex < p8Divs.size()) {
	        IElement selectedNewsletterDiv = p8Divs.get(randomIndex);
	        System.out.println("" + randomIndex);
	        IElement seePreviewsButton = selectedNewsletterDiv.findChildElement(
	                By.xpath(".//a[normalize-space()='Or see previews']"), ElementType.BUTTON);
	        if (seePreviewsButton != null && seePreviewsButton.state().isDisplayed()) {
	            seePreviewsButton.getJsActions().clickAndWait();
	        }
	    }
	}

	public boolean isNewsletterChosen() {
		return chosenButton.state().isDisplayed();
	}

	public List<NewsletterModel> getActualNewsletterData() {
	    List<NewsletterModel> actualDataList = new ArrayList<>();
	    List<IElement> newsletterDivs = getElementFactory().findElements(By.xpath("//div[contains(@class, 'p-8')]"), ElementType.COMBOBOX);

	    for (IElement specificNewsletterDiv : newsletterDivs) {
	        String newsletterName = getNewsletterName(specificNewsletterDiv);
	        String frequency = getFrequencyText(specificNewsletterDiv);
	        String description = getDescriptionText(specificNewsletterDiv);
	        NewsletterModel newsletterModel = new NewsletterModel();
	        newsletterModel.name = newsletterName;
	        newsletterModel.frequency = frequency;
	        newsletterModel.description = description;
	        actualDataList.add(newsletterModel);
	    }

	    return actualDataList;
	}

	private String getNewsletterName(IElement specificNewsletterDiv) {
	    IElement h2Tag = specificNewsletterDiv.findChildElement(By.tagName("h2"), ElementType.TEXTBOX);
	    return h2Tag.getText();
	}

	public String getFrequencyText(IElement specificNewsletterDiv) {
		IElement pTag = specificNewsletterDiv.findChildElement(By.tagName("p"), ElementType.TEXTBOX);
		return pTag.getText();
	}

	public String getDescriptionText(IElement specificNewsletterDiv) {
		IElement nestedDiv = specificNewsletterDiv.findChildElement(By.tagName("div"), ElementType.COMBOBOX);
		IElement nestedPTag = nestedDiv.findChildElement(By.tagName("p"), ElementType.TEXTBOX);
		return nestedPTag.getText();
	}	
}