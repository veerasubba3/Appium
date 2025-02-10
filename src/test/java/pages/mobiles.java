package pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.test.abstractclass;
import org.test.basepage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class mobiles {


    public mobiles(){
        PageFactory.initElements(new AppiumFieldDecorator(new abstractclass().getDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"dismiss-button\"]/android.widget.Image")
    private WebElement dismissButton;

    @AndroidFindBy(xpath = "//android.widget.Image[@text=\"Samsung\"]")
    private WebElement samsung;

    @AndroidFindBy(accessibility = "Samsung Galaxy S25 Ultra 5G")
    private WebElement samsungGalaxyS25Ultra5G;

    @AndroidFindBy(accessibility = "buy-now-button")
    private WebElement buyNowButton;


    public void closeoverlay() {

        // Click the continue button
        if(new basepage().isElementPresent(dismissButton, 20))
            dismissButton.click();
    }

    public void selectSamsung() {

        // Wait for the continue button to be clickable
        new basepage().waitToBeClickable(samsung, 10);
        // Click the continue button
        new basepage().click(samsung);
    }

    public void setSamsungGalaxyS25Ultra5G() {

        // Wait for the continue button to be clickable
        new basepage().waitToBeClickable(samsungGalaxyS25Ultra5G, 10);
        // Click the continue button
        new basepage().click(samsungGalaxyS25Ultra5G);
    }


}
