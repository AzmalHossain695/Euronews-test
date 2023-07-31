package util_classes;

import java.util.Set;

import aquality.selenium.browser.AqualityServices;

public class WindowHandle {
	public static void switchToNewTab() {		
        Set<String> windowHandles = AqualityServices.getBrowser().getDriver().getWindowHandles();
        String currentWindowHandle = AqualityServices.getBrowser().getDriver().getWindowHandle();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                AqualityServices.getBrowser().getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }
}