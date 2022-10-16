package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.colorFilter;

public class filter_withColor {
    colorFilter Filter = new colorFilter();

    @Given("logged user navigate to the home page")
    public void navigate_to_home() {
        String url = "https://demo.nopcommerce.com/";
        browser.driver.navigate().to(url);
    }
    @When("user select a Apparel category then hover to Shoes subcategory")
    public void Apparel_subcategory() {
        Filter.Apparel_subcategory();
    }
    @And("user select shoes subCategory")
    public void shoesCategory() {
        Filter.shoesCategory().click();
    }
    @Then("filter by Red color")
    public void Filter_Color() {
        Filter.Filter_Color().click();
    }
    @And("confirm message")
    public void confirm(){
        Assert.assertTrue(browser.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/shoes?viewmode=grid&orderby=0&pagesize=6&specs=15"));
    }
}
