package pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.test.abstractclass;
import org.test.basepage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class homepage {


    public homepage(){
        PageFactory.initElements(new AppiumFieldDecorator(new abstractclass().getDriver()), this);
    }

    @AndroidFindBy(accessibility = "Select English")
    private WebElement englishLanguagel;

    @AndroidFindBy(id = "in.amazon.mShop.android.shopping:id/continue_button")
    private WebElement continueButton;;

    @AndroidFindBy(id = "in.amazon.mShop.android.shopping:id/skip_sign_in_button")
    private WebElement SkipSignin;

    @AndroidFindBy(accessibility = "Home Tab 1 of 5")
    private WebElement homeTab;

    @AndroidFindBy(accessibility = "Browse menu Tab 5 of 5")
    private WebElement browseTab;

    @AndroidFindBy(accessibility = "Context switcher. Switch between various contexts like Amazon Pay, miniTV, etc. Tab 3 of 5")
    private WebElement contextTab;

    @AndroidFindBy(accessibility = "(//android.widget.ImageView[@resource-id=\"in.amazon.mShop.android.shopping:id/bottom_tab_button_icon\"])[2]")
    private WebElement searchTab;

    @AndroidFindBy(accessibility = "in.amazon.mShop.android.shopping:id/cart_count")
    private WebElement cartTab;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"close\"]")
    private WebElement dismissButton;


    public WebElement menu(String name) {
        return new abstractclass().getDriver().findElement(By.xpath("//android.widget.TextView[@text='" + name + "']"));
    }



    /**
     * Clicks the English language button.
     *
     * This method clicks the English language button on the app's
     * language selection screen.
     */
    public void selectLanguage() {
        // Wait for the language button to be clickable
        new basepage().waitToBeClickable(englishLanguagel, 10);
        // Click the English language button
        englishLanguagel.click();
    }

    /**
     * Clicks the continue button.
     *
     * This method clicks the continue button on the app's
     * welcome screen.
     */
    public void clickContinue() {
        // Wait for the continue button to be clickable
        new basepage().waitToBeClickable(continueButton, 10);
        // Click the continue button
        continueButton.click();
    }

    public void SkipSignin() {
        // Wait for the continue button to be clickable
        new basepage().waitToBeClickable(SkipSignin, 10);
        // Click the continue button
        SkipSignin.click();
    }

    public void closeoverlay() {
        // Click the continue button
        if(new basepage().isElementPresent(dismissButton, 20))
            dismissButton.click();
    }

    public void verifyhomeScreen() {
        if(new basepage().isElementPresent(homeTab, 10))
            System.out.println("home screen is available");
        else
            Assert.fail("Unable to navigate to homepage");
    }

    public void selecttab(String name) {
        new basepage().click( menu(name));
    }


}
