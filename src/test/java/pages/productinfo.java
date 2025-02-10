package pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.test.abstractclass;
import org.test.basepage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class productinfo {


    public productinfo(){
        PageFactory.initElements(new AppiumFieldDecorator(new abstractclass().getDriver()), this);
    }



    @AndroidFindBy(accessibility = "buy-now-button")
    private WebElement buyNowButton;

    @AndroidFindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    @AndroidFindBy(id = "//android.widget.Button[@text=\"DONE\"]")
    private WebElement doneButton;

    public void buyNow() {
        // Wait for the buy now button to be clickable
        new basepage().waitToBeClickable(buyNowButton, 10);
        // Click the buy now button
        new basepage().click(buyNowButton);
    }

    public void setAddToCartButton()  {
        try {
            Thread.sleep(10000);
        } catch (Exception e){

        }
        new basepage().swipedirect("up",0.90);
        new basepage().swipedirect("up",0.60);
        // Wait for the buy now button to be clickable
        new basepage().waitToBeClickable(addToCartButton, 10);
        // Click the add to cart button
        new basepage().click(addToCartButton);
        new basepage().click(doneButton);
    }



}
