package stepdef;
import org.test.abstractclass;


import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
import pages.mobiles;
import pages.homepage;
import pages.productinfo;


import java.net.MalformedURLException;

public class login {

    @When("Open the the App")
    public void open_the_the_app() throws MalformedURLException {
        new abstractclass().intilizedriver("Android");
    }

    @Then("Select english language")
    public void select_english_language() {
        new homepage().selectLanguage();
        new homepage().clickContinue();
    }

    @Then("Select Skip Signin")
    public void select_skip_signin() {
        new homepage().SkipSignin();
    }

    @Then("Verify home page is displayed")
    public void verify_home_page_is_displayed() {
        new homepage().closeoverlay();
        new homepage().verifyhomeScreen();
    }

    @Then("Click on Mobiles session")
    public void click_on_mobiles_session() {
        new homepage().selecttab("Mobiles");
    }

    @Then("Select Samsung Mobile")
    public void select_samsung_mobile() {
        new mobiles().closeoverlay();
        new mobiles().selectSamsung();
    }

    @Then("Click on Samsungs25")
    public void click_on_samsung() {
        new mobiles().setSamsungGalaxyS25Ultra5G();
    }

    @Then("Add the device to cart")
    public void add_the_device_to_cart() {
        new productinfo().setAddToCartButton();

    }

    @Then("Verify device is added to cart")
    public void verify_device_is_added_to_cart() {

    }

}