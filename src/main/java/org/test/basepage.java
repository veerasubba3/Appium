package org.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class basepage {

    private AppiumDriver driver;

    public basepage(){
        this.driver = new abstractclass().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * This method is used to click on a WebElement.
     *
     * @param element The WebElement to be clicked.
     */
    public void click(WebElement element) {
        // Print a message to the console
        System.out.println("Clicking on element " + element);
        // Perform the click operation
        element.click();
    }

    public void waitToBeClickable(WebElement element, int timeout) {
        FluentWait<WebDriver> waittime = new WebDriverWait(driver,
                Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(2));
        waittime.withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        waittime.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isElementPresent(WebElement element, int timeout) {
        try {
            waitToBeClickable(element, 10);
            if (element.isDisplayed() && element.isEnabled())
                return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public void swipedirect( String direction, double value)  {
        org.openqa.selenium.Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        double start = 1.0 - value;
        switch (direction.toLowerCase()) {
            case "up":
                swipetext(driver, (int) (width * (0.50)), (int) (height * (value)), (int) (width * (0.50)),
                        (int) (height * (start)));
                break;
            default:
                swipetext(driver, (int) (width * (0.50)), (int) (height * (start)), (int) (width * (0.50)),
                        (int) (height * (value)));
                break;
        }
    }

    public void swipetext(WebDriver driver, int startx, int starty, int endx, int endy) {
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence drag = new Sequence(finger1, 1);
        drag.addAction(
                finger1.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startx, starty));
        drag.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        drag.addAction(
                finger1.createPointerMove(Duration.ofMillis(701), PointerInput.Origin.viewport(), endx, endy));
        drag.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((RemoteWebDriver) driver).perform(Arrays.asList(drag));
    }
}
